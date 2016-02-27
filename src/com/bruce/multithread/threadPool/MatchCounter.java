package com.bruce.multithread.threadPool;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword.
 * @Author Bruce Jiang
 * @Date 2016/2/27 13:04
 * @version 1.0
 */
public class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    /**
     * Constructs a MatchCounter object
     * @param directory the directory in which to start the search
     * @param keyword the keyword to search
     * @param pool the thread pool for submitting subtasks
     */
    public MatchCounter(File directory, String keyword, ExecutorService pool){
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }


    @Override
    public Integer call() throws Exception {
        count = 0;
        try{
            File[] files = directory.listFiles();

            List<Future<Integer>> results = new ArrayList<>();

            for (File file:files) {
                if(file.isDirectory()){
                    MatchCounter counter = new MatchCounter(file,keyword,pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }else{
                    if(search(file)){
                        count ++;
                    }
                }
            }
            for(Future<Integer> result : results){
                try {
                    count += result.get();
                }catch(ExecutionException e){
                    e.printStackTrace();
                }
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }catch(IOException e){
            e.printStackTrace();
        }
        return count;
    }

    private boolean search(File file) throws IOException{
        try(Scanner in = new Scanner(file)){
            boolean found = false;
            while(!found && in.hasNext()){
                String line = in.nextLine();
                if(line.contains(keyword)){
                    found = true;
                }
            }
            return found;
        }
    }

}
