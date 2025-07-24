package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.runningGuarantee.RunningGuaranteeModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/12/7 0007 9:29
 */
public interface RunningGuaranteeMapper {
    List<RunningGuaranteeModel> getFXLBYHOUR(@Param("params") Map<String,Object> map);
    List<RunningGuaranteeModel> getFXLBYTime(@Param("params") Map<String,Object> map);
    List<RunningGuaranteeModel> getZCLByAIRLINE(@Param("params") Map<String,Object> map);
    List<RunningGuaranteeModel> getZCLByHour(@Param("params") Map<String,Object> map);
    List<RunningGuaranteeModel> getZCLByAIRLINE1(@Param("params") Map<String,Object> map);
}
