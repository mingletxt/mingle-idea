package com.mingle.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CommonIOTest {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws IOException {
        //init
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String day = simpleDateFormat.format(now);
        String path = "/data/logs/";
        File file = new File(path + day + ".log");
        OutputStream out = FileUtils.openOutputStream(file, true);

        //concurrent
        if (!file.getName().contains(day)) {
            try {
                lock.writeLock().lock();
                if (!file.getName().contains(day)) {
                    file = new File(path + day + ".log");
                    out = FileUtils.openOutputStream(file, true);
                    IOUtils.write("header\n", out, Charset.defaultCharset());
                }
            } finally {
                lock.writeLock().unlock();
            }
        }

        //写数据
        try {
            IOUtils.write("1024\n", out, Charset.defaultCharset());
            IOUtils.write("1025\n", out, Charset.defaultCharset());
            IOUtils.write("1026\n", out, Charset.defaultCharset());
        } finally {
            IOUtils.closeQuietly(out);
        }
    }
}
