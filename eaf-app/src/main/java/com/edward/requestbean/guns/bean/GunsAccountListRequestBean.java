package com.edward.requestbean.guns.bean;

import com.edward.requestbean.base.BasePageReq;
import com.sun.istack.internal.NotNull;

/**
 * @author wangcheng
 * @date 2020/6/3 15:02
 */
public class GunsAccountListRequestBean extends BasePageReq {

    private String name;
    private String beginTime;
    private String endTime;
    @NotNull
    public Integer current;
    @NotNull
    public Integer size;

    public GunsAccountListRequestBean() {
    }

    public GunsAccountListRequestBean(String name, String beginTime, String endTime, Integer current, Integer size) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.current = current;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "GunsAccountListRequestBean{" +
                "name='" + name + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
