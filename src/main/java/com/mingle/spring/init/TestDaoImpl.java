package com.mingle.spring.init;

import org.springframework.stereotype.Component;


/**
 * Created by mingle.
 * Time 2017/8/27 下午10:30
 * Desc 文件描述
 */
@Component
public class TestDaoImpl implements TestDao {

    public TestDaoImpl() {
        System.out.println(this.getClass());
    }

    @Override
    public String select() {
        return String.valueOf(System.currentTimeMillis());
    }
}
