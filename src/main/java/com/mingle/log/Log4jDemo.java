package com.mingle.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * User: mingle
 * Date: 12-11-5
 * Time: 下午11:21
 * desc
 */
public class Log4jDemo {
    
    public static void main(String[] args) {
        
        Logger logger = Logger.getLogger(Log4jDemo.class);
        
        //使用默认的配置信息，不需要写log4j.properties
        //BasicConfigurator.configure();
        //设置日志输出级别为info，这将覆盖配置文件中设置的级别
        //logger.setLevel(Level.INFO);
        //下面的消息将被输出
        logger.debug("this is debug");
        logger.info("this is an info");
        logger.warn("this is a warn");
        logger.error("this is an error");
        logger.fatal("this is a fatal");
        try {
            String str = "sss";
            ThreadLocal<String> local = new ThreadLocal<>();
            local.set(str);
            A a = new A();
            a.func(str);
            a.e(str);
        } catch (Exception e) {
            logger.error("error: " , e);
        }
    }
}
