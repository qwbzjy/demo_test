package com.example.demo_test.responsible;

/**
 * @author qiwenbo
 * @date 2023/8/28 16:11
 * @Description
 */
public interface Handler {
    void setNext(Handler next);
    void handleRequest(Request request);
}
