package com.abel.learnenum;

/**
 * Created by sunzqc on 2017/10/17 13:35.
 */
public enum EnumDemo3 {

    FIRST {
        @Override
        public String getInfo() {
            return "FIRST TIME";
        }
    },
    SECOND {
        @Override
        public String getInfo() {
            return "SECOND TIME";
        }
    };

    //测试
    public static void main(String[] args) {
        System.out.println("F:" + EnumDemo3.FIRST.getInfo());
        System.out.println("S:" + EnumDemo3.SECOND.getInfo());
        /**
         输出结果:
         F:FIRST TIME
         S:SECOND TIME
         */
    }

    /**
     * 定义抽象方法
     *
     * @return
     */
    public abstract String getInfo();
}
