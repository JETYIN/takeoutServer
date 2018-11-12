package com.dylan.auth.moudle.sercurity;

import com.dylan.common.constant.IAuthSecurityConstans;
import com.dylan.common.vo.usermoudle.RoleVo;
import com.dylan.common.vo.usermoudle.UserVo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 *
 */
@Slf4j
public class UserDetailsImpl implements UserDetails {
    private Integer userId;
    private String username;
    private String password;

    private String name;
    private String address;
    private List<RoleVo> roleList;
    //fixme 以上信息将会返回在对应的json中


    public UserDetailsImpl(UserVo userVo) {//fixme 提供给UserDetailsServiceImpl中数据可查到数据并实例化数据

        //以下参数将会出现在token中
        this.userId = userVo.getUserId();
        this.username = userVo.getUsername();
        this.name = userVo.getName();
        this.address = userVo.getAddress();
        this.password = userVo.getPassword();
        this.roleList = userVo.getRoleList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {//fixme 获取权限信息
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (RoleVo role : roleList) {
            authorityList.add(new SimpleGrantedAuthority(role.getRoleCode()));//fixme roleCode是数据库中的类似"role_admin"的字段
        }
        // authorityList.add(new SimpleGrantedAuthority(IAuthSecurityConstans.BASE_ROLE_USER));//fixme 此处设置haspermission中的数据,加入基本的角色类型
        return authorityList;
    }


    @Override
    public String getPassword() {//fixme 获取密码
        return password;
    }

    @Override
    public String getUsername() {//fixme 获取用户名
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {//fixme 判断账号是否过期
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {//fixme 判断账号是否被锁定

        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {//fixme 判断密码是否过期

        return true;
    }

    @Override
    public boolean isEnabled() {//fixme 判断账号是否可用（比如是否被删除）

        return true;
    }
}
