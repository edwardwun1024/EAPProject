package com.edward.http.common.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串简易工具类
 *
 * @author arron
 * @version 1.0
 */
public class StringUtil {

    /**
     * 通过正则表达式获取内容
     *
     * @param regex		正则表达式
     * @param from		原字符串
     * @return	返回匹配结果
     */
    public static String[] regex(String regex, String from){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(from);
        List<String> results = new ArrayList<String>();
        while(matcher.find()){
            for (int i = 0; i < matcher.groupCount(); i++) {
                results.add(matcher.group(i+1));
            }
        }
        return results.toArray(new String[]{});
    }

    /**
     * 将字符串的首个字母转换成大写
     * app --> App
     */
    public static String changeaToA(String character){
        String resultString = character.substring(0,1).toUpperCase() + character.substring(1);
        return resultString;
    }

    /**
     * 将字符串根据"/"截取下来，然后将每个单词首字母转换成大写，最后拼装
     * /crowdMonitoringPolicy/create
     * to
     * CrowdMonitoingPolicyCreate
     * @param characterString
     * @return
     */
    public static String changeaToAFromString(String characterString){
        String resultString = "";
        String[] p = characterString.split("/");
        int pos = 0;
        for (int i = 0; i < p.length; i++) {
            //将每个单词首字母转换成大写
            if(!p[i].isEmpty())
                resultString += changeaToA(p[i]);
        }
        return resultString;
    }

    /**
     * 将字符串根据"/"截取下来，然后将每个字符转换成大写，最后用下划线拼装
     * /crowdMonitoringPolicy/create
     * to
     * _CROWD_MONITORINGPOLICY_CREATE
     * @param characterString
     * @return
     */
    public static String changeAaaBbbToAAA_BBB(String characterString){
        String resultString = "";
        String[] p = characterString.split("/");
        int pos = 0;
        for (int i = 0; i < p.length; i++) {
            //将每个单词首字母转换成大写
            if(!p[i].isEmpty())
                resultString += "_" + p[i].toUpperCase();
        }
        return resultString;
    }



    @Test
    public void test(){
        String url = "/crowdMonitoringPolicy/create";
        System.out.println(changeAaaBbbToAAA_BBB(url));
    }


}
