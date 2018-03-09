package com.abel.util;

/**
 * Created by sunzqc on 2017/7/7 15:07.
 * Util
 */
public class MyUtil {
    public static String parseByte2HexStr(byte[] b) {
        StringBuilder stringBuilder = new StringBuilder();

        for (byte aB : b) {
            String hex = Integer.toHexString(0xff & aB);
            if (hex.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int res = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 2), 16);
            result[i] = (byte) res;
        }
        return result;
    }


}
