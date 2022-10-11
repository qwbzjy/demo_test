package com.example.demo_test.common;

import java.time.LocalDate;

/**
 * @author qiwenbo
 * @date 2022/10/8 9:47
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2022,10,1);
        LocalDate yesterday = localDate.plusDays(-1);
        System.out.println(yesterday.getDayOfMonth());
        System.out.println(yesterday.getMonthValue());
        System.out.println(yesterday.getYear());
    }
}
