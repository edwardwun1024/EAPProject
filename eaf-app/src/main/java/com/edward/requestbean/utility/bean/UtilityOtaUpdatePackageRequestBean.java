package com.edward.requestbean.utility.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wangcheng
 * @date 2020/6/9 11:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilityOtaUpdatePackageRequestBean {
    @NotBlank
    @ApiModelProperty(value = "升级包名称", name = "packageName")
    private String packageName;

    @NotNull
    @ApiModelProperty(value = "产品类型", name = "kind")
    private String productType;

    @NotNull
    @ApiModelProperty(value = "应用", name = "application")
    private String application;

    @NotNull
    @ApiModelProperty(value = "版本名称", name = "vname")
    private String vname;

    @NotNull
    @ApiModelProperty(value = "版本编号", name = "vcode")
    private String vcode;

    @NotNull
    @ApiModelProperty(value = "升级包类型，rom,app", name = "packageType")
    private String packageType;


    @NotBlank
    @ApiModelProperty(value = "文件md5校验码码", name = "md5")
    private String md5;

    @ApiModelProperty(value = "文件大小", name = "size")
    private String size;

    @ApiModelProperty(value = "描述", name = "desc")
    private String desc;
}
