package com.dylan.auth.moudle.sercurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/***
 * WebSecurityConfigurerAdapter适配器是集成spring security后具有默认登录授权界面的原因，如需自定义登录授权页面，需要重写configure界面
 * 当用户没有登录就去访问受保护资源时，系统会默认请求/login（get方式）
 */
@Slf4j
@Configuration
@EnableWebSecurity //fixme 开启使用websecurity
public class AuthenticationWebConfig extends WebSecurityConfigurerAdapter {//fixme 此处设置自定义登录界面

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("AuthenticationWebConfig configure HttpSecurity");
        //设置受保护的资源方法
        http.formLogin()// 表单登录  来身份认证
                .loginProcessingUrl("/accout/token")// 自定义登录路径,前端请求
                .and()
                .authorizeRequests()// 对请求授权
                // error  127.0.0.1 将您重定向的次数过多
                .antMatchers("/myLogin.html", "/authentication/require",
                        "/authentication/form").permitAll()// 这些页面不需要身份认证,其他请求需要认证
                .anyRequest() // 任何请求
                .authenticated()//; // 都需要身份认证
                .and()
                .csrf().disable();// 禁用跨站攻击

    }


}
