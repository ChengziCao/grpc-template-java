package com.template.rpc.impl;

import com.template.rpc.RPCHelloServiceGrpc;
import com.template.rpc.RPCService;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class RPCInterface {
    private final RPCHelloServiceGrpc.RPCHelloServiceBlockingStub blockingStub;
    public String ipAddress;
    public Integer port;

    public RPCInterface(String ipAddress, Integer port) {
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
