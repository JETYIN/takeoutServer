package com.dylan.auth.moudle.service.permission.impl;

import com.dylan.auth.moudle.service.permission.IPermissionService;
import com.dylan.auth.moudle.utils.SecurityUtils;
import com.dylan.common.constant.GloalConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 此类实现权限判断，用于资源中判断
 */

@Slf4j
@Component("permissionService") //fixme 此处声明方便后面进行调用
public class PermissionServiceImpl implements IPermissionService {

    private static final String OAUTH2_CLIENT_PREFIX = "takeout-client-";
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Resource
    private ClientDetailsService clientDetailsService;

    @Override
    public boolean hasPermission(Authentication authentication, HttpServletRequest httpServletRequest) {
        log.info("into PermissionServiceImpl haspermission judge method");
        String loginName = SecurityUtils.getCurrentLoginName();
        log.info("current loginName:" + loginName);
        if (StringUtils.equals(loginName, GloalConstants.Sys.SUPER_MANAGER_LOGIN_NAME)) {//fixme admin为超级管理员，可以任意访问
            return true;
        }
        Set<String> currentAuthorityUrl = SecurityUtils.getCurrentAuthorityUrl();
        String requestURI = httpServletRequest.getRequestURI();//fixme 获取当前请求的url，注意加不加toString()-url有区别

        //fixme 项目中Feign客户端具有所有权限, 如果需要则在角色权限中控制
        if (loginName.contains(OAUTH2_CLIENT_PREFIX)) {
            log.info("loginName contains ");
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(loginName);

            return clientDetails != null;
        }

        for (final String authority : currentAuthorityUrl) {
            // fixme 当url中包含以下字段时放过权限：具体处理按需求进行
            if (requestURI.contains("query") || requestURI.contains("get") || requestURI.contains("check") || requestURI.contains("select")) {
                log.info("current url contains query、get、check、select");
                return true;
            }
            if (antPathMatcher.match(authority, requestURI)) {//fixme 用户url和请求url匹配
                log.info("authority equals requestURI");
                return true;
            }
        }
        log.info("not match any condition,return false");

        return false;
    }
}
