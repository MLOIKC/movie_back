package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.UsersRatings;
import com.example.back.mapper.UsersRatingsMapper;
import com.example.back.service.IUsersRatingsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-15
 */
@Service
public class UsersRatingsServiceImpl extends ServiceImpl<UsersRatingsMapper, UsersRatings> implements IUsersRatingsService {

    @Resource
    private UsersRatingsMapper usersRatingsMapper;

    @Override
    public IPage listByGenderRating(IPage<UsersRatings> page, Wrapper ew) {
        return usersRatingsMapper.listByGenderRating(page,ew);
    }

    @Override
    public IPage showMostHotByGender(IPage<UsersRatings> page, Wrapper ew) {
        return usersRatingsMapper.showMostHotByGender(page,ew);
    }
}
