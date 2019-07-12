package com.mingle.rpc.bio;

/**
 * Created by mingle. Time 2019-02-15 13:39 Desc 文件描述
 */
public class HelloServiceImpl implements HelloService {
    
    @Override
    public String hello(String name) {
        return " Hello " + name + " by " + Thread.currentThread();
    }
}
