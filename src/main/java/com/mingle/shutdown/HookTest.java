package com.mingle.shutdown;

import java.util.concurrent.TimeUnit;


/**
 * Created by mingle.
 * Time 09/08/2018 16:22
 * Desc 文件描述
 */
public class HookTest {
    
    public void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Execute Hook.....");
                try {
                    TimeUnit.MILLISECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        }));
    }
    
    
    public static void main(String[] args) {
        new HookTest().start();
        System.out.println("The Application is doing something");
        
        try {
            TimeUnit.MILLISECONDS.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
