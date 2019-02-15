package com.mingle.cglib;

/**
 * Created by mingle.
 * Time 27/08/2018 17:52
 * Desc 文件描述
 */
public class TargetObject {
    public String method1(String paramName) {
        return paramName;
    }
    
    public int method2(int count) {
        return count;
    }
    
    public int method3(int count) {
        return count;
    }
    
    @Override
    public String toString() {
        return "TargetObject []"+ getClass();
    }
}
