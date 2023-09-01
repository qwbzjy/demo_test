package com.example.demo_test.threadlocal;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author qiwenbo
 * @date 2023/8/9 16:28
 * @Description
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        // 创建一个 CopyOnWriteArrayList 对象
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // 添加元素到列表
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // 使用迭代器遍历列表
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // 在遍历过程中修改列表
        list.add("Pear");

        // 再次使用迭代器遍历列表
        iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }

}
