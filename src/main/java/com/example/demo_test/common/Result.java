package com.example.demo_test.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author qiwenbo
 * @date 2022/8/19 9:42
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private static String insert = "INSERT INTO `tduck-pro`.`sys_dict_data` ( `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES \n" +
            "( %d, '%s', '%s', 'sys_expenses_card_type', NULL, 'default', 'N', '0', '000782', '2022-09-05 11:38:02', '', '2022-09-05 11:38:02', NULL);";


    public static void main(String[] args) {
        String fileName = "D://餐费卡号数据.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            AtomicInteger num = new AtomicInteger(1);
            stream.forEach(item -> {
                String[] split = item.split("\\t");
                String format = String.format(insert, num.get(), split[1].trim(), split[0].trim());
                System.out.println(format);
                num.incrementAndGet();
//                System.out.println(split[0].trim());
//                System.out.println(split[1].trim());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int code;
    private String message;
    private Object data;

}
