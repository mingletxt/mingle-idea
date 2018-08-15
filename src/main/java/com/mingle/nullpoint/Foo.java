package com.mingle.nullpoint;


import com.sun.istack.NotNull;


/**
 * Created by mingle.
 * Time 2018/1/11 上午11:38
 * Desc 文件描述
 */
public class Foo {
    
    private String name;
    
    private Integer age;
    
    
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public Integer getAge() {
        return age;
    }
    
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    
    public static void main(String[] args) {
        Foo foo = new Foo();
        System.out.println(foo.getAge() > 0);
    }
}
