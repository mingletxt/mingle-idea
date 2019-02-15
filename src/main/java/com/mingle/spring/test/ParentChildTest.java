package com.mingle.spring.test;


import com.mingle.spring.test.service.TestService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by mingle.
 * Time 2017/8/27 下午10:30
 * Desc 文件描述
 */
public class ParentChildTest {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-total.xml");// 加载 spring 配置文件
        ((ClassPathXmlApplicationContext)context).registerShutdownHook();
        System.out.println("init context");
        TestService testService = (TestService) ((ClassPathXmlApplicationContext)context.getBean("childContext")).getBean("testServiceImpl");
        testService.hello();
        
        //Thread.sleep(100000L);
    }
}
