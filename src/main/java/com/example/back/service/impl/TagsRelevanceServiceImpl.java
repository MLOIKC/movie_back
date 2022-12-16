package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.TagsRelevance;
import com.example.back.mapper.TagsRelevanceMapper;
import com.example.back.service.ITagsRelevanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-16
 */
@Service
public class TagsRelevanceServiceImpl extends ServiceImpl<TagsRelevanceMapper, TagsRelevance> implements ITagsRelevanceService {

    @Resource
    private TagsRelevanceMapper tagsRelevanceMapper;

    @Override
    public List<TagsRelevance> listTagRelevance(Integer userid,List<Integer> movieIdList) {
        return tagsRelevanceMapper.listTagRelevance(userid,movieIdList);
    }
}
