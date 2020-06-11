package com.edward.appcaller;

import com.edward.app.AbstractServiceCaller;
import com.edward.http.HttpApi;
import com.edward.requestbean.utility.bean.*;

import static com.edward.app.UtilityApp.*;

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

    public String getUtilityOtaListProduct(UtilityOtaListProductRequestBean utilityOtaListProductRequestBean){
        return this.getUtilityOtaListProduct(POST_UTILITY_OTA_LISTPRODUCT,utilityOtaListProductRequestBean);
    }
    private String getUtilityOtaListProduct(HttpApi POST_UTILITY_OTA_LISTPRODUCT, UtilityOtaListProductRequestBean utilityOtaListProductRequestBean){
        return doPost(POST_UTILITY_OTA_LISTPRODUCT,utilityOtaListProductRequestBean);
    }

    public String getUtilityOtaListAppByProduct(UtilityOtaListAppByProductRequestBean utilityOtaListAppByProductRequestBean){
        return this.getUtilityOtaListAppByProduct(POST_UTILITY_OTA_LISTAPPBYPRODUCT,utilityOtaListAppByProductRequestBean);
    }
    private String getUtilityOtaListAppByProduct(HttpApi POST_UTILITY_OTA_LISTAPPBYPRODUCT, UtilityOtaListAppByProductRequestBean utilityOtaListAppByProductRequestBean){
        return doPost(POST_UTILITY_OTA_LISTAPPBYPRODUCT,utilityOtaListAppByProductRequestBean);
    }

    public String getUtilityOtaIsExists(UtilityOtaIsExistsRequestBean utilityOtaIsExistsRequestBean){
        return this.getUtilityOtaIsExists(POST_UTILITY_OTA_ISEXISTS,utilityOtaIsExistsRequestBean);
    }
    private String getUtilityOtaIsExists(HttpApi POST_UTILITY_OTA_ISEXISTS, UtilityOtaIsExistsRequestBean utilityOtaIsExistsRequestBean){
        return doPost(POST_UTILITY_OTA_ISEXISTS,utilityOtaIsExistsRequestBean);
    }

    public String getUtilityOtaUpdatePackage(UtilityOtaUpdatePackageRequestBean utilityOtaUpdatePackageRequestBean){
        return this.getUtilityOtaUpdatePackage(POST_UTILITY_OTA_UPDATEpACKAGE,utilityOtaUpdatePackageRequestBean);
    }
    private String getUtilityOtaUpdatePackage(HttpApi POST_UTILITY_OTA_UPDATEpACKAGE, UtilityOtaUpdatePackageRequestBean utilityOtaUpdatePackageRequestBean){
        return doPost(POST_UTILITY_OTA_UPDATEpACKAGE,utilityOtaUpdatePackageRequestBean);
    }

}
