package com.mingle;

import java.text.ParseException;


/**
 * User: mingle
 * Date: 12-9-23
 * Time: 上午1:14
 * desc
 */
public class Test {
    
    
    public static void main(String[] args) throws ParseException {
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader);
    }
}
