package com.example.demo_test;

import cn.hutool.extra.spring.SpringUtil;
import com.example.demo_test.template.ApplicationContextUtil;
import com.example.demo_test.template.GlassHouse;
import com.example.demo_test.template.HouseTemplate;
import com.example.demo_test.template.WoodenHouse;
import com.example.e.TestImportA;
import com.example.e.TestImportB;
import com.example.e.TestImportConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
//@Import({TestImportA.class, TestImportB.class})
//@Import(TestImportConfig.class)
@TestImport
//@Import(ImportBeanDefinitionRegistrarImpl.class)
@MapperScan("com.example.demo_test.mapper")
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class DemoTestApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoTestApplication.class, args);
        TestImportB bean = SpringUtil.getBean(TestImportB.class);
//        TestImportB bean = run.getBean(TestImportB.class);
        bean.test();


//        HouseTemplate wooden = ApplicationContextUtil.templateMap.get("wooden");
//        wooden.buildHouse();
//        String str = "222";
//        System.out.println(str.split(",")[0]);
    }

}
