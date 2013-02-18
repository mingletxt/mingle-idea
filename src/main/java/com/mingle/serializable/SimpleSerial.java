package com.mingle.serializable;

import java.io.*;

/**
 * User: mingle
 * Date: 13-1-17
 * Time: 下午2:57
 * desc: http://my.oschina.net/itjava/blog/99648
 */
public class SimpleSerial {
    public static void main(String[] args) throws Exception {
        File file = new File("person.out");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("John", 101, Gender.MALE);
        oout.writeObject(person);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型
        oin.close();
        System.out.println(newPerson);
    }
}
