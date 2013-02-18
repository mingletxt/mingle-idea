package com.mingle.json.jackson;

import com.mingle.json.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * User: mingle
 * Date: 12-9-23
 * Time: 下午2:10
 * desc
 */
public class TestJackson {
    public static void main(String args[]) throws IOException {
        ObjectMapper mapper = JacksonMapper.getInstance();
        User user = new User();
        User.Name name = new User.Name();
        name.setFirst("chen");
        name.setLast("mingle");
        user.setName(name);
        user.setVerified(true);
        mapper.writeValue(new File("user-jackson.json"), user);
        ClassLoader classLoader = user.getName().getClass().getClassLoader();
        System.out.println(classLoader);
//        System.out.println(classLoader);
        System.out.println(mapper.writeValueAsString(user));
        user = mapper.readValue(new File("user-jackson.json"), User.class);
        System.out.println(user.getName().getFirst() + user.getName().getLast() + user.isVerified());
        mapper.version();
    }
}
