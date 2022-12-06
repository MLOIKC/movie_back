package com.example.back.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mloikc
 * @since 2022-12-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage pageC(IPage<User> page);

    IPage pageA(IPage<User> page, Wrapper ew);
}
