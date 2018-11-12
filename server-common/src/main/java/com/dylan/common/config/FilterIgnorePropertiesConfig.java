package com.dylan.common.config;


import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置security需要过滤的url
 */
@Data
@Configuration
@ConditionalOnExpression("!'${ignore}'.isEmpty()")
@ConfigurationProperties(prefix = "ignore") //获取配置中开头为ignore的属性
public class FilterIgnorePropertiesConfig {


    List<String> filterUrls = new ArrayList<>();//需要过滤的url集合--和yml中的字段对应ignore.filterUrls
}
