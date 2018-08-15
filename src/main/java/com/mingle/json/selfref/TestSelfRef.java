package com.mingle.json.selfref;

import com.google.gson.Gson;

import com.mingle.json.jackson.JacksonMapper;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;


/**
 * Created by mingle.
 * Time 2017/3/26 下午2:12
 * Desc 文件描述
 */
public class TestSelfRef {
    
    public static void main(String[] args) {
        Self self = new Self();
        self.setId(1L);
        self.setName("mingle");
        self.setSelf(self);
        
//        Self child = new Self();
//        child.setSelf(self);
        
        
        ObjectMapper mapper = JacksonMapper.getInstance();
        try {
            System.out.println(mapper.writeValueAsString(self));
        } catch (Throwable t) {
           t.printStackTrace();
        }
        
        Gson gson = new Gson();
        try {
            System.out.println(gson.toJson(self));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
