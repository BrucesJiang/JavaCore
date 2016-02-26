package com.bruce.multithread.synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A bank with a number of bank accounts that uses locks for serializing access
 * Created by bruce-jiang on 2016/2/25.
 *
 * @version 1.0
 */
public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    /**
     * Contructs the bank
     *
     * @param n              the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }


    /**
     * Transfer money from one account to another
      * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     * @throws InterruptedException
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d ", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance :$%10.2f%n", getTotalBalance());
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * Gets the sum of all account balances
     * @return the total balance
     */
    private double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) {
                sum += a;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * Gets the number of accounts in the bank
     *
     * @return the number of accounts
     */
    public int size() {
        return accounts.length;
    }

}
