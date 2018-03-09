package com.abel.learnenum;

public enum EnumDemo2 implements food, sport {
    FOOD,
    SPORT,; //分号分隔

    @Override
    public void eat() {
        System.out.println("eat.....");
    }

    @Override
    public void run() {
        System.out.println("run.....");
    }
}

/**
 * Created by sunzqc on 2017/10/17 13:35.
 */
interface food {
    void eat();
}

interface sport {
    void run();
}
