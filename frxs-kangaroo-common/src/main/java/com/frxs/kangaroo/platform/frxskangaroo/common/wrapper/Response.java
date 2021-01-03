package com.frxs.kangaroo.platform.frxskangaroo.common.wrapper;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private boolean success;
    private T data;
    private String rspCode;
    private String rspDesc;

    public boolean isSuccess() {
        return this.success;
    }

    public static <T> Response<T> ok(T data) {
        Response resp = new Response();
        resp.setData(data);
        resp.setSuccess(true);
        resp.setRspCode("success");
        resp.setRspDesc("操作成功");
        return resp;
    }

    public static <T> Response<T> ok() {
        return ok((T) null);
    }

    public static <T> Response<T> fail(String code, String message) {
        Response resp = new Response();
        resp.setRspCode(code);
        resp.setRspDesc(message);
        resp.setSuccess(false);
        return resp;
    }

    public static <T> Response<T> failOfMessage(String message) {
        Response resp = new Response();
        resp.setRspCode("failed");
        resp.setRspDesc(message);
        resp.setSuccess(false);
        return resp;
    }

    public static <T> Response<T> fail(String code) {
        Response resp = new Response();
        resp.setRspCode(code);
        resp.setSuccess(false);
        return resp;
    }

    public Response() {
    }

    public T getData() {
        return this.data;
    }

    public String getRspCode() {
        return this.rspCode;
    }

    public String getRspDesc() {
        return this.rspDesc;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public void setRspDesc(String rspDesc) {
        this.rspDesc = rspDesc;
    }


}
