package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.Movies;
import com.example.back.mapper.MoviesMapper;
import com.example.back.service.IMoviesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-12
 */
@Service
public class MoviesServiceImpl extends ServiceImpl<MoviesMapper, Movies> implements IMoviesService {

    @Resource
    private MoviesMapper moviesMapper;

    @Override
    public IPage listDefault(IPage<Movies> page) {
        return moviesMapper.listDefault(page);
    }

    @Override
    public IPage listByMovieId(IPage<Movies> page, Wrapper ew) {
        return moviesMapper.listByMovieId(page,ew);
    }

    @Override
    public IPage listByKeyword(IPage<Movies> page, Wrapper ew) {
        return moviesMapper.listByKeyword(page,ew);
    }
}
