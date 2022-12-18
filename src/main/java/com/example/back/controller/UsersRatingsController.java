package com.example.back.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.common.QueryPageParam;
import com.example.back.common.Result;
import com.example.back.entity.Movies;
import com.example.back.entity.MoviesRatings;
import com.example.back.entity.UsersRatings;
import com.example.back.service.IUsersRatingsService;
import io.swagger.models.auth.In;
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
@RequestMapping("/users-ratings")
public class UsersRatingsController {
    @Autowired
    private IUsersRatingsService iUsersRatingsService;

    //区分性别，查询高于某个评分的打分情况
    @PostMapping("/listByGenderRating")
    public Result listByGenderRating(@RequestBody QueryPageParam queryPageParam){
        HashMap param;
        String gender;
        Double rating;
        Page<UsersRatings> page=new Page<>();
        try{
            param = queryPageParam.getParam();
            gender = (String) param.get("gender");
            rating = Double.parseDouble(param.get("rating").toString());
            page.setCurrent(queryPageParam.getPageNum());
            page.setSize(queryPageParam.getPageSize());
        }catch (Exception e){
            return Result.error("参数缺失");
        }
        LambdaQueryWrapper<UsersRatings> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(UsersRatings::getGender,gender).gt(UsersRatings::getRating,rating);

        IPage result=iUsersRatingsService.listByGenderRating(page,lambdaQueryWrapper);
        return Result.success(result.getTotal(),result.getRecords());
    }

    //根据性别查询最受欢迎的电影
    @PostMapping("/showMostHotByGender")
    public Result showMostHotByGender(@RequestBody QueryPageParam queryPageParam){
        HashMap param;
        String gender;
        Page<UsersRatings> page = new Page<>();
        try {
            param = queryPageParam.getParam();
            gender = (String) param.get("gender");
            page.setCurrent(queryPageParam.getPageNum());
            page.setSize(queryPageParam.getPageSize());
        } catch (Exception e) {
            return Result.error("参数缺失");
        }
        LambdaQueryWrapper<UsersRatings> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(UsersRatings::getGender, gender);

        IPage result = iUsersRatingsService.showMostHotByGender(page, lambdaQueryWrapper);
        return Result.success(result.getTotal(), result.getRecords());
    }
}
