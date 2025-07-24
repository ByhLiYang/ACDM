package com.hq.acdm.dao.index;

import com.hq.acdm.model.index.Weather;
import com.hq.acdm.model.statistics.releaseNormal.ReleaseNormal;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WeatherMapper {
    int deleteByPrimaryKey(Date updatedatetime);

    int insert(Weather record);

    int insertSelective(Weather record);

    Weather selectByPrimaryKey(Date updatedatetime);

    int updateByPrimaryKeySelective(Weather record);

    int updateByPrimaryKey(Weather record);

    Weather selectByWeatherDate();

    Weather selectByWeatherDateByTable();

    //查询放行正常率
    List<ReleaseNormal> queryReleaseNormal(@Param("startDate") String startDate, @Param("endDate") String endDate);
}