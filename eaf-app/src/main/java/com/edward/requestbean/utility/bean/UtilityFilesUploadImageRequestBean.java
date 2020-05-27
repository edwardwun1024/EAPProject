package com.edward.requestbean.utility.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangcheng
 * @date 2020/5/27 15:09
 */
public class UtilityFilesUploadImageRequestBean {

    private String image;
    private String serviceType;


    public UtilityFilesUploadImageRequestBean() {
    }

    public UtilityFilesUploadImageRequestBean(String image, String serviceType) {
        this.image = image;
        this.serviceType = serviceType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
