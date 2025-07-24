package com.hq.acdm.dao.sysManager;

import com.hq.acdm.model.sys.TAreaStandToAtc;
import com.hq.acdm.model.sys.TAreaStandToAtcExample;
import java.util.List;
import java.util.Map;

import com.hq.acdm.vo.sysManager.AltStandVo;
import org.apache.ibatis.annotations.Param;

public interface TAreaStandToAtcMapper {
    int countByExample(TAreaStandToAtcExample example);

    int deleteByExample(TAreaStandToAtcExample example);

    int deleteByPrimaryKey(String id);

    int insert(TAreaStandToAtc record);

    int insertSelective(TAreaStandToAtc record);

    List<TAreaStandToAtc> selectByExample(TAreaStandToAtcExample example);

    TAreaStandToAtc selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAreaStandToAtc record, @Param("example") TAreaStandToAtcExample example);

    int updateByExample(@Param("record") TAreaStandToAtc record, @Param("example") TAreaStandToAtcExample example);

    int updateByPrimaryKeySelective(TAreaStandToAtc record);

    int updateByPrimaryKey(TAreaStandToAtc record);

    List<TAreaStandToAtc> findStandBaseInfo(@Param("params") Map params);

    int updStandBaseInfo(TAreaStandToAtc record);

    int insStandBaseInfo(TAreaStandToAtc record);

    int updRTNStand(AltStandVo record);

    AltStandVo selectRTNStand();
}