package com.example.demo_test.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qiwenbo
 * @date 2022/8/19 9:45
 * @Description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("file")
public class Files implements Serializable {
    private static final long serialVersionUID = 5532553458580581034L;

    /**
     * 文件存储路径
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "filePath")
    private String filePath;
    /**
     * 文件名称
     */
    @TableField(value = "fileName")
    private String fileName;
    /**
     * 文件后缀名
     */
    @TableField(value = "fileSuffix")
    private String fileSuffix;
}
