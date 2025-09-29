package com.example.config.redisson.condition;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Peng
 * @date 2025-09-29 17:18
 */
public class RedissonCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String redissonSingleProperty = context.getEnvironment().getProperty("redisson.single-server-config" +
                ".enable-single");
        String redissonClusterProperty = context.getEnvironment().getProperty("redisson.cluster-servers-config" +
                ".enable-cluster");
        return StringUtils.equals(Boolean.TRUE.toString(), redissonSingleProperty) || StringUtils.equals("true",
                redissonClusterProperty);
    }

}
