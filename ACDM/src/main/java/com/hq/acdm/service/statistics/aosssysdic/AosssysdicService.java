package com.hq.acdm.service.statistics.aosssysdic;

import com.hq.acdm.model.statistics.aosssysdic.Aosssysdic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 参数管理
 */
public interface AosssysdicService {
    List<Aosssysdic> selectParamtypeList();

    List<Aosssysdic> selectAllSysdic();

    boolean updateSysDic(Map map) throws Exception;

    List<Aosssysdic> selectDefinedParawvalue(@Param("typecode") String typecode,@Param("paracode") String paracode,
                                             @Param("parameterName") String parameterName,@Param("parameterDescription") String parameterDescription);
}
