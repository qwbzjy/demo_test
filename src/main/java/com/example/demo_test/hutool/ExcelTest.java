package com.tduck.cloud.api.util;

import java.io.FileInputStream;
import java.util.*;

import cn.hutool.core.util.StrUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelTest {

    public static void main(String[] args) throws Exception {
        String filePath = "D:\\test.xlsx";
//        Map<String, String> stringStringMap = readExcel(filePath);
//        stringStringMap.forEach((k, v) -> {
//            String sql = "update blade_user set duty = '" + v + "' where code = '" + k + "'";
//            System.out.println(sql + ";\n"); // 输出生成的 SQL 语句
//        });
        List<String> strings = readExcelUserCode(filePath);
        strings.forEach(item -> {
            String sql = "insert into blade_user_role(user_id,role_id) values('{}',1647855605909368834)";
            System.out.println(StrUtil.format(sql, item) + ";\n");
        });

    }

    public static Map<String, String> readExcel(String filePath) throws Exception {
        Map<String, String> map = new LinkedHashMap<>();
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表
        int numRows = sheet.getLastRowNum() + 1; // 获取行数
        for (int i = 2; i < numRows; i++) { // 第3行开始读取
            Row row = sheet.getRow(i);
            if (row == null) {
                continue; // 跳过空行
            }
            Cell keyCell = row.getCell(3); // 获取第4列的单元格
            if (keyCell == null) {
                continue; // 如果单元格为空，则跳过该行
            }
            Cell valueCell = row.getCell(4); // 获取第5列的单元格
            if (valueCell == null) {
                continue; // 如果单元格为空，则跳过该行
            }
            String key = keyCell.getStringCellValue(); // 将第4列的值作为Map的key
            String value = valueCell.getStringCellValue(); // 将第5列的值作为Map的value
            map.put(key, value);
        }
        workbook.close();
        inputStream.close();
        return map;
    }

    public static List<String> readExcelUserCode(String filePath) throws Exception {
        List<String> ls = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表
        int numRows = sheet.getLastRowNum() + 1; // 获取行数
        for (int i = 1; i < numRows; i++) { // 第3行开始读取
            Row row = sheet.getRow(i);
            if (row == null) {
                continue; // 跳过空行
            }
            Cell keyCell = row.getCell(0); // 获取第4列的单元格
            if (keyCell == null) {
                continue; // 如果单元格为空，则跳过该行
            }

            String key = keyCell.getStringCellValue(); // 将第4列的值作为Map的key
            ls.add(key);
        }
        workbook.close();
        inputStream.close();
        return ls;
    }
}

