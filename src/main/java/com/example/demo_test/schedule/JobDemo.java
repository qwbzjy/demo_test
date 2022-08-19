package com.example.demo_test.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author qiwenbo
 * @date 2022/8/17 11:40
 * @Description
 */

@Component
@Slf4j
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

    @Value("${file.save-path}")
    private String deleteFilePath;

    @Async("executor1")
    @Scheduled(cron = "*/10 * * * * ?")
    public void deleteFiles() {
        deleteFile(new File(deleteFilePath));
    }

    public void deleteFile(File file) {
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()) {
            log.info("暂无文件");
            return;
        }
        //取得这个目录下的所有子文件对象
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f : files) {
            //打印文件名
            String name = f.getName();
            log.info(name);
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()) {
                deleteFile(f);
            } else {
                f.delete();
            }
        }
        //删除空文件夹  for循环已经把上一层节点的目录清空。
        file.delete();
    }


}
