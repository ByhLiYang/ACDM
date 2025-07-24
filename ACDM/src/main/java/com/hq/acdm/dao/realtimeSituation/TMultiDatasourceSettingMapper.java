package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TMultiDatasourceSetting;
import com.hq.acdm.model.realtimeSituation.TMultiDatasourceSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMultiDatasourceSettingMapper {
    int countByExample(TMultiDatasourceSettingExample example);

    int deleteByExample(TMultiDatasourceSettingExample example);

    int deleteByPrimaryKey(String id);

    int insert(TMultiDatasourceSetting record);

    int insertSelective(TMultiDatasourceSetting record);

    List<TMultiDatasourceSetting> selectByExample(TMultiDatasourceSettingExample example);

    TMultiDatasourceSetting selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TMultiDatasourceSetting record, @Param("example") TMultiDatasourceSettingExample example);

    int updateByExample(@Param("record") TMultiDatasourceSetting record, @Param("example") TMultiDatasourceSettingExample example);

    int updateByPrimaryKeySelective(TMultiDatasourceSetting record);

    int updateByPrimaryKey(TMultiDatasourceSetting record);
}