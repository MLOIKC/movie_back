package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.BrowseRecords;
import com.example.back.mapper.BrowseRecordsMapper;
import com.example.back.service.IBrowseRecordsService;
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
public class BrowseRecordsServiceImpl extends ServiceImpl<BrowseRecordsMapper, BrowseRecords> implements IBrowseRecordsService {

    @Resource
    private BrowseRecordsMapper browseRecordsMapper;

    @Override
    public IPage getRecords(IPage<BrowseRecords> page, Wrapper ew) {
        return browseRecordsMapper.getRecords(page,ew);
    }
}
