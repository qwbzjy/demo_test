package com.example.demo_test.responsible;

/**
 * @author qiwenbo
 * @date 2023/8/28 16:12
 * @Description
 */
public class ConcreteHandlerB implements Handler{
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getValue() > 0) {
            System.out.println("Positive values are handled by ConcreteHandlerB: " + request.getValue());
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
