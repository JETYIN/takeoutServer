package com.dylan.auth.moudle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/***
 * 此模块提供spring security的验证登录方式-jwt生成token
 */
@SpringBootApplication
@EnableSwagger2  //开启使用swagger2
@EnableDiscoveryClient
public class AuthMoudleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthMoudleApplication.class, args);
    }


}
