package com.mingle.guava;

import com.google.common.base.Optional;


/**
 * Created by mingle.
 * Time 17/1/26 下午5:23
 * Desc 文件描述
 */
public class OptionalTest {
    
    public static void main(String[] args) {
        Optional<Integer> possible = Optional.of(5);
    
        System.out.println(possible.isPresent()); // returns true
    
        System.out.println(possible.get()); // returns 5
    }
}
