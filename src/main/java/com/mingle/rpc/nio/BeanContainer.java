package com.mingle.rpc.nio;

import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by mingle. Time 2019-02-15 16:06 Desc 文件描述
 */
public class BeanContainer {
    private static ConcurrentHashMap<Class<?>, Object> container = new ConcurrentHashMap<>();
    
    public static boolean addBean(Class<?> clazz, Object object) {
        container.put(clazz, object);
        return true;
    }
    
    public static Object getBean(Class<?> clazz) {
        return container.get(clazz);
    }
}
