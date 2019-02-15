package com.mingle.shutdown;

import java.util.Date;


/**
 * Created by mingle. Time 2019-01-24 19:33 Desc 文件描述
 */
public class MultiThreadApplication {
    
    public static void main(String[] args) {
        System.out.println(new Date());
        //使用@Async
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sleep: " + i);
            }
        });
        System.out.println("启动线程为：" + thread.getName());
        thread.start();
        //优雅停机
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutdown");
            try {
                Thread.sleep(300000L);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
                e.printStackTrace();
            }
            System.out.println("------------hook-----------");
            System.out.println(new Date());
        }));
        System.out.println(new Date());
    }
}
