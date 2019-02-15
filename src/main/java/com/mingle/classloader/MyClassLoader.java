package com.mingle.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * Created by mingle.
 * Time 27/08/2018 20:41
 * Desc 文件描述
 */
public class MyClassLoader extends ClassLoader{
    static {
        System.out.println("MyClassLoader");
    }
    public static final String driver = "/Users/mingle/Desktop/";
    public static final String fileTyep = ".class";
    
    public Class findClass(String name) {
        byte[] data = loadClassData(name);
        return defineClass(data, 0, data.length);
    }
    
    public byte[] loadClassData(String name) {
        FileInputStream fis = null;
        byte[] data = null;
        try {
            File file = new File(driver + name + fileTyep);
            System.out.println(file.getAbsolutePath());
            fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = fis.read()) != -1) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("loadClassData-IOException");
        }
        return data;
    }
}