package com.template.rpc.impl;


import com.template.rpc.RPCHelloServiceGrpc;
import com.template.rpc.RPCService;
import io.grpc.stub.StreamObserver;

public class RPCHelloImpl extends RPCHelloServiceGrpc.RPCHelloServiceImplBase {
    @Override
    public void hello(RPCService.HelloMessage request, StreamObserver<RPCService.HelloMessage> responseObserver) {
        String helloMessage = "Hello, this is a greeting message from the server!";
        RPCService.HelloMessage response = RPCService.HelloMessage.newBuilder()
                .setMessage(helloMessage)
                .build();
        System.out.printf("Receive Message: [%s]%n", request.getMessage());
        // Send message to the client
        responseObserver.onNext(response);
        // Inform the completion of the response to the client
        responseObserver.onCompleted();
    }
}
