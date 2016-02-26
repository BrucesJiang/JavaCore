package com.bruce.multithread.blockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * This class enumerates all files in a directory and is subdirectories
 * Created by bruce-jiang on 2016/2/26.
 * @version  1.0
 */
public class FileEnumeration  implements  Runnable{
    public static File DUMMY = new File("");
    private BlockingQueue<File> fQueue;
    private File  startDirectory;

    /**
     * Constructs a FileEnumeration
     * @param fQueue the blocking queue to which the enumerated files are added
     * @param startDirectory the directory in which to start the enumeration
     */
    public FileEnumeration(BlockingQueue<File> fQueue, File startDirectory){
            this.fQueue = fQueue;
            this.startDirectory = startDirectory;
    }

    @Override
    public void run() {
        try{
            enumerate(startDirectory);

            //the flag to top the program
            fQueue.put(DUMMY);
        }catch(InterruptedException e){
            //the correction method to handler this Exception
            Thread.currentThread().interrupt();
        }
    }

    /**
     * This method enumerates all file in a given directory and its subdirectories through recursion
     * @param directory the given directory to start enumerating
     * @throws InterruptedException the Exception is thrown while enumerating
     */
      private void enumerate(File directory) throws InterruptedException{
        File[] files =  directory.listFiles();
        for (File file: files) {
            if(file.isDirectory()){
                enumerate(file);
            }else{
                fQueue.put(file);
            }
        }
    }
}
