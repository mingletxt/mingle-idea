package com.mingle.rpc.nio;

import java.lang.reflect.Proxy;


/**
 * Created by mingle. Time 2019-02-15 16:08 Desc 文件描述
 */
public class RpcProxyFactory {
    /**
     * 多线程环境代理对象
     *
     * @param interfaceClass
     * @return T
     * @throws BizException
     * @createTime：2018/7/1
     * @author: shakeli
     */
    public static <T> T getMultService(Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[] { interfaceClass },
                new RpcNIoMultHandler());
    }
}
