package com.bruce.multithread.forkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Author Bruce Jiang
 * @Date 2016/2/27 20:25
 * @version 1.0
 */
public class Counter extends RecursiveTask<Integer>{
    public static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private Filter filter;

    public Counter(double[] values, int from ,int to , Filter filter){
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }
    @Override
    protected Integer compute() {
        if(to - from < THRESHOLD){
            int count = 0;
            for(int i= from ; i<to;i++){
                if(filter.accept(values[i])) count++;
            }
            return count;
        }else{
            int mid = (from+to)/2;
            Counter first = new Counter(values,from,mid,filter);
            Counter second = new Counter(values,mid,to,filter);
            invokeAll(first,second);
            return first.join() +second.join();
        }
    }
}
