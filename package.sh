#!/bin/bash
mvn clean package -T 1C -Dmaven.test.skip=true
echo "package completed."

cp RPC-Client/target/rpc-client-jar-with-dependencies.jar deploy/rpc-client.jar
cp RPC-Client/src/main/resources/config.json deploy/config.json

# from 1, step 1, to 3
for ((i=1; i<=3; i++))
do
    if [ ! -d "deploy/server$i" ]; then
        mkdir -p "deploy/server$i"
    fi
    cp RPC-Server/target/rpc-server-jar-with-dependencies.jar "deploy/server$i/rpc-server.jar"
done

echo "copy completed."
