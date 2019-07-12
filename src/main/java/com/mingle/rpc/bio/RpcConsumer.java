package com.mingle.rpc.bio;

/**
 * Created by mingle. Time 2019-02-15 13:40 Desc 文件描述
 */
public class RpcConsumer {
    
    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}
