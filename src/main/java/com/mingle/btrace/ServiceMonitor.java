package com.mingle.btrace;

import com.sun.btrace.AnyType;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;


/**
 * Created by mingle.
 * Time 2017/9/19 下午6:08
 * Desc 文件描述
 */

@BTrace
public class ServiceMonitor {
    
    //监控某一个方法的执行时间
    
    
    @OnMethod(clazz = "com.alibaba.dubbo.demo.provider.DemoServiceImpl", method = "sayHello", location = @Location(Kind.RETURN))
    public static void printMethodRunTime(@Self Object self, String hello, @Return String result) {
    
        println("self: " + self);
        
        println("hello: " + hello);
        
        //println("type: " + type + " ,limit: " + limit);
        
        println("result : " + result);
        
    }
    
}
