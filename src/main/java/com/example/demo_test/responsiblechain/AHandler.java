package com.example.demo_test.responsiblechain;

/**
 * @author qiwenbo
 * @date 2023/12/5 9:30
 * @Description
 */
public class AHandler extends BaseRequestHandler {
    @Override
    public void doHandler(String req) {
        System.out.println("==========a=================" + req);
        if (next != null) {
            next.doHandler(req);
        }
    }
}
