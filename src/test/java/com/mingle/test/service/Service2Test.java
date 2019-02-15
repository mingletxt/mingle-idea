package com.mingle.test.service;


import com.mingle.spring.test.service.TestService;
import com.mingle.test.BaseJunit4Test;
import com.mingle.test.SpringUtils;

import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;

import static org.junit.Assert.assertTrue;

public class Service2Test extends BaseJunit4Test {

    @Resource  //自动注入,默认按名称
    private TestService testService;
    
    @Resource
    private SpringUtils springUtils;

    @Test   //标明是测试方法
    //@Transactional   //标明此方法需使用事务
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚
    @DirtiesContext
    public void hello() {
        System.out.println(testService);
        String sql = "insert into user(name,password) values(?,?)";
        Object[] objs = new Object[]{"00", "000"};
        testService.hello();
        assertTrue(true);
        /*String sql1="select * from user where name=? and password=? ";
        List<Map<String,Object>> list=baseDao.queryForList( sql1 , objs );
        System.out.println(list);
        assertTrue(list.size( )>0);*/
    }
}
