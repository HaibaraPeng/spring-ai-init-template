package com.example.model.vo.auth;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Peng
 * @date 2025-09-24 22:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AuthLoginVo implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String name;

    /**
     * 头像ID
     */
    private Long avatarId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 角色（admin/user）
     */
    private String role;

    @Serial
    private static final long serialVersionUID = 3559885844441381994L;

}
