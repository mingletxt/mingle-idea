package com.mingle.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: mingle
 * Date: 14-2-13
 * Desc:
 */
public class ListRemove {
    public static void main(String args[]) {
        List<Integer>  list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        for(Integer i : list){
            System.out.println(i);
        }
        Iterator itr1 = list.iterator();
        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }
        list.remove(2);
        for(Integer i : list){
            System.out.println(i);
        }
        Iterator itr2 = list.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }
        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }
    }
}
