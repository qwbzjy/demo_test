package com.example.demo_test.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiwenbo
 * @date 2022/8/19 9:42
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private int code;
    private String message;
    private Object data;

    public Result(ResponseCode result) {
        this.code = result.getCode();
        this.message = result.getMsg();
    }
}
