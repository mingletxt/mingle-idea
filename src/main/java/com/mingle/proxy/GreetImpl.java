package com.mingle.proxy;

/**
 * User: mingle
 * Date: 13-1-22
 * Time: 下午10:56
 * desc
 */
class GreetImpl implements Greet {
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    public void goodBye() {
        System.out.println("Good bye.");
    }
}