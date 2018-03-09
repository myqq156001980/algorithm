package com.abel.lintcode;

/**
 * Created by sunzqc on 2017/12/6 13:53.
 */
public class NumToVoice {

    /**
     * 输入 2147483647
     * 输出 二十一亿四千七百四十八万三千六百四十七
     * @param num
     * @return
     */
    static String numToVoice(int num) {
        if (num == 0) {
            return "零";
        }
        String[] unit = {"", "十", "百", "千", "万", "", "", "", "亿"};
        String[] strNUm = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0, resNum = num;
        while (resNum != 0) {
            int curNum = resNum % 10;
            if (index == 0 && curNum == 0) {
                index++;
                resNum /= 10;
                continue;
            }
            if (curNum != 0) {
                stringBuilder.append(unit[index - (index % 4 == 0 ? 0 : (index / 4) * 4)]);
            }
            stringBuilder.append(strNUm[curNum]);
            resNum /= 10;
            index++;
        }

        return stringBuilder.reverse().toString();


    }
}
