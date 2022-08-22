package com.example.demo_test.dynamicproxy.jdk;

/**
 * @author qiwenbo
 * @date 2022/8/19 14:51
 * @Description
 */
public class PersonEAT implements PersonEATInterface {
    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
