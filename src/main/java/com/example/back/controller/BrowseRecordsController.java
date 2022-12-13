package com.example.back.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.common.QueryPageParam;
import com.example.back.common.Result;
import com.example.back.entity.BrowseRecords;
import com.example.back.entity.User;
import com.example.back.service.IBrowseRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mloikc
 * @since 2022-12-12
 */
@RestController
@RequestMapping("/browse-records")
public class BrowseRecordsController {
    @Autowired
    private IBrowseRecordsService iBrowseRecordsService;

    //获取用户浏览记录
    @PostMapping("/get-records")
    public Result getRecords(@RequestBody QueryPageParam queryPageParam){
        HashMap param;
        Integer userid;
        try{
            param=queryPageParam.getParam();
            userid=(Integer) param.get("userid");
        }catch (Exception e){
            return Result.error("参数缺失");
        }
        Page<BrowseRecords> page=new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<BrowseRecords> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(BrowseRecords::getUserid,userid);

        IPage result=iBrowseRecordsService.page(page,lambdaQueryWrapper);

        return Result.success(result.getTotal(),result.getRecords());
    }

    //添加用户浏览记录
    @PostMapping("/set-records")
    public Result setRecords(@RequestBody BrowseRecords BrowseRecords){
        if(iBrowseRecordsService.save(BrowseRecords))
            return Result.success();
        else
            return Result.error();
    }
}
