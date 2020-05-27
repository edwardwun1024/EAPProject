package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

/**
 * @author wangcheng
 * @date 2020/5/27 14:51
 */
public class UtilityApp {
    public static final String UTILITY_FILE_UPLOAD_IMAGE_PATH = "/UTILITY/files/uploadImage";
    public static final HttpApi POST_UTILITY_FILE_UPLOAD_IMAGE = new HttpApi(UTILITY_FILE_UPLOAD_IMAGE_PATH, HttpMethod.POST_FROM);

}
