package com.dylan.user.moudle.controller;

import com.dylan.common.vo.usermoudle.UserVo;
import com.dylan.user.moudle.modle.entity.UserEntity;
import com.dylan.user.moudle.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    /****
     * 根据当前username查询用户信息
     * @param username
     * @return
     */
    @RequestMapping(value = "/findUserByUsername/{username}", method = RequestMethod.GET)
    public UserVo findUserByUsername(@PathVariable String username) {
        log.info("UserController findUserByUsername username:" + username);
        return userService.findUserByUsername(username);
    }

}
