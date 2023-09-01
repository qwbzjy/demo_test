package com.example.demo_test.threadlocal;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.*;

/**
 * @author qiwenbo
 * @date 2023/8/10 15:12
 * @Description
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
       /* ThreadFactory factory = ThreadFactoryBuilder.create().setNamePrefix("custom-pool-")
                .setDaemon(true)
                .build();
        ExecutorService executor = ThreadUtil.newExecutor(10, 50, 100);
        executor.submit(() -> {
            System.out.println("task executed by custom thread pool");
        });
        executor.shutdown();*/

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(100)
                , ThreadFactoryBuilder.create().setNamePrefix("custom-pool-").build(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            threadPoolExecutor.execute(() -> {
               /* try {
                    if (finalI % 3 == 0) {
                        throw new RuntimeException("偶数就报错");
                    }
                } catch (RuntimeException e) {
                    System.err.println("故意报错");
                }*/
                if (finalI % 3 == 0) {
                    throw new RuntimeException("偶数就报错");
                }
                System.out.println("taskNum:" + finalI + "线程名: " + Thread.currentThread().getName());
            });
        }
        threadPoolExecutor.shutdown();
    }

}
