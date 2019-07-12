package com.mingle.rpc.nio;

/**
 * Created by mingle. Time 2019-02-15 16:09 Desc 文件描述
 */
public class RpcNioConsumer {
    public static void main(String[] args) throws InterruptedException {
        multipartRpcNio();
    }
    
    /**
     * 多线程IO调用示例
     *
     * @param
     * @return void
     * @throws BizException
     * @createTime：2018/7/1
     * @author: shakeli
     */
    public static void multipartRpcNio() throws InterruptedException {
        HelloService proxy = RpcProxyFactory.getMultService(HelloService.class);
        for (int i = 0; i < Long.MAX_VALUE; i++) {
            final int j = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    String result = proxy.sayHello("world!");
                }
            };
            Thread t = new Thread(runnable);
            t.start();
            Thread.sleep(1000L);
        }
    }
}
