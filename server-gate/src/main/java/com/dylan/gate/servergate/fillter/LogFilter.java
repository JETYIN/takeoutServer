package com.dylan.gate.servergate.fillter;

import com.dylan.gate.servergate.service.ILogServer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/***
 * 统一的异常处理类，日志系统发送消息到消息队列RabbitMq
 */
@Component
public class LogFilter extends ZuulFilter {

    @Autowired
    public ILogServer logServer;

    @Override
    public String filterType() {//fixme 在route和error过滤器之后调用
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {//数字越大，优先级越低
        return FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {//fixme shouldFilter为true会执行下面的run方法
        return true;//fixme 必须过滤
    }

    @Override
    public Object run() throws ZuulException {

        logServer.sendLog(RequestContext.getCurrentContext());//fixme 获取当前的请求上下文状态发送到消息队列
        return null;
    }
}
