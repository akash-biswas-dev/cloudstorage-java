package com.cloudstorage.sdk.client.impl;


import com.cloudstorage.proto.*;
import com.cloudstorage.sdk.CloudStorageObject;
import com.cloudstorage.sdk.FileObject;
import com.cloudstorage.sdk.client.CloudStorageClient;
import com.cloudstorage.sdk.exceptions.CloudStorageException;
import com.cloudstorage.sdk.exceptions.InvalidFilePathException;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class CloudStorageClientImpl implements CloudStorageClient {

    private static final String FILE_META_DATA = "file-meta-data";

    private final ManagedChannel channel;

    public CloudStorageClientImpl(String url) {
        this.channel = ManagedChannelBuilder.forTarget(url).build();
    }

    public CloudStorageClientImpl(String host, Integer port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).build();
    }

    @Override
    public FileObject uploadFile(CloudStorageObject storageObject) throws Exception{
        Path filePath = storageObject.getFilePath();

        Metadata headers = generateMetadata(storageObject.getKey());

        CloudStorageServiceGrpc.CloudStorageServiceStub cloudStorageServiceStub =
                CloudStorageServiceGrpc
                        .newStub(channel)
                        .withInterceptors(
                                MetadataUtils
                                        .newAttachHeadersInterceptor(headers));

        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<FileObject> fileObjectReference = new AtomicReference<>();
        AtomicReference<Throwable> rpcErrorReference = new AtomicReference<>();

        StreamObserver<CloudStorageServiceUploadRequest> uploadStreamObserver = cloudStorageServiceStub.upload(
                new StreamObserver<>() {
                    @Override
                    public void onNext(CloudStorageServiceUploadResponse cloudStorageServiceUploadResponse) {
                        Status uploadStatus = cloudStorageServiceUploadResponse.getStatus();
                        if (uploadStatus == Status.STATUS_SUCCESS_UNSPECIFIED) {
                            return;
                        }
                        FileDetails fileDetails = cloudStorageServiceUploadResponse.getFileDetails();
                        FileObject fileObject = FileObject.builder()
                                .fileId(fileDetails.getFileName())
                                .size(fileDetails.getFileSize())
                                .accessUrl(fileDetails.getAccessUrl())
                                .build();
                        fileObjectReference.set(fileObject);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        latch.countDown();
                        rpcErrorReference.set(throwable);
                    }

                    @Override
                    public void onCompleted() {
                        channel.shutdown();
                        latch.countDown();
                    }
                }
        );
        try (InputStream stream = Files.newInputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = stream.read(buffer)) != -1) {
                CloudStorageServiceUploadRequest request = CloudStorageServiceUploadRequest
                        .newBuilder()
                        .setData(ByteString.copyFrom(buffer, 0, bytesRead))
                        .build();
                uploadStreamObserver.onNext(request);
            }
            uploadStreamObserver.onCompleted();
            latch.await();
            if (rpcErrorReference.get() != null) {
                throw new RuntimeException("Error occurred while sending data", rpcErrorReference.get());
            }
        } catch (IOException ex) {
            throw new InvalidFilePathException("Invalid file or path provided.");
        } catch (RuntimeException ex){
            throw new CloudStorageException("Some internal error occurred while saving the file.");
        }
        FileObject fileObject = fileObjectReference.get();
        if(fileObject == null){
            throw new CloudStorageException("Unknown error occurred while saving the file.");
        }
        return fileObjectReference.get();
    }

    private Metadata generateMetadata(
            String fileName
    ) {
        FileMetaData fileMetaData = FileMetaData.newBuilder()
                .setFileName(fileName)
                .build();
        Metadata.Key<byte[]> fileMetaDataKey = Metadata.Key.of(String.format("%s-bin", FILE_META_DATA), Metadata.BINARY_BYTE_MARSHALLER);

        Metadata metaData = new Metadata();
        metaData.put(fileMetaDataKey, fileMetaData.toByteArray());
        return metaData;
    }
}
