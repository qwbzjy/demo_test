package com.example.demo_test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author qiwenbo
 * @date 2022/8/17 10:35
 * @Description
 */
public class Per {

    public String name = "sunshine";
    private int age = 28;
    public double weight = 65.50;

    public Per() {
        System.out.println("测试反射获取公有无参构造函数");
    }

    private Per(String name) {
        this.name = name;
        System.out.println("测试反射获取私有有参构造函数");
    }

    public Per(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("测试反射获取公有有多个参数构造函数name:" + name + "    age:" + age);
    }

    public String methodT1() {
        System.out.println("测试反射获取公有无参方法");
        return null;
    }

    public String methodT1(String name, int age) {
        System.out.println("测试反射获取公有多个参方法");
        System.out.println(name + "：" + age);
        return null;
    }

    private String methodT1(String name) {
        System.out.println("测试反射获取私有有参方法");
        System.out.println("name:" + name);
        return null;
    }

    public String methodT2(int[] arr, String[] str) {
        System.out.println("测试反射获取公有有数组参方法");
        System.out.println("int[] arr:" + arr + "String[] str:" + str);
        return null;
    }

    public static void main(String[] args) throws Exception {
//        System.out.println("测试反射获取main方法");
        Class clazz = Per.class;
        Constructor constructor = clazz.getConstructor(null);
        Per per1 = (Per) constructor.newInstance(null);
        Constructor constructor1 = clazz.getConstructor(String.class, int.class);
        Per per2 = (Per) constructor1.newInstance("alice", 10);
        Constructor constructor2 = clazz.getDeclaredConstructor(String.class);
        constructor2.setAccessible(true);
        Per alex = (Per) constructor2.newInstance("alex");
        System.out.println(alex.name);
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        System.out.printf(declaredConstructor.toString());

        //========================================================
        Method methodT1 = clazz.getMethod("methodT1", String.class, int.class);
        methodT1.invoke(per2, "x", 0);
        Method methodT11 = clazz.getDeclaredMethod("methodT1", String.class);
        methodT11.setAccessible(true);
        methodT11.invoke(alex, "y");

        //=========================================================
        Field field = clazz.getField("name");
        System.out.println(field.get(per1));
        System.out.println(field.getType());
        System.out.println(field.getModifiers());

        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f.getType());
        }


    }
}
