package com.mingle.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by mingle.
 * Time 05/03/2017 5:51 PM
 * Desc http://blog.csdn.net/aqsunkai/article/details/51758900
 * http://blog.csdn.net/defonds/article/details/48716161
 * https://www.ibm.com/developerworks/cn/opensource/os-cn-spring-cache/
 * https://my.oschina.net/wnjustdoit/blog/644311 扩展RedisCacheManager
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-anno.xml");// 加载 spring 配置文件
        
        AccountService s = (AccountService) context.getBean("accountServiceBean");
        // 第一次查询，应该走数据库
        System.out.print("first query...");
        s.getAccount(new Account("abc"), "111");
        s.getAccount("somebody33");
        s.getAccountByName("somebody33");
        // 第二次查询，应该不查数据库，直接返回缓存的值
        System.out.print("second query...");
        s.getAccountByName("somebody33");
        System.out.println();
        
        System.out.println("start testing clear cache...");    // 更新某个记录的缓存，首先构造两个账号记录，然后记录到缓存中
        Account account1 = s.getAccountByName("somebody33");
        // 开始更新其中一个    account1.setId(1212);
        s.updateAccount(account1);
        s.getAccountByName("somebody33");// 因为被更新了，所以会查询数据库    s.getAccountByName("somebody2");// 没有更新过，应该走缓存    s.getAccountByName("somebody1");// 再次查询，应该走缓存    // 更新所有缓存
        s.reload();
        s.getAccountByName("somebody1");// 应该会查询数据库    s.getAccountByName("somebody2");// 应该会查询数据库    s.getAccountByName("somebody1");// 应该走缓存    s.getAccountByName("somebody2");// 应该走缓存
        s.getAccountByName("somebody2");
        s.getAccountByName("somebody33");
        s.reload();
    }
}
