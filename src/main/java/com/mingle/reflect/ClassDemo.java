package com.mingle.reflect;

/**
 * Created by mingle.
 * Time 2017/3/30 下午3:29
 * Desc 文件描述
 */
class A {
    
    void aa() {
        System.out.println("A里的");
        
    }
    
}


class B extends A {
    
    void aa() {
        System.out.println("B里的");
        
    }
    
}


class C extends A {
    
    void aa() {
        System.out.println("C里的");
        
    }
    
}


public class ClassDemo {
    
    public static void main(String[] args) {
        ClassDemo t = new ClassDemo();
        t.show("C");
    }
    
    
    void show(String name) {
        try {
            A show = (A) Class.forName(name).newInstance();
            show.aa();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
