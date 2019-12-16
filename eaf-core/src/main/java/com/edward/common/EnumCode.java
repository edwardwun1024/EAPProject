package com.edward.common;

/**
 * @author wangcheng
 * @date 2019/12/16 11:30
 * httpResponseCode
 */
public enum EnumCode {

    BASE_SUCCESS("0000","成功");

    private String code;
    private String msg;

    EnumCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
