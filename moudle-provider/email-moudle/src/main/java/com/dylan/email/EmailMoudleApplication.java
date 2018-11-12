package com.dylan.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/****
 * 此类使用Freemaker创建email服务--发送email
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EmailMoudleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailMoudleApplication.class, args);
    }


}
