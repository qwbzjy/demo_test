package com.example.demo_test.common;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
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

//    private static String insert = "INSERT INTO `tduck-pro`.`sys_dict_data` ( `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES \n" +
//            "( %d, '%s', '%s', 'sys_expenses_card_type', NULL, 'default', 'N', '0', '000782', '2022-09-05 11:38:02', '', '2022-09-05 11:38:02', NULL);";

    private static String update = "UPDATE blade_user SET duty='%s' WHERE code='%s';";


    public static void main(String[] args) {
        String fileName = "D://职能部门工作职责统计表7.11.xlsx";
        InputStream inputStream = null;
        try {
           /* Path path = Paths.get("xxxx.txt");
            List<String> strings = Files.readAllLines(path);
            //读取视频
            try(BufferedInputStream inputStream1 = new BufferedInputStream(new FileInputStream("xxxxxx.mp4"))){
                byte[] buffer = new byte[1024];
                int bytesRead;
                while((bytesRead = inputStream1.read(buffer))!=-1){

                }
            }*/


            File file = new File(fileName);
            inputStream = new FileInputStream(file);
        } catch (Exception e) {
            System.out.println("文件读取报错");
        }
// 2.应用HUtool ExcelUtil获取ExcelReader指定输入流和sheet
        ExcelReader excelReader = ExcelUtil.getReader(inputStream, "人员职责表");
// 可以加上表头验证
// 3.读取第二行到最后一行数据
        List<List<Object>> read = excelReader.read(2, excelReader.getRowCount() - 1);
        System.out.println("总行数: " + read.size());
        read.stream().forEach(item -> {
            String userCode = (String) item.get(3);
            String duty = (String) item.get(4);
            System.out.println(String.format(update, duty, userCode));
        });


/*        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
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
        }*/
    }


    private int code;
    private String message;
    private Object data;

}
