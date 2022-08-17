package com.example.demo_test.po;

import com.baomidou.mybatisplus.annotation.*;
import com.example.demo_test.enums.SexEnum;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Builder;
import lombok.Data;

/**
 * @author qiwenbo
 * @date 2022/8/17 15:13
 * @Description
 */
@Data
@Builder
@TableName("student")
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
}
