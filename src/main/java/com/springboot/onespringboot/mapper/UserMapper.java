package com.springboot.onespringboot.mapper;

import com.springboot.onespringboot.bean.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    User findUserByName(String username);

    void regist(User user);

    User login(User user);
}
