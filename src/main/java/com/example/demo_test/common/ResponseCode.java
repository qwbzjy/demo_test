package com.example.demo_test.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author qiwenbo
 * @date 2022/8/19 9:41
 * @Description
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {
    // 系统模块
    SUCCESS(0, "操作成功"),
    ERROR(1, "操作失败"),
    SERVER_ERROR(500, "服务器异常"),

    // 通用模块 1xxxx
    ILLEGAL_ARGUMENT(10000, "参数不合法"),
    REPETITIVE_OPERATION(10001, "请勿重复操作"),
    ACCESS_LIMIT(10002, "请求太频繁, 请稍后再试"),
    MAIL_SEND_SUCCESS(10003, "邮件发送成功"),

    // 用户模块 2xxxx
    NEED_LOGIN(20001, "登录失效"),
    USERNAME_OR_PASSWORD_EMPTY(20002, "用户名或密码不能为空"),
    USERNAME_OR_PASSWORD_WRONG(20003, "用户名或密码错误"),
    USER_NOT_EXISTS(20004, "用户不存在"),
    WRONG_PASSWORD(20005, "密码错误"),

    // 文件模块 3xxxx
    FILE_EMPTY(30001, "文件不能空"),
    FILE_NAME_EMPTY(30002, "文件名称不能为空"),
    FILE_MAX_SIZE(30003, "文件大小超出"),
    FILE_NO_EXIST(30004, "文件不存在"),
    FILE_DOWNLOAD_SUCCESS(30005, "文件下载成功"),
    FILE_DOWNLOAD_FAILED(30006, "文件下载失败"),
    ;
    private final Integer code;
    private final String msg;

}
