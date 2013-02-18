package com.mingle.thread.future;

/**
 * User: mingle
 * Date: 13-1-14
 * Time: 下午9:23
 * desc
 */

import java.util.Random;
import java.util.concurrent.*;

public class MultiCallableAndFuture {

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000L);
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //创建CompletionService实例
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(pool);
        //提交任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            completionService.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    long sleep = 1000L;
                    if (index > 4) {
                        Random random = new Random(10000L);
                        sleep = random.nextLong() % 10000;
                        if (sleep < 0)
                            sleep = -sleep;
                    }
                    Thread.sleep(sleep);
                    System.out.println(Thread.currentThread().getId() + " is finished");
                    int w = 0;
                    while(w < 1000000000L){
                        w++;
                    }
                    System.out.println(w);
                    return index;
                }

            });
        }
        //获得结果
        for (int i = 0; i < 10; i++) {
            try {
                Future<Integer> future2 = completionService.take();
                System.out.println(future2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}


