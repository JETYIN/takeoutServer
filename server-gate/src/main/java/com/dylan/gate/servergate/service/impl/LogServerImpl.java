package com.dylan.gate.servergate.service.impl;

import com.dylan.gate.servergate.service.ILogServer;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/****
 *网关异常发送到消息队列RabbitMw
 */
@Slf4j
@Component
public class LogServerImpl implements ILogServer {
    @Override
    public void sendLog(RequestContext requestContext) {
        log.error("error occupy,logserver send log to rabbitmq");


    }
}
