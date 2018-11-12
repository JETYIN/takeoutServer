package com.dylan.gate.servergate.fillter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * 限流过滤类--结合redis创建两个key，一个计时，一个计数
 */
@Slf4j
@Component
public class RateLimitFillter extends ZuulFilter {

    private final RateLimiter rateLimiter = RateLimiter.create(1000.0);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {//越小优先级高，最高优先级
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public boolean shouldFilter() {//可在此处设置一个限流开关。开启限流返回ture，关闭返回false
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("RateLimiter zuulFilter run");
        try {
            RequestContext requestContext = RequestContext.getCurrentContext();
            
            HttpServletResponse response = requestContext.getResponse();
            if (!rateLimiter.tryAcquire()) {
                log.info("!ratelimiter.tryAcquire");
                HttpStatus httpStatus = HttpStatus.TOO_MANY_REQUESTS;


                response.setContentType(MediaType.TEXT_PLAIN_VALUE);

                response.setStatus(httpStatus.value());

                response.getWriter().append(httpStatus.getReasonPhrase());


                requestContext.setSendZuulResponse(false);


                throw new ZuulException(

                        httpStatus.getReasonPhrase(),

                        httpStatus.value(),

                        httpStatus.getReasonPhrase()

                );

            }

        } catch (Exception e) {
            ReflectionUtils.rethrowRuntimeException(e);
        }
        return null;
    }
}
