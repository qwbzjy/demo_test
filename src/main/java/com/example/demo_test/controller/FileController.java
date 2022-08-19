package com.example.demo_test.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo_test.common.ResponseCode;
import com.example.demo_test.common.Result;
import com.example.demo_test.po.Files;
import com.example.demo_test.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author qiwenbo
 * @date 2022/8/19 9:47
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class FileController {
    @Autowired
    private FileService fileService;

    @Value("${file.save-path}")
    private String downloadFilePath;

    //文件上传接口
    @PostMapping(value = "/upload")
    public Result upLoadFiles(MultipartFile multipartFile) {
        //如果文件为空，直接返回错误信息
        if (multipartFile.isEmpty()) {
            return new Result(ResponseCode.FILE_EMPTY.getCode(), ResponseCode.FILE_EMPTY.getMsg(), null);
        }
        //否则调用service上传文件
        return fileService.upLoadFiles(multipartFile);
    }


    @RequestMapping("/download2")
    public Result fileDownLoad(HttpServletResponse response, @RequestParam("fileName") String fileName) {
        File file = new File(downloadFilePath + '/' + fileName);
        if (!file.exists()) {
            return new Result(ResponseCode.FILE_NO_EXIST);
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buff = new byte[1024];
            OutputStream os = response.getOutputStream();
            int i;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            log.error("文件下载异常:{}", e);
            return new Result(ResponseCode.FILE_DOWNLOAD_FAILED);
        }
        return new Result(ResponseCode.SUCCESS);
    }

    @GetMapping(value = "/download/{id}")
    public void downloadFiles(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        byte[] bytes = new byte[1024];
        Files files = fileService.getFileById(id);
        String fileName = files.getFileName();
        // 获取输出流
        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            response.setContentType("application/force-download");
            inputStream = fileService.getFileInputStream(files);
            bufferedInputStream = new BufferedInputStream(inputStream);
            outputStream = response.getOutputStream();
            int i = bufferedInputStream.read(bytes);
            while (i != -1) {
                outputStream.write(bytes, 0, i);
                i = bufferedInputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
