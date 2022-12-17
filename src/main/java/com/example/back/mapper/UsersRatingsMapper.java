package com.example.back.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.UsersRatings;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface UsersRatingsMapper extends BaseMapper<UsersRatings> {

    IPage listByGenderRating(IPage<UsersRatings> page, Wrapper ew);

    IPage showMostHotByGender(IPage<UsersRatings> page, Wrapper ew);
}
