package com.example.demo_test.responsiblechain;

/**
 * @author qiwenbo
 * @date 2023/12/5 9:28
 * @Description
 */
public abstract class BaseRequestHandler implements RequestHandler {

    protected RequestHandler next;

    public void next(RequestHandler next) {
        this.next = next;
    }
}
