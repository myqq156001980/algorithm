package com.abel.weekreference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by sunzqc on 2017/9/7 15:23.
 */
public class SoftReferenceTest {


    public static void main(String[] args) {

        Car car = new Car(22000, "silver");

        SoftReference<Car> softCar = new SoftReference<Car>(car);

//    WeakReference<Car> weekCar = new WeakReference<Car>(car);
        int i = 0;

        while (true){
            if (softCar.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + "loops - " + softCar);
            } else {
                System.out.println("Object has been collected");
                break;
            }
        }
    }


}
