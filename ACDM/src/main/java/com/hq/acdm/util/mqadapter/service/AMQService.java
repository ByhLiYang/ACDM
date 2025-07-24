package com.hq.acdm.util.mqadapter.service;

import javax.jms.JMSException;

/**
 * @author LiFaQiang
 * @date 2017年10月3日 上午10:08:23
 * 
 */
public interface AMQService extends MQService{
    void publish(String topicName, String message) throws JMSException;

}
