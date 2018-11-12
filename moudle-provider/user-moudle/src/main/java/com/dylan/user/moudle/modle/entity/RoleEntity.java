package com.dylan.user.moudle.modle.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/***
 * 当前登录用户名的角色信息:如（普通员工、管理层）
 */
@Data
@TableName("tk_role")
@Alias(value = "roleVo")
public class RoleEntity extends Model<RoleEntity> implements Serializable {


    @TableId(value = "role_id", type = IdType.AUTO)
    private int roleId;

    @TableField("role_name")
    private String roleName;
    @TableField("role_code")
    private String roleCode;
    @TableField("role_desc")
    private String roleDesc;

    @TableField("del_flag")
    private int del_flag;

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}
