package com.mingle.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


/**
 * Created by mingle.
 * Time 2018/4/7 下午9:56
 * Desc 文件描述
 */
public class FunctionTest {
    
    public void testFunction(){
        //简单的,只有一行
        Function<Integer, String> function1 = (x) -> "test result: " + x;
        
        //标准的,有花括号, return, 分号.
        Function<String, String> function2 = (x) -> {
            return "after function1";
        };
        System.out.println(function1.apply(6));
        System.out.println(function1.andThen(function2).apply(6));
    }
    
    public void testSupplier(){
        //简写
        Supplier<String> supplier1 = () -> "Test supplier";
        System.out.println(supplier1.get());
        
        //标准格式
        Supplier<Integer> supplier2 = () -> {
            return 20;
        };
        System.out.println(supplier2.get() instanceof Integer);
    }
    
    public void testConsumer(){
        Consumer<String> consumer1 = (x) -> System.out.print(x);
        Consumer<String> consumer2 = (x) -> {
            System.out.println(" after consumer 1");
        };
        consumer1.andThen(consumer2).accept("test consumer1");
    }
    
    public void testPredicate(){
        Predicate<String> predicate = (x) -> x.length() > 0;
        System.out.println(predicate.test("String"));
    }
    
    public void testCustomLamda(){
        Consumer<String> consumer = (x) -> {
            System.out.println("test" + x);
        };
        CustomLamda<String> customLamda = (x) -> {
            x.accept("6");
            return "6";
        };
        customLamda.testCustomFunction(consumer);
    }
    
    
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        test.testFunction();
        test.testSupplier();
        test.testConsumer();
        test.testPredicate();
        test.testCustomLamda();
    }
}
