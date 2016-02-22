package com.bruce.generic.pair2;

import com.bruce.generic.Pair;
/**
 * Created by bruce-jiang on 2016/2/22.
 * @version  1.0
 */
public class ArrayAlg {
    /**
     * Gets the minimum and maximum of an array of objects of type T
     * @param a an array of objects of type T
     * @return return a pair with the min and max value , or null if a is null or empty
     */
    public static <T extends Comparable> Pair<T> minMax(T[] a){
        if(a == null || a.length == 0){
            return null;
        }
        T min = a[0];
        T max = a[1];
        for(int i=0;i<a.length;i++){
            if(min.compareTo(a[i])>0) min = a[i];
            if(max.compareTo(a[i])<0) max = a[i];
        }
        return new Pair<>(min,max);
    }
}
