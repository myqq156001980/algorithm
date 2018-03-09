package com.abel.learnenum;

/**
 * Created by sunzqc on 2017/10/17 13:33.
 */
enum Color {
    GREEN, RED, BLUE
}

public class EnumDemo4 {

    public static void printName(Color color) {
        switch (color) {
            case BLUE: //无需使用Color进行引用
                System.out.println("蓝色");
                break;
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
        }
    }

    public static void main(String[] args) {
        printName(Color.BLUE);
        printName(Color.RED);
        printName(Color.GREEN);

        //蓝色
        //红色
        //绿色
    }
}
