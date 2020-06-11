package com.edward.app;

import com.edward.http.HttpApi;
import com.edward.http.HttpMethod;

/**
 * @author wangcheng
 * @date 2020/5/27 14:51
 */
public class UtilityApp {
    public static final String UTILITY_FILE_UPLOAD_IMAGE_PATH = "/UTILITY/files/uploadImage";
    public static final HttpApi POST_UTILITY_FILE_UPLOAD_IMAGE = new HttpApi(UTILITY_FILE_UPLOAD_IMAGE_PATH, HttpMethod.POST_FILE);
    public static final String UTILITY_OTA_LISTPRODUCT_PATH = "/UTILITY/ota/listProduct";
    public static final HttpApi POST_UTILITY_OTA_LISTPRODUCT = new HttpApi(UTILITY_OTA_LISTPRODUCT_PATH, HttpMethod.POST_JSON);
    public static final String UTILITY_OTA_LISTAPPBYPRODUCT_PATH = "/UTILITY/ota/listAppByProduct";
    public static final HttpApi POST_UTILITY_OTA_LISTAPPBYPRODUCT = new HttpApi(UTILITY_OTA_LISTAPPBYPRODUCT_PATH,HttpMethod.POST_PARAM);
    public static final String UTILITY_OTA_ISEXISTS_PATH = "/UTILITY/ota/isExists";
    public static final HttpApi POST_UTILITY_OTA_ISEXISTS = new HttpApi(UTILITY_OTA_ISEXISTS_PATH,HttpMethod.POST_JSON);
    public static final String UTILITY_OTA_UPDATEpACKAGE_PATH = "/UTILITY/ota/updatePackage";
    public static final HttpApi POST_UTILITY_OTA_UPDATEpACKAGE = new HttpApi(UTILITY_OTA_UPDATEpACKAGE_PATH,HttpMethod.POST_JSON);

}
