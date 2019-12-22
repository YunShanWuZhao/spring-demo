package com.example.spring.model.enums;

public enum ErrorCode {

    PARAM_NOTNULL(-1, "参数不能为空");


    ErrorCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
