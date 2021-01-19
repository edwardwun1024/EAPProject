package com.edward.common;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;

public class Base64Utils {

    //符号
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String EMPTY = "";

    /**
     * 转base64编码
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encodeBase64(String str) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(str))
            return EMPTY;
        final byte[] textByte = str.getBytes(DEFAULT_CHARSET);
        final String encodedText = Base64.getEncoder().encodeToString(textByte);
        return encodedText;
    }

    /**
     * base64解码
     *
     * @param base64String
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String base64Decoder(String base64String) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(base64String))
            return EMPTY;
        byte[] bytes = base64DecoderByte(base64String);
        return URLDecoder.decode(new String(bytes), DEFAULT_CHARSET);
    }


    public static String byteArrayEncode64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] base64DecoderByte(String base64Str) {
        return Base64.getDecoder().decode(base64Str);
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "ChMxMzIyNDM4NDc3NTA1MTA1OTIyEAEaNQjoBxIwCi4KLHJ0c3A6Ly9hZG1pbjpTZW5zZTEyMzc4OTQ1NkAxMC4xNTEuMjMuOTQ6NTU0IhoSDWlkLXdjLXRlc3QtOTgaAjIxSgUIw24QMioBZrIBKSINaWQtd2MtdGVzdC05OEIGd2N0YWc4SgExUg0xNjA0MzcyMTY0MzM2ugEGZGV2aWNlwgEMZGV2aWNlVXBkYXRlygECMTY=";
        final byte[] textByte = text.getBytes("UTF-8");
        //编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
        //解码
        System.out.println(new String(decoder.decode(textByte), "UTF-8"));
    }
}
