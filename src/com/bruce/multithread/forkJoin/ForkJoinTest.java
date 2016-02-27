package com.bruce.multithread.forkJoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author Bruce Jiang
 * @Date 2016/2/27 20:33
 * @version 1.0
 */
public class ForkJoinTest {
    public static void main(String[] args){
        final int SIZE = 1000000;
        double[] numbers = new double[SIZE];
        for(int i=0;i<SIZE;i++) numbers[i] = Math.random();
        Counter counter  = new Counter(numbers, 0, numbers.length, new Filter() {
            @Override
            public boolean accept(double t) {
                return t>0.5;
            }
        });
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}
