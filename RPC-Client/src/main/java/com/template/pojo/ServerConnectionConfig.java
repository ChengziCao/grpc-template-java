package com.template.pojo;

import java.util.List;

public class ServerConnectionConfig {
    public static class Endpoint {
        private String ip;
        private Integer port;

        public Endpoint(String ip, Integer port) {
            this.ip = ip;
            this.port = port;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }
    }

    public List<Endpoint> endpoints;

}
