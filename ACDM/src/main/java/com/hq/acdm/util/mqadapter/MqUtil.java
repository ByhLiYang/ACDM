package com.hq.acdm.util.mqadapter;

import com.google.common.base.Splitter;
import com.hq.acdm.util.ApplicationContextProvider;
import com.hq.acdm.util.mqadapter.service.MQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lizhifeng
 * @Date 2018/8/18
 * @Description:
 */
@Slf4j
public class MqUtil {

    //原始消息由哪个队列转发出去
    @Value("${transferMsgMq:}")
    public static String transferMsgMq;
    public static boolean  splitToListInt(String msg) {
        //if(transferMsgMq==null||transferMsgMq.isEmpty()) return false;
        try{
            Object objMq= ApplicationContextProvider.getBean("AMQService");
            System.out.println("msg:"+msg);
            if(objMq==null) {
                System.out.println("未能获取"+transferMsgMq+"对应的Bean,请检查配置!");
                log.error("未能获取"+transferMsgMq+"对应的Bean,请检查配置!");
                return false;
            }
            MQService mqService=(MQService)objMq;
            log.info("开始转发原始消息...");
            System.out.println("开始转发原始消息...");
            if(mqService.sendMessage(msg)){
                log.info("原始消息转发成功!");
                System.out.println("原始消息转发成功...");
                return  true;
            }else{
                log.info("原始消息转发失败!");
                System.out.println("原始消息转发失败...");
            }
        }catch (Exception ex){
            log.error("转发原始消息失败!"+ex.getMessage(),ex);
            System.out.println("转发原始消息失败..."+ex.getMessage());
            return  false;
        }
        return  false;
    }


}
