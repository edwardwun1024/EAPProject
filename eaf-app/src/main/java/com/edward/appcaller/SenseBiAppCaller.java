package com.edward.appcaller;


import com.edward.app.AbstractServiceCaller;
import com.edward.http.HttpApi;
import com.edward.requestbean.sensebi.bean.SensePassV2RecordRequestBean;
import com.edward.requestbean.utility.bean.UtilityFilesUploadImageRequestBean;

import static com.edward.app.SenseBiApp.POST_SENSEPASS_v2_record;

/**
 * @author wangcheng
 * @date 2020/4/20 11:21
 */
public class SenseBiAppCaller extends AbstractServiceCaller {

    public String getUtilityFilesUploadImage(SensePassV2RecordRequestBean sensePassV2RecordRequestBean){
        return this.getUtilityFilesUploadImage(POST_SENSEPASS_v2_record,sensePassV2RecordRequestBean);
    }
    private String getUtilityFilesUploadImage(HttpApi POST_SENSEPASS_v2_record, SensePassV2RecordRequestBean sensePassV2RecordRequestBean){
        return doPost(POST_SENSEPASS_v2_record,sensePassV2RecordRequestBean);
    }
}
