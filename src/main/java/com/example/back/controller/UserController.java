package com.example.back.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.back.common.QueryPageParam;
import com.example.back.common.Result;
import com.example.back.entity.User;
import com.example.back.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mloikc
 * @since 2022-12-05
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public List<User> list(){
        return iUserService.list();
    }

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return iUserService.save(user);
    }

    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return iUserService.updateById(user);
    }

    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user){
        return iUserService.saveOrUpdate(user);
    }

    //删除
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return iUserService.removeById(id);
    }

    //查询（模糊、匹配）
    @PostMapping("/search")
    public List<User> search(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getUsername,user.getUsername());//模糊
//        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());//匹配
        return iUserService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam queryPageParam){
//        System.out.println(queryPageParam);
        HashMap param=queryPageParam.getParam();
        String username=(String)param.get("username");
//        System.out.println("id==="+param.get("id"));
//        System.out.println("username==="+(String)param.get("username"));
        Page<User> page=new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getUsername,username);

        IPage result=iUserService.page(page,lambdaQueryWrapper);
        System.out.println("total==="+result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listPageA")
    public List<User> listPageA(@RequestBody QueryPageParam queryPageParam){
        HashMap param=queryPageParam.getParam();
        String username=(String)param.get("username");
        Page<User> page=new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getUsername,username);

        IPage result=iUserService.pageA(page,lambdaQueryWrapper);
        System.out.println("total==="+result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listPageC")
    public Result listPageC(@RequestBody QueryPageParam queryPageParam){
        HashMap param=queryPageParam.getParam();
        String username=(String)param.get("username");
        Page<User> page=new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        IPage result=iUserService.pageC(page);
        System.out.println("total==="+result.getTotal());

        return Result.success(result.getTotal(),result.getRecords());
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User dbuser=iUserService.login(user);
        return dbuser==null?Result.error():Result.success(1L,dbuser);
    }
}
