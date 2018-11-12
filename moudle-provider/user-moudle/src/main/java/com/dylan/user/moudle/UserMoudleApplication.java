package com.dylan.user.moudle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 * 用户服务中心:提供用户信息获取及个人信息操作
 */
@EnableTransactionManagement//fixme 事务，启用后可在sevices层对数据库操作进行事务处理
@EnableSwagger2  //开启使用swagger2
@EnableDiscoveryClient
@SpringBootApplication
//@ComponentScan("com.dylan.common.vo.usermoudle")//加扫描必须加上当前包路径
public class UserMoudleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMoudleApplication.class, args);
    }
}
