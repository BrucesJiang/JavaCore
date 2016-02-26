package com.bruce.multithread.synch;

import com.bruce.multithread.synch.TransferRunnable;
/**
 * Created by bruce-jiang on 2016/2/25.
 */
public class SychBankTest {
    private static final int NACCOUNTS = 100;
    private static double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            Thread thread = new Thread(r);
            thread.start();
        }
    }
}
