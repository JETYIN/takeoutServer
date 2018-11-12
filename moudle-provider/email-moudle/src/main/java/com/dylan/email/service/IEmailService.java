package com.dylan.email.service;

import com.dylan.email.dto.EmailMessageDto;

/***
 * 用于发送邮件：修改密码成功发送邮件、登录成功发送邮件
 */
public interface IEmailService {
    /**
     * 用户重置密码后发送邮件--重置密码后将发送到对应的email地址一封邮件
     *
     * @param email
     */
    void sendRestPasswordEmail(String email);

    /**
     * 发送验证码--验证码登录
     *
     * @param sendEmailMessage :信息主体
     * @param loginName        :登录名
     */
    void sendAuthCodeEmail(EmailMessageDto sendEmailMessage, String loginName);

    /**
     * 发送检验验证码邮--用于用户修改密码时使用
     *
     * @param sendEmailMessage
     * @param loginName
     */

    void sendCheckAuthCodeEmail(EmailMessageDto sendEmailMessage, String loginName);

}
