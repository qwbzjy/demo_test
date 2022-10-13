package com.example.demo_test.hutool;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.format.FastDateFormat;
import liquibase.pro.packaged.D;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//        FastDateFormat pattern = FastDateFormat.getInstance("MM月dd日");

//        System.out.println(pattern.format(new Date()));
//        String da = DateUtil.formatChineseDate(new Date(), false, false);
//        System.out.println(da.split("年")[1]);

        String str = "https://www.runoob.com:80/html/html-tutorial.html";
        String pattern = " /(\\w+):\\/\\/([^/:]+)(:\\d*)?([^# ]*)/";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(str);
//        String[] split = str.split(pattern);
//        for (String item : split) {
//            System.out.println(item);
//        }
//        System.out.println(matcher.matches());
        while(matcher.find()){
            String group = matcher.group(0);
            System.out.println(group);
        }

    }
}
