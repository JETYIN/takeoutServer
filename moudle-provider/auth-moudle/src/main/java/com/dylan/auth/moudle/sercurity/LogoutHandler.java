package com.dylan.auth.moudle.sercurity;

import com.dylan.common.pojo.WrapMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 此类用于配置登出成功策略--默认的登出成功配置
 */
@Slf4j
public class LogoutHandler implements LogoutSuccessHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("****LogoutHandler onLogoutSuccess,logout successed");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(WrapMapper.ok("退出成功")));
    }
}
