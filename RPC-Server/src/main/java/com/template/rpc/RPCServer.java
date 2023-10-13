package com.template.rpc;

import com.template.rpc.impl.RPCHelloImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RPCServer {
    protected final int port;
    protected final Server server;

    public RPCServer(int port) {
        this.port = port;
        RPCHelloImpl service = new RPCHelloImpl();

        // 构建 gRPC 服务器
        server = ServerBuilder.forPort(port)
                .addService(service)
                .maxInboundMessageSize(Integer.MAX_VALUE)
                .build();
    }

    public void start() throws IOException {
        // 启动 gRPC 服务器
        server.start();
        System.out.println("Server started, listening on " + port);
        // 添加一个 JVM 关闭钩子，以确保在JVM关闭时调用this.shutdown()方法来关闭服务器。
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                this.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("server shut down.");
            }
        }));
    }

    public void shutdown() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
