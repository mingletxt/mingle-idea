package com.mingle.proxy;

/**
 * User: mingle
 * Date: 13-1-22
 * Time: 下午10:57
 * desc
 */
public class SimpleProxy implements Greet {
    private Greet greet = null;

    SimpleProxy(Greet greet) {
        this.greet = greet;
    }

    public void sayHello(String name) {
        System.out.println("--before method sayHello");
        greet.sayHello(name);
        System.out.println("--after method sayHello");
    }

    public void goodBye() {
        System.out.println("--before method goodBye");
        greet.goodBye();
        System.out.println("--after method goodBye");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Greet tmp = new GreetImpl();
        //生成代理
        Greet greet = new SimpleProxy(tmp);
        greet.sayHello("walter");
        greet.goodBye();

    }
}
