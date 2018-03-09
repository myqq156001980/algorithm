package com.abel.design.patterns.strategy;

/**
 * Created by sunzqc on 2017/8/4 10:14.
 * 孙夫人断后，挡住追兵
 */
public class BlockEnemy implements IStrategy {

    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
