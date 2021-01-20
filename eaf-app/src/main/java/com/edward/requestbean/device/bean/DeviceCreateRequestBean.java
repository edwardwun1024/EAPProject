package com.edward.requestbean.device.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangcheng
 * @date 2021/1/20 11:15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceCreateRequestBean {
    @ApiModelProperty(value = "设备编号", name = "deviceSerial",required = true)
    private String deviceSerial;
    @ApiModelProperty(value = "设备中文名称", name = "deviceCnName",required = true)
    private String deviceCnName;
    @ApiModelProperty(value = "设备英文名称", name = "deviceEnName")
    private String deviceEnName;
    @ApiModelProperty(value = "设备密钥", name = "deviceSecret")
    private String deviceSecret;
    @ApiModelProperty(value = "设备端口", name = "devicePort")
    private String devicePort;
    @ApiModelProperty(value = "设备IP", name = "deviceIP")
    private String deviceIP;
    @ApiModelProperty(value = "设备URI", name = "deviceUri")
    private String deviceUri;
    @ApiModelProperty(value = "设备版本", name = "deviceVersion",required = true)
    private String deviceVersion;
    @ApiModelProperty(value = "设备连接类型", name = "deviceConnType")
    private String deviceConnType;
    @ApiModelProperty(value = "设备通信协议", name = "deviceProtocol")
    private String deviceProtocol;
    @ApiModelProperty(value = "设备描述", name = "desc")
    private String desc;
    @ApiModelProperty(value = "产品类型", name = "productType",required = true)
    private String productType;
    @ApiModelProperty(value = "设备类型", name = "deviceType",required = true)
    private String deviceType;
    @ApiModelProperty(value = "设备分组", name = "deviceTag")
    private String deviceTag;
    @ApiModelProperty(value = "匹配阈值", name = "matchingThreshold")
    private String matchingThreshold;
    @ApiModelProperty(value = "人脸属性开关", name = "faceAttribute",allowableValues = "0,1")
//    @Range(min=0, max=1, message = "人脸属性开关只能是0或1")
    private Integer faceAttribute;
    @ApiModelProperty(value = "活体检测开关", name = "livenessCheck",allowableValues = "0,1")
//    @Range(min=0, max=1, message = "活体检测开关只能是0或1")
    private Integer livenessCheck;
    @ApiModelProperty(value = "人脸质量检测阈值", name = "ingressQCThreshold")
    private String ingressQCThreshold;
    @ApiModelProperty(value = "人脸角度检测阈值", name = "ingressAngleThreshold")
    private String ingressAngleThreshold;
    @ApiModelProperty(value = "播放帧率", name = "frameRate")
    private String frameRate;
    @ApiModelProperty(value = "流高", name = "streamHeight")
    private String streamHeight;
    @ApiModelProperty(value = "流宽", name = "streamWidth")
    private String streamWidth;
    @ApiModelProperty(value = "操作人", name = "operatePerson",required = true)
    private String operatePerson;
    @ApiModelProperty(value = "是否存取大图", name = "bkImageStorage")
    private String bkImageStorage;
    @ApiModelProperty(value = "检测框大小阈值", name = "boundingBoxSizeThreshold")
    private String boundingBoxSizeThreshold;
    @ApiModelProperty(value = "目标组", name = "targetGroup")
    private String targetGroup;
    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;
    @ApiModelProperty(value = "设备区域信息", name = "videoRegion")
    private List<DeviceRegionCreateEntity> validRegionDefinition;
    @ApiModelProperty(value = "部门ID", name = "privilege")
    private String privilege;
    @ApiModelProperty(value = "设备模板ID", name = "deviceTemplateuuid")
    private String deviceTemplateuuid;
    @ApiModelProperty(value = "外部设备ID", name = "externalDid")
    private String externalDid;
}
