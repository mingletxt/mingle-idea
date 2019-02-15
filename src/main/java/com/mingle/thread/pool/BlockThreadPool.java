package com.mingle.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Created by mingle. Time 2018-12-28 11:38 Desc 文件描述
 */
public class BlockThreadPool {
    
    public static void main(String[] args) {
        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<Runnable>(10);
        RejectedExecutionHandler rejectedExecutionHandler =
                new ThreadPoolExecutor.CallerRunsPolicy();
        ExecutorService threadPool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
                workingQueue, rejectedExecutionHandler);
    
        for (int i = 0; i < 15; i++) {
        
            threadPool.submit(new Callable<Boolean>() {
            
                @Override
                public Boolean call() throws Exception {
                    System.out.println("thread " + String.valueOf(Thread.currentThread()) + " is called");
                    Thread.sleep(10000);
                    System.out.println("thread " + String.valueOf(Thread.currentThread()) + " is awake");
                    throw new Exception();
                }
            
            });
        }
        System.out.println("done");
    }
}
