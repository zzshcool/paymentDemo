package com.example.paymentDemo.common.util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    private static final Charset charset = Charset.forName("UTF-8");
    private static final String MD5 = "MD5";
    private static final String HmacMD5 = "HmacMD5";

    public static byte[] digest(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(MD5).digest(str.getBytes(charset));
    }

    public static String digestString(String str) throws NoSuchAlgorithmException {
        return bytesToHex(MessageDigest.getInstance(MD5).digest(str.getBytes(charset)));
    }

    public static byte[] digest(String str, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        return initMac(key).doFinal(str.getBytes(charset));
    }

    public static String digestString(String str, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        return bytesToHex(initMac(key).doFinal(str.getBytes(charset)));
    }

    private static Mac initMac(String key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(charset), HmacMD5);
        Mac mac = Mac.getInstance(HmacMD5);
        mac.init(secretKey);
        return mac;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
