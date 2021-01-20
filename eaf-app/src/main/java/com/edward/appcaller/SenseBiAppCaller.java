package com.edward.appcaller;

import com.edward.http.HttpApi;
import com.edward.requestbean.sensebi.bean.*;
import static com.edward.app.SenseBiApp.*;

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
