package com.bruce.multithread.blockingQueue;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Testing
 * Created by bruce-jiang on 2016/2/26.
 * @version  1.0
 */
public class BlockingQueueTest {
    public static  void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory:");
        String directory = in.nextLine();
        System.out.println("Enter keyword:");
        String keyword = in.nextLine();

        final int  FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;

        BlockingQueue<File> fQueue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

        FileEnumeration enumeration = new FileEnumeration(fQueue,new File(directory));
        new Thread(enumeration).start();
        for(int i=1;i<=SEARCH_THREADS;i++){
            new Thread(new SearchKeyWords(fQueue,keyword)).start();
        }
    }

}
