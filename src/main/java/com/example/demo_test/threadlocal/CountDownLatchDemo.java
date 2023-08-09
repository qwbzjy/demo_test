package com.example.demo_test.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * @author qiwenbo
 * @date 2023/8/9 15:19
 * @Description
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int threadsCount = 3;
        CountDownLatch latch = new CountDownLatch(threadsCount);
        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(new Worker(latch));
            thread.start();
        }
        //主线程等待计数器清零
        latch.await();
        System.out.println("所有子线程执行完毕，继续执行主线程");

    }
}

class Worker implements Runnable {
    private final CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行任务");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "完成任务");
        latch.countDown();
    }
}
