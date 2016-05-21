package com.hong.test;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hong on 2016/5/21.
 */
public class TestMd5 {

    public static void main(String[] args) {
        String pwd = "123456";

        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] digest = md.digest(pwd.getBytes());
//            System.out.println(new String(digest));

            BASE64Encoder encoder = new BASE64Encoder();
            System.out.println(encoder.encode(digest));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
