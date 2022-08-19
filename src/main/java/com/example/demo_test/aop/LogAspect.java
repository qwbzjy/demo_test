package com.example.demo_test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author qiwenbo
 * @date 2022/8/19 14:32
 * @Description
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.example.demo_test.aop.Action)")
    public void annotationPointCut() {
    }

    /**
     * @param joinPoint
     * @Before 前置通知，在方法执行之前
     */
    @Before("execution(* com.example.demo_test.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截:" + method.getName());
    }

    /**
     * @After 后置通知，在方法执行之后
     * @param joinPoint
     */
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        Method method=signature.getMethod();
        Action action=method.getAnnotation(Action.class);
        System.out.println("注解式拦截..."+action.name());
    }
}
