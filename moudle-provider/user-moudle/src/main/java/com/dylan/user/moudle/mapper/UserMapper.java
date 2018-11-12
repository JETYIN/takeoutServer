package com.dylan.user.moudle.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dylan.common.vo.usermoudle.UserVo;
import com.dylan.user.moudle.modle.entity.UserEntity;

public interface UserMapper extends BaseMapper<UserEntity> {

    /***
     * 使用用户名查询用户信息
     * @param username
     * @return
     */
    UserVo selectUserVoByUsername(String username);//fixme 徐鹤数据库映射类中的字段对应统一
}
