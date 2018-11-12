package com.dylan.auth.moudle.utils;

import com.dylan.auth.moudle.sercurity.UserDetailsImpl;
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

/***
 * 返回前端验证后的信息
 */
@Slf4j
public class UserUtils {

    public static UserDetailsImpl getCurrentHr() {//获取UserVo中返回的用户信息
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 获取当前登录的用户名
     *
     * @return
     */
    public static String getCurrentLoginName() {

        return ((UserDetails) getCurrentHr()).getUsername();

    }

    /**
     * 获取用户的权限列表--项目放入的是role——code类似:ROLE_ADMIN
     *
     * @return
     */
    public static Set<String> getCurrentAuthorityUrl() {
        Set<String> path = Sets.newHashSet();
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();//fixme 获取用户权限信息对象GrantedAuthority
        for (final GrantedAuthority authority : authorities) {
            String roleCode = authority.getAuthority();//fixme authority.getAuthority()获取用户权限描述信息
            if (StringUtils.isNotEmpty(roleCode)) {
                path.add(roleCode);
            }
        }
        log.info("SecurityUtils getCurrentAuthorityUrl:" + path.size());
        return path;
    }
}
