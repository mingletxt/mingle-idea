package com.mingle.rpc.nio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by mingle. Time 2019-02-15 16:02 Desc 文件描述
 */
public class SerializeUtil {
    public static byte[] serialize(Object obj) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            byte[] bytes = bos.toByteArray();
            return bytes;
        } catch (IOException e) {
            System.out.println("序列化对象出错！");
            e.printStackTrace();
            return null;
        }
    }
    
    public static Object unSerialize(byte[] bytes) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (IOException e) {
            System.out.println("反序列化出错！");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("反序列化出错！");
            e.printStackTrace();
            return null;
        }
    }
}
