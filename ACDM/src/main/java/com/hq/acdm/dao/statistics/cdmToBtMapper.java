package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.cdmTobt.CdmTobt;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:35
 */
public interface cdmToBtMapper {
    //CDM TOBT遵从度
    List<CdmTobt> queryCdmTobt(@Param("params") Map params);
}
