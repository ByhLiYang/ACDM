package com.hq.acdm.util.mqadapter.listener;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component("AMQListener")
@Scope("prototype")
public class AMQListener extends BaseMqListener implements MessageListener {
    /**
     * create by: Wang Xieqin
     * description:收到消息处理
     * create time: 17:53 2018/9/7
     *
     * @Param: msg 收到的消息
     * @return
     */
    @Override
    public void onMessage(Message message) {
        super.handleMessage(message);
    }
}
