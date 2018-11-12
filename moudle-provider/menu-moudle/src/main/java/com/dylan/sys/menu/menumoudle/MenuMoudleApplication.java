package com.dylan.sys.menu.menumoudle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/****
 * 此模块用于提供服务系统内部的sys、菜单等服务内容
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MenuMoudleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuMoudleApplication.class, args);
    }
}
