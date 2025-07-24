package com.hq.acdm.service.statistics.releaseNormal;

import com.hq.acdm.model.statistics.releaseNormal.ReleaseNormal;
import java.util.List;
import java.util.Map;

/**
 * @author yangrui
 * @date 2018/9/21 0020 14:36
 */
public interface ReleaseNormalService {
    //查询放行正常率
    List<ReleaseNormal> queryReleaseNormal(String startDate, String endDate);
}
