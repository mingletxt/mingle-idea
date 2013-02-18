package com.mingle.serialize;

import java.io.Serializable;

/**
 * User: mingle
 * Date: 12-10-9
 * Time: 下午11:49
 * desc
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person() {

    }

    public Person(String str, int n) {
        System.out.println("Inside Person's Constructor");
        name = str;
        age = n;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}
