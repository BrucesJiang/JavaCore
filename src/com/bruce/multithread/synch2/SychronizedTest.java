package com.bruce.multithread.synch2;

/**
 *
 * Created by bruce-jiang on 2016/2/26.
 * @version  1.0
 */
public class SychronizedTest {
    private static final int NACCOUNTS = 100;
    private static double INITIAL_BALANCE = 10;

    public static void main(String[] args){
        Bank bank = new Bank(NACCOUNTS,INITIAL_BALANCE);
        for(int i=0;i<NACCOUNTS;i++){
            TransferRunnable r = new TransferRunnable(bank,i,INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
