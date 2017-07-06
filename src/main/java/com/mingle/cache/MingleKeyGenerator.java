package com.mingle.cache;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;

import java.lang.reflect.Method;


/**
 * Created by mingle.
 * Time 2017/3/13 上午12:01
 * Desc 文件描述
 */
public class MingleKeyGenerator implements KeyGenerator {
    
    @Override
    public Object generate(Object target, Method method, Object... params) {
        if (params.length == 0) {
            return SimpleKey.EMPTY;
        }
        if (params.length == 1) {
            Object param = params[0];
            if (param != null && !param.getClass().isArray()) {
                return param + "mingle";
            }
        }
        
        return new SimpleKey(params) + "mingle";
    }
}
