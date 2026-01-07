package com.cloudstorage.sdk.client.impl;


import com.cloudstorage.proto.*;
import com.cloudstorage.sdk.CloudStorageObject;
import com.cloudstorage.sdk.FileObject;
import com.cloudstorage.sdk.client.CloudStorageClient;
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
    public FileObject uploadFile(CloudStorageObject storageObject) {
        Path filePath = storageObject.getFilePath();

        Metadata headers = generateMetadata(storageObject.getKey());

        CloudStorageServiceGrpc.CloudStorageServiceStub cloudStorageServiceStub =
                CloudStorageServiceGrpc
                        .newStub(channel)
                        .withInterceptors(
                                MetadataUtils
                                        .newAttachHeadersInterceptor(headers));

        final FileObject[] fileObject = new FileObject[1];
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<CloudStorageServiceUploadRequest> uploadStreamObserver = cloudStorageServiceStub.upload(
                new StreamObserver<>() {
                    @Override
                    public void onNext(CloudStorageServiceUploadResponse cloudStorageServiceUploadResponse) {
                        Status uploadStatus = cloudStorageServiceUploadResponse.getStatus();
                        if (uploadStatus == Status.STATUS_SUCCESS_UNSPECIFIED) {
                            return;
                        }
                        FileDetails fileDetails = cloudStorageServiceUploadResponse.getFileDetails();
                        fileObject[0] = FileObject.builder()
                                .fileId(fileDetails.getFileName())
                                .size(fileDetails.getFileSize())
                                .accessUrl(fileDetails.getAccessUrl())
                                .build();
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        log.error("Some error occurred while streaming the data : {}", throwable.getMessage());
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
            while (stream.read(buffer) != -1) {
                CloudStorageServiceUploadRequest request = CloudStorageServiceUploadRequest
                        .newBuilder()
                        .setData(ByteString.copyFrom(buffer))
                        .build();
                uploadStreamObserver.onNext(request);
                latch.await();
            }
        } catch (IOException ex) {
            log.error("Error occurred while reading the file with message: {}", ex.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return fileObject[0];
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
