package com.hq.acdm.dao.monitioring;

import com.hq.acdm.model.monitoring.cobtJump.CobtJump;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface CobtJumpMapper {
    //CobtJump 跳跃监管
    List<CobtJump> queryList(@Param("params") Map params);
}
