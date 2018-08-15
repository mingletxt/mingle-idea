package com.mingle.spring.init;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * Created by mingle.
 * Time 2017/8/27 下午10:29
 * Desc 文件描述
 */
@Component
public class TestServiceImpl implements TestService, DisposableBean {

    @Autowired
    private TestDao testDao;


    public TestServiceImpl() {
        System.out.println(this.getClass());
    }
    
    
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy:" + this.getClass());
    }
    
    
    @Override
    public void hello() throws InterruptedException {
        Thread.sleep(100000L);
        System.out.println(testDao.select());
    }


    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }
}
