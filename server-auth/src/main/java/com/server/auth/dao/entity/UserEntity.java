package com.server.auth.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/****
 * 数据库中对应的用户属性字段
 */
@Data
@TableName("dy_user_table")    //数据库表名--全为小写
@ApiModel(value = "登录用户信息")
public class UserEntity extends Model implements Serializable {

    //swagger2接口说明注解

    @ApiModelProperty(value = "用户名")
    public String user_name;
    //密码
    @ApiModelProperty(value = "用户密码")
    public String user_password;
    //编号
    @ApiModelProperty(value = "用户编号")
    public String user_no;

    //id
    @ApiModelProperty(value = "用户id")
    public String id;
    //名字
    @ApiModelProperty(value = "用户名字")
    public String name;
    //年龄
    @ApiModelProperty(value = "用户年龄")
    public Integer age;
    //地址
    @ApiModelProperty(value = "用户地址")
    public String address;
    //邮箱
    @ApiModelProperty(value = "用户email")
    public String email;
    //电话
    @ApiModelProperty(value = "用户电话号码")
    public String phone;

    //性别
    @ApiModelProperty(value = "用户性别")
    public String sex;
    //当前状态--0离开 1.在职
    @ApiModelProperty(value = "用户状态（在职、离职）")
    public Integer status;

    //描述
    @ApiModelProperty(value = "用户描述")
    public String description;

    //额外的其他描述项
    @ApiModelProperty(value = "用户类型")
    public String type;
    @ApiModelProperty(value = "用户属性")
    public String attr;
    @ApiModelProperty(value = "其他")
    public String other;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
