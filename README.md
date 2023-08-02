# grpc-template-java

An Example of a Distributed Service with Java gRPC.

I tested it on macOS with JDK11, theoretically it is also fully available for Windows and Linux.

## Modules

RPC-Client

- ClientApplication.java      # Entry point of the client application
- pojo.ServerConnectionConfig.java    # POJO class to hold server connection configuration
- rpc.RPCClient.java        # Client implementation to communicate with the gRPC server
- rpc.RPCThread.java        # Thread class for handling gRPC requests asynchronously
- resources/config.json     # JSON configuration file containing server connection details

RPC-Core

- rpc.RPCHelloServiceGrpc.java    # gRPC-generated service class for defining the Hello service
- rpc.RPCService.java    # Custom implementation of the Hello service
- utils.PathUtils.java    # Utility class for handling file paths
- resources/common.proto    # Protocol Buffers file defining the service messages and methods

RPC-Server

- ServerApplication.java    # Entry point of the server application
- rpc.RPCHelloImp.java    # Implementation of the Hello service interface
- rpc.RPCServer.java    # Server implementation to start the gRPC server

## Test

Run `package.sh`. 

When you are in the development stage and modify *.proto, you can just use `compile.sh`.

Run `start-server.sh` first, then `start-client.sh`.

## Notes

Since the protobuf-maven-plugin does not provide an arm version, if you are using macOS (Apple Silicon), please add the following content to your maven settings.xml file.

```xml
<profiles>
    <profile>
      <id>macos</id>
      <properties>
        <os.detected.classifier>osx-x86_64</os.detected.classifier>
      </properties>
    </profile>
</profiles>
<activeProfiles>
    <activeProfile>macos</activeProfile>
</activeProfiles>
```

