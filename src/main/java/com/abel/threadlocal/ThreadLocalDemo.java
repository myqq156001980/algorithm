package com.abel.threadlocal;

import java.util.Random;

public class ThreadLocalDemo implements Runnable {
    //创建线程局部变量studentLocal，在后面你会发现用来保存Student对象
    private static final ThreadLocal<Student> studentLocal = new ThreadLocal<Student>() {
        @Override
        protected Student initialValue() {
            Student st = new Student();
            st.setName(Thread.currentThread().getName());
            return st;
        }
    };


    public static void main(String[] agrs) throws InterruptedException {
        Student student = new Student();
        student.setName("Abel");
        ThreadLocalDemo td = new ThreadLocalDemo();
        ThreadLocalDemo.studentLocal.set(student);
        Thread t1 = new Thread(td, "a");
        Thread t2 = new Thread(td, "b");
        t1.start();
        t2.start();


        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + "====" + student.toString());
    }

    public void run() {
        accessStudent();
    }

    /**
     * 示例业务方法，用来测试
     */
    public void accessStudent() {
        //获取当前线程的名字
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running!");
        //产生一个随机数并打印
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println("thread " + currentThreadName + " set age to:" + age);
        //获取一个Student对象，并将随机数年龄插入到对象属性中
        Student student = getStudent();
        student.setAge(age);
        System.out.println("thread " + currentThreadName + " name is:" + student.getName() + " first read age is:" + student.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("thread " + currentThreadName + " name is:" + student.getName() + " second read age is:" + student.getAge());
    }

    protected Student getStudent() {
        return studentLocal.get();
    }
}