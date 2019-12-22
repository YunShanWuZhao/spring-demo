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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
