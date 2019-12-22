package com.example.spring.model;

import com.example.spring.model.enums.ErrorCode;

public class RespBody<T> {

    private int code;
    private String msg;
    private T data;

    public RespBody(){
        this.code = 0;
        this.msg = "";
    }

    public RespBody(T data){
        this.code = 0;
        this.data = data;
    }

    public RespBody(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public RespBody(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
