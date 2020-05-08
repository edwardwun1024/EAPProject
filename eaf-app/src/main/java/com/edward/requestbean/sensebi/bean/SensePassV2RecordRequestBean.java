package com.edward.requestbean.sensebi.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020/4/20 11:30
 */
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
    //    @ApiModelProperty(value = "身份证证件照图Base64字符串", name = "doc_photo")
//    private String doc_photo;
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


    public SensePassV2RecordRequestBean() {
    }

    public SensePassV2RecordRequestBean(int user_id, String user_name, Integer abnormal_type, String sign_avatar, String sign_bg_avatar, int sign_time, int type, String id_number, String ic_number, String id_info, String description, String score, Integer mode, int in_time, int entry_mode, double verify_score, List<IdentifyDataReq.VerticesBean> rectangle, int push_option, double body_temperature) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.abnormal_type = abnormal_type;
        this.sign_avatar = sign_avatar;
        this.sign_bg_avatar = sign_bg_avatar;
        this.sign_time = sign_time;
        this.type = type;
        this.id_number = id_number;
        this.ic_number = ic_number;
        this.id_info = id_info;
        this.description = description;
        this.score = score;
        this.mode = mode;
        this.in_time = in_time;
        this.entry_mode = entry_mode;
        this.verify_score = verify_score;
        this.rectangle = rectangle;
        this.push_option = push_option;
        this.body_temperature = body_temperature;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getAbnormal_type() {
        return abnormal_type;
    }

    public void setAbnormal_type(Integer abnormal_type) {
        this.abnormal_type = abnormal_type;
    }

    public String getSign_avatar() {
        return sign_avatar;
    }

    public void setSign_avatar(String sign_avatar) {
        this.sign_avatar = sign_avatar;
    }

    public String getSign_bg_avatar() {
        return sign_bg_avatar;
    }

    public void setSign_bg_avatar(String sign_bg_avatar) {
        this.sign_bg_avatar = sign_bg_avatar;
    }

    public int getSign_time() {
        return sign_time;
    }

    public void setSign_time(int sign_time) {
        this.sign_time = sign_time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getIc_number() {
        return ic_number;
    }

    public void setIc_number(String ic_number) {
        this.ic_number = ic_number;
    }

    public String getId_info() {
        return id_info;
    }

    public void setId_info(String id_info) {
        this.id_info = id_info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public int getIn_time() {
        return in_time;
    }

    public void setIn_time(int in_time) {
        this.in_time = in_time;
    }

    public int getEntry_mode() {
        return entry_mode;
    }

    public void setEntry_mode(int entry_mode) {
        this.entry_mode = entry_mode;
    }

    public double getVerify_score() {
        return verify_score;
    }

    public void setVerify_score(double verify_score) {
        this.verify_score = verify_score;
    }

    public List<IdentifyDataReq.VerticesBean> getRectangle() {
        return rectangle;
    }

    public void setRectangle(List<IdentifyDataReq.VerticesBean> rectangle) {
        this.rectangle = rectangle;
    }

    public int getPush_option() {
        return push_option;
    }

    public void setPush_option(int push_option) {
        this.push_option = push_option;
    }

    public double getBody_temperature() {
        return body_temperature;
    }

    public void setBody_temperature(double body_temperature) {
        this.body_temperature = body_temperature;
    }

    @Override
    public String toString() {
        return "SensePassV2RecordRequestBean{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", abnormal_type=" + abnormal_type +
                ", sign_avatar='" + sign_avatar + '\'' +
                ", sign_bg_avatar='" + sign_bg_avatar + '\'' +
                ", sign_time=" + sign_time +
                ", type=" + type +
                ", id_number='" + id_number + '\'' +
                ", ic_number='" + ic_number + '\'' +
                ", id_info='" + id_info + '\'' +
                ", description='" + description + '\'' +
                ", score='" + score + '\'' +
                ", mode=" + mode +
                ", in_time=" + in_time +
                ", entry_mode=" + entry_mode +
                ", verify_score=" + verify_score +
                ", rectangle=" + rectangle +
                ", push_option=" + push_option +
                ", body_temperature=" + body_temperature +
                '}';
    }
}
