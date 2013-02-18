package com.mingle.json.gson;

import com.mingle.json.User;

import java.io.*;

/**
 * User: mingle
 * Date: 12-9-23
 * Time: 下午5:15
 * desc
 */
public class TestGson {
    public static void main(String args[]) {
        User user = new User();
        User.Name name = new User.Name();
        name.setFirst("chen");
        name.setLast("mingle");
        user.setName(name);
        user.setVerified(true);
        /*-----------bean to json ----------*/
        String json = MyGson.getGson().toJson(user);
        System.out.println(json);

        /*-----------json to bean ----------*/
        File f = new File("user-gson.json");
        InputStream in = null;
        Reader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new InputStreamReader(new FileInputStream(f));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    //System.out.print((char) tempchar);
                    sb.append((char) tempchar);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String s = sb.toString();
        user = MyGson.getGson().fromJson(s, User.class);
        System.out.println(user.getName().getFirst());
    }
}
