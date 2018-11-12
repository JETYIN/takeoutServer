package com.dylan.common.vo.usermoudle;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库表名隐射
 */

@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 用户id
     */
    private int userId;

    /**
     * 名字
     */
    private String name;
    /****
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    @JsonIgnore //fixme 对应返回给前端的接口将不会包含此字段
    private String password;
    /****
     * 电话
     */
    @JsonIgnore
    private String phone;
    /**
     * 固定电话
     */
    @JsonIgnore
    private String telephone;
    /**
     * 地址
     */
    private String address;

    /**
     * 标注:数据库默认为1
     */
    private int enabled;
    /****
     * 头像地址
     */
    private String avatar;
    /***
     * 部门id
     */
    private int deptId;
    /**
     * 其他说明
     */
    private String remark;
    /**
     * 角色列表
     */
    private List<RoleVo> roleList;//fixme 当前用户的角色列表
}
