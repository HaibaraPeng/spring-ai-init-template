package com.example.config.redisson.condition;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Peng
 * @date 2025-10-09 11:39
 */
public class RedissonClusterCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("redisson.cluster-servers-config.enable-cluster");
        return StringUtils.equals(Boolean.TRUE.toString(), property);
    }

}
