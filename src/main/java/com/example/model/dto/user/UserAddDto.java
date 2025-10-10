package com.example.model.dto.user;


import com.example.common.validate.PostGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

import static com.example.common.base.Constants.REGEX_NUMBER_AND_LETTER_STR;

/**
 * @author Peng
 * @date 2025-10-10 15:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserAddDto implements Serializable {

    /**
     * 账号
     */
    @Size(min = 2, max = 16, message = "账号长度介于2-16位之间", groups = {PostGroup.class})
    @NotBlank(message = "账号不能为空", groups = {PostGroup.class})
    @Pattern(regexp = REGEX_NUMBER_AND_LETTER_STR, message = "账户名称包含特殊字符", groups = {PostGroup.class})
    private String account;

    /**
     * 密码
     */
    @Size(min = 5, max = 16, message = "密码长度介于5-16位之间", groups = {PostGroup.class})
    @NotBlank(message = "密码不能为空", groups = {PostGroup.class})
    private String password;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式错误", groups = {PostGroup.class})
    @NotBlank(message = "邮箱不能为空", groups = {PostGroup.class})
    private String email;

    /**
     * 名称
     */
    @Size(min = 1, max = 16, message = "名称长度介于1-16位之间", groups = {PostGroup.class})
    @NotBlank(message = "名称不能为空", groups = {PostGroup.class})
    private String name;

    @Serial
    private static final long serialVersionUID = 3927650956290675182L;

}
