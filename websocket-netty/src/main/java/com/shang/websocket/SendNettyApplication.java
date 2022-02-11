package com.shang.websocket;

import com.shang.websocket.service.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class SendNettyApplication implements CommandLineRunner {

    @Value("${netty.port}")
    private int port;

    @Value("${netty.url}")
    private String url;

    @Autowired
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(SendNettyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(url,port);
        System.out.println("run .... . ... "+url);
        nettyServer.start(address);
    }
}

