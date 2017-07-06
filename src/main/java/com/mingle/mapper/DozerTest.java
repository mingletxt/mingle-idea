package com.mingle.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * @author mingle
 * @Version 16/12/3
 */
public class DozerTest {

    public static void main(String[] args) {
        Mapper mapper  = new DozerBeanMapper();
        A a = new A();
        a.setId("id");
        a.setName("mingle");
        B b = mapper.map(a,B.class);
        System.out.println(b.getName());
        a.setName("abc");
        b = mapper.map(a, B.class);
        System.out.println(b.getName());
    }
}
