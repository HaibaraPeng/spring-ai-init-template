package com.example.model.vo.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Peng
 * @date 2025-10-10 15:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserPageVo implements Serializable {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户头像ID
     */
    private Long avatarId;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户角色（admin/user）
     */
    private String role;

    /**
     * 用户状态（0表示启用，1表示禁用）
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    @Serial
    private static final long serialVersionUID = 8592635184824125033L;

}
