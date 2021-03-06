package com.mingle.test;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Created by mingle.
 * Time 2018/3/28 上午10:18
 * Desc 文件描述
 */
public class UnitTest extends TestCase{
    
    @Test
    public void testRead() {
        System.out.println("hello");
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
        
        Assert.assertTrue(true);
    }
}
