package com.hq.acdm.util.mqadapter;

import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.JmsUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class MyMessageListenerContainer extends DefaultMessageListenerContainer {
    @Override
    protected void commitIfNecessary(Session session, Message message) throws JMSException {
        if (session.getTransacted()) {
            if (this.isSessionLocallyTransacted(session)) {
                JmsUtils.commitIfNecessary(session);
            }
        } else if (message != null && this.isClientAcknowledge(session)) {
           // message.acknowledge();
        }

    }
}
