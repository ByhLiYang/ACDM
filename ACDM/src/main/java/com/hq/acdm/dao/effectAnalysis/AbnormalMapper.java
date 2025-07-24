package com.hq.acdm.dao.effectAnalysis;

import com.hq.acdm.model.sys.Users;
import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface AbnormalMapper {
    //tony add 查询晚关门或延误航班列表
    List<TLocalFlightInfoVo> getAbnormal(@Param("params") Map params);
    //tony add 查询历史晚关门或延误航班列表
    List<TLocalFlightInfoVo> getAbnormalHis(@Param("params") Map params);
    //出现信封消息
    public List<TEnvelopeMsgVo> getEnvelopMsg(@Param("params") Map params);
    //修改信封消息的确定人
    int updateMsgUser(@Param("params") Map params);
}
