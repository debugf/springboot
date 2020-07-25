package com.springboot.onespringboot.service;

import com.springboot.onespringboot.bean.Result;
import com.springboot.onespringboot.bean.User;
import com.springboot.onespringboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
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

    public Result userList(String username, String email, int startIndex, int pageSize){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            int pageNumber =(startIndex - 1) * pageSize;
            List<User> userList = userMapper.findUserList(username,email,pageNumber,pageSize);
            result.setMsg("查询成功");
            result.setDetail(userList);
            result.setSuccess(true);

        } catch (RuntimeException e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result getUser(int id){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User user = userMapper.getUser(id);
            if(user == null){
                result.setMsg("用户不存在");
            }else{
                userMapper.regist(user);
                result.setMsg("查询成功");
                result.setSuccess(true);
                result.setDetail(user);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result delUser(int id){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            int rows = userMapper.delUser(id);
            if(rows == 1){
                result.setMsg("删除成功");
                result.setSuccess(true);
            }else {
                result.setMsg("用户不存在");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result putUser(int id, User user){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            int rows = userMapper.putUser(id, user);
            if (rows == 1){
                result.setMsg("修改成功");
                result.setDetail(user);
            }else {
                result.setMsg("用户不存在");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


}
