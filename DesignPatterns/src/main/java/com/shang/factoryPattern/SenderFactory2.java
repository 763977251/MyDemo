package com.shang.factoryPattern;

/**
 * 多个工厂方法
 * 此种方式就要求调用方判断调用那个方法
 */
public class SenderFactory2 {
    public Sender produceSms(){
        return new SmsSender();
    }
    public Sender produceMail(){
        return new MailSender();
    }
}
