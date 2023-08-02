package com.template;

import com.template.rpc.RPCServer;

public class ServerApplication {
    public static Integer serverPort;
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("args length error.");
            return;
        }
        try {
            serverPort = Integer.parseInt(args[0]);
            RPCServer server = new RPCServer(serverPort);
            server.start();
            server.blockUntilShutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
