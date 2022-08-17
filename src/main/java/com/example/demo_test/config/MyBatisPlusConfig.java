package com.example.demo_test.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiwenbo
 * @date 2022/8/17 15:58
 * @Description
 */
@Configuration
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
