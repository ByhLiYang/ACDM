package com.hq.acdm.service.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;



public interface DelayPrejudgeService {

    //航班延误预判-航班执行情况
    public List<DelayPrejudgeHBZXQKVo> findFligthExecInfo();
    //机场运行效率
    List<DelayPrejudgeJCYXXLVo> findAirRunEfficiency();
    //执行率
    List<DelayPrejudgeExeVarVo> findExeRate();
    //出港延误一小时以上未起飞航班数
    List<DelayPrejudgeExeVarVo> findDelayNotTakingOff();
    //出港延误1小时以上未起飞的航班数占当日出港航班计划数的比率
    List<DelayPrejudgeExeVarVo> findDelayNotTakingOffRate1H();
    //机场航班起降小时数(两两相减得相差小时数)
    List<String> findTakingOffH();
    //未来1小时出港执行率
    List<String> findFuture1HFltDRate();
    //未来1小时进港执行率
    List<String> findFuture1HFltARate();
    //本小时出港执行率
    List<String> findFutureCurrHFltDRate();
    //本小时进港执行率
    List<String> findFutureCurrHFltARate();
    //航延预判数据信息
    Map<String,Object> findDelayPrejudgeInfo();
    //未来2小时延误航班
    List<FutureDelayVo> findFtDelays();
    //查询当前启动的预警ID
    TEmergencyDisposal findWarningId();
    //启动预警查询
    TEmergencyDisposal findWarningChat(String level,String edId);
    //根据处置ID查询处置任务清单
    List<TEdDynTask> findTaskList(String edId);
    //根据处置ID查询响应表录入数据
    TEdResponse findResponseEt(String edId);
    //根据处置ID查询响应表实时计算数据
    TEdResponse findResponseCalc(String edId);
    //根据处置ID查询预警信息表
    TEdWarning findWarningInfo(String edId);
    //根据处置任务ID更新处置任务
    int updateEmgcDsps(TEdDynTask tEdDynTask);
    //根据处置任务ID更新响应情况通报表
    int updateEdResponse(TEdResponse tEdResponse);
    //根据处置任务ID更新预警信息通报表
    int updateEdWarning(TEdWarning tEdWarning);
    //未来2小时延误航班
    FutureDelayXVo findFtDelaysX();
}
