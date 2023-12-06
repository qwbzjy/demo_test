package com.example.demo_test.decorate;

/**
 * @author qiwenbo
 * @date 2023/12/6 9:31
 * @Description
 */
public class Pudding extends Decorator {
    public Pudding(AbstractMilkyTea abstractMilkyTea) {
        super(abstractMilkyTea);
        setDesc("布丁");
        setPrice(6.5f);
    }

    @Override
    public float cost() {
        return super.cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc();
    }
}
