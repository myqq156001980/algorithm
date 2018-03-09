package com.abel.design.patterns.strategy;

/**
 * Created by sunzqc on 2017/8/4 10:13.
 * "求吴国太开个绿灯,放行！ "
 */
public class GivenGreenLight implements IStrategy {

    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯,放行！ ");
    }
}
