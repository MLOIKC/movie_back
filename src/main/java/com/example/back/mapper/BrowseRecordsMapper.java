package com.example.back.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.BrowseRecords;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface BrowseRecordsMapper extends BaseMapper<BrowseRecords> {

    IPage getRecords(IPage<BrowseRecords> page, Wrapper ew);
}
