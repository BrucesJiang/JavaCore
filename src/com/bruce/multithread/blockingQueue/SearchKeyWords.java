package com.bruce.multithread.blockingQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * This class finds key words in files
 * Created by bruce-jiang on 2016/2/26.
 * @version  1.0
 */
public class SearchKeyWords implements Runnable{
    private BlockingQueue<File> fQueue;
    private String keyword;

    /**
     * Constructs a SearchKeyWords object
     * @param fQueue the queue from which the work start
     * @param keyword the keyword to search
     */
    public SearchKeyWords(BlockingQueue<File> fQueue, String keyword){
        this.fQueue = fQueue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        try {
            boolean done = false;
            while(!done){
                //从阻塞队列里取出文件
                File file = fQueue.take();
                if(file == FileEnumeration.DUMMY){
                    fQueue.put(file);
                    done = true;
                }else searchKeyword(file);
            }
        }catch(InterruptedException e){
            //处理线程例外
            Thread.currentThread().interrupt();
        }catch(IOException e){
            //因该将例外处理了，输出到日志等
            e.printStackTrace();
        }

    }

    /**
     * Searches a file for a keyword and prints all matching lines
     * @param file the file to search
     * @throws IOException the Exception will be thrown while searching
     */
    private void searchKeyword(File file) throws IOException {
        //带资源的try语句 无论是否抛出例外，流都将被关闭
        try(Scanner in  =  new Scanner(file)) {
            int lineNum = 0;
            while (in.hasNext()) {
                lineNum++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNum, line);
                }
            }
        }

    }

}
