package com.mingle.disruptor;

import com.lmax.disruptor.EventHandler;


/**
 * Created by mingle.
 * Time 2017/8/24 上午12:51
 * Desc 文件描述
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + longEvent);
        Thread.sleep(2000);
    }
}
