package com.example.back.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.common.QueryPageParam;
import com.example.back.common.Result;
import com.example.back.entity.MoviesRatings;
import com.example.back.service.IMoviesRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mloikc
 * @since 2022-12-15
 */
@RestController
@RequestMapping("/movies-ratings")
public class MoviesRatingsController {
    @Autowired
    private IMoviesRatingsService iMoviesRatingsService;

    //根据用户id查询users、ratings联合数据
    @PostMapping("/listByUserId")
    public Result listByUserId(@RequestBody QueryPageParam queryPageParam){
        HashMap param;
        Integer userid;
        Page<MoviesRatings> page=new Page<>();
        try{
            param = queryPageParam.getParam();
            userid = (Integer) param.get("userid");
            page.setCurrent(queryPageParam.getPageNum());
            page.setSize(queryPageParam.getPageSize());
        }catch (Exception e){
            return Result.error("参数缺失");
        }
        LambdaQueryWrapper<MoviesRatings> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(MoviesRatings::getUserid,userid);

        IPage result=iMoviesRatingsService.listByUserId(page,lambdaQueryWrapper);
        return Result.success(result.getTotal(),result.getRecords());
    }

}
