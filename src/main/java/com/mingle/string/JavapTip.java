package com.mingle.string;

import java.util.Date;

/**
 * User: mingle
 * Date: 12-9-23
 * Time: 上午11:15
 * desc
 */
public class JavapTip {

    public static void main(String[] args) {
        int count = 10000;
        int total = 10;
        withStrings(count);
        withStringBuffer(count);
        withStringBuilder(count);
        long withStrings = 0;
        long withStringBuffer = 0;
        long withStringBuilder = 0;
        for (int i = 0; i < total; i++) {
            Date d1 = new Date();
            withStrings(count);
            Date d2 = new Date();
            Date d3 = new Date();
            withStringBuffer(count);
            Date d4 = new Date();
            Date d5 = new Date();
            withStringBuilder(count);
            Date d6 = new Date();
            withStrings += d2.getTime() - d1.getTime();
            withStringBuffer += d4.getTime() - d3.getTime();
            withStringBuilder += d6.getTime() - d5.getTime();
        }
        System.out.println("withStrings: " + (withStrings)
                + " vs withStringBuffer: " + (withStringBuffer) + " vs withStringBuilder: " + (withStringBuilder));
    }

    public static String withStrings(int count) {
        String s = null;
        String temp = "temp";
        for (int i = 0; i < count; i++) {
            s += temp;
        }
        return s;
    }

    public static String withStringBuffer(int count) {
        StringBuffer sb = null;
        String temp = "temp";
        for (int i = 0; i < count; i++) {
            sb = new StringBuffer();
            sb.append(temp);
            sb.append(temp);
            sb.toString();
        }
        return sb.toString();
    }

    public static String withStringBuilder(int count) {
        StringBuilder sb = null;
        String temp = "temp";
        for (int i = 0; i < count; i++) {
            sb = new StringBuilder();
            sb.append(temp);
            sb.append(temp);
            sb.toString();
        }
        return sb.toString();
    }
}

