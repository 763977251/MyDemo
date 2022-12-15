package com.shang.springintegrationmqttdemo;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@IntegrationComponentScan
@ConditionalOnProperty(value = "spring.mqtt.enable", havingValue = "true")
public class MqttConfig {

    private static final Logger logger = LoggerFactory.getLogger(MqttConfig.class);

    @Value("${server.port:8080}")
    private String port;

    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.url}")
    private String hostUrl;

    @Value("${spring.mqtt.producerclientid}")
    private String producerClientId;

    @Value("${spring.mqtt.producertopic}")
    private String producerTopic;

    //生产者和消费者是单独连接服务器会使用到一个clientid（客户端id），如果是同一个clientid的话会出现Lost connection: 已断开连接; retrying...
    @Value("${spring.mqtt.consumerclientid}")
    private String consumerClientId;

    @Value("${spring.mqtt.consumertopic}")
    private String[] consumerTopic;

    @Value("${spring.mqtt.timeout}")
    private int timeout;   //连接超时

    @Value("${spring.mqtt.keepalive}")
    private int keepalive;  //连接超时

    @Value("${spring.mqtt.automaticReconnect:true}")
    private boolean automaticReconnect;  //是否自动重连

    @Value("${spring.mqtt.cleanSession:true}")
    private boolean cleanSession;  //是否清除session，如果fasle不清楚即保持上次的连接

    //入站通道名（消费者）订阅的bean名称
    public static final String CHANNEL_NAME_IN = "mqttInboundChannel";
    //出站通道名（生产者）发布的bean名称
    public static final String CHANNEL_NAME_OUT = "mqttOutboundChannel";

    /**
     * MQTT连接器选项
     *
     * @return {@link MqttConnectOptions}
     */
    @Bean
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        mqttConnectOptions.setKeepAliveInterval(keepalive);
        mqttConnectOptions.setCleanSession(cleanSession);
        mqttConnectOptions.setAutomaticReconnect(automaticReconnect);
        return mqttConnectOptions;
    }

    /**
     * MQTT客户端
     *
     * @return {@link org.springframework.integration.mqtt.core.MqttPahoClientFactory}
     */
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptions());
        return factory;
    }

    /*******************************生产者*******************************************/

    /**
     * MQTT信息通道（生产者）
     *
     * @return {@link MessageChannel}
     */
    @Bean(name = CHANNEL_NAME_OUT)
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    /**
     * MQTT消息处理器（生产者）
     *
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = CHANNEL_NAME_OUT)
    public MessageHandler mqttOutbound() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(producerClientId + "_" + hostAddress + "_" + port, mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(producerTopic);
        return messageHandler;
    }

    /*******************************消费者*******************************************/

    /**
     * MQTT信息通道（消费者）
     *
     * @return {@link MessageChannel}
     */
    @Bean(name = CHANNEL_NAME_IN)
    public MessageChannel mqttInboundChannel() {
        return new DirectChannel();
    }

    /**
     * MQTT消息订阅绑定（消费者）
     *
     * @return {@link org.springframework.integration.core.MessageProducer}
     */
    @Bean
    public MessageProducer inbound() throws UnknownHostException {
        // 可以同时消费（订阅）多个Topic
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(consumerClientId + "_" + hostAddress + "_" + port, mqttClientFactory(), consumerTopic);
        adapter.setCompletionTimeout(timeout);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        // 设置订阅通道
        adapter.setOutputChannel(mqttInboundChannel());
        return adapter;
    }

    /**
     * MQTT消息处理器（消费者）
     *
     * @return {@link MessageHandler}
     */
    @Bean
    @ServiceActivator(inputChannel = CHANNEL_NAME_IN)
    public MessageHandler handler() {
        //方法1
//        return new MessageHandler() {
//            @Override
//            public void handleMessage(Message<?> message) throws MessagingException {
//                String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
//                String msg = message.getPayload().toString();
//                logger.info("接收到订阅消息:\ntopic:" + topic + "\nmessage:" + msg);
//            }
//        };
        //方法2
        return new MqttConsumer();
    }

    //如果我要配置多个client，只要配置多个通道即可
    //通道2
//    @Bean
//    public MessageChannel mqttInputChannelTwo() {
//        return new DirectChannel();
//    }
//    //配置client2，监听的topic:hell2,hello3
//    @Bean
//    public MessageProducer inbound1() {
//        MqttPahoMessageDrivenChannelAdapter adapter =
//                new MqttPahoMessageDrivenChannelAdapter(clientId, mqttClientFactory(),
//                        "hello2","hello3");
//        adapter.setCompletionTimeout(timeout);
//        adapter.setConverter(new DefaultPahoMessageConverter());
//        adapter.setQos(1);
//        adapter.setOutputChannel(mqttInputChannelTwo());
//        return adapter;
//    }
//
//    //通过通道2获取数据
//    @Bean
//    @ServiceActivator(inputChannel = "mqttInputChannelTwo")
//    public MessageHandler handlerTwo() {
//        return new MqttConsumer();
//    }
}
