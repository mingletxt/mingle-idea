package com.mingle.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * Created by mingle.
 * Time 27/08/2018 17:52
 * Desc 文件描述
 */
public class TargetInterceptor implements MethodInterceptor {
    
    /**
     * 重写方法拦截在方法前和方法后加入业务
     * Object obj为目标对象
     * Method method为目标方法
     * Object[] params 为参数，
     * MethodProxy proxy CGlib方法代理对象
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] params,
            MethodProxy proxy) throws Throwable {
        System.out.println("调用前");
        Object result = proxy.invokeSuper(obj, params);
        System.out.println(" 调用后"+result);
        return result;
    }
    
    
}
