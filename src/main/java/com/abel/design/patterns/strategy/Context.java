package com.abel.design.patterns.strategy;

/**
 * Created by sunzqc on 2017/8/4 10:16.
 * * 计谋有了，那还要有锦囊
 */
public class Context {
    private IStrategy iStrategy;

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void operate(){
        this.iStrategy.operate();
    }
}
