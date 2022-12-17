package com.example.back.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.MoviesRatings;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-15
 */
public interface IMoviesRatingsService extends IService<MoviesRatings> {

    IPage listByUserId(IPage<MoviesRatings> page, Wrapper ew);

    IPage showMostHotByGenres(IPage<MoviesRatings> page, Wrapper ew);
}
