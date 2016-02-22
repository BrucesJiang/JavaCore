package com.bruce.generic;

/**
 * Created by bruce-jiang on 2016/2/22.
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair(){first = null; second = null;}
    public Pair(T first, T  second){
        this.first = first;
        this.second = second;
    }


    public void setFirst(T value){first = value;}
    public void setSecond(T value){second = value;}

    public T getFirst(){return first;}
    public T getSecond(){return second;}
}
