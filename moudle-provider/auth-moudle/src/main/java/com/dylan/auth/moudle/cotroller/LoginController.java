package com.dylan.auth.moudle.cotroller;

import com.dylan.common.bean.http.RespBean;
import com.dylan.common.constant.IAuthSecurityConstans;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/****
 * 用于配合websecurityConfig配合使用
 */
@RestController
@RequestMapping("/authentication")
public class LoginController {
    /**
     * 前端未授权时将会返回此错误
     *
     * @return
     */
    @RequestMapping("/require")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public RespBean login() {
        return RespBean.error(IAuthSecurityConstans.ERROR_NOT_LOGIN_MESSAGE);//尚未登录
    }


}
