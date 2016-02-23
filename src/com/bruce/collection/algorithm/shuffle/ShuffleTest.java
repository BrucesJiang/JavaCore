package com.bruce.collection.algorithm.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This program demonstrates the random shuffle and sort algorithms
 * Created by bruce-jiang on 2016/2/23.
 * @version  1.0
 */
public class ShuffleTest {
    public static  void  main(String[] args){
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=49;i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> c = numbers.subList(0,6);
        Collections.sort(c);
        System.out.println(c);
    }
}
