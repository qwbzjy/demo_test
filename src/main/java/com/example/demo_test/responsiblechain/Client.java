package com.example.demo_test.responsiblechain;

import liquibase.pro.packaged.A;

/**
 * @author qiwenbo
 * @date 2023/12/5 10:15
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        BaseRequestHandler a = new AHandler();
        BaseRequestHandler b = new BHandler();
        a.next(b);
        a.doHandler("测试责任链设计模式");

    }
}
