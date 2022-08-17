package com.example.demo_test.template;

import org.springframework.stereotype.Component;

/**
 * @author qiwenbo
 * @date 2022/8/12 13:58
 * @Description
 */
@Component("wooden-template")
public class WoodenHouse extends HouseTemplate{
    @Override
    protected void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }
}
