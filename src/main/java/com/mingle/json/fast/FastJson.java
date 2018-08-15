package com.mingle.json.fast;

import com.alibaba.fastjson.JSON;
import com.mingle.json.Entity;
import com.mingle.json.User;

import java.util.Arrays;


/**
 * Created by mingle.
 * Time 03/07/2018 10:56
 * Desc 文件描述
 */
public class FastJson {
    
    public static void main(String[] args) throws Exception {
        
        User user = new User();
        User.Name name = new User.Name();
        name.setFirst("chen");
        name.setLast("mingle");
        user.setName(name);
    
        System.out.println(user);
        System.out.println(Arrays.asList(user));
        
        User[] users = new User[]{user};
        System.out.println(users.toString());
        
        String code = JSON.toJSONString(user);
        System.out.println(code);
    
        Entity entity = new Entity();
        entity.setId(123L);
        entity.setName("mingle");
        System.out.println(entity);
    }
    
}
