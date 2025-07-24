package com.hq.acdm.dao.realtimeSituation;

import com.hq.acdm.model.realtimeSituation.TLocalFlightInfo;
import com.hq.acdm.model.realtimeSituation.TLocalFlightInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLocalFlightInfoMapper {
    int countByExample(TLocalFlightInfoExample example);

    int deleteByExample(TLocalFlightInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TLocalFlightInfo record);

    int insertSelective(TLocalFlightInfo record);

    List<TLocalFlightInfo> selectByExample(TLocalFlightInfoExample example);

    TLocalFlightInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TLocalFlightInfo record, @Param("example") TLocalFlightInfoExample example);

    int updateByExample(@Param("record") TLocalFlightInfo record, @Param("example") TLocalFlightInfoExample example);

    int updateByPrimaryKeySelective(TLocalFlightInfo record);

    int updateByPrimaryKey(TLocalFlightInfo record);
}