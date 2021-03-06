package com.mingle.rpc.nio;

import java.io.IOException;


/**
 * https://www.jianshu.com/p/13bef2795c44
 * Created by mingle. Time 2019-02-15 16:06 Desc 文件描述
 */
public class RpcNioProvider {
    public static void main(String[] args) throws IOException {
        // 将服务放进bean容器
        HelloService helloService = new HelloServiceImpl();
        BeanContainer.addBean(HelloService.class, helloService);
        // 启动NIO服务端
        startMultRpcNioServer();
    }
    
    public static void startMultRpcNioServer() {
        Runnable r = () -> {
            try {
                RpcNioMultServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}
