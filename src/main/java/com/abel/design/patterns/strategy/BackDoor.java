package com.abel.design.patterns.strategy;

/**
 * Created by sunzqc on 2017/8/4 10:11.
 * 找乔国老帮忙，使孙权不能杀刘备
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }
}
