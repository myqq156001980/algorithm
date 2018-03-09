package com.abel.learnenum;

/**
 * Created by sunzqc on 2017/10/17 11:21.
 */
public enum Day2 {
    MONDAY("星期一", 1),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");//记住要用分号结束

    private String desc;//中文描述
    private int num;

    public int getNum() {
        return num;
    }

    /**
     * 私有构造,防止被外部调用
     *
     * @param desc
     */
    private Day2(String desc) {
        this.desc = desc;
    }

    private Day2(String desc, int num) {
        this.desc = desc;
        this.num = num;
    }

    public static void main(String[] args) {
        for (Day2 day : Day2.values()) {
            System.out.println("name:" + day.name() +
                    ",desc:" + day.getDesc() + ",num: " + day.getNum());
        }
    }

    /**
     * 定义方法,返回描述,跟常规类的定义没区别
     *
     * @return
     */
    public String getDesc() {
        return desc;
    }

    /**
     输出结果:
     name:MONDAY,desc:星期一
     name:TUESDAY,desc:星期二
     name:WEDNESDAY,desc:星期三
     name:THURSDAY,desc:星期四
     name:FRIDAY,desc:星期五
     name:SATURDAY,desc:星期六
     name:SUNDAY,desc:星期日
     */
}