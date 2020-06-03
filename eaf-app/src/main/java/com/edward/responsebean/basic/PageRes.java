package com.edward.responsebean.basic;

import com.edward.requestbean.sensebi.bean.SensePassV2RecordRequestBean;

import java.io.Serializable;

/**
 * @author wangcheng
 * @date 2020/6/3 15:49
 */
public class PageRes<T> implements Serializable {
    private T data;
    private Integer size;
    private Integer total;
    private String code;
    private String msg;

    public PageRes(T data, Integer size, Integer total, String code, String msg) {
        this.data = data;
        this.size = size;
        this.total = total;
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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
