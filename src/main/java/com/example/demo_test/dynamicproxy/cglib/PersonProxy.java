package com.example.demo_test.dynamicproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author qiwenbo
 * @date 2022/8/19 14:56
 * @Description
 */
public class PersonProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        Object result;
        System.out.println("饭前洗洗手");
        result = proxy.invokeSuper(obj, objects);
        System.out.println("饭后散散步");
        return result;
    }
}
