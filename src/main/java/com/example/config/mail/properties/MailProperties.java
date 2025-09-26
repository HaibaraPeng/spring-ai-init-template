package com.example.config.mail.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Peng
 * @date 2025-09-26 16:44
 */
@Data
@ConfigurationProperties(prefix = "spring.mail")
public class MailProperties {

    /**
     * 是否开启邮件功能
     */
    private Boolean enable = false;

}