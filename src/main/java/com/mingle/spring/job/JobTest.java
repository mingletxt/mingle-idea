package com.mingle.spring.job;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by mingle.
 * Time 2018/4/28 下午3:05
 * Desc 文件描述
 */
public class JobTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-job.xml");
    }
}
