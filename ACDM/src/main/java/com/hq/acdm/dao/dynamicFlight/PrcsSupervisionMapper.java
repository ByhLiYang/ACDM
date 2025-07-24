package com.hq.acdm.dao.dynamicFlight;

import com.hq.acdm.vo.dynamicFlight.*;
import com.hq.acdm.model.realtimeSituation.TDynTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:38
 * @Description
 */
public interface PrcsSupervisionMapper {
    //查询即将进港数据
    List<PrcsJJJGVo> getJJJG(@Param("params") Map params);
    //查询落地滑行数据
    List<PrcsLDHXVo> getLDHX(@Param("params") Map params);
    //查询离港滑行数据
    List<PrcsLGHXVo> getLGHX(@Param("params") Map params);
    //查询前站延误数据
    List<PrcsQZYWVo> getQZYW(@Param("params") Map params);
    //查询前站起飞数据
    List<PrcsQZYWVo> getQZQF(@Param("params") Map params);
    //查询提前30分钟起飞数据
    List<PrcsQZYWVo> getTQQF(@Param("params") Map params);
    //查询过站保障数据
    List<Map<String,Object>> getGZBZ(@Param("params") Map params);
    //查询过站保障数据
    List<Map<String,Object>> getGZBZlist(@Param("list") List<String> list,@Param("params") Map params);
    //查询过站保障数据状态
    List<TDynTask> getGZBZState(@Param("params") Map params);
    //查询任务节点信息
    List<TaskNodeVo> findTaskNode();
    //查询节点预计实际时间
    List<Map<String,Object>> SelectNoticeTime(@Param("params") Map params);
    //查询任务节点对应的调度信息
    List<String> findSchedulingNoticeInfo(@Param("params") Map params);
}
