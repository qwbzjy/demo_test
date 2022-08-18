package com.example.demo_test.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo_test.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author qiwenbo
 * @date 2022/8/17 15:14
 * @Description
 */
public interface UserMapper extends BaseMapper<User> {

//    IPage<User> selectUserPage(Page<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
