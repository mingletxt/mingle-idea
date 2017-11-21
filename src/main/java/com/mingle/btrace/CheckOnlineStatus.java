package com.mingle.btrace;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace

/**
 * Created by mingle.
 * Time 2017/9/19 下午6:05
 * Desc 文件描述
 */
public class CheckOnlineStatus {
    //监控某一个方法的执行时间
    
    @OnMethod(clazz = "com.alibaba.dubbo.demo.provider.DemoServiceImpl",method = "sayHello",location=@Location(Kind.RETURN))
    
    public static void printMethodRunTime(@ProbeClassName String probeClassName,@Duration long duration){
        
        println(probeClassName + ",duration:" + duration / 1000000 + " ms");
        
    }
}
