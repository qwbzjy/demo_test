package com.example.demo_test.decorate;

/**
 * @author qiwenbo
 * @date 2023/12/6 9:26
 * @Description
 */
public class PearlMilkyTea extends AbstractMilkyTea {
    public PearlMilkyTea() {
        setDesc("珍珠");
        setPrice(10);
    }

    @Override
    protected float cost() {
        return getPrice();
    }

}
