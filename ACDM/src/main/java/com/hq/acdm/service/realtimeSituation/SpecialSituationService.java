package com.hq.acdm.service.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TSpecialInfo;
import com.hq.acdm.vo.realtimeSituation.SpecialSituationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:15
 * @Description
 */

public interface SpecialSituationService {

    public List<SpecialSituationVo> findByTSpecialInfo(Map params);

    public int insert(TSpecialInfo record);

    public int updateByPrimaryKey(TSpecialInfo record);

    public int deleteByPrimaryKey(String id);

    public List<TSpecialInfo> findAllTSpecialInfo(Map params);

    List<SpecialSituationVo> findByTNoticeOfConstructionInfo(@Param("params") Map params);

    List<SpecialSituationVo> findByTNoticeOfGroundingInfo(@Param("params") Map params);

    List<SpecialSituationVo> findByTMdrsInfo(@Param("params") Map params);

    List<SpecialSituationVo> findByTControlInfoInfo(@Param("params") Map params);
}
