package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TSpecialInfo;
import com.hq.acdm.model.realtimeSituation.TSpecialInfoExample;
import com.hq.acdm.vo.realtimeSituation.SpecialSituationVo;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TSpecialInfoMapper {
    int countByExample(TSpecialInfoExample example);

    int deleteByExample(TSpecialInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSpecialInfo record);

    int insertSelective(TSpecialInfo record);

    List<TSpecialInfo> selectByExample(TSpecialInfoExample example);

    TSpecialInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSpecialInfo record, @Param("example") TSpecialInfoExample example);

    int updateByExample(@Param("record") TSpecialInfo record, @Param("example") TSpecialInfoExample example);

    int updateByPrimaryKeySelective(TSpecialInfo record);

    int updateByPrimaryKey(TSpecialInfo record);

    List<SpecialSituationVo> findByTSpecialInfo(@Param("params") Map params);

    List<TSpecialInfo> findAllTSpecialInfo(@Param("params") Map params);

    List<SpecialSituationVo> findByTNoticeOfConstructionInfo(@Param("params") Map params);

    List<SpecialSituationVo> findByTNoticeOfGroundingInfo(@Param("params") Map params);

    List<SpecialSituationVo> findByTMdrsInfo(@Param("params") Map params);

    List<SpecialSituationVo> findByTControlInfoInfo(@Param("params") Map params);


}