package com.example.demo_test.strategy;

import org.springframework.stereotype.Component;

/**
 * @author qiwenbo
 * @date 2022/8/12 14:28
 * @Description
 */
@Component(value = "wooden")
public class WoodenHouse implements House {
    @Override
    public String firstStep(String houseName) {
        return "小木屋";
    }

    @Override
    public String secondStep(String housePrice) {
        return "100w";
    }
}
