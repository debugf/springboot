package com.springboot.onespringboot.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.springboot.onespringboot.bean.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("TokenService")
public class TokenService {
    public String getToken(User user){
        String token="";
        token= JWT.create().withAudience(user.getUsername())  // 将 username 保存到 token 里面
//                .withExpiresAt(new Date(System.currentTimeMillis() + 2 * 60 * 1000))//定义token的有效期
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
