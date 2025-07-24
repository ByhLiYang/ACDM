package com.hq.acdm.dao.flight;

import com.hq.acdm.model.flight.DailyFlightMaster;
import com.hq.acdm.model.flight.DailyFlightMasterKey;
import org.apache.ibatis.annotations.Param;
import java.util.Map;
import java.util.List;

public interface DailyFlightMasterMapper {
    int deleteByPrimaryKey(DailyFlightMasterKey key);

    int insert(DailyFlightMaster record);

    int insertSelective(DailyFlightMaster record);

    DailyFlightMaster selectByPrimaryKey(DailyFlightMasterKey key);
    //tony add 移动查询航班接口
    List<DailyFlightMaster> queryList(@Param("params") Map params);

    //tony add 查询所有航班下拉列表
    List<Map> queryFlightList(@Param("params") Map params);

    int updateByPrimaryKeySelective(DailyFlightMaster record);

    int updateByPrimaryKey(DailyFlightMaster record);

    List<String> findAllCompany();
}