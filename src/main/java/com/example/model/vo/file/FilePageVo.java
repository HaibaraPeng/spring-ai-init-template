package com.example.model.vo.file;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Peng
 * @date 2025-10-16 19:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FilePageVo implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 原名称
     */
    private String originalName;

    /**
     * 扩展名
     */
    private String suffix;

    /**
     * 大小
     */
    private String size;

    /**
     * 地址
     */
    private String url;

    /**
     * OSS类型
     */
    private String ossType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    @Serial
    private static final long serialVersionUID = -4793285381130452793L;

}
