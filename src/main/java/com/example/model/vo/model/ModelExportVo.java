package com.example.model.vo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Peng
 * @date 2025-10-16 19:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelExportVo implements Serializable {

    /**
     * 类型（对话-chat，向量-embedding，图片-image，语音转文字-transcription，文字转语音-tts）
     */
    private String type;

    @Serial
    private static final long serialVersionUID = -4537844212690141842L;

}
