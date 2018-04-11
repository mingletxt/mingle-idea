package com.mingle.rxjava;

import io.reactivex.Flowable;


/**
 * Created by mingle.
 * Time 2017/11/21 下午4:03
 * Desc 文件描述
 */
public class HelloRX {
    
    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
    }
}
