package com.springboot.springbootmybatisplus.controller;

import com.springboot.springbootmybatisplus.Bean.Result;
import com.springboot.springbootmybatisplus.Bean.User;
import com.springboot.springbootmybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author liuxiang
 * @since 2020-07-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    // 用户注册
    @PostMapping(value = "/register")
    public Result regist(@RequestBody User user) {
        return userService.regist(user);
    }

    // 用户登录
    @PostMapping(value = "/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }
}
