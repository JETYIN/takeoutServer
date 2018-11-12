package com.dylan.auth.moudle.feign;

import com.dylan.auth.moudle.feign.fallback.UserFeignApiServiceFallBack;

import com.dylan.common.vo.usermoudle.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-moudle", fallback = UserFeignApiServiceFallBack.class)
public interface IUserFeignApiService {//fixme 提供当前鉴权模块登录用户信息

    /***
     *授权服务从用户服务模块获取当前的用户信息
     * @param username
     * @return
     */

    @GetMapping(value = "/user/findUserByUsername/{username}")
    UserVo findUserByUsername(@PathVariable("username") String username);

}

