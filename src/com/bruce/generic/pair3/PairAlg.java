package com.bruce.generic.pair3;


import com.bruce.generic.Pair;
/**
 * Created by bruce-jiang on 2016/2/22.
 */
public class PairAlg {
    public static boolean hasNulls(Pair<?> p){
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p){swapHelper(p);}

    public static <T> void swapHelper(Pair<T> p){
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
