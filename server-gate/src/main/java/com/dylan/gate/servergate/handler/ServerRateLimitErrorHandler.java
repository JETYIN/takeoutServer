package com.dylan.gate.servergate.handler;


import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.DefaultRateLimiterErrorHandler;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/****
 * 单一节点在一定时间内多次访问网关异常处理--单位时间限流与降级处理:分布式限流配额--properties中配置
 */
@Slf4j
@Configuration
public class ServerRateLimitErrorHandler {

    @Bean
    public RateLimiterErrorHandler rateLimiterErrorHandler() {

        return new DefaultRateLimiterErrorHandler() {

            @Override
            public void handleError(String msg, Exception e) {
                log.error("RateLimiterErrorHandler handleerror,message:" + msg);
                super.handleError(msg, e);
            }

            @Override
            public void handleFetchError(String key, Exception e) {
                log.error("RateLimiterErrorHandler handleFetchError,key:" + key);
                super.handleFetchError(key, e);
            }

            @Override
            public void handleSaveError(String key, Exception e) {
                log.error("RateLimiterErrorHandler handleSaveError,key:" + key);
                super.handleSaveError(key, e);
            }
        };
    }

    @Bean
    public RateLimitKeyGenerator rateLimitKeyGenerator() {

        return new RateLimitKeyGenerator() {
            @Override
            public String key(HttpServletRequest httpServletRequest, Route route, RateLimitProperties.Policy policy) {
                log.error("rateLimitKeyGenerator invoke");
                return null;
            }
        };
    }
}
