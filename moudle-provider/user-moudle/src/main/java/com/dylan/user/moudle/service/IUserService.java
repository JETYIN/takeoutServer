package com.dylan.user.moudle.service;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dylan.common.vo.usermoudle.UserVo;
import com.dylan.user.moudle.modle.entity.UserEntity;

/***
 * 用户中心用户信息提供接口
 */
public interface IUserService extends BaseMapper<UserEntity> {

    UserVo findUserByUsername(String username);
}
