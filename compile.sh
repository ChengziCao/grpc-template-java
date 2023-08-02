#/bin/bash
cd RPC-core
mvn protobuf:compile -f pom.xml
mvn protobuf:compile-custom -f pom.xml
cd ..
