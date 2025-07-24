package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TGate;
import com.hq.acdm.model.realtimeSituation.TGateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGateMapper {
    int countByExample(TGateExample example);

    int deleteByExample(TGateExample example);

    int deleteByPrimaryKey(String id);

    int insert(TGate record);

    int insertSelective(TGate record);

    List<TGate> selectByExample(TGateExample example);

    TGate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TGate record, @Param("example") TGateExample example);

    int updateByExample(@Param("record") TGate record, @Param("example") TGateExample example);

    int updateByPrimaryKeySelective(TGate record);

    int updateByPrimaryKey(TGate record);
}