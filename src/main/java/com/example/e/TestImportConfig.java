package com.example.e;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiwenbo
 * @date 2022/8/17 14:41
 * @Description
 */
@Configuration
public class TestImportConfig {
    @Bean
    public TestImportA testImportA() {
        return new TestImportA();
    }

    @Bean
    public TestImportB testImportB() {
        return new TestImportB();
    }
}
