package com.shang.emaildemo.controller;

import com.shang.emaildemo.util.MailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailTestController {

    private final MailUtil mailUtil;

    @PostMapping("/receiveEmailTest1")
    public String receiveEmailTest1() {
        try {
            mailUtil.receive();
            return "接收邮件成功";
        } catch (MailException e) {
            e.printStackTrace();
            return "接收邮件方失败";
        }
    }

}
