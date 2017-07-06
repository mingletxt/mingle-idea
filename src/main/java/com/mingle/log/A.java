package com.mingle.log;

/**
 * Created by mingle.
 * Time 2/24/17 9:52 AM
 * Desc 文件描述
 */
public class A {
    public String func(String str) {
        String result = "A func: " + str;
        System.out.println(result);
        return result;
    }
    
    public String e(String str) throws Exception {
        String result = "A e: " + str;
        throw new Exception("fuck");
    }
}
