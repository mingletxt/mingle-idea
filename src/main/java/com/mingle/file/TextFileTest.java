package com.mingle.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


/**
 * Created by mingle. Time 2018-12-27 10:33 Desc 文件描述
 */
public class TextFileTest {
    
    public static void main(String[] args) {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            
            /* 读入TXT文件 */
            String pathname = "/Users/mingle/Desktop/format2.json"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = br.readLine();
            
            StringBuilder stringBuilder = new StringBuilder();
            while (line != null) {
                stringBuilder.append(line);
                line = br.readLine(); // 一次读入一行数据
            }
            System.out.println(stringBuilder.toString());
            
            /* 写入Txt文件 */
            File writename = new File("/Users/mingle/Desktop/format3.json"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(stringBuilder.toString());
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
