package com.example.demo_test.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author qiwenbo
 * @date 2022/8/25 15:09
 * @Description
 */
public class Java8Test {


    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(Book.of(1L, "Thinking in Java", "2021-06-29 17:13:14"));
        books.add(Book.of(2L, "Hibernate in action", "2021-06-29 18:13:14"));
        books.add(Book.of(3L, "Thinking in Java", "2021-06-29 19:13:14"));
        Map<Object, Boolean> map = new HashMap<>();
        for (Book book : books) {
            Boolean aBoolean = map.putIfAbsent(book.getName(), Boolean.TRUE);
            System.out.println("写入数据");
        }

        // filter 如果返回true则保留，https://blog.csdn.net/qq_33829547/article/details/80279488
        // removeIf中的test方法返回true代表当前元素会被过滤掉；
        //filter中的test方法返回true代表当前元素会保留下来。
        List<Book> distinctNameBooks3 = books.stream().filter(distinctByKey(Book::getName)).collect(Collectors.toList());
        List<Book> collect = books.stream().distinct().collect(Collectors.toList());
        Map<String, List<Book>> collect1 = books.stream().collect(Collectors.groupingBy(Book::getName));
        collect1.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);

        });

//        System.out.println(distinctNameBooks3);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new HashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
