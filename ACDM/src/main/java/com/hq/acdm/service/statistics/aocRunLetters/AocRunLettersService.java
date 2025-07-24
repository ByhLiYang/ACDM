package com.hq.acdm.service.statistics.aocRunLetters;

import com.hq.acdm.model.statistics.aocRunLetters.BridgeRate;
import com.hq.acdm.model.statistics.aocRunLetters.RealInterfaceYD;

import java.util.List;
import java.util.Map;

/**
 * AOC运行快报服务类
 */
public interface AocRunLettersService {
    /**
     * 查询 总计划 实际 正常率 放行正常率
     */
    List<RealInterfaceYD> queryAllRealInterfaceYD();

    /**
     * 查询公务机数量
     * @return
     */
    int queryCorporateAircraftCount();

    /**
     * 查询旅客数量
     * @return
     */
    int queryNumberOfPassengers();


    /**
     * 查询始发放行率
     * @return
     */
    Map queryStartRate();

    /**
     * 查询靠桥率
     * @return
     */
    String queryOnTheBridgeRate();

    /**
     * 京沪快线出港总数
     */
    int queryPEKtoSHAdeparture();

    /**
     * 京沪快线放行正常数
     * @return
     */
    int queryPEKtoSHAreleaseNormal();

    /**
     * 靠桥率2
     * @return
     */
    List<BridgeRate> queryOnTheBridgeRateTwo();


    //getFun请求
    //靠桥率
    Map queryStartRateOfGetFun();





    /**
     * 京沪航班总数  getFun
     * @return
     */
    List<Map> queryBJtoSHflight();

    //CODE不合理
    int queryCodeUnreasonable();


    //飞机晚到
    List<Map>  queryPlaneLate();

    //COBT与计划出港(SOBT)相差10-25分钟
    int cobtWithSobtLeavePort();

    //小延误
    List<Map> querySmallDelay();

    //出港航班总数
    int queryLeavePortCount();

    //COBT跳变
    Map querycobtSaltusStep();

    //COBT跳变2
    List<Map> querycobtDailyBest();






}
