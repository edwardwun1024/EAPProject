package com.edward.app;

import com.edward.http.common.HttpConfig;
import com.edward.http.common.HttpHeader;

/**
 * 抽象类，提供post和get抽象方法
 */
public class AbstractServiceCaller{


    public static String host = "http://studio80/";


    public abstract interface post{};
    public abstract interface get{};


}
