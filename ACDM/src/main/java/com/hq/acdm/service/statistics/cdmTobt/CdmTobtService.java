package com.hq.acdm.service.statistics.cdmTobt;

import com.hq.acdm.model.statistics.cdmTobt.CdmTobt;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface CdmTobtService {
    //查询CDM TOBT遵从度

    List<CdmTobt> queryCdmTobt(Map params);

}
