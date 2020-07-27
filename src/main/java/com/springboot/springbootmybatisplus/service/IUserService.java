package com.springboot.springbootmybatisplus.service;

import com.springboot.springbootmybatisplus.Bean.Result;
import com.springboot.springbootmybatisplus.Bean.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author liuxiang
 * @since 2020-07-26
 */
public interface IUserService extends IService<User> {

    Result regist(User user);

    Result login(User user);
}
