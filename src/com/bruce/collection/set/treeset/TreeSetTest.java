package com.bruce.collection.set.treeset;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This program sorts a set of item by comparing
 * Created by bruce-jiang on 2016/2/23.
 * @version  1.0
 */
public class TreeSetTest {
    public static void main(String[] args){
        //默认的排序方式，按照部件编号排序，在Item类中定义的按照
        //部件编号排序
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster" ,2345));
        parts.add(new Item("Widget",2222));
        parts.add(new Item("Modem",3445));
        System.out.println(parts);

        //重定义排序方式，定制的比较器按照描述信息排序
        SortedSet<Item> sortByDescrption = new TreeSet<>(new Comparator<Item>(){
            public int compare(Item a, Item b){
                return a.getDescription().compareTo(b.getDescription());
            }
        });

        sortByDescrption.addAll(parts);
        System.out.println(sortByDescrption);
    }
}
