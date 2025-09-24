package com.example.config.captcha.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Peng
 * @date 2025-09-24 22:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Captcha implements Serializable {

    /**
     * 验证码
     */
    private String code;

    /**
     * 验证码UUID
     */
    private String uuid;

    @Serial
    private static final long serialVersionUID = -6070139749121232739L;

}
