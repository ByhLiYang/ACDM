package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TPresetField;
import com.hq.acdm.model.realtimeSituation.TPresetFieldExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TPresetFieldMapper {
    int countByExample(TPresetFieldExample example);

    int deleteByExample(TPresetFieldExample example);

    int deleteByPrimaryKey(String id);

    int insert(TPresetField record);

    int insertSelective(TPresetField record);

    List<TPresetField> selectByExample(TPresetFieldExample example);

    TPresetField selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TPresetField record, @Param("example") TPresetFieldExample example);

    int updateByExample(@Param("record") TPresetField record, @Param("example") TPresetFieldExample example);

    int updateByPrimaryKeySelective(TPresetField record);

    int updateByPrimaryKey(TPresetField record);

    List<TPresetField> findTPresetField(@Param("params") Map params);
}