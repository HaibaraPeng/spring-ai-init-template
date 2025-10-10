package com.example.model.dto.user;


import com.example.common.validate.PutGroup;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Peng
 * @date 2025-10-10 15:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserUpdateStateDto implements Serializable {

    /**
     * ID
     */
    @NotNull(message = "ID不能为空", groups = {PutGroup.class})
    private Long id;

    @Serial
    private static final long serialVersionUID = 6340692579539958471L;
}
