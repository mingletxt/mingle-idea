package com.mingle;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * User: mingle Date: 12-9-23 Time: 上午1:14 desc
 */
public class Test {
    
    
    public static void main(String[] args) throws ParseException {
        List<String> list = new ArrayList<>();
        list.add("B79069AE49190489CFEFD55ADD55E3315CD56207");
        list.add("12345");
        list.add("test");
        list.add("webank");
        list.add("abc123tk");
        Collections.sort(list);
        System.out.println(list);
    }
}
