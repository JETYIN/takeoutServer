package com.dylan.auth.moudle.config;

import com.dylan.common.constant.IAuthSecurityConstans;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/****
 * 此类用于配置自定义的表单登录--前端接口/login/form
 */

@Component
public class AuthFormSecurityConfig {

    protected final AuthenticationSuccessHandler authenticationSuccessHandler;//fixme PcAuthenticationFailureHandler类中实现并生成token

    /**
     * The Pc authentication failure handler.
     */
    protected final AuthenticationFailureHandler authenticationFailureHandler;//fixme 同上，都来自与paascloud-provider-uac

    /**
     * 因为在java中是先执行构造方法，可以在构造方法中针对需求的参数做Autowired自动装配
     *
     * @param authenticationSuccessHandler
     * @param authenticationFailureHandler
     */
    @Autowired
    public AuthFormSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler, AuthenticationFailureHandler authenticationFailureHandler) {

        this.authenticationFailureHandler = authenticationFailureHandler;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    /***
     * 留于认证服务器中调用
     * @param http
     */
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(IAuthSecurityConstans.DEFAULT_UNAUTHENTICATION_URL)//authentication/require
                .loginProcessingUrl(IAuthSecurityConstans.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)///login/form fixme 前端配置的表单登录地址/auth/form
                .successHandler(authenticationSuccessHandler)//fixme 登录成功处理--生成token
                .failureHandler(authenticationFailureHandler);//fixme 登录失败处理

    }
}
