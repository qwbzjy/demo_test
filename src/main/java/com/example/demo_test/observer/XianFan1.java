package com.example.demo_test.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiwenbo
 * @date 2023/12/6 10:34
 * @Description
 */
public class XianFan1 implements Huairen {
    //别称
    private String name = "大熊";
    //定义观察者集合
    private List<Observer> observerList = new ArrayList<Observer>();

    //增加观察者
    @Override
    public void addObserver(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    //移除观察者
    @Override
    public void removeObserver(Observer observer) {
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }
    }

    //通知观察者
    @Override
    public void notice(String message) {
        for (Observer observer : observerList) {
            observer.update(message, name);
        }
    }
}
