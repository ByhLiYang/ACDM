package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecord;
import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMultiDatasourceRecordMapper {
    int countByExample(TMultiDatasourceRecordExample example);

    int deleteByExample(TMultiDatasourceRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TMultiDatasourceRecord record);

    int insertSelective(TMultiDatasourceRecord record);

    List<TMultiDatasourceRecord> selectByExample(TMultiDatasourceRecordExample example);

    TMultiDatasourceRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TMultiDatasourceRecord record, @Param("example") TMultiDatasourceRecordExample example);

    int updateByExample(@Param("record") TMultiDatasourceRecord record, @Param("example") TMultiDatasourceRecordExample example);

    int updateByPrimaryKeySelective(TMultiDatasourceRecord record);

    int updateByPrimaryKey(TMultiDatasourceRecord record);
}