package com.dylan.auth.moudle.services.impl;

import com.dylan.auth.moudle.services.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/***
 * 此类用于权限判断处理
 */
@Slf4j
@Service("permissionServiceImpl")//fixme 用于外部调用
public class PermissionServiceImpl implements IPermissionService {

    //private IMenuFeignApiService menuService;//fixme 获取菜单服务

    private AntPathMatcher antPathMatcher = new AntPathMatcher();// fixme 菜单匹配规则

    private static final String OAUTH2_CLIENT_PREFIX = "takeout-client-";
    @Resource
    private ClientDetailsService clientDetailsService;

    @Override
    public boolean hasPermission(Authentication authentication, HttpServletRequest httpServletRequest) {//fixme userDetail中放入的是Rolecode

        Object principal = authentication.getPrincipal();//获取到当前用户信息
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();//fixme 获取用户权限信息对象

        boolean hasPermission = false;
        if (null != principal) {

            if (grantedAuthorityList.isEmpty()) {//fixme 当角色列表为空返回 false
                log.error("role info is null：{}", authentication.getPrincipal());
                return hasPermission;
            }

        }

        return hasPermission;
    }


}
