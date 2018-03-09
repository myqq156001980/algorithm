package com.abel.design.patterns.factory;

/**
 * Created by sunzqc on 2017/8/4 10:50.
 * <p>
 * 黄色人种
 */
public class YellowHuman implements Human {

    @Override
    public void laugh() {
        System.out.println("黄色人种会哭");
    }

    @Override
    public void cry() {

        System.out.println("黄色人种会大笑，幸福呀！ ");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节");

    }
}
