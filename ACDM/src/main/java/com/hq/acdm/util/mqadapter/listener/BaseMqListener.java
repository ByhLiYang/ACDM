package com.hq.acdm.util.mqadapter.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;

public abstract class BaseMqListener {
    private static Logger logger=  LoggerFactory.getLogger(BaseMqListener.class);


    /**
     * create by: Wang Xieqin
     * description:处理消息
     * create time: 12:52 2018/11/2
     *
      * @Param: message 收到的消息
     */
    protected void handleMessage(Message message){
        try {
            logger.info("开始处理消息......");
            //mqMsgController.handle(message);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }

}
