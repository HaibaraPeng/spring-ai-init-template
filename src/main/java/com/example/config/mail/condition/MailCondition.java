package com.example.config.mail.condition;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Peng
 * @date 2025-09-26 16:42
 */
public class MailCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("spring.mail.enable");
        return StringUtils.equals(Boolean.TRUE.toString(), property);
    }

}
