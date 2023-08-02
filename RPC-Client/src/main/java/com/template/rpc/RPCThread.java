package com.template.rpc;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class RPCThread {
    private final RPCHelloServiceGrpc.RPCHelloServiceBlockingStub blockingStub;
    public String ipAddress;
    public Integer port;

    public RPCThread(String ipAddress, Integer port) {
        this.ipAddress = ipAddress;
        this.port = port;

        Channel channel =
                ManagedChannelBuilder.forAddress(ipAddress, port).usePlaintext().maxInboundMessageSize(1024 * 1024 * 1024).build();
        this.blockingStub = RPCHelloServiceGrpc.newBlockingStub(channel);
    }

    public RPCService.HelloMessage rpcHello(RPCService.HelloMessage message) {
        try {
            return blockingStub.hello(message);
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
