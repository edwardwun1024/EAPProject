package com.edward.dataProvider.utility;

import com.edward.common.EnumCode;
import com.edward.requestbean.utility.bean.UtilityFilesUploadImageRequestBean;

/**
 * @author wangcheng
 * @date 2020/5/27 15:35
 */
public class UtilityFilesUploadImageTestData {
    public Object[][] genUtilityFilesUploadImageTestData() {
        UtilityFilesUploadImageRequestBean utilityFilesUploadImageRequestBean = new UtilityFilesUploadImageRequestBean();
        utilityFilesUploadImageRequestBean.setFilePath("D:\\zm.jpeg");
        utilityFilesUploadImageRequestBean.setFileName("image");
        utilityFilesUploadImageRequestBean.setServiceType("person");
        return new Object[][]{
                {"创建person上传图片", utilityFilesUploadImageRequestBean, EnumCode.BASE_SUCCESS}
        };
    }
}
