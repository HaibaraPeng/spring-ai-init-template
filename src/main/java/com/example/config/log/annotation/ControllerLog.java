package com.example.config.log.annotation;


import com.example.config.log.enums.Operator;

import java.lang.annotation.*;

/**
 * @author Peng
 * @date 2025-09-24 22:16
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ControllerLog {

    /**
     * 操作描述
     */
    String description() default "";

    /**
     * 操作类型（0其他1增2删3查4改5导入6导出）
     */
    Operator operator() default Operator.OTHER;

    /**
     * 屏蔽请求/响应参数
     */
    String[] maskParams() default {};

}
