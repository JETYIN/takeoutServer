package com.server.auth.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.server.auth.exception.UserInvalidException;
import com.server.auth.jwt.JWTInfo;
import com.server.auth.jwt.JsonTokenUtils;
import com.server.auth.jwt.pojo.JwtAuthRequestPojo;
import com.server.auth.dao.entity.UserEntity;
import com.server.auth.dao.mapper.UserMapper;
import com.server.auth.services.IAuthentication;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


/**
 * 验证授权服务生成token--service层应当处理//@Transactional(rollbackFor = Exception.class)--调用获取数据库接口
 */

@Slf4j
@Service
public class AuthenticationImpl extends ServiceImpl<UserMapper, UserEntity> implements IAuthentication {


    @Override
    public String login(JwtAuthRequestPojo jwtAuthRequestPojo) throws Exception {//fixme 生成jwtToken并返回前端:userId先去数据查询，查询到userId信息后则生成token返回
        log.info("auth login and create jwtToken to front web");
        //生成token
        UserEntity userInfo = baseMapper.getUserInfoByUserName(jwtAuthRequestPojo.getUsername());
        if (!StringUtils.isEmpty(userInfo.getId())) {//fixme 数据库正确验证到用户键入信息，生成token返回
            log.info("query data form mysql,id:" + userInfo.getId());
            return JsonTokenUtils.getInstance().generateToken(new JWTInfo(userInfo.getUser_name(), userInfo.getId() + "", userInfo.getName()));//保存token到redis

        }


        throw new UserInvalidException("User does not exist or account password is incorrect!");//抛出异常用户名或密码不正确
    }

    @Override
    public String refreshToken(String oldToken) throws Exception {//fixme token刷新:利用旧token获取到用户信息，然后重新生成新token

        return JsonTokenUtils.getInstance().generateToken(JsonTokenUtils.getInstance().getInfoFromToken(oldToken));

    }

    @Override
    public void invalidToken(String curretnToken) throws Exception {//fixme 令当前token失效

        JsonTokenUtils.getInstance().getInfoFromToken(curretnToken);

    }

    @Override
    public String logout(String token) throws Exception {//fixme：登出，清除缓存中token

        return null;
    }
}
