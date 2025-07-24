package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TRunwayMode;
import com.hq.acdm.model.realtimeSituation.TSectionWt;
import com.hq.acdm.vo.realtimeSituation.FlightIndexRunwayVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface FlightrunSituationService {

    //获取跑道模式信息
    public List<TRunwayMode> findRunwayModeInfo(Map params);
    //新增飞行区运行情况（能见度，风速，风向，云低高）
    int insert(TSectionWt record);
    //删除飞行区运行情况（能见度，风速，风向，云低高）
    int deleteByPrimaryKey(String id);
    //修改飞行区运行情况（能见度，风速，风向，云低高）
    int updateByPrimaryKey(TSectionWt record);
    //查询所有飞行区运行情况
    List<TSectionWt> selectAllTSectionWt();
    //修改跑道信息
    int updateRunway(TRunwayMode recod);
    //修改航班跑道信息
    int updateRunwayD(TRunwayMode recod);
    //修改航班跑道信息
    int updateRunwayA(TRunwayMode recod);

    FlightIndexRunwayVo findRunwayAllInfo();

    int updateRunwayAllInfo(@Param("params") Map params);
}
