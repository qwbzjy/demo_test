package com.example.demo_test.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo_test.po.User;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
>>>>>>> c836a0cba2ea8be10c7483fff9255e2fa2847e1e

/**
 * @author qiwenbo
 * @date 2022/8/17 15:14
 * @Description
 */
<<<<<<< HEAD
@Repository
=======
@Mapper
>>>>>>> c836a0cba2ea8be10c7483fff9255e2fa2847e1e
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectUserPage(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
