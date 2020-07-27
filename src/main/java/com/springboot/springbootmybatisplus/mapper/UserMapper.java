package com.springboot.springbootmybatisplus.mapper;

import com.springboot.springbootmybatisplus.Bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuxiang
 * @since 2020-07-26
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findAllUser();

    User findUserByName(String username);

    void regist(User user);

    User login(User user);

}
