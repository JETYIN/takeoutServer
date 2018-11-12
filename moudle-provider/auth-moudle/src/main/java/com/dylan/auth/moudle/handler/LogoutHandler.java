package com.dylan.auth.moudle.handler;


import com.dylan.common.bean.http.RespBean;
import com.dylan.common.constant.IAuthSecurityConstans;
import com.dylan.common.vo.WrapMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * 此类用于配置登出成功策略--默认的登出成功配置
 */
@Slf4j
@Component
public class LogoutHandler implements LogoutSuccessHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("****LogoutHandler onLogoutSuccess,logout successed");

        RespBean res=RespBean.ok(IAuthSecurityConstans.SUCCESS_LOGOUT_MESSAGE);//退出成功
        PrintWriter out = response.getWriter();
        out.write(objectMapper.writeValueAsString(res));
        out.flush();
        out.close();

    }
}
