package com.shang.factoryPattern;

public class SmsSender implements Sender{
    @Override
    public void send() {
        System.out.println("发送短信");
    }
}
