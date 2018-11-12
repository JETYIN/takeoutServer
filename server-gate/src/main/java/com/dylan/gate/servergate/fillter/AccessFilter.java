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

        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }


}
