package com.springboot.springbootmybatisplus.service.impl;


import com.springboot.springbootmybatisplus.Bean.Result;
import com.springboot.springbootmybatisplus.Bean.User;
import com.springboot.springbootmybatisplus.mapper.UserMapper;
import com.springboot.springbootmybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuxiang
 * @since 2020-07-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenServiceImpl tokenService;

    @Override
    public List<User> findAllUser(){

        return userMapper.findAllUser();
    }

    public Result regist(User user){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User existUser = userMapper.findUserByName(user.getUsername());
            if(existUser != null){
                //如果用户名已存在
                result.setMsg("用户名已存在");
            }else{
                userMapper.regist(user);
                result.setMsg("注册成功");
                result.setSuccess(true);
                Map returnMap = new HashMap();
                returnMap.put("username", user.getUsername());
                returnMap.put("email", user.getEmail());
                result.setDetail(returnMap);
            }
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    public Result login(User user){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            User user1 = userMapper.login(user);
            if (user1 == null){
                result.setMsg("用户名或密码错误");
            }else {
                result.setMsg("登录成功");
                String token = tokenService.getToken(user);
                result.setSuccess(true);
                Map returnMap = new HashMap();
                returnMap.put("id", user1.getId());
                returnMap.put("username", user1.getUsername());
                returnMap.put("token", token);
                result.setDetail(returnMap);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

}

