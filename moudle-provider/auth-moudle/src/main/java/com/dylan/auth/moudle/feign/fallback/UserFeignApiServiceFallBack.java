package com.dylan.auth.moudle.feign.fallback;


import com.dylan.auth.moudle.feign.IUserFeignApiService;

import com.dylan.common.vo.usermoudle.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserFeignApiServiceFallBack implements IUserFeignApiService {

    @Override
    public UserVo findUserByUsername(String username) {
        log.error("UserFeignApiServiceFallBack findUserByUsername error,user:" + username);
        return null;
    }
}