package com.abel.lintcode;

import java.util.ArrayList;

/**
 * 给一个由数字组成的字符串。求出其可能恢复为的所有IP地址
 * 给出字符串 "25525511135"，所有可能的IP地址为：
 * [
 * "255.255.11.135",
 * "255.255.111.35"
 * ]
 * Created by fpschina on 16/3/2.
 */
public class RestoreIPAddresses {

    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public static boolean isValid(String s) {
        if (s.charAt(0) == '0') return s.equals("0");
        int num = Integer.parseInt(s);
        return num <= 255 && num > 0;
    }

    public static ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) return res;
        dfs(s, "", res, 0);
        return res;
    }

    public static void dfs(String s, String tmp, ArrayList<String> res, int count) {
        if (count == 3 && isValid(s)) {
            res.add(tmp + s);
            return;
        }
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String substr = s.substring(0, i);
            if (isValid(substr)) {
                dfs(s.substring(i), tmp + substr + '.', res, count + 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        ArrayList<String> list = restoreIpAddresses(s);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println((int)'z');
    }
}
