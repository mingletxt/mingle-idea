package com.mingle.compute;

/**
 * User: mingle
 * Date: 12-11-12
 * Time: 下午11:32
 * desc
 */
public class CpuTest {

    public static void main(String args[]){
        Thread t1 = new RunThread();
        Thread t2 = new RunThread();
        Thread t3 = new RunThread();
        Thread t4 = new RunThread();
        t1.start();
        t2.start();
        t3.start();
        //t4.start();

    }


}


class RunThread extends Thread{

    public void run(){
        while(true){

        }
    }
}