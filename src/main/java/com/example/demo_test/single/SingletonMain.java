package com.example.demo_test.single;

/**
 * @author qiwenbo
 * @date 2023/12/6 10:03
 * @Description
 */
public class SingletonMain {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        for (int i = 0; i < 10; i++) {
            Thread th = new Thread(() -> {
                System.out.println("获取的对象：" + SingleTon.getInstance());
            });
            th.start();
        }
    }
}

class SingleTon {
    private SingleTon() {
    }

    /**
     * 保证了线程间的可见性
     */
    private volatile static SingleTon instance;

    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}
