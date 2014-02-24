package com.mingle.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * User: mingle
 * Date: 14-2-13
 * Desc:
 */
public class MapRemove {
    public static void main(String args[]) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            System.out.println(i);
        }
        Iterator itr1 = map.entrySet().iterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }
        map.put(4, 4);
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            System.out.println(i);
        }
        Iterator itr2 = map.entrySet().iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }
    }
}
