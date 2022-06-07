package com.shang.websocketclient;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;

@Service
public class MyWebSocketClient extends WebSocketClient {

    private static Logger LOG = LoggerFactory.getLogger(MyWebSocketClient.class);
    private static URI socketUrl;

    static {
        try {
            socketUrl = new URI("ws://127.0.0.1:9009/ws/123");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public MyWebSocketClient() {
        super(socketUrl);
    }

    @PostConstruct
    public void init() throws URISyntaxException {
        LOG.info("进入init方法");
        this.connect();
        CompletableFuture.runAsync(() -> {
            try {
                while (true) {
                    Thread.sleep(10000);
                    if (!this.isOpen()) {
                        LOG.info("init--reconnect");
                        this.reconnect();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        LOG.info("------ MyWebSocket onOpen ------");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        LOG.info("------ MyWebSocket onClose ------");
    }

    @Override
    public void onError(Exception arg0) {
        LOG.info("------ MyWebSocket onError ------");
    }

    @SneakyThrows
    @Override
    public void onMessage(String arg0) {
        String text = String.valueOf(JSON.parse(arg0));
        JSONObject jsonObject = JSONUtil.parseObj(text);
        LOG.info("接收到数据： " + jsonObject);
    }

}
