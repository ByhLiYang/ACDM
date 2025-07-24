package com.hq.acdm.util.mqadapter.mqmanager;

import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.QueueConnection;

public interface IMqManager {
    /**
     * 获得一个发送消息的JMS操作类，需要QueueConnectionFactory，CachingConnectionFactory
     */
    JmsOperations getSenderJmsOperator();

    /**
     * 获得接收消息的JMS操作类
     */
    JmsOperations getReceiverJmsOperator();

    /***
     * 获得一个队列连接
     */
    QueueConnection getConnection();

    /***
     * 获得一个监听容器
     */
    DefaultMessageListenerContainer getListenerContainer();
}
