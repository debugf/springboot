package com.springboot.onespringboot.controller;

import com.springboot.onespringboot.annotation.UserLoginToken;
import com.springboot.onespringboot.bean.Result;
import com.springboot.onespringboot.bean.User;
import com.springboot.onespringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @UserLoginToken
    @PostMapping(value = "/register")
    public Result regist(@RequestBody User user){
            return userService.regist(user);
    }

    @PostMapping(value = "/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }



}
