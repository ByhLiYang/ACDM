package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.aosssysdic.Aosssysdic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 参数管理
 */
public interface AosssysdicMapper {
    List<Aosssysdic> selectParamtypeList();

    List<Aosssysdic> selectAllSysdic();

    int deleteDefinedSysdiclogic(@Param("typecode") String typecode,@Param("paracode") String paracode);

    int insertDefinedSysdicPhysic(Map map);

    List<Aosssysdic> selectDefinedParawvalue(@Param("typecode") String typecode,@Param("paracode") String paracode,
                                             @Param("parameterName") String parameterName,@Param("parameterDescription") String parameterDescription);


}
