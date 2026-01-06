package com.cloudstorage.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudStorageServiceGrpc {

  private CloudStorageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "cloudstorage.v1.CloudStorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cloudstorage.proto.CloudStorageServiceUploadRequest,
      com.cloudstorage.proto.CloudStorageServiceUploadResponse> getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Upload",
      requestType = com.cloudstorage.proto.CloudStorageServiceUploadRequest.class,
      responseType = com.cloudstorage.proto.CloudStorageServiceUploadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.cloudstorage.proto.CloudStorageServiceUploadRequest,
      com.cloudstorage.proto.CloudStorageServiceUploadResponse> getUploadMethod() {
    io.grpc.MethodDescriptor<com.cloudstorage.proto.CloudStorageServiceUploadRequest, com.cloudstorage.proto.CloudStorageServiceUploadResponse> getUploadMethod;
    if ((getUploadMethod = CloudStorageServiceGrpc.getUploadMethod) == null) {
      synchronized (CloudStorageServiceGrpc.class) {
        if ((getUploadMethod = CloudStorageServiceGrpc.getUploadMethod) == null) {
          CloudStorageServiceGrpc.getUploadMethod = getUploadMethod =
              io.grpc.MethodDescriptor.<com.cloudstorage.proto.CloudStorageServiceUploadRequest, com.cloudstorage.proto.CloudStorageServiceUploadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Upload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cloudstorage.proto.CloudStorageServiceUploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cloudstorage.proto.CloudStorageServiceUploadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudStorageServiceMethodDescriptorSupplier("Upload"))
              .build();
        }
      }
    }
    return getUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.cloudstorage.proto.CloudStorageServiceDownloadRequest,
      com.cloudstorage.proto.CloudStorageServiceDownloadResponse> getDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Download",
      requestType = com.cloudstorage.proto.CloudStorageServiceDownloadRequest.class,
      responseType = com.cloudstorage.proto.CloudStorageServiceDownloadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.cloudstorage.proto.CloudStorageServiceDownloadRequest,
      com.cloudstorage.proto.CloudStorageServiceDownloadResponse> getDownloadMethod() {
    io.grpc.MethodDescriptor<com.cloudstorage.proto.CloudStorageServiceDownloadRequest, com.cloudstorage.proto.CloudStorageServiceDownloadResponse> getDownloadMethod;
    if ((getDownloadMethod = CloudStorageServiceGrpc.getDownloadMethod) == null) {
      synchronized (CloudStorageServiceGrpc.class) {
        if ((getDownloadMethod = CloudStorageServiceGrpc.getDownloadMethod) == null) {
          CloudStorageServiceGrpc.getDownloadMethod = getDownloadMethod =
              io.grpc.MethodDescriptor.<com.cloudstorage.proto.CloudStorageServiceDownloadRequest, com.cloudstorage.proto.CloudStorageServiceDownloadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Download"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cloudstorage.proto.CloudStorageServiceDownloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cloudstorage.proto.CloudStorageServiceDownloadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudStorageServiceMethodDescriptorSupplier("Download"))
              .build();
        }
      }
    }
    return getDownloadMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CloudStorageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudStorageServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudStorageServiceStub>() {
        @java.lang.Override
        public CloudStorageServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudStorageServiceStub(channel, callOptions);
        }
      };
    return CloudStorageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static CloudStorageServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudStorageServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudStorageServiceBlockingV2Stub>() {
        @java.lang.Override
        public CloudStorageServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudStorageServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return CloudStorageServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudStorageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudStorageServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudStorageServiceBlockingStub>() {
        @java.lang.Override
        public CloudStorageServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudStorageServiceBlockingStub(channel, callOptions);
        }
      };
    return CloudStorageServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CloudStorageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudStorageServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudStorageServiceFutureStub>() {
        @java.lang.Override
        public CloudStorageServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudStorageServiceFutureStub(channel, callOptions);
        }
      };
    return CloudStorageServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.cloudstorage.proto.CloudStorageServiceUploadRequest> upload(
        io.grpc.stub.StreamObserver<com.cloudstorage.proto.CloudStorageServiceUploadResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUploadMethod(), responseObserver);
    }

    /**
     */
    default void download(com.cloudstorage.proto.CloudStorageServiceDownloadRequest request,
        io.grpc.stub.StreamObserver<com.cloudstorage.proto.CloudStorageServiceDownloadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDownloadMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CloudStorageService.
   */
  public static abstract class CloudStorageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CloudStorageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CloudStorageService.
   */
  public static final class CloudStorageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CloudStorageServiceStub> {
    private CloudStorageServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudStorageServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudStorageServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.cloudstorage.proto.CloudStorageServiceUploadRequest> upload(
        io.grpc.stub.StreamObserver<com.cloudstorage.proto.CloudStorageServiceUploadResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void download(com.cloudstorage.proto.CloudStorageServiceDownloadRequest request,
        io.grpc.stub.StreamObserver<com.cloudstorage.proto.CloudStorageServiceDownloadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CloudStorageService.
   */
  public static final class CloudStorageServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CloudStorageServiceBlockingV2Stub> {
    private CloudStorageServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudStorageServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudStorageServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<com.cloudstorage.proto.CloudStorageServiceUploadRequest, com.cloudstorage.proto.CloudStorageServiceUploadResponse>
        upload() {
      return io.grpc.stub.ClientCalls.blockingClientStreamingCall(
          getChannel(), getUploadMethod(), getCallOptions());
    }

    /**
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.cloudstorage.proto.CloudStorageServiceDownloadResponse>
        download(com.cloudstorage.proto.CloudStorageServiceDownloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getDownloadMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CloudStorageService.
   */
  public static final class CloudStorageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudStorageServiceBlockingStub> {
    private CloudStorageServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudStorageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudStorageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.cloudstorage.proto.CloudStorageServiceDownloadResponse> download(
        com.cloudstorage.proto.CloudStorageServiceDownloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDownloadMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CloudStorageService.
   */
  public static final class CloudStorageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudStorageServiceFutureStub> {
    private CloudStorageServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudStorageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudStorageServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DOWNLOAD = 0;
  private static final int METHODID_UPLOAD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DOWNLOAD:
          serviceImpl.download((com.cloudstorage.proto.CloudStorageServiceDownloadRequest) request,
              (io.grpc.stub.StreamObserver<com.cloudstorage.proto.CloudStorageServiceDownloadResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.upload(
              (io.grpc.stub.StreamObserver<com.cloudstorage.proto.CloudStorageServiceUploadResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getUploadMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.cloudstorage.proto.CloudStorageServiceUploadRequest,
              com.cloudstorage.proto.CloudStorageServiceUploadResponse>(
                service, METHODID_UPLOAD)))
        .addMethod(
          getDownloadMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.cloudstorage.proto.CloudStorageServiceDownloadRequest,
              com.cloudstorage.proto.CloudStorageServiceDownloadResponse>(
                service, METHODID_DOWNLOAD)))
        .build();
  }

  private static abstract class CloudStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudStorageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cloudstorage.proto.MainProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudStorageService");
    }
  }

  private static final class CloudStorageServiceFileDescriptorSupplier
      extends CloudStorageServiceBaseDescriptorSupplier {
    CloudStorageServiceFileDescriptorSupplier() {}
  }

  private static final class CloudStorageServiceMethodDescriptorSupplier
      extends CloudStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CloudStorageServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CloudStorageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CloudStorageServiceFileDescriptorSupplier())
              .addMethod(getUploadMethod())
              .addMethod(getDownloadMethod())
              .build();
        }
      }
    }
    return result;
  }
}
