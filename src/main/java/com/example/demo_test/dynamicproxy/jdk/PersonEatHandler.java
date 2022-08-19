package com.example.demo_test.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author qiwenbo
 * @date 2022/8/19 14:52
 * @Description
 */
public class PersonEatHandler implements InvocationHandler {
    private Object target;

    public PersonEatHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("饭前洗洗手");
        Object result = method.invoke(target, args);
        System.out.println("饭后散散步");
        return result;
    }
}
