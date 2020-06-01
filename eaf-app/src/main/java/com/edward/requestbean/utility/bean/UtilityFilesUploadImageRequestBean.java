package com.edward.requestbean.utility.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangcheng
 * @date 2020/5/27 15:09
 */
public class UtilityFilesUploadImageRequestBean {

    private String filePath;
    private String fileName;
    private String serviceType;


    public UtilityFilesUploadImageRequestBean() {
    }

    public UtilityFilesUploadImageRequestBean(String filePath, String fileName, String serviceType) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.serviceType = serviceType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
