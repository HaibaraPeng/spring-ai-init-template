package com.example.config.captcha.service;


/**
 * @author Peng
 * @date 2025-09-24 22:02
 */
public interface CaptchaService {

//    /**
//     * 生成验证码
//     */
//    CaptchaCreate createCaptcha();

    /**
     * 校验验证码
     *
     * @param code 验证码
     * @param uuid 验证码的UUID
     */
    void checkCaptcha(String code, String uuid);

}
