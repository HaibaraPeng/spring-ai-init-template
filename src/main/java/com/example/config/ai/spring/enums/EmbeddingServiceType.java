package com.example.config.ai.spring.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Peng
 * @date 2025-10-16 19:52
 */
@Getter
@AllArgsConstructor
public enum EmbeddingServiceType {

    /**
     * OpenAI服务
     */
    OpenAI("OpenAI", "openai"),

    /**
     * Ollama服务
     */
    Ollama("Ollama", "ollama"),

    /**
     * ZhiPuAi服务
     */
    ZhiPuAI("智谱AI", "zhipu"),

    /**
     * MistralAi服务
     */
    MistralAI("MistralAI", "mistralai"),

    /**
     * MiniMax服务
     */
    MiniMax("MiniMax", "minimax"),

    /**
     * AzureOpenAI服务
     */
    AzureOpenAI("AzureOpenAI", "azureopenai");

    /**
     * 模型中文标签
     */
    private final String label;

    /**
     * 模型英文名称
     */
    private final String value;

}
