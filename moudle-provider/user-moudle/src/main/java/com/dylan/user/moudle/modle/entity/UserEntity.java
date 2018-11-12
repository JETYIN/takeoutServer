package com.dylan.user.moudle.modle.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库表名隐射
 */

@Data
@TableName("tk_user")   //fixme 对应数据库表名
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
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
    private String password;
    /****
     * 电话
     */
    private String phone;
    /**
     * 固定电话
     */
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
    @TableField("dept_id")
    private int deptId;
    /**
     * 其他说明
     */
    private String remark;
}
