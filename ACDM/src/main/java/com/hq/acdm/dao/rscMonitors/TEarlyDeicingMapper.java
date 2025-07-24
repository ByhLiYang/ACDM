package com.hq.acdm.dao.rscMonitors;

import com.hq.acdm.model.rscMonitors.TEarlyDeicing;
import com.hq.acdm.vo.rscMonitors.EarlyDeicingVo;

import java.util.List;

public interface TEarlyDeicingMapper {
    int deleteByPrimaryKey(String id);

    int insert(TEarlyDeicing record);

    TEarlyDeicing selectByPrimaryKey(String id);

    int updateByPrimaryKey(TEarlyDeicing record);
//查询除冰计划
    List<TEarlyDeicing> selectByDate(String execDate);
//查询早出港航班
    List<TEarlyDeicing> selectEarlyFltByDate(String execDate);

    int updateByFlno(TEarlyDeicing record);

    int updateStand(TEarlyDeicing record);
//查询可分配的机位
    List<String> selectStand(TEarlyDeicing record);
    //查询航班分配的机位位置
    List<EarlyDeicingVo> selectFltLocation(String execDate);
}