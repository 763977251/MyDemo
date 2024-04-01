package com.shang.emaildemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 10699518
 */
@Data
@Component
@ConfigurationProperties(prefix = "mail.receive")
public class MailReceiveConfig {
    private Boolean isSSL;
    private String host;
    private String port;
    /**
     * 接收邮件账户
     */
    private String userName;
    /**
     * 密码传授权码
     */
    private String passWord;
    private String attachmentDir;
}
