package com.mingle.spring.retry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by mingle.
 * Time 14/05/2018 10:57
 * Desc 文件描述
 */
public class Application {
    public static void main(String[] args) throws Exception {
        //ApplicationContext annotationContext = new AnnotationConfigApplicationContext("hello");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-retry.xml");
        RemoteService remoteService = context.getBean("remoteService", RemoteService.class);
        remoteService.call();
        System.out.println("----------");
        remoteService.retry();
    }
}
