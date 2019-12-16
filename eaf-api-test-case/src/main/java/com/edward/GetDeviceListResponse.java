package com.edward;

import java.util.ArrayList;

public class GetDeviceListResponse {
    private ArrayList<DeviceListRes> data;
    private String size;
    private String total;
    private String code;
    private String msg;

    public GetDeviceListResponse() {
    }

    public GetDeviceListResponse(ArrayList<DeviceListRes> data, String size, String total, String code, String msg) {
        this.data = data;
        this.size = size;
        this.total = total;
        this.code = code;
        this.msg = msg;
    }

    public ArrayList<DeviceListRes> getData() {
        return data;
    }

    public void setData(ArrayList<DeviceListRes> data) {
        this.data = data;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
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

    @Override
    public String toString() {
        return "GetDeviceListResponse{" +
                "data=" + data +
                ", size='" + size + '\'' +
                ", total='" + total + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
