package com.example.demo_test.decorate;

/**
 * @author qiwenbo
 * @date 2023/12/6 9:30
 * @Description
 */
public class RedBeans extends Decorator {
    public RedBeans(AbstractMilkyTea abstractMilkyTea) {
        super(abstractMilkyTea);
    }

    @Override
    public float cost() {
        return super.cost() + 5.0f;
    }

    @Override
    public String getDesc() {
        return abstractMilkyTea.getDesc() + "红豆";
    }

}
