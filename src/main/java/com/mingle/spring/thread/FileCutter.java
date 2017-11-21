package com.mingle.spring.thread;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;


/**
 * Created by mingle.
 * Time 2017/8/20 下午10:48
 * Desc 文件描述
 */
public class FileCutter  implements DisposableBean {

    private Cutter cutter;

    private AtomicInteger tasks = new AtomicInteger(0);


    public void setCutter(Cutter cutter) {
        this.cutter = cutter;
    }


    @Override
    public void destroy() throws Exception {
        /*for (int i = 0; i< 5;i++){
        Thread.sleep(1000);
            System.out.println("sleep " + i);
        }*/
        do {
            Thread.sleep(10000);
            System.out.println("waiting for tasks : " + tasks);
        }while (tasks.get() > 0);

        System.out.println(Thread.currentThread() + "destroy");
    }


    public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }


    @Resource
    private ThreadPoolTaskExecutor taskExecutor;


    public void filesMng(String path, String fileName) {
        tasks.incrementAndGet();
        this.taskExecutor.execute(new CutFilesThread(path, fileName));
    }


    private class CutFilesThread implements Runnable {

        private String path;

        private String fileName;


        private CutFilesThread(String path, String fileName) {
            super();
            this.path = path;
            this.fileName = fileName;
        }


        @Override
        public void run() {
            try {
                Thread.sleep(60000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cutter.cut();
            System.out.println(Thread.currentThread() + path + ":barry... run...");
            //            display(path, fileName);
            tasks.decrementAndGet();
        }
    }
}
