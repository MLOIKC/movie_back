package com.example.back.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.MoviesRatings;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.back.entity.UsersRatings;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mloikc
 * @since 2022-12-15
 */
@Mapper
public interface MoviesRatingsMapper extends BaseMapper<MoviesRatings> {
    IPage listByUserId(IPage<MoviesRatings> page, Wrapper ew);

    IPage showMostHotByGenres(IPage<MoviesRatings> page, Wrapper ew);
}
