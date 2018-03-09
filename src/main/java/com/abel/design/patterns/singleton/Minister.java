package com.abel.design.patterns.singleton;

/**
 * Created by sunzqc on 2017/8/4 10:34.
 * 大臣是天天要面见皇帝，今天见的皇帝和昨天的，前天不一样那就出问题了
 */
public class Minister {

    public static void main(String[] args) {
        Emperor emperor1 = Emperor.getInstance();
        emperor1.emperorInfo(); //第一天见的皇帝叫什么名字呢？
        //第二天
        Emperor emperor2 = Emperor.getInstance();
        emperor2.emperorInfo();
        //第三天
        Emperor emperor3 = Emperor.getInstance();
        emperor2.emperorInfo();
    }
}
