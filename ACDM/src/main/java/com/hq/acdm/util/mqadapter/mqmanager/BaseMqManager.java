package com.hq.acdm.util.mqadapter.mqmanager;

import com.hq.acdm.util.mqadapter.MyMessageListenerContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.transaction.PlatformTransactionManager;

import javax.jms.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/***
 * Author: wangxieqin 2018/9/11
 * MQ消息配置类
 */
public abstract class BaseMqManager implements IMqManager {
    private Logger logger = LoggerFactory.getLogger(BaseMqManager.class);

    //连接工厂
    protected QueueConnectionFactory queueConnectionFactory;

    //工厂适配器
    protected UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter;

    //连接池
    protected CachingConnectionFactory cachingConnectionFactory;

    //队列连接
    protected QueueConnection queueConnection;

    //MQ发送操作类
    protected JmsOperations senderJmsOperations;

    //MQ接收操作类
    protected JmsOperations receiverJmsOperations;

    //读队列
    protected Queue revQueue;

    //发队列
    protected Queue sendQueue;

    //消息监听
    protected MessageListener messageListener;

    //事务管理器
    protected PlatformTransactionManager jmsTrasactionManager;

    //监听容器（多线程）
    protected DefaultMessageListenerContainer defaultMessageListenerContainer;


    @Value("${receive-timeout:500}")
    protected long receiveTimeout;

    //线程池
    @Autowired
    ExecutorService executorService;


    protected QueueConnectionFactory getQueueConnectionFactory() {
        return queueConnectionFactory;
    }

    protected void setQueueConnectionFactory(QueueConnectionFactory queueConnectionFactory) {
        this.queueConnectionFactory = queueConnectionFactory;
    }

    protected UserCredentialsConnectionFactoryAdapter getUserCredentialsConnectionFactoryAdapter() {
        return userCredentialsConnectionFactoryAdapter;
    }

    protected void setUserCredentialsConnectionFactoryAdapter(UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter) {
        this.userCredentialsConnectionFactoryAdapter = userCredentialsConnectionFactoryAdapter;
    }

    protected CachingConnectionFactory getCachingConnectionFactory() {
        return cachingConnectionFactory;
    }

    protected void setCachingConnectionFactory(CachingConnectionFactory cachingConnectionFactory) {
        this.cachingConnectionFactory = cachingConnectionFactory;
    }


    protected void setSenderJmsOperations(JmsOperations senderJmsOperations) {
        this.senderJmsOperations = senderJmsOperations;
    }


    protected JmsOperations getSenderJmsOperations() {
        return senderJmsOperations;
    }

    protected void setReceiverJmsOperations(JmsOperations receiverJmsOperations) {
        this.receiverJmsOperations = receiverJmsOperations;
    }

    protected JmsOperations getReceiverJmsOperations() {
        return receiverJmsOperations;
    }


    public Queue getRevQueue() {
        return revQueue;
    }

    public void setRevQueue(Queue revQueue) {
        this.revQueue = revQueue;
    }

    public Queue getSendQueue() {
        return sendQueue;
    }

    public void setSendQueue(Queue sendQueue) {
        this.sendQueue = sendQueue;
    }

    public QueueConnection getQueueConnection() {
        return queueConnection;
    }

    public void setQueueConnection(QueueConnection queueConnection) {
        this.queueConnection = queueConnection;
    }

    public MessageListener getMessageListener() {
        return messageListener;
    }

