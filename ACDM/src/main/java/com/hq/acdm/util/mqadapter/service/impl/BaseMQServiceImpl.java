package com.hq.acdm.util.mqadapter.service.impl;

import com.hq.acdm.util.StringUtil;
import com.hq.acdm.util.mqadapter.mqmanager.IMqManager;
import com.hq.acdm.util.mqadapter.service.MQService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseMQServiceImpl implements MQService{
    private Logger logger = LoggerFactory.getLogger(BaseMQServiceImpl.class);



    protected IMqManager mqMsgManager;

    public IMqManager getMqMsgManager() {
        return mqMsgManager;
    }

    public void setMqMsgManager(IMqManager mqMsgManager) {
        this.mqMsgManager = mqMsgManager;
    }
    /**
     * create by: Wang Xieqin
     * description:判断消息是否需要屏蔽
     * create time: 12:56 2018/9/7
     *
     * @return 返回判断结果 true 是 false 否
     * @Param: null
     */
    public boolean judgeMessage() throws Exception {
        return true;
    }


    /**
     * create by: Wang Xieqin
     * description:接收消息
     * create time: 12:57 2018/9/7
     *
     * @return 返回收到的消息
     * @Param: null
     */
    public String receiveMessage()  {
        String message = (String) mqMsgManager.getReceiverJmsOperator().receiveAndConvert();
        if(null!=message && !"".equals(message)){
            logger.info("收到消息："+message);
            return message;
        }
        return null;
    }

    /**
     * create by: Wang Xieqin
     * description:发送消息
     * create time: 12:57 2018/9/7
     *
     * @param msg
     * @return 发送结果 true 成功 false 失败
     * @Param: 发送的消息内容
     */
    public boolean sendMessage(String msg)  {
        try{
            if (StringUtil.isNotEmpty(msg)) {
                mqMsgManager.getSenderJmsOperator().convertAndSend(msg);
                logger.info("发送消息成功："+msg);
                return true;
            }
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }
        logger.info("发送消息失败："+msg);
        return false;

    }

}
