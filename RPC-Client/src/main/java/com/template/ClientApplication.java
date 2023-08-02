package com.template;

import com.template.rpc.RPCClient;
import com.template.rpc.RPCService;

public class ClientApplication {

    private static String configFileName = "config.json";

    public static void main(String[] args) {
        try {
            RPCClient rpcClient = new RPCClient(configFileName);
            RPCService.HelloMessage helloMessage = RPCService.HelloMessage.newBuilder()
                    .setMessage("Hello, this is a greeting message from the client")
                    .build();
            rpcClient.rpcHello(helloMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
