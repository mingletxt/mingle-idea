package com.mingle.btrace;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.TLS;

import static com.sun.btrace.BTraceUtils.Strings.str;
import static com.sun.btrace.BTraceUtils.Strings.strcat;
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.timeMillis;


/**
 * Created by mingle.
 * Time 2017/9/19 下午5:56
 * Desc http://blog.csdn.net/qyongkang/article/details/6090497
 */
@BTrace
public class TraceHelloWorld {
    
    @TLS
    private static long startTime = 0;
    
    
    @OnMethod(clazz = "com.alibaba.dubbo.demo.provider.DemoServiceImpl", method = "sayHello")
    public static void startMethod() {
        startTime = timeMillis();
    }
    
    
    @OnMethod(clazz = "com.alibaba.dubbo.demo.provider.DemoServiceImpl", method = "sayHello", location = @Location(Kind.RETURN))
    public static void endMethod() {
        println(strcat("the class method execute time=>", str(timeMillis() - startTime)));
        println("-------------------------------------------");
    }
    
    
    @OnMethod(clazz = "com.alibaba.dubbo.demo.provider.DemoServiceImpl", method = "sayHello", location = @Location(Kind.RETURN))
    public static void traceExecute(@ProbeClassName String name, @ProbeMethodName String method, int sleepTime) {
        println(strcat("the class name=>", name));
        println(strcat("the class method=>", method));
        println(strcat("the class method params=>", str(sleepTime)));
        
    }
}
