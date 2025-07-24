package com.hq.acdm.dao.index;

import com.hq.acdm.model.index.VForecast;
import com.hq.acdm.vo.realtimeSituation.HBSPerHour;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VForecastMapper {
    int insert(VForecast record);

    int insertSelective(VForecast record);
    //侯机区人数
    List<HBSPerHour> getplanFlightNum(@Param("flag") String flag);
    //隔离区人数
    List<HBSPerHour> getquarantineNum(@Param("flag") String flag);
    //机上人数
    List<HBSPerHour> getactualFlightNum(@Param("flag") String flag);

    List<VForecast> getFlightNum(@Param("flag") String flag);
}