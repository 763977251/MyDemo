package com.shang.websocket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;

@Component
@ServerEndpoint("/ws/{name}")   // 此注解是多例
public class WebSocketServer {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private String name;
    private Session session;

    @OnOpen
    public void onOpen(@PathParam(value = "name") String name, Session session) throws IOException {
        if (!ObjectUtils.isEmpty(name)) {
            logger.info("名称合法，添加到Map中，name={}",name);
            this.name = name;
            this.session = session;
            WebSocketSessionManager.add(name,session);
        } else {
            logger.info("名称不合法，关闭连接，name={}",name);
            session.close();
        }
    }

    @OnMessage
    public void onMessage(String message) {
        logger.info("接收到消息 {}", message);
        sendMsgToAllClient(message);
    }

    @OnError
    public void onError(Throwable throwable) {
        logger.error("连接发生错误 {}", throwable.getMessage());
        try {
            WebSocketSessionManager.remove(this.name);
            this.session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        try {
            logger.info("链接关闭，name={}",this.name);
            WebSocketSessionManager.remove(this.name);
            this.session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMsgToAllClient(String message) {
        for (Map.Entry<String, Session> sessionEntry : WebSocketSessionManager.SESSION_POOL.entrySet()) {
            Session value = sessionEntry.getValue();
            try {
                value.getBasicRemote().sendText("广播消息 " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
