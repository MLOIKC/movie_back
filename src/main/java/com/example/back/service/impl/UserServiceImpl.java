package com.example.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.back.entity.User;
import com.example.back.mapper.UserMapper;
import com.example.back.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mloikc
 * @since 2022-12-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        String username = user.getUsername();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username); //select * from login_user where account=xxx
        try{
            User dbuser = getOne(queryWrapper);
            String dbPassword = dbuser.getPassword();
            if(dbPassword.equals(user.getPassword())){
                return dbuser;
            }
        }catch (Exception e){
            log.error("用户不存在或数据库查询异常",e);
        }
        return null;
    }

    @Override
    public IPage pageC(IPage<User> page) {
        return userMapper.pageC(page);
    }

    @Override
    public IPage pageA(IPage<User> page, Wrapper wrapper) {
        return userMapper.pageA(page,wrapper);
    }
}
