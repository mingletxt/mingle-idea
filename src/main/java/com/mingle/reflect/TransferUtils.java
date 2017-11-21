package com.mingle.reflect;

import java.lang.reflect.Field;


/**
 * Created by mingle.
 * Time 2017/8/15 下午3:04
 * Desc 文件描述
 */
public class TransferUtils {

    public static void main(String[] args) {
        String setName = "people";
        String getName = "peopleDTO";
        Field[] fields = PeopleDTO.class.getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();
            String upName = name.substring(0, 1).toUpperCase() + name.substring(1);
            System.out.println(setName + ".set" + upName + "(" + getName + ".get" + upName + "()" + ");");
        }
    }
}
