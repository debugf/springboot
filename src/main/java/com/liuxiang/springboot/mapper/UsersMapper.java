package com.liuxiang.springboot.mapper;


import com.liuxiang.springboot.bean.Users;
import org.apache.ibatis.annotations.*;

// 指定这是一个操作数据库的mapper
//@Mapper
public interface UsersMapper {

    @Select("select * from t_user where id=#{id}")
    public Users getUserById(Integer id);

    @Delete("delete from t_user where id=#{id}")
    public int deleteUserById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into t_user(username, password) values(#{username},#{password})")
    public int insertUser(Users users);

    @Update("updata t_user set username=#{username} where id=#{id}")
    public int updataUser(Users users);

}
