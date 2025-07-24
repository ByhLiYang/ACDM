package com.hq.acdm.service.dynamicFlight;

import com.hq.acdm.model.realtimeSituation.TDynTask;
import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */
public interface PrcsSupervisionService {
    //查询即将进港数据
    List<PrcsJJJGVo> findJJJG(@Param("params") Map params);
    //查询落地滑行数据
    List<PrcsLDHXVo> findLDHX(@Param("params") Map params);
    //查询离港滑行数据
    List<PrcsLGHXVo> findLGHX(@Param("params") Map params);
    //查询前站延误数据
    List<PrcsQZYWVo> findQZYW(@Param("params") Map params);
    //查询提前起飞数据
    List<PrcsQZYWVo> findTQQF(@Param("params") Map params);
    //查询过站保障数据
    List<Map<String,Object>> findGZBZ(@Param("params") Map params);
    //查询过站保障数据状态
    List<TDynTask> findGZBZState(@Param("params") Map params);
    //查询任务节点信息
    List<TaskNodeVo> findTaskNode();
    //查询节点预计实际时间
    List<Map<String,Object>> selectNoticeTime(@Param("params") Map params);
    //查询任务节点对应的调度信息
    List<String> findSchedulingNoticeInfo(@Param("params") Map params);

}
