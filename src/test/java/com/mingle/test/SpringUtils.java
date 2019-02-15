package com.mingle.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: YANG
 * Date: 2015/12/16
 * Time: 15:16
 */

public class SpringUtils implements BeanFactoryPostProcessor {
    
    private static ConfigurableListableBeanFactory beanFactory;
    
    
    public SpringUtils() {
    }
    
    
    public static ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
    
    
    public static boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }
    
    
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.getAliases(name);
    }
    
    
    public static Object getBean(String name) throws BeansException {
        return beanFactory.getBean(name);
    }
    
    
    public static <T> T getBean(Class<T> clz) throws BeansException {
        Object result = beanFactory.getBean(clz);
        return (T) result;
    }
    
    
    public static <T> Map<String, T> getBeans(Class<T> clz) throws BeansException {
        return beanFactory.getBeansOfType(clz);
    }
    
    
    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.getType(name);
    }
    
    
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.isSingleton(name);
    }
    
    
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }
}
