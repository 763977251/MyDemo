package com.shang.springintegrationmqttdemo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @author 10699518
 */
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
@Component
@ConditionalOnProperty(value = "spring.mqtt.enable", havingValue = "true")
public interface MqttProducer {

    /**
     * payload或者data是发送消息的内容
     * topic是消息发送的主题,这里可以自己灵活定义,也可以使用默认的主题,就是配置文件的主题,qos是mqtt 对消息处理的几种机制分为0,1,2
     * 其中0表示的是订阅者没收到消息不会再次发送,消息会丢失,1表示的是会尝试重试,一直到接收到消息,但这种情况可能导致订阅者收到多次重复消息,2相比多了一次去重的动作,确保订阅者收到的消息有一次
     * 当然,这三种模式下的性能肯定也不一样,qos=0是最好的,2是最差的
     */

    void sendToMqtt(String data);

    void sendToMqtt(String payload, @Header(MqttHeaders.TOPIC) String topic);

    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
}
