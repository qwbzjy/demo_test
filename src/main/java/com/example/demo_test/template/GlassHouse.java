package com.example.demo_test.template;

import org.springframework.stereotype.Component;

/**
 * @author qiwenbo
 * @date 2022/8/12 13:58
 * @Description
 */
@Component("glass-tempalte")
public class GlassHouse extends HouseTemplate{
    @Override
    protected void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }
}
