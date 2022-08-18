package com.example.demo_test.schedule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author qiwenbo
 * @date 2022/8/17 11:38
 * @Description
 */
@Configuration
public class ExecutorConfig {
    @Value("${executor.size.core:4}")
    private Integer core;

    @Value("${executor.size.max:4}")
    private Integer max;

    @Value("${executor.size.queue:100}")
    private Integer queue;

    @Value("${executor.keepalive.time:60}")
    private Integer keepalive;


    @Bean
    public ThreadPoolTaskExecutor executor1() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(core);
        //最大线程数
        executor.setMaxPoolSize(max);
        //队列中最大的数
        executor.setQueueCapacity(queue);
        //线程名称前缀
        executor.setThreadNamePrefix("threadNamePrefix_");
        //对拒绝task的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程空闲后最大的存活时间(秒)
        executor.setKeepAliveSeconds(keepalive);
        //初始化加载
        executor.initialize();
        return executor;
    }
}
