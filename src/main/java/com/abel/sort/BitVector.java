package com.abel.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 */
public class BitVector {
    private int count;
    private int[] a; //数组 * Created by sunzqc on 2017/7/27 14:04.

    private int P; //整数部分
    private int S; //余数
    private int MASK = 0x1F;// 2^5 - 1
    private int SHIFT = 5; // 2^n SHIFT=n=5 表示2^5=32 即bit位长度32

    /**
     * 初始化位向量
     *
     * @param count
     */
    public BitVector(int count) {
        this.count = count;
        int BIT_LENGTH = 32;
        a = new int[(count - 1) / BIT_LENGTH + 1];
        init();
    }

    //测试
    public static void main(String[] args) {
        int count = 30;
        List<Integer> randoms = getRandomsList(count);
        System.out.println("排序前：");

        BitVector bitVector = new BitVector(count);
        for (Integer e : randoms) {
            System.out.print(e + ",");
            bitVector.set(e);
        }

        List<Integer> sortedArray = bitVector.getSortedArray();
        System.out.println();
        System.out.println("排序后：");
        for (Integer e : sortedArray) {
            System.out.print(e + ",");
        }

        /**
         输出结果:
         排序前：
         6,3,20,10,18,15,19,16,13,4,21,22,24,2,14,5,12,7,23,8,1,17,9,11,
         排序后：
         1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,
         */
    }

    private static List<Integer> getRandomsList(int count) {
        Random random = new Random();

        List<Integer> randomsList = new ArrayList<Integer>();
        while (randomsList.size() < (count - 1)) {
            int element = random.nextInt(count - 1) + 1;//element ∈  [1,count)
            if (!randomsList.contains(element)) {
                randomsList.add(element);
            }
        }
        return randomsList;
    }

    /**
     * 获取排序后的数组
     *
     * @return
     */
    public List<Integer> getSortedArray() {
        List<Integer> sortedArray = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            if (get(i) == 1) {//判断i是否存在
                sortedArray.add(i);
            }
        }
        return sortedArray;
    }

    /**
     * 将数组中元素bit位设置为0
     */
    public void init() {
        for (int i = 0; i < count; i++) {
            clear(i);
        }
    }

    /**
     * 置位操作,添加操作
     *
     * @param i
     */
    public void set(int i) {
        P = i >> SHIFT; //结果等同  P = i / BIT_LENGTH; 取整数 ①
        S = i & MASK;   //结果等同  S = i % BIT_LENGTH; 取余数 ②

        a[P] |= 1 << S;  //赋值设置该元素bit位为1               ③
        //将int型变量j的第k个比特位设置为1， 即j=j|(1<<k),上述3句合并为一句
        // a[i >> SHIFT] |= (1 << (i & MASK));
    }

    /**
     * 置0操作，相当于清除元素
     *
     * @param i
     */
    public void clear(int i) {
        P = i >> SHIFT; //计算位于数组中第？个元素 P = i / BIT_LENGTH;
        S = i & MASK;   //计算余数  S = i % BIT_LENGTH;
        //把a[P]元素的第S+1个(从低位到高位)bit位设置为0
        a[P] &= ~(1 << S);

        //更优写法
        //将int型变量j的第k个比特位设置为0，即j= j&~(1<<k)
        //a[i>>SHIFT] &= ~(1<<(i &MASK));
    }

    /**
     * 读取操作，返回1代表该bit位有值，返回0代表该bit位没值
     *
     * @param i
     * @return
     */
    public int get(int i) {
        //a[i>>SHIFT] & (1<<(i&MASK));
        P = i >> SHIFT;
        S = i & MASK;
        return Integer.bitCount(a[P] & (1 << S));
    }

}
