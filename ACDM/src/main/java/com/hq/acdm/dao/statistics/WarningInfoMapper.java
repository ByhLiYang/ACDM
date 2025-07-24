package com.hq.acdm.dao.statistics;

import com.hq.acdm.model.statistics.warningInfo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/29 0029 15:14
 */
public interface WarningInfoMapper {
    List<ExecutionModel> SELECT_EXECRATE_08_23();
    List<ExecutionModel> SELECT_DELAY1H_UNEXEC_08_23();
    List<V_UTIL_DAILY_FLIGHTModel> SELECT_BASIC_DATA_01();
    List<ScheduleModel> SELECT_BASIC_DATA_02();
    List<ReturnFlightNumberModel> SELECT_BASIC_DATA_03();
    List<OutBoundDelayModel> SELECT_BASIC_DATA_04();
    List<ThisHourExcuteScheduleModel> SELECT_BASIC_DATA_05();
    List<StandModel> SELECT_BASIC_DATA_06();
    List<CurrentWarningStatusModel> SELECT_BASIC_DATA_07();
    List<ExecutionModel> SELECT_DELAY1H_UNEXEC();
    List<NoFlightHourModel> SELECT_UNEXEC_HOURS();
    List<ExecutionModel> SELECT_EXECDRATE_1HOURAFTER();
    List<ExecutionModel> SELECT_EXECARATE_1HOURAFTER();
    List<ExecutionModel> SELECT_EXECDRATE_THISHOUR();
    List<ExecutionModel> SELECT_EXECARATE_THISHOUR();
    int INSERT_OPERATION_LOG(@Param("params")Map<String,Object> map);
    List<WarningInfo> QUERY_OPERATION_LOG();
    WarningInfo queryStatus();
}
