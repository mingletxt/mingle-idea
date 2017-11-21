package com.mingle.spring.init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by mingle.
 * Time 2017/8/27 下午10:30
 * Desc 文件描述
 */
public class InitDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-init.xml");// 加载 spring 配置文件
        System.out.println("init context");
        TestService testService = (TestService) context.getBean("testServiceImpl");
        testService.hello();
    }
}
