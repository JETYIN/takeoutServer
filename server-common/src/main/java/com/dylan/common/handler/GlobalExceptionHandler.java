package com.dylan.common.handler;

import com.dylan.common.bean.ServerExceptionBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice//fixme 全局异常，可供其他moudle引入,用于网关处
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ServerExceptionBean exception(Exception e) {
        log.error("this global exception occur", e.getMessage(), e);
        return new ServerExceptionBean<>(e);
    }
}
