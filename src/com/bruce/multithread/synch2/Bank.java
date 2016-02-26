package com.bruce.multithread.synch2;

/**
 * A bank with a number of bank accounts that uses synchronization primitives
 * Created by bruce-jiang on 2016/2/26.
 * @version  1.0
 */
public class Bank {
    private final double[] accounts;

    /**
     * Constructs the bank
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        for(int i=0;i<accounts.length; i++){
            accounts[i] = initialBalance;
        }
    }

    public synchronized void transfer(int from , int to, double amount) throws InterruptedException{
        while(accounts[from]<amount){
            wait();
        }
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d",amount,from,to);
        accounts[to] += amount;
        System.out.printf("Total Balance :%10.2f%n",getTotalBalance());
        notifyAll();
    }

    /**
     * Gets the sum of all account balances
     * @return the total balance
     */
    public synchronized  double getTotalBalance(){
        double sum = 0;
        for(double a : accounts){
            sum += a;
        }
        return sum;
    }

    /**
     * Get the number of accounts in the bank
     * @return the number of accounts
     */
    public int size(){
        return accounts.length;
    }
}
