package com.edward.requestbean.sensebi.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020/4/20 11:33
 */
public class IdentifyDataReq {
    private Integer user_id;
    private Integer type;//数据类型，1-库中人，2-陌生人，3-活体，4-非活体
    private List<TargetImagesBean> images;
    private DepthBean depth;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DepthBean {
        private String data;
        private Integer width;
        private Integer height;
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TargetImagesBean {
        private ContentBean content;
        private Integer image_type;//图片类型，1：rgb图片，2：ir图片
        private TargetInfoBean target_info;
        private String detection_mode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ContentBean {
        private String data;
        private String format;
        private String url;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TargetInfoBean {
        private int quality;
        private RectangleBean rectangle;
        private int track_id;
        private AngleBean angle;
        private List<LandmarksBean> landmarks;//对象关键点坐标

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AngleBean {
        private int pitch;//人脸俯仰变化角度
        private int roll;//人脸平面旋转角度
        private int yaw;//人脸姿态变化角度
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RectangleBean {
        private List<VerticesBean> vertices;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VerticesBean {
        private int x;
        private int y;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LandmarksBean {
        private int x;
        private int y;
    }
}
