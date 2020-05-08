package com.edward.common;

import lombok.extern.java.Log;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.util.Base64Utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangcheng
 * @date 2020/4/20 10:40
 * 图片转换成Base64Code
 */
public class CommonUtils {


    /**
     * 图片转换成Base64Code
     * @param localImagePath
     * eg:/Users/wangcheng1_vendor/Pictures/539091750513872709.jpg
     */
    public static String imageToBase64Code(String localImagePath){
        byte[] data = null;
        File file = new File(localImagePath);
        try {
            FileInputStream inputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int i = 0;
            while ((i = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, i);
            }
            data = outputStream.toByteArray();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert data != null;
        String base64Str = Base64Utils.encodeToString(data);

        return base64Str;
    }

    /**
     * 将object转换成Map<String,Object>
     * @param obj
     * @return
     */
    public static Map<String, Object> transBean2Map(Object obj) {

        if(obj == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }

        return map;

    }



    @Test
    public void getBase64Code(){
        String localImagePath = "/Users/wangcheng1_vendor/Pictures/539091750513872709.jpg";
        String base64Code = imageToBase64Code(localImagePath);
        System.out.println(base64Code);

    }


}

