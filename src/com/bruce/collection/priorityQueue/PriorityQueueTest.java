package com.bruce.collection.priorityQueue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * This program demonstrates the use of a priority queue
 * Created by bruce-jiang on 2016/2/23.
 * @version  1.0
 */
public class PriorityQueueTest {
    public static void main(String[] args){
        PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
        pq.add(new GregorianCalendar(1906,Calendar.DECEMBER,9));
        pq.add(new GregorianCalendar(1815,Calendar.DECEMBER,10));
        pq.add(new GregorianCalendar(1903,Calendar.DECEMBER,3));
        pq.add(new GregorianCalendar(1905,Calendar.JUNE,2));
        pq.add(new GregorianCalendar(1810,Calendar.JUNE,2));

        System.out.println("Iterating over elements ...");
        for(GregorianCalendar date : pq){
            System.out.println(date.get(Calendar.YEAR));
        }
        System.out.println("Remove Elements ...");
        while(!pq.isEmpty()){
            System.out.println(pq.remove().get(Calendar.YEAR));
        }
    }
}
