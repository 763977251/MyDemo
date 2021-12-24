package com.shang.biuilderPattern;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("发送短信");
    }
}
