package com.example.config.captcha.aop;


import com.example.common.base.ReturnCode;
import com.example.config.captcha.condition.CaptchaCondition;
import com.example.config.captcha.model.Captcha;
import com.example.config.captcha.service.CaptchaService;
import com.example.exception.customize.CustomizeReturnException;
import jakarta.annotation.Resource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author Peng
 * @date 2025-09-24 21:57
 */
@Component
@EnableAspectJAutoProxy
@Aspect
@Conditional(CaptchaCondition.class)
public class CaptchaAop {

    @Resource
    private CaptchaService captchaService;

    /**
     * 定义切入点方法
     */
    @Pointcut("@annotation(com.example.config.captcha.annotation.EnableCaptcha)")
    private void pointCutMethod() {

    }

    /**
     * 前置通知
     */
    @Before("pointCutMethod()")
    public void doBefore(JoinPoint joinPoint) {
        String uuid = "";
        String code = "";
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            Class<?> argClass = arg.getClass();
            try {
                Field captchaField = argClass.getDeclaredField("captcha");
                captchaField.setAccessible(true);
                Captcha captcha = (Captcha) captchaField.get(arg);
                uuid = captcha.getUuid();
                code = captcha.getCode();
            } catch (Exception e) {
                throw new CustomizeReturnException(ReturnCode.PARAMETER_FORMAT_MISMATCH, "缺少验证码");
            }
        }
        captchaService.checkCaptcha(code, uuid);
    }

}
