package com.mingle.function;

import java.util.function.Consumer;


/**
 * Created by mingle.
 * Time 2018/4/11 下午8:51
 * Desc 文件描述
 */
public class CookingDemo {
    public void doTask(String material, Consumer<String> consumer) {
        consumer.accept(material);
    }
    public static void main(String[] args) {
        CookingDemo cookingDemo = new CookingDemo();
        cookingDemo.doTask("蔬菜", material -> System.out.println("清洗" + material));
        cookingDemo.doTask("蔬菜", material -> System.out.println(material + "切片"));
        cookingDemo.doTask("食用油", material -> System.out.println(material + "烧热"));
        cookingDemo.doTask("", material -> System.out.println("炒菜"));
    }
}
