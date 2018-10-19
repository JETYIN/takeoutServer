package com.server.auth.config;

import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用于处理mybatisplus的分页
 */
@Configuration
public class MybatisPlusConfig {


    @Bean
    public PaginationInterceptor paginationInterceptor() {//fixme 分页插件使用

        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");//fixme 设置方言类型

        return paginationInterceptor;
    }

    /**
     * 数据权限插件
     *
     * @return DataScopeInterceptor
     */
    /*@Bean
    public DataScopeInterceptor dataScopeInterceptor() {
        return new DataScopeInterceptor();
    }*/

    /**
     * 相当于Application入口处顶部的：
     * {@code @MapperScan("com.server.auth.mapper*")}
     * 这里可以扩展，比如使用配置文件来配置扫描Mapper的路径
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.server.auth.dao.mapper*");//设置mapper的扫描路径
        return scannerConfigurer;
    }


    @Bean
    public H2KeyGenerator getH2KeyGenerator() {
        return new H2KeyGenerator();
    }


    /**
     * 性能分析拦截器，不建议生产使用
     */
   /* @Beans
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }*/


}
