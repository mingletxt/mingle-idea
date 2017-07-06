package com.mingle.serialize.kryo;

import com.caucho.hessian.io.HessianOutput;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by mingle.
 * Time 2017/6/25 下午11:32
 * Desc 文件描述
 */
public class Simple implements java.io.Serializable{
    private String name;
    private int age;
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    static Simple getSimple() {
        Simple simple = new Simple();
        simple.setAge(10);
        simple.setName("XiaoMing");
        return simple;
    }
    
    
    public static void main(String[] args) throws IOException {
        Kryo kryo = new Kryo();
        // ...
        Output output = new Output(new FileOutputStream("file.bin"));
        Simple writeObject = Simple.getSimple();
        kryo.writeObject(output, writeObject);
        output.close();
        // ...
        Input input = new Input(new FileInputStream("file.bin"));
        Simple readObject = kryo.readObject(input, Simple.class);
        input.close();
    
        HessianOutput hout = new HessianOutput(new FileOutputStream("hessian.bin"));
        hout.writeObject(Simple.getSimple());
    }
}
