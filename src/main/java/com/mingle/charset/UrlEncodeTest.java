package com.mingle.charset;

import sun.nio.cs.Surrogate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CoderResult;

/**
 * User: mingle
 * Date: 12-12-11
 * Time: 下午11:09
 * desc
 */
public class UrlEncodeTest {
    public static void main(String args[]) throws UnsupportedEncodingException {

        String code = URLEncoder.encode("中文zhongwen", "GBK"); // Or "UTF-8".
        System.out.println(code);
        String decode = URLDecoder.decode(code, "utf-8");
        System.out.println(decode);
        decode = URLDecoder.decode(code, "GBK");
        System.out.println(decode);
        byte[] byteses = "裙b".getBytes("ISO-8859-1");
        for (byte b : byteses) {
            System.out.print(b);
        }
        byte bb = 123;
        System.out.println(bb);
    }
}
