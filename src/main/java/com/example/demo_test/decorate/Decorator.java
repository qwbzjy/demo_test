package com.example.demo_test.decorate;

/**
 * @author qiwenbo
 * @date 2023/12/6 9:28
 * @Description
 */
public abstract class Decorator extends AbstractMilkyTea {

    public AbstractMilkyTea abstractMilkyTea;

    public Decorator(AbstractMilkyTea abstractMilkyTea) {
        this.abstractMilkyTea = abstractMilkyTea;
    }

    /**
     * 当前总价格
     */
    @Override
    protected float cost() {
        return abstractMilkyTea.cost() + super.getPrice();
    }

    @Override
    public String getDesc() {
        return abstractMilkyTea.getDesc() + "&" + super.getDesc();
    }

}
