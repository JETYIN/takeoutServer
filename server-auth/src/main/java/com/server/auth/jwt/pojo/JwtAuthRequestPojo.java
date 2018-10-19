package com.server.auth.jwt.pojo;

import java.io.Serializable;

/****
 * 登录请求的数据封装
 */
public class JwtAuthRequestPojo implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;//对应请求参数json字段
    private String password;


    public JwtAuthRequestPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JwtAuthRequestPojo() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
