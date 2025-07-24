package com.hq.acdm.util.mqadapter.service;

/**
 * MQ通用方法
 */
public interface MQService {
    /**
     * 发送消息
     * @param message 消息内容
     */
    boolean sendMessage(String message);

    /**
     * 接收消息
     */
    String receiveMessage();
    /**
     * create by: Wang Xieqin
     * description:判断消息是否需要屏蔽
     * create time: 12:56 2018/9/7
     *
     * @Param: null
     * @return 返回判断结果 true 是 false 否
     */
    boolean judgeMessage()throws Exception;
}
