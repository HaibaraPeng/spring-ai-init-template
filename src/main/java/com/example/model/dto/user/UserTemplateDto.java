package com.example.model.dto.user;


import cn.idev.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Peng
 * @date 2025-10-10 16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTemplateDto implements Serializable {

    /**
     * 账号
     */
    @ExcelProperty(value = "用户账号")
    private String account;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "用户邮箱")
    private String email;

    /**
     * 名称
     */
    @ExcelProperty(value = "用户名称")
    private String name;

    @Serial
    private static final long serialVersionUID = -6737409854767719305L;

}
