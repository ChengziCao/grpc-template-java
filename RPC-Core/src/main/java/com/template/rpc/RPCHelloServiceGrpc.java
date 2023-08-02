package com.template.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service definition for RPCService
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.31.1)",
    comments = "Source: common.proto")
public final class RPCHelloServiceGrpc {

  private RPCHelloServiceGrpc() {}

  public static final String SERVICE_NAME = "RPCHelloService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.template.rpc.RPCService.HelloMessage,
      com.template.rpc.RPCService.HelloMessage> getHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "hello",
      requestType = com.template.rpc.RPCService.HelloMessage.class,
      responseType = com.template.rpc.RPCService.HelloMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.template.rpc.RPCService.HelloMessage,
      com.template.rpc.RPCService.HelloMessage> getHelloMethod() {
    io.grpc.MethodDescriptor<com.template.rpc.RPCService.HelloMessage, com.template.rpc.RPCService.HelloMessage> getHelloMethod;
    if ((getHelloMethod = RPCHelloServiceGrpc.getHelloMethod) == null) {
      synchronized (RPCHelloServiceGrpc.class) {
        if ((getHelloMethod = RPCHelloServiceGrpc.getHelloMethod) == null) {
          RPCHelloServiceGrpc.getHelloMethod = getHelloMethod =
              io.grpc.MethodDescriptor.<com.template.rpc.RPCService.HelloMessage, com.template.rpc.RPCService.HelloMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "hello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.template.rpc.RPCService.HelloMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.template.rpc.RPCService.HelloMessage.getDefaultInstance()))
              .setSchemaDescriptor(new RPCHelloServiceMethodDescriptorSupplier("hello"))
              .build();
        }
      }
    }
    return getHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPCHelloServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RPCHelloServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RPCHelloServiceStub>() {
        @java.lang.Override
        public RPCHelloServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RPCHelloServiceStub(channel, callOptions);
        }
      };
    return RPCHelloServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPCHelloServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RPCHelloServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RPCHelloServiceBlockingStub>() {
        @java.lang.Override
        public RPCHelloServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RPCHelloServiceBlockingStub(channel, callOptions);
        }
      };
    return RPCHelloServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPCHelloServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RPCHelloServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RPCHelloServiceFutureStub>() {
        @java.lang.Override
        public RPCHelloServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RPCHelloServiceFutureStub(channel, callOptions);
        }
      };
    return RPCHelloServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service definition for RPCService
   * </pre>
   */
  public static abstract class RPCHelloServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void hello(com.template.rpc.RPCService.HelloMessage request,
        io.grpc.stub.StreamObserver<com.template.rpc.RPCService.HelloMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.template.rpc.RPCService.HelloMessage,
                com.template.rpc.RPCService.HelloMessage>(
                  this, METHODID_HELLO)))
          .build();
    }
  }

  /**
   * <pre>
   * Service definition for RPCService
   * </pre>
   */
  public static final class RPCHelloServiceStub extends io.grpc.stub.AbstractAsyncStub<RPCHelloServiceStub> {
    private RPCHelloServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPCHelloServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPCHelloServiceStub(channel, callOptions);
    }

    /**
     */
    public void hello(com.template.rpc.RPCService.HelloMessage request,
        io.grpc.stub.StreamObserver<com.template.rpc.RPCService.HelloMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service definition for RPCService
   * </pre>
   */
  public static final class RPCHelloServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RPCHelloServiceBlockingStub> {
    private RPCHelloServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPCHelloServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPCHelloServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.template.rpc.RPCService.HelloMessage hello(com.template.rpc.RPCService.HelloMessage request) {
      return blockingUnaryCall(
          getChannel(), getHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service definition for RPCService
   * </pre>
   */
  public static final class RPCHelloServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RPCHelloServiceFutureStub> {
    private RPCHelloServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RPCHelloServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPCHelloServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.template.rpc.RPCService.HelloMessage> hello(
        com.template.rpc.RPCService.HelloMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPCHelloServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPCHelloServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HELLO:
          serviceImpl.hello((com.template.rpc.RPCService.HelloMessage) request,
              (io.grpc.stub.StreamObserver<com.template.rpc.RPCService.HelloMessage>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RPCHelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RPCHelloServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.template.rpc.RPCService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RPCHelloService");
    }
  }

  private static final class RPCHelloServiceFileDescriptorSupplier
      extends RPCHelloServiceBaseDescriptorSupplier {
    RPCHelloServiceFileDescriptorSupplier() {}
  }

  private static final class RPCHelloServiceMethodDescriptorSupplier
      extends RPCHelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RPCHelloServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RPCHelloServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RPCHelloServiceFileDescriptorSupplier())
              .addMethod(getHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
