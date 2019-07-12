package com.mingle.rpc.nio;

/**
 * Created by mingle. Time 2019-02-15 16:03 Desc 文件描述
 */
public class HelloServiceImpl implements HelloService {
    
    @Override
    public String sayHello(String name) {
        return " Hello " + name + " by " + Thread.currentThread();
    }
}
