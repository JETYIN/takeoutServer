package com.dylan.common.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * 作为controller的基类，可以获取用户的token与userId
 */
@Slf4j
public class BaseController {
    @Autowired
    public HttpServletRequest httpServletRequest;
}
