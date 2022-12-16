package com.example.back.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.common.QueryPageParam;
import com.example.back.common.Result;
import com.example.back.entity.MoviesRatings;
import com.example.back.entity.TagsRelevance;
import com.example.back.service.IMoviesRatingsService;
import com.example.back.service.ITagsRelevanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @Autowired
    private ITagsRelevanceService iTagsRelevanceService;

    //根据用户id查询users、ratings联合数据
    @PostMapping("/listByUserId")
    public Result listByUserId(@RequestBody QueryPageParam queryPageParam) {
        HashMap param;
        Integer userid;
        Page<MoviesRatings> page = new Page<>();
        try {
            param = queryPageParam.getParam();
            userid = (Integer) param.get("userid");
            page.setCurrent(queryPageParam.getPageNum());
            page.setSize(queryPageParam.getPageSize());
        } catch (Exception e) {
            return Result.error("参数缺失");
        }
        LambdaQueryWrapper<MoviesRatings> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(MoviesRatings::getUserid, userid);

        IPage result = iMoviesRatingsService.listByUserId(page, lambdaQueryWrapper);

        List<MoviesRatings> list = result.getRecords();
        List<Integer> movieIdList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            movieIdList.add(list.get(i).getMovieid());
        }
        List<TagsRelevance> tagsRelevance = iTagsRelevanceService.listTagRelevance(userid, movieIdList);
        for (int i = 0; i < list.size(); i++) {
            List<Double> relevanceTemp = new ArrayList<>();
            List<String> tagTemp = new ArrayList<>();
            for (int j = 0; j < tagsRelevance.size(); j++) {
                if (list.get(i).getMovieid().equals(tagsRelevance.get(j).getMovieid())) {
                    tagTemp.add(tagsRelevance.get(j).getTag());
                    relevanceTemp.add(tagsRelevance.get(j).getRelevance());
                    list.get(i).setTag(tagTemp);
                    list.get(i).setRelevance(relevanceTemp);
                    if(tagTemp.size()==3)
                        break;
                }
            }
        }
        return Result.success(result.getTotal(), list);
    }
}
