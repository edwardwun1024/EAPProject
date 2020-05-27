package com.edward.appcaller;

import com.edward.app.AbstractServiceCaller;
import com.edward.http.HttpApi;
import com.edward.requestbean.utility.bean.UtilityFilesUploadImageRequestBean;

import static com.edward.app.UtilityApp.POST_UTILITY_FILE_UPLOAD_IMAGE;

/**
 * @author wangcheng
 * @date 2020/5/27 14:53
 */
public class UtilityAppCaller extends AbstractServiceCaller {

    public String getUtilityFilesUploadImage(UtilityFilesUploadImageRequestBean utilityFilesUploadImageRequestBean){
        return this.getUtilityFilesUploadImage(POST_UTILITY_FILE_UPLOAD_IMAGE,utilityFilesUploadImageRequestBean);
    }
    private String getUtilityFilesUploadImage(HttpApi POST_UTILITY_FILE_UPLOAD_IMAGE, UtilityFilesUploadImageRequestBean utilityFilesUploadImageRequestBean){
        return doPost(POST_UTILITY_FILE_UPLOAD_IMAGE,utilityFilesUploadImageRequestBean);
    }
}
