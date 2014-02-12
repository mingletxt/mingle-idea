package com.mingle.num;

/**
 * User: mingle
 * Date: 14-2-12
 * Desc:
 */
public class IntegerTest {
    public static void main(String args[]) {
        System.out.println(Integer.valueOf("127") == Integer.valueOf("127"));

        System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));

        System.out.println(Integer.parseInt("128") == Integer.valueOf("128"));
    }
}
