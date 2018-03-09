package com.abel.jvmlearn;

/**
 * Created by sunzqc on 2017/9/6 11:02.
 */
public class JavaVMStackSOf {

    private int stackLength = 1;


    /**
     * -Xss128k
     *
     * @param args
     */
    public static void main(String[] args) {
        JavaVMStackSOf oom = new JavaVMStackSOf();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }

    public void stackLeak() {

        stackLength++;
        stackLeak();
    }

}
