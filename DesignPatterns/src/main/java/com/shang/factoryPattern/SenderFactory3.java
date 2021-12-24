package com.shang.factoryPattern;

/**
 * 静态工厂方法
 */
public class SenderFactory3 {
    public static Sender produceSms(){
        return new SmsSender();
    }
    public static Sender produceMail(){
        return new MailSender();
    }
}
