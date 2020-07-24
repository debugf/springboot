package com.springboot.onespringboot.mapper;

import com.springboot.onespringboot.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    User findUserByName(String username);

    void regist(User user);

    User login(User user);

    List<User> findUserList();

    User getUser(int id);

    int delUser(int id);

    int putUser(@Param("id") int id, @Param("user") User user);


}
