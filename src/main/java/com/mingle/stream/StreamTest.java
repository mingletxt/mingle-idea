package com.mingle.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Created by mingle.
 * Time 2017/10/27 上午10:04
 * Desc https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
 */
public class StreamTest {
    
    public static void uppercase() {
        List<String> wordList = Arrays.asList("hello", "world");
        List<String> output = wordList.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        System.out.println(output);
    }
    
    
    public static void square() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        
        System.out.println(squareNums);
    }
    
    
    public static void flat() {
        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        List<Integer> list = outputStream.collect(Collectors.toList());
        System.out.println(list);
    }
    
    
    public static void filter() {
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        List<Integer> evens = Stream.of(sixNums).filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evens);
    }
    
    
    public static void peek() {
        List<String> list = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase).peek(e -> System.out
                .println("Mapped " + "value: " + e)).collect(Collectors.toList());
        System.out.println(list);
    }
    
    
    public static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // return if (text != null) ? text.length() : -1;
    }
    
    
    public static void reduce() {
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
    }
    
    
    public static void testLimitAndSkip() {
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            Person person = new Person(i, "name" + i, 0);
            persons.add(person);
        }
        List<String> personList2 = persons.stream().
                map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(personList2);
    }
    
    
    static class Person {
        
        public int no;
        
        private String name;
        
        private int age;
        
        
        public Person(int no, String name, int age) {
            this.no = no;
            this.name = name;
            this.age = age;
        }
        
        
        public String getName() {
            return name;
        }
        
        
        public int getAge() {
            return age;
        }
    }
    
    
    public static void sort() {
        System.out.println("------sort------");
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            Person person = new Person(i, "name" + i, 0);
            persons.add(person);
        }
        List<Person> personList2 = persons.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
        System.out.println(personList2.size());
    }
    
    
    public static void generate() {
        System.out.println("------generate------");
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        //Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);
    }
    
    
    public static void max() throws Exception {
        System.out.println("------max------");
        BufferedReader br = new BufferedReader(new FileReader("c:\\SUService.log"));
        int longest = br.lines().
                mapToInt(String::length).
                max().
                getAsInt();
        br.close();
        System.out.println(longest);
        List<String> words = br.lines().
                flatMap(line -> Stream.of(line.split(" "))).
                filter(word -> word.length() > 0).
                map(String::toLowerCase).
                distinct().
                sorted().
                collect(Collectors.toList());
        br.close();
        System.out.println(words);
    }
    
    
    public static void iterate() {
        System.out.println("------iterate------");
        Stream.iterate(0, n -> n + 3).limit(10).forEach(x -> System.out.print(x + " "));
    }
    
    
    public static void groupingBy() {
        /*Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).
                limit(100).
                collect(Collectors.groupingBy(Person::getAge));
        Iterator it = personGroups.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Person>> persons = (Map.Entry) it.next();
            System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
        }
        Map<Boolean, List<Person>> children = Stream.generate(new PersonSupplier()).
                limit(100).
                collect(Collectors.partitioningBy(p -> p.getAge() < 18));
        System.out.println("Children number: " + children.get(true).size());
        System.out.println("Adult number: " + children.get(false).size());*/
    }
    
    
    public static void main(String[] args) {
        uppercase();
        square();
        flat();
        filter();
        peek();
        System.out.println(getLength(null));
        reduce();
        testLimitAndSkip();
        sort();
        generate();
        iterate();
    }
    
}
