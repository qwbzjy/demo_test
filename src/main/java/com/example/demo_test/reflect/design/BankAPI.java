package com.example.demo_test.reflect.design;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface BankAPI {
    String desc() default "";

    String url() default "";
}
