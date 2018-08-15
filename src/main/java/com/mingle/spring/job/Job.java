package com.mingle.spring.job;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * Created by mingle.
 * Time 2018/4/28 下午3:03
 * Desc 文件描述
 */
@Component
public class Job implements ApplicationContextAware {
    
    private ApplicationContext context;
    
    public void execute1(){
        System.out.printf("Task: %s, Current time: %s\n", 1, LocalDateTime.now());
    }
    
    public void execute2(){
        System.out.printf("Task: %s, Current time: %s\n", 2, LocalDateTime.now());
    }
    
    public void execute3(){
        System.out.printf("Task: %s, Current time: %s\n", 3, LocalDateTime.now());
    }
    
    public void execute4(){
        System.out.printf("Task: %s, Current time: %s\n", 4, LocalDateTime.now());
    }
    
    public void execute5(){
        System.out.printf("Task: %s, Current time: %s\n", 5, LocalDateTime.now());
    }
    
    public void execute6(){
        System.out.printf("Task: %s, Current time: %s\n", 6, LocalDateTime.now());
    }
    
    public void execute7(){
        System.out.printf("Task: %s, Current time: %s\n", 7, LocalDateTime.now());
    }
    
    public void execute8(){
        System.out.printf("Task: %s, Current time: %s\n", 8, LocalDateTime.now());
    }
    
    public void execute9(){
        System.out.printf("Task: %s, Current time: %s\n", 9, LocalDateTime.now());
    }
    
    public void execute10(){
        System.out.printf("Task: %s, Current time: %s\n", 10, LocalDateTime.now());
    }
    
    public void execute11(){
        System.out.printf("Task: %s, Current time: %s\n", 11, LocalDateTime.now());
    }
    
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
