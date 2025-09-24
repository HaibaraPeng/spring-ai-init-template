package com.example.exception;


import com.example.common.base.ReturnCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Peng
 * @date 2025-09-24 22:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomizeException extends RuntimeException {

    public ReturnCode returnCode = null;

    public String msg = null;

}
