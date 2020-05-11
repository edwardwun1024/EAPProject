package com.edward.app;

import com.edward.http.common.HttpConfig;

/**
 * 抽象类，提供post和get抽象方法
 */
public class AbstractServiceCaller{

    public static HttpConfig httpConfig = HttpConfig.custom();
    public static String host = "http://studio80/";

    public static HttpConfig getHttpConfig(){
        return HttpConfig.custom();
    }

    public abstract interface post{};
    public abstract interface get{};


}
