package com.example.model.dto.user;


import com.example.common.validate.PostGroup;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Peng
 * @date 2025-10-10 16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserExcelDto implements Serializable {

    /**
     * 用户信息表（大小：200KB；格式：xls或xlsx）
     */
    @NotNull(message = "用户信息表不能为空", groups = {PostGroup.class})
    private MultipartFile file;

    @Serial
    private static final long serialVersionUID = -5473146660872340062L;

}
