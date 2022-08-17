package com.example.demo_test.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author qiwenbo
 * @date 2022/8/12 14:29
 * @Description
 */
@Getter
@AllArgsConstructor
public enum HouseTypeEnum {

    WOODEN(1, "wooden"),
    GLASS(2, "glass");

    private final Integer type;
    private final String houseType;


}
