package com.example.demo_test;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author qiwenbo
 * @date 2022/8/17 14:45
 * @Description
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ImportSelectorImpl.class)
public @interface TestImport {
    String value() default "value";
    boolean flag() default false;
}
