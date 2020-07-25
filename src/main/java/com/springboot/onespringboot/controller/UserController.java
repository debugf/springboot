package com.springboot.onespringboot.controller;

import com.springboot.onespringboot.annotation.UserLoginToken;
import com.springboot.onespringboot.bean.Result;
import com.springboot.onespringboot.bean.User;
import com.springboot.onespringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.zip.CheckedOutputStream;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 用户注册
    @PostMapping(value = "/register")
    public Result regist(@RequestBody User user){
            return userService.regist(user);
    }

    // 用户登录
    @PostMapping(value = "/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    // 获取用户列表and模糊查询
    @UserLoginToken
    @GetMapping(value = "/list")
    public Result userList(@RequestParam(value="username",required=false) String username,
                           @RequestParam(value="email",required=false) String email,
                           @RequestParam(value="startIndex",required=false) int startIndex,
                           @RequestParam(value="pageSize",required=false) int pageSize){
        return userService.userList(username, email, startIndex, pageSize);
    }

    // 根据id获取单个用户信息
    @UserLoginToken
    @GetMapping(value = "/get/{id}")
    public Result getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    // 根据id删除单个用户信息
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
