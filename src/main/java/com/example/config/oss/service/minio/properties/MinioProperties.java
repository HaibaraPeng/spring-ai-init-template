package com.example.config.oss.service.minio.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Peng
 * @date 2025-10-10 15:54
 */
@Data
@ConfigurationProperties(prefix = "oss.minio")
public class MinioProperties {

    /**
     * 是否开启
     */
    private Boolean enable = false;

    /**
     * 域名（一定是协议前缀+ip+port）
     */
    private String endpoint;

    /**
     * 是否开启TLS
     */
    private Boolean enableTls = false;

    /**
     * 用户的 SecretId
     */
    private String secretId;

    /**
     * 用户的 SecretKey
     */
    private String secretKey;

    /**
     * 桶名称
     */
    private String bucketName;

}
