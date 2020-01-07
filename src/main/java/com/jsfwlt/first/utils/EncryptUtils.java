package com.jsfwlt.first.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

public class EncryptUtils {
    private static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static String encryptMD5(String str,String salt){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            //String salt = UUID.randomUUID().toString().substring(0,16).replaceAll("-","");
            String inputWithSalt = str+salt;
            //带盐进行md5加密
            String hashResult = byte2HexStr(md.digest(inputWithSalt.getBytes()));
            //将salt存储在hashResult中，每两个hash字符之间存一个salt字符，用于用户登录时提取salt并进行验证
            char[] cs = new char[48];
            for (int i = 0; i < 48; i += 3) {
                cs[i] = hashResult.charAt(i / 3 * 2);
                cs[i + 1] = salt.charAt(i / 3);//输出带盐，存储盐到hash值中;每两个hash字符中间插入一个盐字符
                cs[i + 2] = hashResult.charAt(i / 3 * 2 + 1);
            }
            hashResult = new String(cs);
            return hashResult;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //将字节数组转换成十六进制字符串
    private static String byte2HexStr(byte[] bytes){
        int len = bytes.length;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < len; i++) {
            byte byte0 = bytes[i];
            result.append(hex[byte0 >>> 4 & 0xf]);
            result.append(hex[byte0 & 0xf]);
        }
        return result.toString();
    }

    //从库中提取的hash值提取salt
    public static String getSaltFromHash(String hash){
        StringBuilder sb=new StringBuilder();
        char [] h=hash.toCharArray();
        for(int i=0;i<hash.length();i+=3){
            sb.append(h[i+1]);
        }
        return sb.toString();
    }
}
