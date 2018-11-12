package com.dylan.auth.moudle.services;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;
import java.util.Set;

/**
 * 此类用户支撑权限判断
 */
@Slf4j
public class SecurityUtils {

    private static String AUTH_LOGIN_AFTER_URL = "/user/loginAfter";
    private static String AUTH_LOGOUT_URL = "/user/logout";

    /**
     * 获取当前登录的用户名
     *
     * @return
     */
    public static String getCurrentLoginName() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {

            return ((UserDetails) principal).getUsername();

        }

        if (principal instanceof Principal) {

            return ((Principal) principal).getName();

        }

        log.info("SecurityUtils getCurrentLoginName:" + String.valueOf(principal));
        return String.valueOf(principal);

    }

    /**
     * @return
     */
    public static Set<String> getCurrentAuthorityUrl() {
        Set<String> path = Sets.newHashSet();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();//fixme 获取用户权限信息对象GrantedAuthority
        for (final GrantedAuthority authority : authorities) {
            String url = authority.getAuthority();//fixme authority.getAuthority()获取用户权限描述信息
            if (StringUtils.isNotEmpty(url)) {
                path.add(url);//fixme 获取到的url
            }
        }
        path.add(AUTH_LOGIN_AFTER_URL);
        path.add(AUTH_LOGOUT_URL);
        log.info("SecurityUtils getCurrentAuthorityUrl:" + path.size());
        return path;
    }
}
