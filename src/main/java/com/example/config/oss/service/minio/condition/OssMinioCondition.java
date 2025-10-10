package com.example.config.oss.service.minio.condition;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Peng
 * @date 2025-10-10 15:55
 */
public class OssMinioCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("oss.minio.enable");
        return StringUtils.equals(Boolean.TRUE.toString(), property);
    }

}
