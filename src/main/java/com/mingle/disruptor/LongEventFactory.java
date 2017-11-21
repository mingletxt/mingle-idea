package com.mingle.disruptor;

import com.lmax.disruptor.EventFactory;


/**
 * Created by mingle.
 * Time 2017/8/24 上午12:50
 * Desc 文件描述
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    public LongEvent newInstance() {
        return new LongEvent();
    }
}
