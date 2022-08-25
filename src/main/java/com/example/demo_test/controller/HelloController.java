package com.example.demo_test.controller;

import com.example.demo_test.aop.Action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiwenbo
 * @date 2022/8/15 16:40
 * @Description  spring自动映射获取表单和json格式数据的源码分析：https://blog.csdn.net/qq_23202687/article/details/101842511
 */
@RestController
public class HelloController {

    @Action(name = "测试日志")
    @RequestMapping("/hello")
    public String hello(String content) {
        return "hello " + content;
    }
}
