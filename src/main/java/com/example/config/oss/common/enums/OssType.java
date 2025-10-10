package com.example.config.oss.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Peng
 * @date 2025-10-10 16:11
 */
@Getter
@AllArgsConstructor
public enum OssType {

    /**
     * MinIO
     */
    MINIO("minio"),

    /**
     * 阿里云OSS
     */
    ALI("ali"),

    /**
     * 腾讯云COS
     */
    TENCENT("tencent");

    private final String typeName;

}
