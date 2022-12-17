package com.example.back.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.Movies;
import com.example.back.entity.UsersRatings;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-15
 */
public interface IUsersRatingsService extends IService<UsersRatings> {

    IPage listByGenderRating(IPage<UsersRatings> page, Wrapper ew);

    IPage showMostHotByGender(IPage<UsersRatings> page, Wrapper ew);
}
