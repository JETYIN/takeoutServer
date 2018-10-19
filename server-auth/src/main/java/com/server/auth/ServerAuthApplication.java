package com.server.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication//fixme 不能再在其中指定数据源类别，否则报错不能启动
@EnableTransactionManagement//fixme 事务，启用后可在sevices层对数据库操作进行事务处理
@ComponentScan(basePackages = {"com.server.auth.config", "com.server.auth.controller", "com.server.auth.services"})
@EnableSwagger2  //开启使用swagger2
@EnableDiscoveryClient
public class ServerAuthApplication {//fixme 使用JWT管理系统认证

    public static void main(String[] args) {
        SpringApplication.run(ServerAuthApplication.class, args);
    }
}