    public void setMessageListener(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    public PlatformTransactionManager getJmsTrasactionManager() {
        return jmsTrasactionManager;
    }

    public void setJmsTrasactionManager(PlatformTransactionManager jmsTrasactionManager) {
        this.jmsTrasactionManager = jmsTrasactionManager;
    }

    public DefaultMessageListenerContainer getDefaultMessageListenerContainer() {
        return defaultMessageListenerContainer;
    }

    public void setDefaultMessageListenerContainer(DefaultMessageListenerContainer defaultMessageListenerContainer) {
        this.defaultMessageListenerContainer = defaultMessageListenerContainer;
    }

    /***
     * 创建一个工厂适配器
     * @return 工厂适配器
     */
    protected UserCredentialsConnectionFactoryAdapter  createUserCredentialsConnectionFactoryAdapter (String username, String password){
        try{
            if (this.getQueueConnectionFactory() != null){
                UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter = new UserCredentialsConnectionFactoryAdapter();
                userCredentialsConnectionFactoryAdapter.setUsername(username);
                userCredentialsConnectionFactoryAdapter.setPassword(password);
                userCredentialsConnectionFactoryAdapter.setTargetConnectionFactory(this.getQueueConnectionFactory());
                return userCredentialsConnectionFactoryAdapter;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return null;

    }

    /***
     * 创建一个连接池工厂
     * @return
     */
    protected CachingConnectionFactory createCachingConnectionFactory(ConnectionFactory connectionFactory){
        if (connectionFactory != null) {
            cachingConnectionFactory = new CachingConnectionFactory();
            cachingConnectionFactory.setTargetConnectionFactory(connectionFactory);
            cachingConnectionFactory.setSessionCacheSize(500);
            cachingConnectionFactory.setReconnectOnException(true);
            return cachingConnectionFactory;
        }else{
            return null;
        }
    }

    /***
     * 创建一个队列连接
     * @return
     */
    protected  QueueConnection createQueueConnection(boolean isTransactionOn,int mode){
        if (this.getQueueConnectionFactory() != null &&
                this.getMessageListener() != null) {
            try {
                QueueConnection queueConnection = this.getQueueConnectionFactory().createQueueConnection();
                Session session = queueConnection.createSession(isTransactionOn, mode);
                MessageConsumer messageConsumer = session.createConsumer(this.getRevQueue());
                messageConsumer.setMessageListener(this.getMessageListener());
                return queueConnection;
            } catch (Exception ex) {
                logger.error(ex.getMessage(),ex);
            }
        }
        return null;
    }

    /***
     * 创建一个jms操作类，自定义事务
     * @return
     */
    protected JmsOperations createJmsOperations(long receiveTimeout,Queue queue,boolean isTransactionOn,int mode) {
        try {
            JmsTemplate jmsTemplate = (JmsTemplate)createJmsOperations(receiveTimeout,queue);
            jmsTemplate.setSessionTransacted(isTransactionOn);
            jmsTemplate.setSessionAcknowledgeMode(mode);
            return jmsTemplate;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    /***
     * 创建一个jms操作类,默认事务
     * @return
     */
    protected JmsOperations createJmsOperations(long receiveTimeout,Queue queue){
        try {
            if (this.getCachingConnectionFactory() != null &&  this.getQueueConnectionFactory() != null){
                this.getCachingConnectionFactory().setTargetConnectionFactory(this.getQueueConnectionFactory());
                JmsTemplate jmsTemplate = new JmsTemplate(this.getCachingConnectionFactory());
                jmsTemplate.setReceiveTimeout(receiveTimeout);
                jmsTemplate.setDefaultDestination(queue);
                return jmsTemplate;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    /***
     * 获得一个JMS操作类，需要QueueConnectionFactory，CachingConnectionFactory
     */
    @Override
    public JmsOperations getSenderJmsOperator() {
        if (this.getSenderJmsOperations() == null) {
            this.setSenderJmsOperations(createJmsOperations(receiveTimeout, getSendQueue()));
        }
        return senderJmsOperations;
    }

    /**
     * 获得接收消息的JMS操作类
     */
    public JmsOperations getReceiverJmsOperator(boolean isTransactionOn,int mode){
        if (this.getReceiverJmsOperations() == null) {
            this.setReceiverJmsOperations(createJmsOperations(receiveTimeout, getRevQueue(),isTransactionOn,mode));
        }
        return receiverJmsOperations;
    }

    /***
     * 获得一个队列连接
     * @return
     */
    @Override
    public QueueConnection getConnection() {
        return this.getQueueConnection();
    }

    /***
     * 获得一个监听容器
     */
    @Override
    public DefaultMessageListenerContainer getListenerContainer() {
        return this.getDefaultMessageListenerContainer();
    }

    /**
     * create by: Wang Xieqin
     * description:创建监听容器
     * create time: 17:02 2018/10/31
     *
     * @Param: isTransactionOn 事务是否开启
     * @return 监听容器
     */
    protected DefaultMessageListenerContainer createDefaultMessageListenerContainer(boolean isTransactionOn,int mode ){
        if (this.getQueueConnectionFactory() != null &&
                this.getMessageListener() != null &&
                this.getRevQueue() != null){
            defaultMessageListenerContainer = new MyMessageListenerContainer();
            defaultMessageListenerContainer.setConnectionFactory(this.getCachingConnectionFactory());
            defaultMessageListenerContainer.setDestination(this.getRevQueue());
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
