package com.bruce.multithread.fature;

import com.bruce.generic.pair3.Manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword
 * Created by bruce-jiang on 2016/2/26.
 * @version  1.0
 */
public class MatchCounter implements Callable<Integer>{
    private File directory;
    private String keyword;
    private int count;

    /**
     *Constructs a MatchCounter object
     * @param directory the directory in which to start the search
     * @param keyword the keyword to look for
     */
    public MatchCounter(File directory, String keyword){
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try{
            File[] files = directory.listFiles();

            List<Future<Integer>>  results  = new ArrayList<>();
            for(File file:files){
                if(file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file,keyword);
                    FutureTask<Integer> task = new FutureTask<Integer>(counter);
                    results.add(task);
                    Thread t= new Thread(task);
                    t.start();
                }else{
                    if(search(file)) count++;
                }
                for(Future<Integer> result :results){
                    try{
                        count += result.get();
                    }catch (ExecutionException e){
                        e.printStackTrace();
                    }
                }
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return count;
    }

    /**
     * Searches a file for a given keyword
     * @param file the file to search
     * @return true if the keyword is contained in the file
     */
    private boolean search(File file){
        try{
            //带资源的try语句
            try(Scanner scanner = new Scanner(file)){
                boolean found = false;
                while(!found && scanner.hasNext()){
                    if(scanner.nextLine().contains(keyword)){
                        found = true;
                    }
                }
                return found;
            }
        }catch(IOException e){
            return false;
        }
    }
}
