package com.example.demo_test.responsible;

/**
 * @author qiwenbo
 * @date 2023/8/28 16:12
 * @Description
 */
public class ConcreteHandlerA implements Handler{
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getValue() < 0) {
            System.out.println("Negative values are handled by ConcreteHandlerA: " + request.getValue());
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
