package com.mingle.spring.thread;

import org.springframework.beans.factory.DisposableBean;

import java.util.Date;


/**
 * Created by mingle.
 * Time 2017/8/28 上午12:20
 * Desc 文件描述
 */
public class Cutter implements DisposableBean {

    public void cut() {
        System.out.println("cut " + new Date());
    }


    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass() + " destroy");
    }
}
