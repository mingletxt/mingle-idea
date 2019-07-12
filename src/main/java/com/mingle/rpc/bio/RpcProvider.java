package com.mingle.rpc.bio;

/**
 * Created by mingle. Time 2019-02-15 13:40 Desc 文件描述
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
