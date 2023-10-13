package com.template.rpc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.template.pojo.ServerConnectionConfig;
import com.template.rpc.impl.RPCInterface;
import com.template.utils.PathUtils;
import com.template.rpc.RPCService.HelloMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;

public class RPCClient {

    public static ExecutorService executorService;
    private List<ServerConnectionConfig.Endpoint> endpoints;
    public static List<RPCInterface> rpcInterfaces = new ArrayList<>();

    public RPCClient(String configFile) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(PathUtils.getRealPath(configFile))));
        // Create a Gson instance
        Gson gson = new GsonBuilder().create();
        // Parse the JSON string into ServerConfigData
        ServerConnectionConfig configData = gson.fromJson(jsonString, ServerConnectionConfig.class);
        // Access the endpoints list
        endpoints = configData.endpoints;
        // Print the result
        for (ServerConnectionConfig.Endpoint endpoint : endpoints) {
            rpcInterfaces.add(new RPCInterface(endpoint.getIp(), endpoint.getPort()));
        }
        executorService = Executors.newFixedThreadPool(endpoints.size());
    }

    public void rpcHello(HelloMessage message) throws Exception {
        List<Future<HelloMessage>> futureResponseList = null;

        List<Callable<HelloMessage>> tasks = new ArrayList<>();

        for (RPCInterface rpcInterface : rpcInterfaces) {
            tasks.add(() -> rpcInterface.rpcHello(message));
        }
        futureResponseList = executorService.invokeAll(tasks);
        for (Future<HelloMessage> futureResponse : futureResponseList) {
            HelloMessage response = futureResponse.get();
            System.out.println(response.getMessage());
        }
    }
}
