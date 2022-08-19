package com.example.demo_test.aop;

import java.lang.annotation.*;

/**
 * @author qiwenbo
 * @date 2022/8/19 14:31
 * @Description
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Action {
    String name();
}
