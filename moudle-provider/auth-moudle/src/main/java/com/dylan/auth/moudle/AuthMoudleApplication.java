package com.dylan.auth.moudle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/***
 * 此模块提供spring security的验证登录方式-jwt生成token
 */
@SpringBootApplication
@EnableSwagger2  //开启使用swagger2
@EnableDiscoveryClient
@EnableFeignClients//fixme 用于服务间通信
@EnableAuthorizationServer //fixme 开启使用oauth2组件
public class AuthMoudleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthMoudleApplication.class, args);
    }


}
