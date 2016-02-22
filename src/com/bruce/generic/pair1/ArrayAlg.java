package com.bruce.generic.pair1;

import com.bruce.generic.Pair;

/**
 * Created by bruce-jiang on 2016/2/21.
 */

public class ArrayAlg {
    public static Pair<String> minMax(String[] string){
        if(string == null){
            return null;
        }
        String min = string[0];
        String max = string[1];
        for(int i=0;i<string.length;i++){
            if(min.compareTo(string[i])>0) min = string[i];
            if(max.compareTo(string[i])<0) max = string[i];
        }
        return new Pair<>(min,max);
    }
}
