package com.example.demo_test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiwenbo
 * @date 2022/8/19 13:56
 * @Description
 */
@Component
@ConfigurationProperties(prefix = "http.pool.conn")
@Data
public class HttpPoolProperties {
    // 最大连接数
    private Integer maxTotal = 20;
    // 同路由并发数
    private Integer defaultMaxPerRoute = 20;
    private Integer connectTimeout = 2000;
    private Integer connectionRequestTimeout = 2000;
    private Integer socketTimeout = 2000;
    // 线程空闲多久后进行校验
    private Integer validateAfterInactivity = 2000;
    // 重试次数
    private Integer retryTimes = 2;

    // 是否开启充实
    private boolean enableRetry = true;
    // 重试的间隔：可实现 ServiceUnavailableRetryStrategy 接口
    private Integer retryInterval = 2000;
}
