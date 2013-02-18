package com.mingle.charset;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

/**
 * User: mingle
 * Date: 12-10-23
 * Time: 上午12:06
 * desc
 */
public class CharsetTest {
    public static void main(String args[]) {
        Charset cset = Charset.forName("ISO-8859-1");
        Set<String> aliases = cset.aliases();
        for (String alias : aliases) {
            System.out.println(alias);
        }
        Map<String, Charset> map = Charset.availableCharsets();
        for(String name : map.keySet()){
            System.out.println(name);
        }
    }
}
