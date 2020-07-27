package com.springboot.springbootmybatisplus.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.springboot.springbootmybatisplus.Bean.User;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenServiceImpl {
    public String getToken(User user){
        String token="";
        token= JWT.create().withAudience(user.getUsername())  // 将 username 保存到 token 里面
//                .withExpiresAt(new Date(System.currentTimeMillis() + 2 * 60 * 1000))//定义token的有效期
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
