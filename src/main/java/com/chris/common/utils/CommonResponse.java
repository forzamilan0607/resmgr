package com.chris.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * @author chris
 * @since Apr 20.18
 */
public class CommonResponse<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public static CommonResponse getSuccessResponseModel() {
        return (new CommonResponse()).setCode("200").setMsg("success");
    }

    public static CommonResponse getFailedResponseModel() {
        return (new CommonResponse()).setCode("500").setMsg("error");
    }

    public static CommonResponse getLoginErrorResponseModel() {
        return (new CommonResponse()).setCode("401").setMsg("auth_error");
    }

    public CommonResponse() {
    }

    public CommonResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public CommonResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public CommonResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public CommonResponse setData(T data) {
        this.data = data;
        return this;
    }

    public String toString() {
        try {
            String e = "CommonResponse{code=\'" + this.code + '\'' + ", msg=\'" + this.msg + '\'' + ", data=" + (new ObjectMapper()).writeValueAsString(this.data) + '}';
            return e;
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }
}
