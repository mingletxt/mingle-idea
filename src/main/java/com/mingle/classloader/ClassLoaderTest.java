package com.mingle.classloader;

/**
 * Created by mingle.
 * Time 27/08/2018 20:43
 * Desc 文件描述
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader cl1 = new MyClassLoader();
        //磁盘中/home/im/Desktop/Hello.class文件存在
        try {
            Class c1 = cl1.loadClass("HelloImpl");
            Hello object = (Hello) c1.newInstance();
            
            Work work = new Work();
            work.setHello(object);
            
            System.out.println(work);
            System.out.println("work classloader:" + work.getClass().getClassLoader());
            System.out.println();
            System.out.println(work.getHello());
            System.out.println("hello classloader:" + work.getHello().getClass().getClassLoader());
            System.out.println();
            System.out.println("classloader:" + Thread.currentThread().getContextClassLoader());
            work.sayHello();
            Class clazz = Class.forName(work.getHello().getClass().getName());
            System.out.println("clazz:" + clazz);
            //Thread.currentThread().setContextClassLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("main-ClassNotFoundException");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
