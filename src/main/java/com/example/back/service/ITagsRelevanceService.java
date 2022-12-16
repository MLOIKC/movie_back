package com.example.back.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.TagsRelevance;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-16
 */
public interface ITagsRelevanceService extends IService<TagsRelevance> {

    List<TagsRelevance> listTagRelevance(Integer userid,List<Integer> movieIdList);
}
