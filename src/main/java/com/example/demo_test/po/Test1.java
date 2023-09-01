package com.example.demo_test.po;

/**
 * @author qiwenbo
 * @date 2023/8/25 9:50
 * @Description
 */
public class Test1 {
    public static void main(String[] args) {
        String userId = "P001002";
        String userId1 = "P012345";
        String prefix_0 = "P";
        String prefix_1 = "P0";
//        System.out.println(userId.startsWith(prefix_0));
//        System.out.println(userId.startsWith(prefix_1));
        System.out.println(userId1.startsWith(prefix_0));
        System.out.println(userId1.startsWith(prefix_1));
    }
}
