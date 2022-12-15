package com.example.back.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.common.QueryPageParam;
import com.example.back.common.Result;
import com.example.back.entity.Movies;
import com.example.back.entity.User;
import com.example.back.service.IMoviesService;
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
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private IMoviesService iMoviesService;

    //默认展示的前n个电影
    @PostMapping("/listDefault")
    public Result listDefault(@RequestBody QueryPageParam queryPageParam){
        Page<Movies> page=new Page<>();
        try{
            page.setCurrent(queryPageParam.getPageNum());
            page.setSize(queryPageParam.getPageSize());
        }catch (Exception e){
            return Result.error("参数缺失");
        }
        IPage result=iMoviesService.listDefault(page);
        return Result.success(result.getTotal(),result.getRecords());
    }

    //根据电影id展示电影
    @PostMapping("/listByMovieId")
    public Result listByMovieId(@RequestBody QueryPageParam queryPageParam){
        List<Integer> searchId;
        Page<Movies> page=new Page<>();
        try{
            searchId = (List)queryPageParam.getSearchId();
            page.setCurrent(queryPageParam.getPageNum());
            page.setSize(queryPageParam.getPageSize());
        }catch (Exception e){
            return Result.error("参数缺失");
        }
        LambdaQueryWrapper<Movies> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.in(Movies::getMovieid,searchId);

        IPage result=iMoviesService.listByMovieId(page,lambdaQueryWrapper);
        return Result.success(result.getTotal(),result.getRecords());
    }

    //根据关键词展示电影
    @PostMapping("listByKeyWord")
    public Result listByKeyword(@RequestBody QueryPageParam queryPageParam){
        HashMap param;
        String keyWord;
        Page<Movies> page=new Page<>();
        try{
            param = queryPageParam.getParam();
            keyWord = (String) param.get("keyWord");

            page.setCurrent(queryPageParam.getPageNum());
            page.setSize(queryPageParam.getPageSize());
        }catch (Exception e){
            return Result.error("参数缺失");
        }
        LambdaQueryWrapper<Movies> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(Movies::getTitle,keyWord);

        IPage result=iMoviesService.listByKeyword(page,lambdaQueryWrapper);
        return Result.success(result.getTotal(),result.getRecords());
    }
}
