package com.hq.acdm.util.mqadapter.mqmanager;

import javax.jms.JMSException;

public interface IPublish {
    /**
     * create by: Wang Xieqin
     * description:获得主题发布实例
     * create time: 16:27 2018/9/25
     */
    void publish(String topicName, String message) throws JMSException;
}
