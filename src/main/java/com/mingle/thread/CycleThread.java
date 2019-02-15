package com.mingle.thread;

/**
 * Created by mingle. Time 2019-01-21 10:40 Desc 文件描述
 */
public class CycleThread {
    
    public static void main(String[] args) {
        while(true) {
            new Thread(() -> {
                System.out.println(Thread.currentThread() + " doing");
            });
        }
    }
}
