package com.shang.websocket.client;

public class TestNettyClient {
    public static void main(String[] args) {
        //开启10条线程，每条线程就相当于一个客户端
        for (int i = 1; i <= 1; i++) {
            new Thread(new NettyClient("thread" + "--" + i)).start();
        }
    }
}
