package com.example.demo_test.observer;

/**
 * @author qiwenbo
 * @date 2023/12/6 10:36
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        //定义两个嫌犯
        Huairen xf1 = new XianFan1();
        Huairen xf2 = new XianFan2();
        //定义三个观察便衣警察
        Observer o1 = new Bianyi1();
        Observer o2 = new Bianyi2();
        Observer o3 = new Bianyi3();
        //为嫌犯增加观察便衣
        xf1.addObserver(o1);
        xf1.addObserver(o2);
        xf2.addObserver(o1);
        xf2.addObserver(o3);
        //定义嫌犯1的情况
        String message1 = "又卖了一批货";
        String message2 = "老大要下来视察了";
        xf1.notice(message1);
        xf2.notice(message2);
    }
}
