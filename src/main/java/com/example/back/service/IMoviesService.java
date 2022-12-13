package com.example.back.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.Movies;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.back.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-12
 */
public interface IMoviesService extends IService<Movies> {

    IPage listDefault(IPage<Movies> page);

    IPage listByMovieId(IPage<Movies> page, Wrapper ew);
}
