package com.example.demo_test.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author qiwenbo
 * @date 2022/8/19 14:53
 * @Description
 */
public class PersonEATTest {
    public static void main(String[] args) {
        PersonEAT eat = new PersonEAT();
        eat.eat();
        System.out.println("==================jdk 代理后==================");
        PersonEatHandler handler = new PersonEatHandler(eat);
        PersonEATInterface bp = (PersonEATInterface) Proxy.newProxyInstance(eat.getClass().getClassLoader(), eat.getClass().getInterfaces(), handler);
        bp.eat();
    }

}
