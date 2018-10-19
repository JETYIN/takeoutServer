package com.server.auth.jwt;

import java.io.Serializable;

/**
 * 认证，鉴权用户信息
 */
public class JWTInfo implements Serializable, IJWTInfo {
    private String username; //数据库用户名
    private String userId;//用户id
    private String name;//名称

    public JWTInfo(String username, String userId, String name) {
        this.username = username;
        this.userId = userId;
        this.name = name;
    }

    @Override
    public String getUniqueName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JWTInfo jwtInfo = (JWTInfo) o;

        if (username != null ? !username.equals(jwtInfo.username) : jwtInfo.username != null) {
            return false;
        }
        return userId != null ? userId.equals(jwtInfo.userId) : jwtInfo.userId == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
