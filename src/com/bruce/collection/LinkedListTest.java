package com.bruce.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by bruce-jiang on 2016/2/22.
 * @version  1.0
 */
public class LinkedListTest {
    public static void main(String[] args){
        List<String> a  = new LinkedList();
        a.add("Bob");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Boug");
        b.add("Frances");
        b.add("Gloria");

        //merge the words from b into a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while(bIter.hasNext()){
            if(aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        //remove every second word from b
        bIter  = b.iterator();
        while(bIter.hasNext()){

            bIter.next(); //skip one element
            if(bIter.hasNext()) {
                bIter.next(); //skip next element
                bIter.remove(); // remove that element
            }
        }

        System.out.println(b);
        //bulk operation: remove all words in b from a
        a.removeAll(b);
        System.out.println(a);

    }
}
