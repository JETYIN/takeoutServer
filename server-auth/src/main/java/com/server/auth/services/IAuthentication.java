package com.server.auth.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.server.auth.dao.entity.UserEntity;
import com.server.auth.jwt.pojo.JwtAuthRequestPojo;

public interface IAuthentication extends IService<UserEntity> {


    String login(JwtAuthRequestPojo jwtLoginRequestPojo) throws Exception;

    String refreshToken(String oldToken) throws Exception;

    void invalidToken(String currentToken) throws Exception;

    String logout(String token) throws Exception;//系统登出，重置token
}
