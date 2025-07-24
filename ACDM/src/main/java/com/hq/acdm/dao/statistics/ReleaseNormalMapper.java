package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.releaseNormal.ReleaseNormal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangrui
 * @date 2018/9/21 0020 14:35
 */
public interface ReleaseNormalMapper {
    //查询放行正常率
    List<ReleaseNormal> queryReleaseNormal(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
