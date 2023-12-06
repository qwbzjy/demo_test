package com.example.demo_test.responsiblechain;

/**
 * @author qiwenbo
 * @date 2023/12/5 10:14
 * @Description
 */
public class BHandler extends BaseRequestHandler {
    @Override
    public void doHandler(String req) {
        System.out.println("=============b===============" + req);
        if (next != null) {
            next.doHandler(req);
        }
    }
}
