package com.mingle.thread.future;

/**
 * User: mingle
 * Date: 13-1-14
 * Time: 下午9:23
 * desc
 */

import java.util.concurrent.*;

public class CallableAndFuture {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        Future<String> future = threadPool.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(15000);
                return "future";
            }

        });
        try {
            System.out.println("waiting...");
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Future<String> future1 = threadPool1.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(15000);
                return "future";
            }

        });
        try {
            System.out.println("waiting...");
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

