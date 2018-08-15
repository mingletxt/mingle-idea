package com.mingle.thread.pool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by mingle.
 * Time 28/07/2018 22:27
 * Desc 文件描述
 */
public class ThreadLocalTest {
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        
        for (int i = 0; i < 100; i++) {
            pool.submit(new MyRunnable());
        }
        
        Thread.sleep(10000L);
        pool.shutdown();
    }
    
}


class MyRunnable implements Runnable {
    
    @Override
    public void run() {
        Bean bean = Bean.get();
        bean.work();
    }
}

class Bean {
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    
    private static Bean instance;
    
    void work() {
        String string = threadLocal.get();
        if (string == null) {
            System.out.println(Thread.currentThread()  + " there is no string");
            threadLocal.set("mingle-" + new Random().nextInt());
            string = threadLocal.get();
        }
        System.out.println(Thread.currentThread() + " hello:" + string);
    }
    
    public static Bean get() {
        if (instance == null) {
            synchronized (Bean.class) {
                if (instance == null) {
                    instance = new Bean();
                }
            }
        }
        return instance;
    }
}
