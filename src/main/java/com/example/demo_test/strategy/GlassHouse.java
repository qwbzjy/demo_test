package com.example.demo_test.strategy;

import org.springframework.stereotype.Component;

/**
 * @author qiwenbo
 * @date 2022/8/12 14:36
 * @Description
 */
@Component("glass")
public class GlassHouse implements House {
    @Override
    public String firstStep(String houseName) {
        return houseName + "玻璃房";
    }

    @Override
    public String secondStep(String housePrice) {
        return housePrice + "200W";
    }
}
