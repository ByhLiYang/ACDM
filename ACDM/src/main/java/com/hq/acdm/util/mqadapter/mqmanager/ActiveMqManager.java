package com.hq.acdm.util.mqadapter.mqmanager;


import com.hq.acdm.util.mqadapter.MyMessageListenerContainer;

import com.hq.acdm.util.StringUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/***
 * ACTIVE MQ 管理类
 */
@Component("ActiveMqManager")
public class ActiveMqManager extends BaseMqManager implements IMqManager ,IPublish{
    private Logger logger = LoggerFactory.getLogger(ActiveMqManager.class);

    ActiveMqManager(@Value("${spring.activemq.broker-url:failover:(tcp://192.168.100.182:61616,tcp://192.168.100.183:61616,tcp://192.168.100.184:61616)?initialReconnectDelay=1000}")
                                String amqurl,
                        @Value("${spring.activemq.user:admin}")
                                String amqusername,
                        @Value("${spring.activemq.password:admin}")
                                String amqpassword,
                        @Value("${spring.activemq.receive-qname}")
                                String amqrevqname,
                        @Value("${spring.activemq.send-qname:ACDM.TO.AGDIS.TASK.TST}")
                                String amqsdqname,
                        @Value("${spring.activemq.transaction:false}")
                                boolean transaction,
                        @Value("${spring.activemq.transactionMode:2}")
                                int transactionMode,
                        @Value("${spring.activemq.topicNames:}")
                                String amqtopname) {
        this.amqurl = amqurl;
        this.amqusername = amqusername;
        this.amqpassword = amqpassword;
        this.amqrevqname = amqrevqname;
        this.amqsdqname = amqsdqname;
        this.transaction = transaction;
        this.transactionMode = transactionMode;
        this.amqtopname = amqtopname;

    }

    private String amqurl;
    private String amqusername;
    private String amqpassword;
    private String amqrevqname;
    private String amqsdqname;
    private boolean transaction;
    private int transactionMode;
    //接收主题字符串
    private String amqtopname;
    //发主题
    protected Map<String,Topic> sendTopicMap;
    //接受主题
    protected Topic revTopic;

    public Topic getRevTopic() {
        if (revTopic == null && StringUtil.isNotEmpty(amqtopname)){
            this.revTopic = new ActiveMQTopic(amqtopname);
        }
        return this.revTopic;
    }

    public Topic getSendTopic(String sendTopicName) {
        if(sendTopicMap==null){
            sendTopicMap=new HashMap<>();
        }
        if(sendTopicMap.containsKey(sendTopicName)){
            return sendTopicMap.get(sendTopicName);
        }else{
            if (StringUtil.isNotEmpty(sendTopicName)){
                ActiveMQTopic topic= new ActiveMQTopic(sendTopicName);
                sendTopicMap.put(sendTopicName,topic);
                return topic;
            }
            return null;
        }

    }


    @Override
    public QueueConnectionFactory getQueueConnectionFactory() {
        if (queueConnectionFactory == null){
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
            activeMQConnectionFactory.setBrokerURL(amqurl);
            activeMQConnectionFactory.setUserName(amqusername);
            activeMQConnectionFactory.setPassword(amqpassword);
            queueConnectionFactory = activeMQConnectionFactory;
        }
        return queueConnectionFactory;
    }

    @Override
    protected CachingConnectionFactory getCachingConnectionFactory() {
        if (cachingConnectionFactory == null && this.getQueueConnectionFactory() != null){
            this.setCachingConnectionFactory(super.createCachingConnectionFactory(queueConnectionFactory));
        }
        return cachingConnectionFactory;
    }

    @Override
    public Queue getRevQueue() {
        if (revQueue == null && StringUtil.isNotEmpty(amqrevqname)){
            this.revQueue = new ActiveMQQueue(amqrevqname);
        }
        return this.revQueue;
    }

    @Override
    public Queue getSendQueue() {
        if (sendQueue == null && StringUtil.isNotEmpty(amqsdqname)){
            this.sendQueue = new ActiveMQQueue(amqsdqname);
        }
        return this.sendQueue;
    }


    @Override
    @Resource(name="AMQListener")
    public void setMessageListener(MessageListener messageListener) {
        super.setMessageListener(messageListener);
    }

    @Override
    public QueueConnection getQueueConnection() {
        if (this.queueConnection==null){
            this.setQueueConnection(super.createQueueConnection(transaction,transactionMode));
        }
        return queueConnection;
    }

    /**
     * 获得接收消息的JMS操作类
     */
    @Override
    public JmsOperations getReceiverJmsOperator() {
        return this.getReceiverJmsOperator(this.transaction,this.transactionMode);
    }

    public void sendMsg(Destination destination, TextMessage msg) {
        this.getSenderJmsOperator().convertAndSend(destination, msg);
    }

    /**
     * send msg to queue.
     * @param data
     */
    public void sendToQueue(String qName,String data) {
        amqsdqname=qName;
        TextMessage message = new ActiveMQTextMessage();
        try {
            message.setText(data);
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sendMsg(this.getSendQueue(), message);
    }

    /**
     * send msg to topic.
     * @param data
     */
    @Override
    public void publish(String topName,String data) {
        //amqtopname=topName;
        TextMessage message = new ActiveMQTextMessage();
        try {
            message.setText(data);
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sendMsg(this.getSendTopic(topName), message);
    }


    /**
     * create by: Wang Xieqin
     * description:创建监听容器
     * create time: 17:02 2018/10/31
     *
     * @Param: isTransactionOn 事务是否开启
     * @return 监听容器
     */
    @Override
    public DefaultMessageListenerContainer getDefaultMessageListenerContainer(){
        if (this.defaultMessageListenerContainer == null){
            this.setDefaultMessageListenerContainer(this.createDefaultMessageListenerContainer(this.transaction,this.transactionMode));
        }
        return this.defaultMessageListenerContainer;
    }
    @Override
    protected DefaultMessageListenerContainer createDefaultMessageListenerContainer(boolean isTransactionOn, int mode) {
        System.out.println("111111111111");
        if (this.getQueueConnectionFactory() != null &&
                this.getMessageListener() != null &&
                (this.getRevTopic() != null||this.getRevQueue()!=null)){
            defaultMessageListenerContainer = new MyMessageListenerContainer();
            defaultMessageListenerContainer.setConnectionFactory(this.getCachingConnectionFactory());
            defaultMessageListenerContainer.setDestination(this.getRevTopic()!=null?this.getRevTopic():this.getRevQueue());
            defaultMessageListenerContainer.setMessageListener(this.getMessageListener());
            defaultMessageListenerContainer.setSessionTransacted(isTransactionOn);
            defaultMessageListenerContainer.setSessionAcknowledgeMode(mode);
            //根据线程池最大值来限定Container收消息的大小
            defaultMessageListenerContainer.setConcurrency("1-"+ ((ThreadPoolExecutor)executorService).getMaximumPoolSize());
            //缓存连接
            defaultMessageListenerContainer.setCacheLevel(1);
            defaultMessageListenerContainer.setTaskExecutor(executorService);
            defaultMessageListenerContainer.setMaxMessagesPerTask(1);
            return defaultMessageListenerContainer;
        }else{
            return null;
        }
    }

}
