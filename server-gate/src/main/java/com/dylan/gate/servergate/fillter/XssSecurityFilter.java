package com.dylan.gate.servergate.fillter;

import com.dylan.common.filter.XssHttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * XSS攻击过滤器--防止用户输入时注入恶意脚本
 */
@Slf4j
@Component
public class XssSecurityFilter extends OncePerRequestFilter {//fixme 只执行一次的filter

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        log.info("doFilterInternal xss script filter");
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(httpServletRequest);//fixme common模块中的对于xss模块的封装
        filterChain.doFilter(xssRequest, httpServletResponse);
    }
}
