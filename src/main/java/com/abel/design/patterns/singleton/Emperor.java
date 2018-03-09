package com.abel.design.patterns.singleton;

/**
 * Created by sunzqc on 2017/8/4 10:32.
 * 中国的历史上一般都是一个朝代一个皇帝，有两个皇帝的话，必然要PK出一个皇帝出来
 */
public class Emperor {
    private static Emperor emperor = null;

    private Emperor() {
    }

    public static Emperor getInstance() {
        if (emperor == null) {
            emperor = new Emperor();
        }
        return emperor;
    }

    //皇帝叫什么名字呀
    public void emperorInfo() {
        System.out.println("我就是皇帝某某某....");
    }
}
