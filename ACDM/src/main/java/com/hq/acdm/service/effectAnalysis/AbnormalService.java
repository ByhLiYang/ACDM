package com.hq.acdm.service.effectAnalysis;

import com.hq.acdm.model.realtimeSituation.TFlightSupportRecord;
import com.hq.acdm.vo.dynamicFlight.TEnvelopeMsgVo;
import com.hq.acdm.vo.dynamicFlight.TLocalFlightInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface AbnormalService {
    //tony add 查询晚关门或延误航班列表
    List<TLocalFlightInfoVo> findAbnormal(@Param("params") Map params,boolean flag);
    //tony add 查询历史晚关门或延误航班列表
    List<TLocalFlightInfoVo> findAbnormalHis(@Param("params") Map params);
    //add 航班保障记录表
    int insertTFlightSupportRecord(TFlightSupportRecord record);
    //update 航班保障记录表
    int updateTFlightSupportRecord(TFlightSupportRecord record);
    //查询航班保障记录表
    List<TFlightSupportRecord> findTFlightSupportRecord(@Param("params") Map params);
    //查询信封消息
    public List<TEnvelopeMsgVo> getEnvelopMsg(@Param("params") Map params);
    //修改信封消息的确定人
    int updateMsgUser(@Param("params") Map params);
}
