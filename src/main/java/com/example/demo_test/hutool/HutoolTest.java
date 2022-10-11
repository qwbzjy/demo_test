package com.example.demo_test.hutool;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.format.FastDateFormat;
import liquibase.pro.packaged.D;

import java.util.Calendar;
import java.util.Date;

/**
 * @author qiwenbo
 * @date 2022/10/10 14:26
 * @Description
 */
public class HutoolTest {
    public static void main(String[] args) {
//        String emoji = EmojiUtil.toUnicode(":smile:");
//        System.out.println(emoji);
        //生成二维码
//        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg"));
//        System.out.println(IdcardUtil.getMonthByIdCard("422202199112282415"));
//        DesensitizeUtil.mobilePhone("18049531999");
//        String pattern = "MM月dd日";
        FastDateFormat pattern = FastDateFormat.getInstance("MM月dd日");

        System.out.println(pattern.format(new Date()));
//        String da = DateUtil.formatChineseDate(new Date(), false, false);
//        System.out.println(da.split("年")[1]);
    }
}
