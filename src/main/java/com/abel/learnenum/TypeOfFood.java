package com.abel.learnenum;

/**
 * Created by sunzqc on 2017/10/17 13:37.
 */
public class TypeOfFood {


    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.LASAGNE;
        food = Food.Dessert.GELATO;
        food = Food.Coffee.CAPPUCCINO;
    }
}
