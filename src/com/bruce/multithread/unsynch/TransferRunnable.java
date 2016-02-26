package com.bruce.multithread.unsynch;

/**
 * A runnable that transfers money from an account to other accounts in a bank
 * Created by bruce-jiang on 2016/2/25.
 * @version  1.0
 */
public class TransferRunnable implements Runnable{
    private Bank bank;
    private int from;
    private double maxAmount;
    private static final int DELAY = 10;

    /**
     * Constructs a transfer runnable
     * @param bank tha bank between whose account money is transferred
     * @param from the account to transfer money from
     * @param max the maximum amount of money in each transfer
     */
    public TransferRunnable(Bank bank  , int from, double max){
        this.bank = bank;
        this.from = from;
        this.maxAmount = max;
    }


    @Override
    public void run() {
        try{
            while(true){
                int toAccount = (int)(bank.size()*Math.random());
                double amount = maxAmount*Math.random();
                bank.transfer(from,toAccount,amount);
                Thread.sleep((int)(DELAY*Math.random()));
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
