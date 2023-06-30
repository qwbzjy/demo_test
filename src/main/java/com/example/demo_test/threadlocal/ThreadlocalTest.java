package com.example.demo_test.threadlocal;

import java.util.stream.IntStream;

/**
 * @author qiwenbo
 * @date 2023/5/9 13:39
 * @Description
 */
public class ThreadlocalTest {
    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new MyRunnable(i)).start();
        }
    }

    static class MyRunnable implements Runnable {
        private int id;

        public MyRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            THREAD_LOCAL.set(id);
            System.out.println("Thread " + Thread.currentThread().getName() + " set value: " + THREAD_LOCAL.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " get value: " + THREAD_LOCAL.get());
//            THREAD_LOCAL.remove();
        }
    }


}
