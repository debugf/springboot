package com.springboot.onespringboot.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.springboot.onespringboot.bean.User;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenService {
    public String getToken(User user){
        String token="";
        token= JWT.create().withAudience(user.getUsername())  // 将 username 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
