package com.dylan.auth.moudle.sercurity;

import com.dylan.auth.moudle.feign.IUserFeignApiService;
import com.dylan.common.vo.usermoudle.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

/**
 * 查询角色信息:前端登录后的用户名将会进入loadUserByUsername，根据此用户名查询到数据库对应的用户信息
 */
@Slf4j
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    public IUserFeignApiService iUserFeignApiService; //用户服务中心获取的用户信息

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {//fixme 登录用户名--前端发起登录时进入此处,将用此用户名去数据库查询对应信息
        log.info("UserDetailsServiceImpl loadUserByUsername,userName:" + userName);
        UserVo userVo = iUserFeignApiService.findUserByUsername(userName);
        if (null == userVo) {
            throw new UsernameNotFoundException("用户名不存在或者密码错误");
        }
        return new UserDetailsImpl(userVo);
    }
}
