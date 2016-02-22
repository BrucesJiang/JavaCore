package com.bruce.generic.pair2;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.bruce.generic.Pair;
/**
 * Created by bruce-jiang on 2016/2/22.
 * @version  1.0
 */
public class PairTest {
    public static void main(String[] args){
        GregorianCalendar[] birthdays = {
                new GregorianCalendar(1097, Calendar.DECEMBER,9),
                new GregorianCalendar(1047, Calendar.DECEMBER,20),
                new GregorianCalendar(1907, Calendar.DECEMBER,3),
                new GregorianCalendar(1910, Calendar.JUNE,22)
        };
        Pair<GregorianCalendar> mm = ArrayAlg.minMax(birthdays);
        System.out.println("Min = "+mm.getFirst().getTime());
        System.out.println("Max = "+mm.getSecond().getTime());
    }
}
