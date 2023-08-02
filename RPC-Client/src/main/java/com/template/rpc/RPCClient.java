package com.template.rpc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.template.pojo.ServerConnectionConfig;
import com.template.utils.PathUtils;
import com.template.rpc.RPCService.HelloMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;

public class RPCClient {

    public static ExecutorService executorService;
    private List<ServerConnectionConfig.Endpoint> endpoints = new ArrayList<>();
    public static List<RPCThread> rpcThreads = new ArrayList<>();

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
            rpcThreads.add(new RPCThread(endpoint.getIp(), endpoint.getPort()));
        }
        executorService = Executors.newFixedThreadPool(endpoints.size());
    }

    public void rpcHello(HelloMessage message) throws Exception {
        List<Future<HelloMessage>> futureResponseList = null;

        List<Callable<HelloMessage>> tasks = new ArrayList<>();

        for (RPCThread rpcThread : rpcThreads) {
            tasks.add(() -> rpcThread.rpcHello(message));
        }
        futureResponseList = executorService.invokeAll(tasks);
        for (Future<HelloMessage> futureResponse : futureResponseList) {
            HelloMessage response = futureResponse.get();
            System.out.println(response.getMessage());
        }

    }
}
