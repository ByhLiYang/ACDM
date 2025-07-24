package com.hq.acdm.service.monitoring.CobtJump;

import com.hq.acdm.model.monitoring.cobtJump.CobtJump;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface CobtJumpService {
    //查询CDM TOBT遵从度

    public List<CobtJump> queryList(Map params)  ;

}
