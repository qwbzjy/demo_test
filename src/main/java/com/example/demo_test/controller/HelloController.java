package com.example.demo_test.controller;

import com.example.demo_test.aop.Action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiwenbo
 * @date 2022/8/15 16:40
 * @Description
 */
@RestController
public class HelloController {

    @Action(name = "测试日志")
    @RequestMapping("/hello")
    public String hello(String content) {
        return "hello " + content;
    }
}
