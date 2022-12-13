package com.example.back.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.Movies;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.back.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mloikc
 * @since 2022-12-12
 */
@Mapper
public interface MoviesMapper extends BaseMapper<Movies> {

    IPage listDefault(IPage<Movies> page);

    IPage listByMovieId(IPage<Movies> page, Wrapper ew);
}
