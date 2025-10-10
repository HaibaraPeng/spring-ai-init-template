package com.example.model.dto.user;


import com.example.common.validate.PutGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class UserUpdateNameDto implements Serializable {

    /**
     * 新名称
     */
    @Size(min = 1, max = 16, message = "名称长度介于1-16位之间", groups = {PutGroup.class})
    @NotBlank(message = "名称不能为空", groups = {PutGroup.class})
    private String newName;

    @Serial
    private static final long serialVersionUID = -400810866340194558L;

}
