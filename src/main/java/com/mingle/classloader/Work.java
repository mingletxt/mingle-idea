package com.mingle.classloader;

/**
 * Created by mingle.
 * Time 27/08/2018 18:12
 * Desc 文件描述
 */
public class Work {
    
    private Hello hello;
    
    public void sayHello(){
        hello.work();
    }
    
    
    public Hello getHello() {
        return hello;
    }
    
    
    public void setHello(Hello hello) {
        this.hello = hello;
    }
}
