package com.abel.md5;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMD5 {
    private static byte[] getMd5Byte(String s) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("md5");
        messageDigest.update(s.getBytes());
        return messageDigest.digest();

    }


    private static String bytesToHexString(byte[] src, int signnum) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte aSrc : src) {
            int v = aSrc & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        if (signnum == 16) {
            return stringBuilder.toString().substring(8, 24);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String name = "萌萌哒和园园哒";
        byte[] b = getMd5Byte(name);
        System.out.println(bytesToHexString(b, 32));
        System.out.println(bytesToHexString(b, 16));


    }


}
