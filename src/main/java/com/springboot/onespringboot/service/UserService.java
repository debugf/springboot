package com.springboot.onespringboot.service;

import com.springboot.onespringboot.bean.Result;
import com.springboot.onespringboot.bean.User;
import com.springboot.onespringboot.mapper.UserMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    TokenService tokenService;

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
                result.setDetail(user);
            }
        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result login(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User userc = userMapper.login(user);
            if(userc == null){
                result.setMsg("用户名或密码错误");
            }else {
                result.setMsg("登录成功");
                String token = tokenService.getToken(user);
                result.setSuccess(true);
                Map returnMap = new HashMap();
                returnMap.put("id", userc.getId());
                returnMap.put("token", token);
                result.setDetail(returnMap);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public User findByUsername(String username){
        return userMapper.findUserByName(username);
    }

}
