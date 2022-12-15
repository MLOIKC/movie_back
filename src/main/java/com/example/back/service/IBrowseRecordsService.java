package com.example.back.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.BrowseRecords;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.back.entity.Movies;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-12
 */
public interface IBrowseRecordsService extends IService<BrowseRecords> {

    IPage getRecords(IPage<BrowseRecords> page, Wrapper ew);
}
