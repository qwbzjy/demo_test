package com.example.demo_test.responsible;

/**
 * @author qiwenbo
 * @date 2023/8/28 16:13
 * @Description
 */
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // 创建责任链中的处理器对象
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();

        // 设置处理器之间的关系
        handlerA.setNext(handlerB);

        // 创建一个请求，并将其沿着责任链传递
        Request request1 = new Request(5);
        handlerA.handleRequest(request1);

        Request request2 = new Request(-3);
        handlerA.handleRequest(request2);
    }
}
