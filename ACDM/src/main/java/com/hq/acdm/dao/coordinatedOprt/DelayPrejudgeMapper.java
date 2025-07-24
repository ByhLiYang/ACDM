package com.hq.acdm.dao.coordinatedOprt;

import com.hq.acdm.vo.coordinatedOprt.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface DelayPrejudgeMapper {
    //航班延误预判-航班执行情况
    List<DelayPrejudgeHBZXQKVo> findFligthExecInfo();
    //机场运行效率
    List<DelayPrejudgeJCYXXLVo> findAirRunEfficiency();
    //启动延误预警-响应表实时航班信息
    TEdResponse findFltResponse();
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
    //未来2小时延误航班
    List<FutureDelayVo> findFtDelays();
    //未来2小时延误航班
    List<FutureDelayVo> findFtDelaysX();
}
