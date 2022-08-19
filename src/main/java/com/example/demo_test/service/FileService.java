package com.example.demo_test.service;

import com.example.demo_test.common.Result;
import com.example.demo_test.po.Files;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author qiwenbo
 * @date 2022/8/19 9:48
 * @Description 文件处理方法
 */
public interface FileService {
    /**
     * 文件上传接口
     *
     * @param file
     * @return
     */
    Result upLoadFiles(MultipartFile file);

    /**
     * 根据id获取文件
     *
     * @param id
     * @return
     */
    Files getFileById(String id);

    /**
     * 根据id获取数据流
     *
     * @param files
     * @return
     */
    InputStream getFileInputStream(Files files);
}
