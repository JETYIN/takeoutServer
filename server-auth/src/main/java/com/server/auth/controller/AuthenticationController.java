package com.server.auth.controller;

import com.dylan.common.msg.ObjectRestResponse;
import com.dylan.common.pojo.BaseController;
import com.server.auth.jwt.pojo.JwtAuthRequestPojo;
import com.server.auth.services.IAuthentication;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/***
 * 用于支援提供前端调用
 */
@RestController
@RequestMapping("/accout")
@Slf4j
@Transactional(rollbackFor = Exception.class) //fixme 注解配置事务管理--当出现异常将不会网数据库中添加数据
public class AuthenticationController extends BaseController {//fixme 授权中心提供token操作

    @Value("${jwt.token-header}")
    private String tokenHeader;//从properties中获取的属性

    @Autowired
    public IAuthentication iAuthentication;

    //fixme 登录成功返回token与当前用户的菜单选项
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @ApiOperation(value = "POST", notes = "获取token-登录")
    public ObjectRestResponse<String> login(JwtAuthRequestPojo jwtAuthRequestPojo) throws Exception {
        log.info("enter IAuthentication interface");
        String token = iAuthentication.login(new JwtAuthRequestPojo(jwtAuthRequestPojo.getUsername(), jwtAuthRequestPojo.getPassword()));

        return new ObjectRestResponse<>().data(token);//fixme 前端axios中需要对应response.data
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ApiOperation(value = "GET", notes = "刷新tokn")
    public ObjectRestResponse<String> refreshToken(HttpServletRequest httpServletRequest) throws Exception {
        String oldToken = httpServletRequest.getHeader(tokenHeader);//获取请求头中的token信息以获取用户信息进行token刷新
        String refreshToken = iAuthentication.refreshToken(oldToken);
        return new ObjectRestResponse<>().data(refreshToken);

    }

    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    @ApiOperation(value = "GET", notes = "验证token")
    public ObjectRestResponse<?> verify(String token) throws Exception {
        iAuthentication.invalidToken(token);
        return new ObjectRestResponse<>();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ApiOperation(value = "GET", notes = "登出接口")
    public ObjectRestResponse<?> logout(String token) {

        if (!StringUtils.isEmpty(token)) {//已登录的用户，token不为null的状态下
            log.info("token is not null,logout current accout");
            //账户登出，重置状态
        }

        return new ObjectRestResponse<>();
    }
}
