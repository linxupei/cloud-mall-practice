package com.qianxu.cloud.mall.practice.common.util;

import com.qianxu.cloud.mall.practice.common.common.Constant;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/6 19:55
 * @describe MD5工具
 */
public class MD5Utils {

    /**
     * 对密码进行MD5机密
     * @param strValue 用户原始密码
     * @return 加密后的密码
     * @throws NoSuchAlgorithmException 请求加密失败抛出异常
     */
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest((strValue + Constant.SALT).getBytes()));
    }
}
