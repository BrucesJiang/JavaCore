package com.bruce.multithread.threadPool;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @version 1.0
 * @Author Bruce Jiang
 * @Date 2016/2/27 13:21
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory:");
        String directory = in.nextLine();
        System.out.println("Enter keyword:");
        String keyword = in.nextLine();

        ExecutorService pool = Executors.newCachedThreadPool();

        MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);

        Future<Integer> result = pool.submit(counter);

        try {
            System.out.println(result.get() + " matching files");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();

        int largesPoolSize = ((ThreadPoolExecutor)pool).getLargestPoolSize();
        System.out.println("Largest pool size = "+largesPoolSize);
    }
}