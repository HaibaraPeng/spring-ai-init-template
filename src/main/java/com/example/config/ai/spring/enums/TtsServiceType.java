package com.example.config.ai.spring.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Peng
 * @date 2025-10-16 20:49
 */
@Getter
@AllArgsConstructor
public enum TtsServiceType {

    /**
     * OpenAi服务
     */
    OpenAI("OpenAI", "openai");

    /**
     * 模型中文标签
     */
    private final String label;

    /**
     * 模型英文名称
     */
    private final String value;

}
