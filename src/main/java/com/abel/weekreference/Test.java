package com.abel.weekreference;

import java.lang.ref.WeakReference;

/**
 * Created by sunzqc on 2017/9/5 15:42.
 */
public class Test {

    public static void main(String[] args) {
        Car car = new Car(22000, "silver");

        WeakReference<Car> weekCar = new WeakReference<Car>(car);
        int i = 0;

        while (true) {

            System.out.println("here is the strong reference 'car' " + car); // 加上则不会被gc回收
            if (weekCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + "loops - " + weekCar);
            } else {
                System.out.println("Object has been collected");
                break;
            }
        }

    }
}
