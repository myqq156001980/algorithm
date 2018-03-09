package com.abel.design.patterns.factory;

/**
 * Created by sunzqc on 2017/8/4 10:52.
 * 黑色人种
 */
public class BlackHuman implements Human {

    @Override
    public void laugh() {
        System.out.println("黑人会哭");
    }

    @Override
    public void cry() {
        System.out.println("黑人会笑");
    }

    @Override
    public void talk() {
        System.out.println("黑人可以说话，一般人听不懂");
    }
}
