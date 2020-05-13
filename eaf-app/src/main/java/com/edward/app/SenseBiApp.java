package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

/**
 * @author wangcheng
 * @date 2020/4/20 11:17
 */
public class SenseBiApp {
    public static final String SENSEPASS_v2_record = "/sensepass/v2/record";
    public static final HttpApi POST_SENSEPASS_v2_record = new HttpApi(SENSEPASS_v2_record, HttpMethod.POST_JSON);

}
