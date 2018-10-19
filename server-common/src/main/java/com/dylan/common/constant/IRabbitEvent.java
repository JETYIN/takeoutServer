package com.dylan.common.constant;

//fixme 配置消息队列名称，键值与发送消息与接收消息应对应
public interface IRabbitEvent {//fixme 用于统一配置rabbitmq的消息键值


    /**
     * 日志系统
     **/

    String LOG_EVENT_MQ = "log_event_mq";


    /**
     * 路由系统
     **/

    String ROUTE_EVENT_MQ = "route_event_mq";



}
