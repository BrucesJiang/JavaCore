package com.bruce.generic.pair3;


import com.bruce.generic.Pair;
/**
 *
 * Created by bruce-jiang on 2016/2/22.
 *@version  1.0
 */
public class PairTest {

    public static void main(String[] args){
        Manager ceo = new Manager("A",800000,2003,12,15);
        Manager cfo = new Manager("B",870000,2003,12,11);
        Pair<Manager> buddies = new Pair<>(ceo,cfo);

        ceo.setBonus(1000000);
        cfo.setBonus(50000);
        Manager[] managers = {ceo,cfo};

        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers,result);

        System.out.println("first:"+result.getFirst().getName()+", second:"+result.getSecond().getName());

        maxminBonus(managers,result);
        System.out.println("first:"+result.getFirst().getName()+", second:"+result.getSecond().getName());
    }
    public static void printBuddies(Pair<? extends Employee> p){
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+" are buddies.");
    }

    public static void minmaxBonus(Manager[] a , Pair<? super Manager> result){
        if(a == null || a.length ==0) return ;
        Manager min = a[0];
        Manager max = a[1];
        for(int i=1;i<a.length;i++){
            if(min.getBonus()>a[i].getBonus()) min = a[i];
            if(max.getBonus()<a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }


    public static void maxminBonus(Manager[] a, Pair<? super Manager> result){
        minmaxBonus(a,result);
        PairAlg.swapHelper(result);
    }
}
