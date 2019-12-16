package com.edward;

public class DeviceListRes {
    private String did;
    private String deviceSerial;
    private String productType;
    private String productTypeName;
    private String productTypeEnName;
    private String deviceType;
    private String deviceTypeName;
    private String deviceTypeEnName;
    private String deviceCnName;
    private String deviceEnName;
    private String deviceTag;
    private String desc;
    private String sts;
    private String deviceIp;
    private String privilege;

    public DeviceListRes() {
    }

    public DeviceListRes(String did, String deviceSerial, String productType, String productTypeName, String productTypeEnName, String deviceType, String deviceTypeName, String deviceTypeEnName, String deviceCnName, String deviceEnName, String deviceTag, String desc, String sts, String deviceIp, String privilege) {
        this.did = did;
        this.deviceSerial = deviceSerial;
        this.productType = productType;
        this.productTypeName = productTypeName;
        this.productTypeEnName = productTypeEnName;
        this.deviceType = deviceType;
        this.deviceTypeName = deviceTypeName;
        this.deviceTypeEnName = deviceTypeEnName;
        this.deviceCnName = deviceCnName;
        this.deviceEnName = deviceEnName;
        this.deviceTag = deviceTag;
        this.desc = desc;
        this.sts = sts;
        this.deviceIp = deviceIp;
        this.privilege = privilege;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeEnName() {
        return productTypeEnName;
    }

    public void setProductTypeEnName(String productTypeEnName) {
        this.productTypeEnName = productTypeEnName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceTypeEnName() {
        return deviceTypeEnName;
    }

    public void setDeviceTypeEnName(String deviceTypeEnName) {
        this.deviceTypeEnName = deviceTypeEnName;
    }

    public String getDeviceCnName() {
        return deviceCnName;
    }

    public void setDeviceCnName(String deviceCnName) {
        this.deviceCnName = deviceCnName;
    }

    public String getDeviceEnName() {
        return deviceEnName;
    }

    public void setDeviceEnName(String deviceEnName) {
        this.deviceEnName = deviceEnName;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "DeviceListRes{" +
                "did='" + did + '\'' +
                ", deviceSerial='" + deviceSerial + '\'' +
                ", productType='" + productType + '\'' +
                ", productTypeName='" + productTypeName + '\'' +
                ", productTypeEnName='" + productTypeEnName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceTypeEnName='" + deviceTypeEnName + '\'' +
                ", deviceCnName='" + deviceCnName + '\'' +
                ", deviceEnName='" + deviceEnName + '\'' +
                ", deviceTag='" + deviceTag + '\'' +
                ", desc='" + desc + '\'' +
                ", sts='" + sts + '\'' +
                ", deviceIp='" + deviceIp + '\'' +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}
