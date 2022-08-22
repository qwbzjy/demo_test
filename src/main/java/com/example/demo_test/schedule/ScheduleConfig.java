package com.example.demo_test.schedule;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.*;

/**
 * @author qiwenbo
 * @date 2022/8/18 11:55
 * @Description
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    //自定义线程池大小，可配置。代码中默认10个
    @Value("${threadPool.schedule.coreSize: 5}")
    public int SCHEDULE_CORE_SIZE;

    //自定义线程池名称
    public static final String THREAD_NAME_WITH_SCHEDULE = "schedule-thread-";

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(SCHEDULE_CORE_SIZE));
        scheduledTaskRegistrar.setScheduler(this.buildSchedulerThreadPool());
        System.out.println("Scheduler threadpool core_size: " + SCHEDULE_CORE_SIZE);
    }

    /**
     * Spring的@Scheduled的自定义周期性线程池
     *
     * @return
     */
    @Bean(value = "scheduleThreadPool")
    public ExecutorService buildSchedulerThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNamePrefix(THREAD_NAME_WITH_SCHEDULE).build();

        /**
         * 1. CallerRunsPolicy ：    这个策略重试添加当前的任务，他会自动重复调用 execute() 方法，直到成功。
         2. AbortPolicy ：         对拒绝任务抛弃处理，并且抛出异常。
         3. DiscardPolicy ：       对拒绝任务直接无声抛弃，没有异常信息。
         4. DiscardOldestPolicy ： 对拒绝任务不抛弃，而是抛弃队列里面等待最久的一个线程，然后把拒绝任务加到队列。
         不写则为默认的AbortPolicy策略。
         */
        return new ScheduledThreadPoolExecutor(
                SCHEDULE_CORE_SIZE,
                threadFactory);
    }
}
