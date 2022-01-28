package com.shang.websocket.controller;

import com.shang.websocket.service.WebSocketSessionManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.Session;
import java.io.IOException;

/**
 * 发送消息的controller
 */
@RestController
public class SendMsgController {

    @PostMapping("/sendMsg")
    public String sendMsg(String name, String msg){
        Session session = WebSocketSessionManager.get(name);
        if (session != null){
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "发送成功";
    }
}
