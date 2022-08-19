package com.example.demo_test.service.impl;

import com.example.demo_test.common.ResponseCode;
import com.example.demo_test.common.Result;
import com.example.demo_test.po.Files;
import com.example.demo_test.mapper.FileMapper;
import com.example.demo_test.service.FileService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author qiwenbo
 * @date 2022/8/19 9:49
 * @Description
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.save-path}")
    private String savePath;
    @Autowired
    private FileMapper fileMapper;


    @Override
    public Result upLoadFiles(MultipartFile file) throws FileNotFoundException {
        //设置支持最大上传的文件，这里是1024*1024*2=2M
        long MAX_SIZE = 2097152L;
        //获取要上传文件的名称
        String fileName = file.getOriginalFilename();
        //如果名称为空，返回一个文件名为空的错误
        if (StringUtils.isEmpty(fileName)) {
            return new Result(ResponseCode.FILE_NAME_EMPTY.getCode(), ResponseCode.FILE_NAME_EMPTY.getMsg(), null);
        }
        //如果文件超过最大值，返回超出可上传最大值的错误
        if (file.getSize() > MAX_SIZE) {
            return new Result(ResponseCode.FILE_MAX_SIZE.getCode(), ResponseCode.FILE_MAX_SIZE.getMsg(), null);
        }
        //获取到后缀名
        String suffixName = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;
        //文件的保存重新按照时间戳命名
//        String newName = System.currentTimeMillis() + suffixName;
//        savePath = ResourceUtils.getURL("classpath:").getPath() + "file/" ;
        File newFile = new File(savePath, fileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        try {
            //文件写入
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将这些文件的信息写入到数据库中

        Files files = Files.builder().filePath(newFile.getPath()).fileName(fileName).fileSuffix(suffixName).build();
        fileMapper.insert(files);
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), "数据上传成功");
    }

    @Override
    public Files getFileById(String id) {
        Files files = fileMapper.selectById(id);
        return files;
    }

    @Override
    public InputStream getFileInputStream(Files files) {
        File file = new File(files.getFilePath());
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
