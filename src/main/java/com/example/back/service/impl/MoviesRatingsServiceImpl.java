package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.MoviesRatings;
import com.example.back.mapper.MoviesRatingsMapper;
import com.example.back.service.IMoviesRatingsService;
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
public class MoviesRatingsServiceImpl extends ServiceImpl<MoviesRatingsMapper, MoviesRatings> implements IMoviesRatingsService {

    @Resource
    private MoviesRatingsMapper moviesRatingsMapper;

    @Override
    public IPage listByUserId(IPage<MoviesRatings> page, Wrapper ew) {
        return moviesRatingsMapper.listByUserId(page,ew);
    }
}
