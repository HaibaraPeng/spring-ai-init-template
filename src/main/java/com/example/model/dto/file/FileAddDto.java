package com.example.model.dto.file;


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
 * @date 2025-10-16 19:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FileAddDto implements Serializable {

    /**
     * 文件信息（大小：10MB；格式：任意）
     */
    @NotNull(message = "文件不能为空", groups = {PostGroup.class})
    private MultipartFile file;

    @Serial
    private static final long serialVersionUID = -5683429946233594776L;

}
