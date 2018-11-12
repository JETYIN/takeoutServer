package com.dylan.common.vo.usermoudle;


import lombok.Data;

import java.io.Serializable;

/***
 * 当前登录用户名的角色信息:如（普通员工、管理层）
 */
@Data
public class RoleVo implements Serializable {


    private int roleId;
    private String roleName;
    private String roleCode;
    private String roleDesc;
    private int del_flag;

}
