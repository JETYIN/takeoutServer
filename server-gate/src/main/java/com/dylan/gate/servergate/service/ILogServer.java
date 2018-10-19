package com.dylan.gate.servergate.service;

import com.netflix.zuul.context.RequestContext;

public interface ILogServer {

    void sendLog(RequestContext requestContext);
}
