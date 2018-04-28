package com.mingle.kotlin;

/**
 * Created by mingle.
 * Time 2018/4/22 下午4:22
 * Desc 文件描述
 */
public class JavaKotlin {
    
    public static void main(String[] args) {
        //在Java中可以访问Kotlin的Bean，通过getter/setter
        KotlinBean bean = new KotlinBean(0);
        bean.setI(10);
        System.out.println(bean.getI());
        System.out.println("test trans");
        Dto d = null;
        Vo vo = TransKt.tran(d);
        System.out.println(vo);
        vo = TransKt.tran(new Dto());
        System.out.println(vo);
        Dto dto = new Dto();
        dto.setS("hello");
        vo = TransKt.tran(dto);
        System.out.println(vo);
    }
}
