package com.jsfwlt.first.exception;

import lombok.Data;

/**
 * 自定义异常类
 * 待完善
 */
@Data
public class SelfException extends RuntimeException {
    private String errorCode;
    public SelfException(String errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
    }
}
