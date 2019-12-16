package com.edward;

public class PolicyDevices {
    private String deviceId;
    private String deviceSerial;
    private String deviceType;

    public PolicyDevices() {
    }

    public PolicyDevices(String deviceId, String deviceSerial, String deviceType) {
        this.deviceId = deviceId;
        this.deviceSerial = deviceSerial;
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "PolicyDevices{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceSerial='" + deviceSerial + '\'' +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }
}
