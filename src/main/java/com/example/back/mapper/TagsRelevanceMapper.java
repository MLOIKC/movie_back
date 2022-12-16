package com.example.back.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.TagsRelevance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mloikc
 * @since 2022-12-16
 */
@Mapper
public interface TagsRelevanceMapper extends BaseMapper<TagsRelevance> {

    List<TagsRelevance> listTagRelevance(Integer userid,List<Integer> movieIdList);
}
