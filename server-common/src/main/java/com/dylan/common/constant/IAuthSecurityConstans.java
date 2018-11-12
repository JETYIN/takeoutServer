package com.dylan.common.constant;

public interface IAuthSecurityConstans {//fixme 权限模块公共参数

    /***
     * 使用协议--生成token时使用
     */
    String DYLAN_LINCE = "made by dylan";


    /**
     * 基础角色
     */
    String BASE_ROLE_USER = "ROLE_USER";


    /**
     * 当请求需要身份认证时，默认跳转的url
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    /**
     * 默认的用户名密码登录请求处理url--前端
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/login/form";

    String HAVE_NO_PERMISSION = "无权限访问";

    String ERROR_NO_PERMISSION = "500";

    int CODE_NEED_TO_AUTH = 401;
    int CODE_INTTER_ERROR = 500;


    String ERROR_AUTH_FAILED_MESSAGE = "授权失败，禁止访问!";
    String ERROR_NOT_LOGIN_MESSAGE = "尚未登录，请登录!";
    String SUCCESS_LOGOUT_MESSAGE = "退出成功";
}
