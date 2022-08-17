package com.example.demo_test.po;

import com.baomidou.mybatisplus.annotation.*;
import com.example.demo_test.enums.SexEnum;
import com.example.demo_test.typehandlers.ListTypeHandler;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author qiwenbo
 * @date 2022/8/17 15:13
 * @Description
 */
@Data
@Builder
@TableName(value = "student", autoResultMap = true)
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //把字段更新为null
//    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Integer deptId;
    private String name;
    private String remark;
    private SexEnum sex;
    @TableLogic
    private Integer status;

    @TableField(typeHandler = ListTypeHandler.class)
    private List<String> features;


}
