package com.edward.common;

import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;


/**
 * Create by wangcheng in 2019/12/4 上午10:35
 */
public class AES256Utils {
    /**
     * 密钥算法
     * java6支持56位密钥，bouncycastle支持64位
     */
    public static final String KEY_ALGORITHM = "AES";

    public static final String KEY_VALUE = "2f6DhqPBNoK3f2A7";

    /**
     * 加密/解密算法/工作模式/填充方式
     * <p>
     * JAVA6 支持PKCS5PADDING填充方式
     * Bouncy castle支持PKCS7Padding填充方式
     */
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 生成密钥，java6只支持56位密钥，bouncycastle支持64位密钥
     *
     * @return byte[] 二进制密钥
     */
    public static byte[] initkey() throws Exception {

        //实例化密钥生成器
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        //初始化密钥生成器，AES要求密钥长度为128位、192位、256位
        kg.init(256);
        //生成密钥
        SecretKey secretKey = kg.generateKey();
        //获取二进制密钥编码形式
        return secretKey.getEncoded();
    }

    /**
     * 转换密钥
     *
     * @param key 二进制密钥
     * @return Key 密钥
     */
    public static Key toKey(byte[] key) throws Exception {
        //实例化DES密钥
        //生成密钥
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }

    /**
     * 加密数据
     *
     * @param data 待加密数据
     * @return byte[] 加密后的数据
     */
    public static String encrypt(byte[] data) throws Exception {
        //还原密钥
        Key k = toKey(KEY_VALUE.getBytes());
        /**
         * 实例化
         * 使用 PKCS7PADDING 填充方式，按如下方式实现,就是调用bouncycastle组件实现
         * Cipher.getInstance(CIPHER_ALGORITHM,"BC")
         */
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);
        //执行操作
        byte[] bytePwd = cipher.doFinal(data);
        //通过base64进行转码 并返回加密后的密码
        return java.util.Base64.getEncoder().encodeToString(bytePwd);

//        return Base64.toBase64String(bytePwd);
    }

    /**
     * 解密数据
     *
     * @param data 待解密数据
     * @return byte[] 解密后的数据
     * 解密key：2f6DhqPBNoK3f2A7
     */
    public static String decrypt(byte[] data) throws Exception {
        //欢迎密钥
        Key k = toKey(KEY_VALUE.getBytes());
        /**
         * 实例化
         * 使用 PKCS7PADDING 填充方式，按如下方式实现,就是调用bouncycastle组件实现
         * Cipher.getInstance(CIPHER_ALGORITHM,"BC")
         */
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);
        //执行操作
        byte[] decPwd = cipher.doFinal(data);
        //通过base64进行转码 并返解密后的数据
        return Base64.toBase64String(cipher.doFinal(data));
    }


//    public static String getPassword(String content, String key) {
//        byte[] decode = null;
//        try {
//            decode = decrypt(Base64.decode(content), key.getBytes());
//            String insertPassword = new String(decode);
//            return insertPassword;
//        } catch (Exception e) {
//            throw new BusinessException(BizExceptionEnum.USER_NAMEPASSWORD_ERROR.getCode(), BizExceptionEnum.USER_NAMEPASSWORD_ERROR.getMessage());
//        }
//    }
//
//    public static String encryptPassword(String content, String key) {
//        byte[] decode = null;
//        try {
//            decode = encrypt(content.getBytes(), key.getBytes());
////            decode = decrypt(Base64.decode(content), key.getBytes());
//
//            String encryptPassword = Base64.toBase64String(decode);
//            return encryptPassword;
//        } catch (Exception e) {
//            throw new BusinessException(BizExceptionEnum.USER_NAMEPASSWORD_ERROR.getCode(), BizExceptionEnum.USER_NAMEPASSWORD_ERROR.getMessage());
//        }
//    }
//
//    /**
//     * @param args
//     * @throws Exception
//     */
    public static void main(String[] args) throws Exception {
        String str = "Edward2019@";
        System.out.println("原文：" + str);
        //初始化密钥
//        byte[] key=AES256Utils.initkey();
//        System.out.println("密钥："+Base64.toBase64String(key));
        //加密数据
        String encData = AES256Utils.encrypt(str.getBytes());
        System.out.println("加密后：" + encData);
//        //解密数据
//        String decData = AES256Utils.decrypt(encData.getBytes());
//        System.out.println("解密后：" + decData);


//        log.info("新方法呢解密：{}", getPassword("aqVVnyYGeVTysuqkSD6+5g==", "2f6DhqPBNoK3f2A7"));
    }

}
