package com.abel.design.patterns.proxy;

/**
 * Created by sunzqc on 2017/8/4 10:25.
 * 王婆这个人老聪明了，她太老了，是个男人都看不上，
 * 但是她有智慧有经验呀，她作为一类女人的代理！
 */
public class WangPo implements KindWomen {
    private KindWomen kindWomen;

    public WangPo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }

    @Override
    public void makeEyesWithMan() {
        this.kindWomen.makeEyesWithMan();
    }

    @Override
    public void happyWithMan() {
        this.kindWomen.happyWithMan();
    }
}
