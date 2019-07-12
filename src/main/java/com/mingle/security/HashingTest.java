package com.mingle.security;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by mingle. Time 2019-07-05 15:25 Desc 文件描述
 */
public class HashingTest {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String string = "abc123";
        String salt = "hello";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(salt.getBytes());
        System.out.println("update: " + new String(Hex.encodeHex(messageDigest.digest(string.getBytes()))));
    
        messageDigest = MessageDigest.getInstance("SHA-256");
        System.out.println("digest: " + new String(Hex.encodeHex(messageDigest.digest((salt + string).getBytes()))));
    
        System.out.println("hashing: " + Hashing.sha256().hashString(salt + string, Charsets.UTF_8));
        
        
    }
    
}
