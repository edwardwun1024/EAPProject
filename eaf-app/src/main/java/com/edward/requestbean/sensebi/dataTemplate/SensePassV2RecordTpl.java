package com.edward.requestbean.sensebi.dataTemplate;

import com.edward.requestbean.sensebi.bean.IdentifyDataReq;
import com.edward.requestbean.sensebi.bean.SensePassV2RecordRequestBean;

import java.util.List;

/**
 * @author wangcheng
 * @date 2020/4/20 11:36
 */
public class SensePassV2RecordTpl {
    public static class TestValues{
        public static final int user_id = Integer.parseInt(null);
        public static final String user_name = null;
        public static final Integer abnormal_type = null;
        public static final String sign_avatar = null;
//        public static final String sign_bg_avatar = null;
        public static final String doc_photo = null;
        public static final int sign_time = Integer.parseInt(null);
        public static final int type = Integer.parseInt(null);
        public static final String id_number = null;
        public static final String ic_number = null;
        public static final String id_info = null;
        public static final String description = null;
        public static final String score = null;
        public static final Integer mode = null;
        public static final int in_time = Integer.parseInt(null);
        public static final int entry_mode = Integer.parseInt(null);
        public static final double verify_score = Double.parseDouble(null);
        public static final List<IdentifyDataReq.VerticesBean> rectangle = null;
        public static final int push_option = Integer.parseInt(null);
        public static final double body_temperature = Double.parseDouble(null);

    }

    public SensePassV2RecordRequestBean buildData(){
        SensePassV2RecordRequestBean requestBean = new SensePassV2RecordRequestBean();
        requestBean.getAbnormal_type();
        requestBean.getBody_temperature();
        requestBean.getDescription();
        requestBean.getEntry_mode();
        requestBean.getIc_number();
        requestBean.getId_number();
        requestBean.getIn_time();
        requestBean.getPush_option();
        requestBean.getRectangle();
        requestBean.getScore();
        requestBean.getSign_avatar();
        requestBean.getSign_time();
        requestBean.getType();
        requestBean.getUser_id();
        requestBean.getUser_name();
        requestBean.getVerify_score();

        return requestBean;
    }

}
