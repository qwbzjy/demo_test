package com.example.demo_test.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author qiwenbo
 * @date 2022/8/25 15:08
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public static Book of(Long id, String name, String createTime) {
        return new Book(id, name, Date.from(LocalDateTime.parse(createTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant()));
    }

    private Long id;

    private String name;

    private Date createTime;
}
