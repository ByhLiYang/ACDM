package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TAbnormalReason;
import com.hq.acdm.model.realtimeSituation.TAbnormalReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAbnormalReasonMapper {
    int countByExample(TAbnormalReasonExample example);

    int deleteByExample(TAbnormalReasonExample example);

    int deleteByPrimaryKey(String id);

    int insert(TAbnormalReason record);

    int insertSelective(TAbnormalReason record);

    List<TAbnormalReason> selectByExample(TAbnormalReasonExample example);

    TAbnormalReason selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TAbnormalReason record, @Param("example") TAbnormalReasonExample example);

    int updateByExample(@Param("record") TAbnormalReason record, @Param("example") TAbnormalReasonExample example);

    int updateByPrimaryKeySelective(TAbnormalReason record);

    int updateByPrimaryKey(TAbnormalReason record);
}