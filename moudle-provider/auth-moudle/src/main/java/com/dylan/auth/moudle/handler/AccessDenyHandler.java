package com.dylan.auth.moudle.handler;


import com.dylan.common.bean.http.RespBean;
import com.dylan.common.constant.IAuthSecurityConstans;
import com.dylan.common.constant.ICommonConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 * 授权失败处理类--oauth
 */
@Slf4j
@Component
public class AccessDenyHandler extends OAuth2AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
        log.error("AccessDenyHandler auth failed");
        response.setCharacterEncoding(ICommonConstants.UTF8);
        response.setContentType(ICommonConstants.CONTENT_TYPE);

        RespBean respBean = RespBean.error(IAuthSecurityConstans.CODE_NEED_TO_AUTH, IAuthSecurityConstans.ERROR_AUTH_FAILED_MESSAGE);//授权失败，禁止访问-401

        PrintWriter out = response.getWriter();
        out.write(objectMapper.writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
