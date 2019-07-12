package com.mingle.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by mingle. Time 2019-05-17 14:20 Desc 文件描述
 */
public class MemoryTest {
    
    public static void main(String[] args) {
        Random random = new Random();
        while(true) {
            String str = "mingle" + random.nextInt();
            System.out.println(str);
        }
    }
}
