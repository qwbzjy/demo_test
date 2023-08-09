package com.example.demo_test.threadlocal;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author qiwenbo
 * @date 2023/8/9 15:42
 * @Description
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int threadCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> System.out.println("所有线程都已经达到栅栏，继续执行后续操作"));
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new Worker1(barrier));
            thread.start();
        }

    }
}

class Worker1 implements Runnable {
    private final CyclicBarrier barrier;

    public Worker1(CyclicBarrier barrier) {
        this.barrier = barrier;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行任务");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "到达栅栏");
        try {
            //等待其他线程达到栅栏
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}