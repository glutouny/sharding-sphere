package com.yangl.shardingsphere.infra.hash;

import java.security.MessageDigest;

/**
 * Ketama Hash算法
 * @author li.yang01@hand-china.com 2020/9/16 2:20 下午
 */
public class Ketama {

    /**
     * key 生成 hash值
     *
     * @param key key
     * @return hash值
     */
    public static long hash(final String key) {

        final byte[] keyBytes = computeMd5(key);
        long rv = ((long) (keyBytes[3] & 0xFF) << 24)
                | ((long) (keyBytes[2] & 0xFF) << 16)
                | ((long) (keyBytes[1] & 0xFF) << 8)
                | (keyBytes[0] & 0xFF);
        return rv & 0xffffffffL;
    }

    /**
     * key生成md5
     *
     * @param key 入参
     * @return md5字节数组
     */
    private static byte[] computeMd5(String key) {

        MessageDigest md5;
        try {
            md5 = (MessageDigest) messageDigest.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("clone of MD5 not supported", e);
        }
        md5.update(key.getBytes());
        return md5.digest();
    }

    private final static String MD5 = "MD5";

    private static MessageDigest messageDigest;

    // 初始化 messageDigest
    static {
        try {
            messageDigest = MessageDigest.getInstance(MD5);
        } catch (Exception ex) {
            throw new RuntimeException(MD5 + "not supported", ex);
        }
    }
}
