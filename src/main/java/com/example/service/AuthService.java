package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.model.dto.auth.AuthEmailCodeDto;
import com.example.model.dto.auth.AuthLoginDto;
import com.example.model.dto.auth.AuthRegisterDto;
import com.example.model.dto.auth.AuthRetrievePasswordDto;
import com.example.model.entity.User;
import com.example.model.vo.auth.AuthLoginVo;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Peng
 * @date 2025-09-24 22:45
 */
public interface AuthService extends IService<User> {

    /**
     * 注册
     *
     * @param authRegisterDto 用户注册Dto类
     */
    void register(AuthRegisterDto authRegisterDto);

    /**
     * 注册后激活账号
     *
     * @param uuid 随机验证码
     */
    void activate(String uuid, HttpServletResponse response);

    /**
     * 登录
     *
     * @param authLoginDto 用户登录Dto类
     * @return 返回登录用户信息
     */
    AuthLoginVo login(AuthLoginDto authLoginDto);

    /**
     * 校验邮箱验证码
     *
     * @param authRetrievePasswordDto 找回密码Dto类
     */
    void checkEmailCode(AuthRetrievePasswordDto authRetrievePasswordDto);

    /**
     * 获取邮箱验证码
     *
     * @param authEmailCodeDto 邮箱验证码Dto类
     */
    void getEmailCode(AuthEmailCodeDto authEmailCodeDto);

}
