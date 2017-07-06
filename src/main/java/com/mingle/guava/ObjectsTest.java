package com.mingle.guava;

import com.google.common.base.Objects;


/**
 * Created by mingle.
 * Time 17/1/26 下午5:44
 * Desc 文件描述
 */
public class ObjectsTest {
    
    public static void main(String[] args) {
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a"); // returns false
        Objects.equal("a", null); // returns false
        Objects.equal(null, null); // returns true
    }
}
