package com.shang.springintegrationmqttdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

/**
 * @author 10699518
 */
@Component
@ConditionalOnProperty(value = "spring.mqtt.enable", havingValue = "true")
public class MqttConsumer implements MessageHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        String topic = String.valueOf(message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
        String payload = String.valueOf(message.getPayload());
        logger.info("接收到 mqtt消息，主题:{} 消息:{}", topic, payload);
    }
}
