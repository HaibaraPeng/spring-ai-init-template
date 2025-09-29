package com.example.model.dto.auth;


import com.example.common.validate.PostGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Peng
 * @date 2025-09-29 17:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AuthEmailCodeDto implements Serializable {

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空", groups = {PostGroup.class})
    private String account;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式错误", groups = {PostGroup.class})
    @NotBlank(message = "邮箱不能为空", groups = {PostGroup.class})
    private String email;

    @Serial
    private static final long serialVersionUID = -6780315895322389464L;

}
