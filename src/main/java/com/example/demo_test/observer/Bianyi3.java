package com.example.demo_test.observer;

/**
 * @author qiwenbo
 * @date 2023/12/6 10:32
 * @Description
 */
public class Bianyi3 implements Observer {
    private String bname = "姜子牙";

    @Override
    public void update(String message, String name) {
        System.out.println(bname + ":" + name + "那里有新情况：" + message);
    }
}
