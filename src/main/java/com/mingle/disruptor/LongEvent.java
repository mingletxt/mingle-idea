package com.mingle.disruptor;

/**
 * Created by mingle.
 * Time 2017/8/24 上午12:42
 * Desc 文件描述
 */
public class LongEvent {

    private long value;


    public void set(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value: " + value + " " + Thread.currentThread();
    }
}
