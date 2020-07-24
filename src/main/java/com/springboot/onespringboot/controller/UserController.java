package com.springboot.onespringboot.controller;

import com.springboot.onespringboot.annotation.UserLoginToken;
import com.springboot.onespringboot.bean.Result;
import com.springboot.onespringboot.bean.User;
import com.springboot.onespringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 用户注册接口
    @PostMapping(value = "/register")
    public Result regist(@RequestBody User user){
            return userService.regist(user);
    }

    // 用户登录接口
    @PostMapping(value = "/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    // 用户列表接口
    @UserLoginToken
    @GetMapping(value = "/list")
    public Result userList(){
        return userService.userList();
    }

    // 根据id获取用户详情接口
    @UserLoginToken
    @GetMapping(value = "/get/{id}")
    public Result getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    // 删除用户接口
    @UserLoginToken
    @DeleteMapping(value = "/delete/{id}")
    public Result delUser(@PathVariable("id") int id){
        return userService.delUser(id);

    }

    // 修改用户信息接口
    @UserLoginToken
    @PutMapping(value = "/update/{id}")
    public Result putUser(@PathVariable("id") int id, @RequestBody User user){
        return userService.putUser(id, user);
    }






}
