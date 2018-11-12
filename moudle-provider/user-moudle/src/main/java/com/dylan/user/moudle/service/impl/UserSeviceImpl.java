package com.dylan.user.moudle.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.dylan.common.vo.usermoudle.UserVo;
import com.dylan.user.moudle.mapper.UserMapper;
import com.dylan.user.moudle.modle.entity.UserEntity;
import com.dylan.user.moudle.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/***
 * 实现IUserService接口获取用户信息
 */
@Slf4j
@Service
public class UserSeviceImpl implements IUserService {

    //获取userMapper
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserVo findUserByUsername(String username) {
        log.info("UserSeviceImpl findUserByUsername username:" + username);
        return userMapper.selectUserVoByUsername(username);
    }

    @Override
    public int insert(UserEntity userEntity) {
        return 0;
    }

    @Override
    public int deleteById(Serializable serializable) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> map) {
        return 0;
    }

    @Override
    public int delete(Wrapper<UserEntity> wrapper) {
        return 0;
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> collection) {
        return 0;
    }

    @Override
    public int updateById(UserEntity userEntity) {
        return 0;
    }

    @Override
    public int update(UserEntity userEntity, Wrapper<UserEntity> wrapper) {
        return 0;
    }

    @Override
    public UserEntity selectById(Serializable serializable) {
        return null;
    }

    @Override
    public List<UserEntity> selectBatchIds(Collection<? extends Serializable> collection) {
        return null;
    }

    @Override
    public List<UserEntity> selectByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public UserEntity selectOne(Wrapper<UserEntity> wrapper) {
        return null;
    }

    @Override
    public Integer selectCount(Wrapper<UserEntity> wrapper) {
        return null;
    }

    @Override
    public List<UserEntity> selectList(Wrapper<UserEntity> wrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<UserEntity> wrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<UserEntity> wrapper) {
        return null;
    }

    @Override
    public IPage<UserEntity> selectPage(IPage<UserEntity> iPage, Wrapper<UserEntity> wrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage<UserEntity> iPage, Wrapper<UserEntity> wrapper) {
        return null;
    }
}
