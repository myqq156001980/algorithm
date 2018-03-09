package com.abel.lintcode;

import java.util.ArrayList;

/**给一个数字字符串，每个数字代表一个字母，请返回其所有可能的字母组合
 * 下图的手机按键图，就表示了每个数字可以代表的字母。
 * Created by fpschina on 16/3/2.
 */
public class LetterCombinations {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        findCombinations(digits, "", result);
        return result;

    }

    public int[] caculatePosition(int num) {

        int[] pos = new int[2];
        if (num == 7 || num == 9) {
            pos[1] = 4;
        } else {
            pos[1] = 3;
        }
        if (num <= 7) {
            pos[0] = 97 + (num - 2) * 3;

        } else {
            pos[0] = 97 + (num - 2) * 3 + 1;
        }

        return pos;

    }

    public void findCombinations(String digits, String tmp, ArrayList<String> result) {

        if (digits.length() != 1) {
            String rest = digits.substring(1);
            int num = Integer.parseInt(digits.substring(0, 1));
            int[] pos = caculatePosition(num);

            for (int i = 0; i < pos[1]; i++) {
                findCombinations(rest, tmp + (char) (pos[0] + i), result);
            }
        } else {
            int[] pos = caculatePosition(Integer.parseInt(digits));
            for (int i = 0; i < pos[1]; i++) {
                result.add(tmp + (char) (pos[0] + i));
            }
        }

    }
}
