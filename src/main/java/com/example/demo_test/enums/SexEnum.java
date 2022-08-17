package com.example.demo_test.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;

/**
 * @author qiwenbo
 * @date 2022/8/17 16:46
 * @Description
 */
@AllArgsConstructor
public enum SexEnum implements IEnum<Integer> {
    MAN(1, "男"),
    WOMEN(0, "女");


    private int code;
    private String value;

    @Override
    public Integer getValue() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
