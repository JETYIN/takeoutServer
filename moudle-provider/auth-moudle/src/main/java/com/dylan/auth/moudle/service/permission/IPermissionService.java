package com.dylan.auth.moudle.service.permission;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;


public interface IPermissionService {
    /**判断权限接口
     * HttpServletRequest
     * @param authentication
     * @param httpServletRequest
     * @return
     */
    boolean hasPermission(Authentication authentication, HttpServletRequest httpServletRequest);
}
