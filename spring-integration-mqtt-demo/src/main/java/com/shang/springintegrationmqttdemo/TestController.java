package com.shang.springintegrationmqttdemo;

import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试controller
 *
 * @author 10699518
 */
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    private final MqttProducer mqttProducer;

    public TestController(MqttProducer mqttProducer) {
        this.mqttProducer = mqttProducer;
    }

    /**
     * 发送消息测试
     *
     * @param topic 主题
     * @param data  内容
     */
    @PostMapping("/send")
    public ResponseEntity<String> send(String topic, String data) {
        this.logger.info("开始发送mqtt消息,主题：{},消息：{}", topic, data);
        if (StringUtils.isNotBlank(topic)) {
            mqttProducer.sendToMqtt(topic, 1, data);
            this.logger.info("发送mqtt消息完成,主题：{},消息：{}", topic, data);
            return ResponseEntity.ok("execute successful");
        } else {
            return ResponseEntity.ok("topic is blank");
        }
    }
}
