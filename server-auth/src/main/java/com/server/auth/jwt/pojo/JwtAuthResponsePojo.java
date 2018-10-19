package com.server.auth.jwt.pojo;

import java.io.Serializable;

/***
 * jwt返回类
 */
public class JwtAuthResponsePojo implements Serializable {
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthResponsePojo(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
