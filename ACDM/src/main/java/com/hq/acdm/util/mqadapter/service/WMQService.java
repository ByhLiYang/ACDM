package com.hq.acdm.util.mqadapter.service;


import javax.jms.JMSException;

/**
 * @author wangxieqin
 * 接收Websphere MQ消息接口定义
 */
public interface WMQService extends MQService {
    void publish(String topicName, String message) throws JMSException;

}
