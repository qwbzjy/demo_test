package com.example.demo_test.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author qiwenbo
 * @date 2022/8/17 11:40
 * @Description
 */

@Component
public class JobDemo {
    // 会使用 ExecutorConfig 中配置的线程池
    @Async("executor1")
    @Scheduled(cron = "0/5 * * * * *")
    public void printLocalDate1() {
        System.out.println("printLocalDate1:" + Thread.currentThread().getName() + "\t" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    // 会使用 ExecutorConfig 中配置的线程池
    @Async("executor1")
    @Scheduled(cron = "0/5 * * * * *")
    public void printLocalDate2() {
        System.out.println("printLocalDate2:" + Thread.currentThread().getName() + "\t" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }


    // 会使用 ScheduleConfig 中配置的线程池
//    @Async("executor1")
    @Scheduled(cron = "0/5 * * * * *")
    public void printLocalDate3() {
        System.out.println("printLocalDate3:" + Thread.currentThread().getName() + "\t" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }


}
