package com.mingle.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * User: mingle
 * Date: 13-1-7
 * Time: 下午11:39
 * desc
 */
public class MBeanTest {

    public static void main(String args[]) {
        Thread t1 = new MyThread("mingle");
        t1.start();
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        long[] threadIds = mxBean.getAllThreadIds();
        ThreadInfo[] threadInfos =
                mxBean.getThreadInfo(threadIds);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("name------"+
                    threadInfo.getThreadName());
            System.out.println(
                    threadInfo.getBlockedCount());
            System.out.println(
                    threadInfo.getBlockedTime());
            System.out.println(
                    threadInfo.getWaitedCount());
            System.out.println(
                    threadInfo.getWaitedTime());
        }
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println("I am running");
        try {
            this.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("ending");
    }
}