package com.shang.factoryPattern;

import org.junit.jupiter.api.Test;

public class FactoryTest {
    @Test
    public void test1(){
        SenderFactory senderFactory = new SenderFactory();
        Sender mail = senderFactory.produce(MailSender.class);
        mail.send();
        Sender sms = senderFactory.produce(SmsSender.class);
        sms.send();
        senderFactory.produce(null);
    }

    @Test
    public void test2(){
        SenderFactory2 senderFactory2 = new SenderFactory2();
        Sender sender = senderFactory2.produceMail();
        sender.send();
    }

    @Test
    public void test3(){
        Sender sender = SenderFactory3.produceSms();
        sender.send();
    }

    @Test
    public void test4(){
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
