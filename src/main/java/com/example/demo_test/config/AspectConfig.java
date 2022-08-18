package com.example.demo_test.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author qiwenbo
 * @date 2022/8/18 17:24
 * @Description
 */
@Component
@Aspect
public class AspectConfig {

    @Pointcut("execution(* com.example.demo_test..*(..))")
    private void pointcut() {

    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object testAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("执行业务前打印日志..............");
        Object proceed = joinPoint.proceed();
        System.out.println("执行业务后打印日志..............");
        return proceed;
    }
}
