package com.bruce.generic.pair1;

import com.bruce.generic.Pair;

/**
 * Created by bruce-jiang on 2016/2/21.
 *@version  1.0
 */
public class PairTest {
    public static void main(String[] args){
        String[] words = {"Mary","had","a" , "little","lamb"};
        Pair<String> mm = ArrayAlg.minMax(words);
        System.out.println("min = "+mm.getFirst());
        System.out.println("max = "+mm.getSecond());
    }
}
