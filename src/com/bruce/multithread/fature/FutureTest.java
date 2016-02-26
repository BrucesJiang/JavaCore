package com.bruce.multithread.fature;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by bruce-jiang on 2016/2/26.
 * @version  1.0
 */
public class FutureTest {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter base directory:");
        String directory = in.nextLine();
        System.out.println("Enter keyword:");
        String keyword = in.nextLine();

        MatchCounter counter  = new MatchCounter(new File(directory),keyword);

        FutureTask<Integer> task = new FutureTask<Integer>(counter);
        Thread t = new Thread(task);
        t.start();
        try{
            System.out.println(task.get()+" matching files.");
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
