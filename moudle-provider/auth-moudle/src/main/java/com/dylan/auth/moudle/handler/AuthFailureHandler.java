package com.dylan.auth.moudle.handler;

import com.dylan.common.bean.http.RespBean;
import com.dylan.common.constant.IAuthSecurityConstans;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * 登录失败处理
 */
@Slf4j
@Component("authFailureHandler")
public class AuthFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        log.error("login failed,message:" + e.getMessage());
        httpServletResponse.setContentType("application/json;charset=utf-8");

        RespBean respBean = RespBean.error(e.getMessage());

        httpServletResponse.setStatus(IAuthSecurityConstans.CODE_INTTER_ERROR);//需要授权

        ObjectMapper om = new ObjectMapper();
        PrintWriter out = httpServletResponse.getWriter();
        out.write(om.writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
