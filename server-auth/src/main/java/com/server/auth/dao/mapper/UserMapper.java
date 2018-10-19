package com.server.auth.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.server.auth.dao.entity.UserEntity;

/**
 * 创建mabtis-plus的mapper层(数据层dao层接口)
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    UserEntity getUserInfoByUserName(String userName);//根据用户名查询用户信息

}
