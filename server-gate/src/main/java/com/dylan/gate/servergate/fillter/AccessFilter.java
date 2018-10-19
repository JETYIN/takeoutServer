package com.dylan.gate.servergate.fillter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * 进入网关处的过滤：当不含有token时，放过当前界面进入获取token界面。当含有token时应检验token是否合法
 */
@Slf4j
@Component

public class AccessFilter extends ZuulFilter {//fixme 把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>


    @Override
    public String filterType() {//fixme 在请求路由前被调用
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {//fixme 为true将会执行run方法

        return true;
    }

    //fixme jwt 的token使用公钥进行解密
    @Override
    public Object run() throws ZuulException {//fixme 网关处安全控制--RequestContext传递数据--网关统一控制当前请求是否有token(未登陆情况)--将登录获取token的地址放过
        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request = ctx.getRequest();
        log.info("enter accessfillter，current url:{}，current methodName：{}", request.getRequestURL(), request.getMethod());
        String accessToken = request.getHeader("accessToken");
        if (StringUtils.isEmpty(accessToken)) {//fixme 不含有token进行到登录界面--登录的url此时未含token，直接放过
            log.error("cuurrent request has not accessToken");
            //使用Zuul来过滤这次请求
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }

        log.info("request has accessed");
        return null;

    }
}
