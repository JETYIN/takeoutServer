package com.server.auth.exception;


import com.dylan.common.exception.BaseException;
import com.server.auth.jwt.IJwtTokenconstant;

/**
 * 获取userId失败异常
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, IJwtTokenconstant.EX_USER_PASS_INVALID_CODE);
    }
}
