package com.hong.day07.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hong on 2016/5/21.
 */
public class Md5Util {

    public static String encode(String msg) {

        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] bytes = digest.digest(msg.getBytes());
            return new BASE64Encoder().encode(bytes);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
