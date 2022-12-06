package com.example.back.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-05
 */
public interface IUserService extends IService<User> {

    User login(User user);

    IPage pageC(IPage<User> page);

    IPage pageA(IPage<User> page, Wrapper ew);
}
