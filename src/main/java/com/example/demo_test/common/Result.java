package com.example.demo_test.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.from((formatter.parse("2022-05-21 00:00:00"))).minusDays(1);
//
//
////        System.out.println(LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN));
////        System.out.println(LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MAX));
//        Long startTime = LocalDateTime.of(LocalDate.from(localDateTime), LocalTime.MIN).toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        Long endTime = LocalDateTime.of(LocalDate.from(localDateTime), LocalTime.MAX).toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        System.out.println(startTime);
//        System.out.println(endTime);

    }
}
