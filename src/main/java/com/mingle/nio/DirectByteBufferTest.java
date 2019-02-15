package com.mingle.nio;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;


/**
 * Created by mingle.
 * Time 21/10/2018 13:57
 * Desc 文件描述
 */
public class DirectByteBufferTest {
    
    public static void main(String[] args) {
        File file = new File("/Users/mingle/Desktop/test1");
        long len = file.length();
        byte[] ds = new byte[(int) len];
        
        try {
            Thread.sleep(60000);
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file, "r")
                    .getChannel()
                    .map(FileChannel.MapMode.READ_ONLY, 0, len);
            
            for (int offset = 0; offset < len; offset++) {
                byte b = mappedByteBuffer.get();
                ds[offset] = b;
            }
            
            Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");
            while (scan.hasNext()) {
                System.out.print(scan.next() + " ");
            }
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
