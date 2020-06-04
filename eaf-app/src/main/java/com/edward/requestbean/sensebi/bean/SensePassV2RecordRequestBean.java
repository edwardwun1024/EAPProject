package com.edward.requestbean.sensebi.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020/4/20 11:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensePassV2RecordRequestBean {
    @ApiModelProperty(value = "用户ID", name = "user_id")
    private int user_id;
    @ApiModelProperty(value = "用户名", name = "user_name")
    private String user_name;
    //异常记录类型。0-无;10001-人证不匹配;10002-人卡不匹配;10003-人码不匹配;20001-访客不在有效期内;20002-不在通行时间内；30001-无效身份证;30002-无效IC卡;30003-无效二维码;40001-体温异常；
    @ApiModelProperty(value = "异常记录类型", name = "abnormal_type")
    private Integer abnormal_type;
    @ApiModelProperty(value = "人脸图Base64字符串", name = "sign_avatar")
    private String sign_avatar;
    @ApiModelProperty(value = "人脸场景图片Base64字符串", name = "sign_bg_avatar")
    private String sign_bg_avatar;
    @ApiModelProperty(value = "打卡时间[时间戳秒级]", name = "sign_time")
    private int sign_time;
    @ApiModelProperty(value = "类型:{1:员工, 2:访客, 3:陌生人,4:非活体,5:员工未授权,6:访客未授权, 999:其他}", name = "type")
    private int type;
    @ApiModelProperty(value = "身份证号;desc加密", name = "id_number")
    private String id_number;
    @ApiModelProperty(value = "IC卡号", name = "ic_number")
    private String ic_number;
    @ApiModelProperty(value = "身份证其他的信息", name = "id_info")
    private String id_info;
    @ApiModelProperty(value = "门禁提示信息", name = "description")
    private String description;
    @ApiModelProperty(value = "匹配相似度", name = "score")
    private String score;
    @ApiModelProperty(value = "识别模式1:刷脸或刷卡；2:刷脸且刷卡；3:刷脸或刷身份证；4:刷脸且刷身份证；5:刷脸且刷身份证预约；6:刷脸或扫码；7:刷脸且扫码；8:蓝牙；9:人脸；10:人脸或二维码或刷卡", name = "mode")
    private Integer mode;
    @ApiModelProperty(value = "是否及时上传(1:是;0:否)", name = "in_time")
    private int in_time;
    @ApiModelProperty(value = "核验方式 1、刷脸；2、二维码；3、刷卡；4：刷脸+刷卡；5：刷身份证；6：刷脸且刷身份证；7：刷脸且刷身份证预约；8：刷脸且扫码：9：蓝牙；default：1", name = "entry_mode")
    private int entry_mode;
    private double verify_score;
    private List<IdentifyDataReq.VerticesBean> rectangle;
    private int push_option;
    @ApiModelProperty(value = "体温", name = "body_temperature")
    private double body_temperature;

}
