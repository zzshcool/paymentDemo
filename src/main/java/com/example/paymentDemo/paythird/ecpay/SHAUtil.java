package com.example.paymentDemo.paythird.ecpay;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具
 */
public class SHAUtil {
    private static final Charset charset = Charset.forName("UTF-8");
    private static final String SHA1 = "SHA-1";
    private static final String SHA256 = "SHA-256";
    private static final String SHA224 = "SHA-224";
    private static final String HmacSHA256 = "HmacSHA256";

    public static byte[] digestSHA256bin(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(SHA256).digest(str.getBytes(charset));
    }

    public static String digestSHA1(String str) throws NoSuchAlgorithmException {
        return bytesToHex(MessageDigest.getInstance(SHA1).digest(str.getBytes(charset)));
    }

    public static String digestSHA256(String str) throws NoSuchAlgorithmException {
        return bytesToHex(MessageDigest.getInstance(SHA256).digest(str.getBytes(charset)));
    }

    public static String digestSHA256(String str, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        return bytesToHex(initMac(HmacSHA256, key).doFinal(str.getBytes(charset)));
    }

    public static String digestSHA224(String str) throws NoSuchAlgorithmException {
        return bytesToHex(MessageDigest.getInstance(SHA224).digest(str.getBytes(charset)));
    }

    private static Mac initMac(String algorithm, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(charset), algorithm);
        Mac mac = Mac.getInstance(algorithm);
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