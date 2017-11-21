package com.mingle.spring.init;

import org.springframework.stereotype.Component;


/**
 * Created by mingle.
 * Time 2017/8/27 下午10:45
 * Desc 文件描述
 */
@Component
public class SomeDAOImpl implements SomeDAO {

    public SomeDAOImpl() {
        System.out.println(this.getClass());
    }


    @Override
    public String list() {
        return "list";
    }
}
