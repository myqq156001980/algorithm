package com.abel.mydigest;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.abel.util.MyUtil.parseByte2HexStr;

/**
 * Created by sunzqc on 2017/7/6 17:24.
 * SHA MD5 DIGEST
 */
class MyDigest {

    private static final String SHA = "SHA";
    private static final String SHA_256 = "SHA-256";
    private static final String SHA_512 = "SHA-512";
    private static final String MD5 = "MD5";


    private static String md5(String content) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(MD5);
        messageDigest.update(content.getBytes());
        byte[] b = messageDigest.digest();
        return parseByte2HexStr(b);

    }

    private static String sha256(String content) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(SHA_256);
        messageDigest.update(content.getBytes());
        byte[] b = messageDigest.digest();
        return parseByte2HexStr(b);

    }

    private static String sha512(String content) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(SHA_512);
        messageDigest.update(content.getBytes());
        byte[] b = messageDigest.digest();
        return parseByte2HexStr(b);
    }

    private static String sha(String content) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(SHA);
        messageDigest.update(content.getBytes());
        byte[] b = messageDigest.digest();
        return parseByte2HexStr(b);
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {

        String name = "szq";
        System.out.println(sha(name));
        System.out.println(sha256(name));
        System.out.println(sha512(name));
        System.out.println(md5(name));

    }

}
