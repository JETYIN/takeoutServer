package com.dylan.email.service.impl;

import com.dylan.email.dto.EmailMessageDto;
import com.dylan.email.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

/***
 * 用于实现IEmailService:当用户触发某些敏感信息后发送邮件(用户重置密码),重新templates中的模板网页
 */
@Slf4j
@Service
public class EmailServiceImpl implements IEmailService {

    @Value("${dylan.auth.rest-pwd-url}")
    private String resetPwdUrl;//fixme 包含修改密码url

    @Override
    public void sendRestPasswordEmail(String email) {

    }

    @Override
    public void sendAuthCodeEmail(EmailMessageDto sendEmailMessage, String loginName) {

    }

    @Override
    public void sendCheckAuthCodeEmail(EmailMessageDto sendEmailMessage, String loginName) {

    }
}
