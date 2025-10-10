package com.example.model.dto.user;


import com.example.common.validate.PutGroup;
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
 * @date 2025-10-10 16:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserUpdateEmailDto implements Serializable {

    /**
     * 新名称
     */
    @Email(message = "邮箱格式错误", groups = {PutGroup.class})
    @NotBlank(message = "新邮箱不能为空", groups = {PutGroup.class})
    private String newEmail;

    @Serial
    private static final long serialVersionUID = -5897238396873323519L;

}
