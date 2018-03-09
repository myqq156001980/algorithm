package com.abel.jvmlearn;

/**
 * Created by sunzqc on 2017/9/12 15:55.
 */
public class DynamicDispatch {

    public static void main(String[] args) {
        Human man = new Man();
        Human women = new Women();

        women.sayHello();
        man.sayHello();
        man = new Women();
        man.sayHello();
    }

    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }

    }

    static class Women extends Human {

        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

}
