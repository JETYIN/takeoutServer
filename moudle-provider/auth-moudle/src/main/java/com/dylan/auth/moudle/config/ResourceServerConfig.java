package com.dylan.auth.moudle.config;

import com.dylan.auth.moudle.handler.AccessDenyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


/***
 * 资源管理服务器--ResourceServerConfigurerAdapter
 */
@Configuration
@EnableResourceServer
@Slf4j
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;
    @Autowired
    private AuthFormSecurityConfig authFormSecurityConfig;
    @Autowired
    private AccessDenyHandler accessDenyHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        log.info("ResourceServerConfig configure HttpSecurity");
        authFormSecurityConfig.configure(http);//fixme 资源服务器中传入参数到配置的表单配置中
        http.headers().frameOptions().disable().and()
                .cors().and()
                //关闭跨站请求防护
                .csrf().disable();



    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {//资源安全配置
        resources.expressionHandler(expressionHandler);
        resources.accessDeniedHandler(accessDenyHandler);
    }

    /***
     * 前端页面--记住我选项
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        return null;
    }

    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }

    /**
     * 密码--加密方式
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
