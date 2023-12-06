package com.example.demo_test.decorate;

/**
 * @author qiwenbo
 * @date 2023/12/6 9:25
 * @Description
 */
public abstract class AbstractMilkyTea {
    /**
     * 单品信息
     */
    private String desc;

    /**
     * 价格
     */
    private float price;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 单品价格
     *
     * @return
     */
    protected abstract float cost();
}
