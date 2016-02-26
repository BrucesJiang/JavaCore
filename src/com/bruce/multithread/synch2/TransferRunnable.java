package com.bruce.multithread.synch2;

/**
 * A runnable that transfers money from an account to other accounts in a bank
 * Created by bruce-jiang on 2016/2/26.
 *
 * @version 1.0
 */
public class TransferRunnable implements Runnable {
    private Bank bank;
    private int fromAccount;
    private double maxBalance;

    /**
     * Constructs a transfer runnable
     *
     * @param bank        the bank between whose the money transfers
     * @param fromAccount the account that the money transfer from
     * @param maxBalance  the maximum balance to transfer
     */
    public TransferRunnable(Bank bank, int fromAccount, double maxBalance) {
        this.bank = bank;
        this.fromAccount = fromAccount;
        this.maxBalance = maxBalance;
    }


    @Override
    public void run() {
        try {
            while (true) {
                int toAccount = (int) (bank.size() * Math.random());
                double balance = maxBalance * Math.random();
                bank.transfer(fromAccount, toAccount, balance);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
