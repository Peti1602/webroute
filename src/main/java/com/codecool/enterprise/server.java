package com.codecool.enterprise;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class server {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new MyHandler());
        server.createContext("/user", new MyHandler());
        server.createContext("/test", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

}
