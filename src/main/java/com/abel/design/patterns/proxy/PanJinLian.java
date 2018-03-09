package com.abel.design.patterns.proxy;

/**
 * Created by sunzqc on 2017/8/4 10:25.
 * 定一个潘金莲是什么样的人
 */
public class PanJinLian implements KindWomen {

    @Override
    public void makeEyesWithMan() {
        System.out.println("潘金莲在和男人做那个.....");
    }

    @Override
    public void happyWithMan() {
        System.out.println("潘金莲抛媚眼");
    }
}
