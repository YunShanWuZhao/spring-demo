package com.example.spring.exception;

import com.example.spring.model.enums.ErrorCode;

public class BizException extends RuntimeException {
    private int code;
    private String message;

    public BizException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public BizException(int errorCode, String errorMsg){
        this.code = errorCode;
        this.message = errorMsg;
    }
}
