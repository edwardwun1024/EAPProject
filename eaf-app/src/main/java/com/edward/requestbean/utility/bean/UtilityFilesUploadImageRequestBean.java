package com.edward.requestbean.utility.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangcheng
 * @date 2020/5/27 15:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilityFilesUploadImageRequestBean {

    private String filePath;
    private String fileName;
    private String serviceType;

}
