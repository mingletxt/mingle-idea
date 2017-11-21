package com.mingle.spring.thread;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by mingle.
 * Time 2017/8/20 下午10:35
 * Desc 文件描述
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-thread.xml");// 加载 spring 配置文件
        FileCutter fileCutter = (FileCutter) context.getBean("fileCutter");
        for (int i = 0; i< 10; i++) {
            System.out.println(i + "---->");
            fileCutter.filesMng(String.valueOf(i), "world");
        }
        AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext) context;
        //abstractApplicationContext.close();
        //System.exit(1);
    }
}
