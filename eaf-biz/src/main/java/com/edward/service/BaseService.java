package com.edward.service;

import com.edward.appcaller.GunsAppCaller;
import com.edward.appcaller.PersonAppCaller;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangcheng
 * @date 2020/6/3 19:50
 */
public class BaseService {
    public static final Logger logger = Logger.getLogger("HttpClient(异步)工具类");
    public static final Gson gson = new Gson();



    public GunsAppCaller gunsAppCaller = new GunsAppCaller();
    public PersonAppCaller personAppCaller = new PersonAppCaller();

    public String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss-SSS"); //获取当前时间精确到毫秒
        return simpleDateFormat.format(new Date());
    }

}
