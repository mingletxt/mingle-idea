package com.mingle.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Created by mingle. Time 2019-01-08 17:17 Desc 文件描述
 */
public class TestShutdown {
    
    public static void main(String[] args) {
        int parallelSize = 10;
        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<Runnable>(parallelSize);
        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ExecutorService threadPool = new ThreadPoolExecutor(parallelSize, parallelSize, 0L, TimeUnit.MILLISECONDS, workingQueue, rejectedExecutionHandler);
    
        for (int i = 0; i < 25; i++) {
            threadPool.submit(() -> {
                System.out.println(Thread.currentThread() + " running");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    
}
