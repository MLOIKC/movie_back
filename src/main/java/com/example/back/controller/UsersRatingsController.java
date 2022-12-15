package com.example.back.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.common.QueryPageParam;
import com.example.back.common.Result;
import com.example.back.entity.Movies;
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

    //根据性别和评分查询users、ratings联合数据
    @PostMapping("/listByGenderRating")
    public Result listByGenderRating(@RequestBody QueryPageParam queryPageParam){
        HashMap param = queryPageParam.getParam();
        String gender = (String) param.get("gender");
        Double rating = (Double) param.get("rating");
        Page<UsersRatings> page=new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<UsersRatings> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(UsersRatings::getGender,gender).gt(UsersRatings::getRating,rating);

        IPage result=iUsersRatingsService.listByGenderRating(page,lambdaQueryWrapper);
        return Result.success(result.getTotal(),result.getRecords());
    }
}
