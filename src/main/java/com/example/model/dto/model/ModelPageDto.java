package com.example.model.dto.model;


import com.example.common.validate.GetGroup;
import com.example.common.validate.PostGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

import static com.example.common.base.Constants.REGEX_MODEL_TYPE_STR;

/**
 * @author Peng
 * @date 2025-10-16 19:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ModelPageDto implements Serializable {

    /**
     * 模型类型（eq）
     */
    @NotBlank(message = "类型不能为空", groups = {PostGroup.class})
    @Pattern(regexp = REGEX_MODEL_TYPE_STR, message = "无此模型类型", groups = {GetGroup.class})
    private String type;

    /**
     * 模型服务（eq）
     */
    private String service;

    /**
     * 模型名称（like）
     */
    private String name;

    /**
     * 模型服务URL（like）
     */
    private String baseUrl;

    /**
     * 模型状态（eq）
     */
    private Integer state;

    @Serial
    private static final long serialVersionUID = 1673409342477821184L;

}
