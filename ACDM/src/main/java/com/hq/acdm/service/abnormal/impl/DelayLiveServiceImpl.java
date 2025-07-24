package com.hq.acdm.service.abnormal.impl;

import com.google.common.collect.Lists;
import com.hq.acdm.beans.Mail;
import com.hq.acdm.dao.abnormal.DelayLiveMapper;
import com.hq.acdm.dao.index.VDelayFlightSumMapper;
import com.hq.acdm.dao.index.VPaxSumMapper;
import com.hq.acdm.dao.index.VRealInterfaceMapper;
import com.hq.acdm.dao.supervision.VAordcount1hourMapper;
import com.hq.acdm.model.index.VDelayFlightSum;
import com.hq.acdm.model.index.VPaxSum;
import com.hq.acdm.model.index.VRealInterface;
import com.hq.acdm.model.supervision.managermonitor.VAordcount1hour;
import com.hq.acdm.service.abnormal.DelayLiveService;
import com.hq.acdm.vo.abnormal.DelayLiveVO;
import com.hq.acdm.vo.abnormal.DelayNumberVO;
import com.hq.acdm.vo.abnormal.FiveD;
import com.hq.acdm.vo.supervision.managermonitor.DateName;
import com.hq.acdm.vo.supervision.managermonitor.FourD;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/9/27 0027
 * @Description:
 */
@Service("delayLiveService")
public class DelayLiveServiceImpl implements DelayLiveService {

    private static final String TYPE_FLIGHT_PERSON = "机上人数";

    private static final String TYPE_SECURITY_PERSON = "安检区人数";

    private static final String TYPE_WAIT_FLIGHT_PERSON = "候机区人数";

    @Autowired
    private VAordcount1hourMapper vAordcount1hourMapper;
    @Resource
    private DelayLiveMapper delayLiveMapper;
    @Resource
    private VPaxSumMapper vPaxSumMapper;
    @Resource
    private VDelayFlightSumMapper vDelayFlightSumMapper;
    @Resource
    private VRealInterfaceMapper vRealInterfaceMapper;


    @Override
    public DelayLiveVO query(@Param("params") Map params) {
        DelayLiveVO vo = new DelayLiveVO();
        //获取离港航班延误
        List<FiveD> tableData1 = delayLiveMapper.getTableData1(params);
        vo.setTableData1(tableData1);
//
//        //获取离港航线延误
//        List<FiveD> tableData2 = delayLiveMapper.getTableData2();
//        for (FiveD d : tableData2) {
//            if (d.getD3().contains(".")) {
//                d.setD3(d.getD3().substring(0, d.getD3().indexOf(".")+3)+"%");
//            }
//            if (d.getD4().contains(".")) {
//                d.setD4(d.getD4().substring(0, d.getD4().indexOf(".")));
//            }
//        }
//        vo.setTableData2(tableData2);
//
//        //三大区域人数
//        List<DateName> tableData3 = Lists.newArrayList();
//        List<VPaxSum> paxList = vPaxSumMapper.getRecord();
//        int totalPersonNum = 0;
//        for (VPaxSum pax : paxList) {
//            DateName dateName = new DateName();
//            dateName.setDate(pax.getType());
//            dateName.setName(String.valueOf(pax.getPaxNum()));
//
//            tableData3.add(dateName);
//            //总人数：
//            totalPersonNum += pax.getPaxNum().intValue();
//        }
//        vo.setTableData3(tableData3);
//        vo.setTotalPersonNum(String.valueOf(totalPersonNum));
//
//        //离港延误时间分析
//        List<FourD> tableData4 = Lists.newArrayList();
//        List<VDelayFlightSum> executedList = vDelayFlightSumMapper.getRecord();
//        //未执行=flightNum-delayFlightNum（已经执行）
//        for (VDelayFlightSum flight : executedList) {
//            FourD four = new FourD();
//            four.setD0(flight.getType());
//            four.setD1(String.valueOf(flight.getFlightNum()));
////            four.setD2(String.valueOf(flight.getFlightNum().subtract(flight.getDelayFlightNum())));
//            four.setD2(String.valueOf(flight.getDelayFlightNum()));
//            four.setD3(String.valueOf(flight.getPassengerNum()));
//            tableData4.add(four);
//        }
//        vo.setTableData4(tableData4);
//
//        VRealInterface realInterfaceRecord = vRealInterfaceMapper.getRecord();
//        //已执行:
//        vo.setExecuted(realInterfaceRecord.getAlreadyNum().intValue());
//        //未执行:
//        vo.setNonExecution(realInterfaceRecord.getReadyNum().intValue());
//        //已取消
//        vo.setCancel(realInterfaceRecord.getCancelNum().intValue());
//        //正常率：
//        BigDecimal norMalFenZi = realInterfaceRecord.getFlightNormalRateNumerator();
//        BigDecimal normalFenMu = realInterfaceRecord.getFlightNormalRateDenominator();
//        if (normalFenMu.intValue() == 0) {
//            vo.setNormalRate("0");
//        } else {
//            BigDecimal divide = norMalFenZi.multiply(new BigDecimal(100)).divide(normalFenMu,1,BigDecimal.ROUND_HALF_DOWN);
//
//            String str = String.valueOf(divide);
//            vo.setNormalRate(new DecimalFormat(".0").format((100-Float.parseFloat(str))));
//        }

        //放行率：
//        BigDecimal passFenZi = realInterfaceRecord.getFlightReleaseRateNumerator();
//        BigDecimal passFenMu = realInterfaceRecord.getfReleaseRateDenominator();
//        if (passFenMu.intValue() == 0) {
//            vo.setPassRate("0");
//        } else {
//            BigDecimal divide = passFenZi.multiply(new BigDecimal(100)).divide(passFenMu,1,BigDecimal.ROUND_HALF_DOWN);
//
//            String str = String.valueOf(divide);
//            vo.setPassRate(new DecimalFormat(".0").format((100-Float.parseFloat(str))));
//        }

        //最近进港航班
        List<FiveD> recentInboundList = delayLiveMapper.getRecentInbound();
        if (null != recentInboundList && recentInboundList.size() > 0) {
            FiveD recentInbound = recentInboundList.get(0);
            vo.setRecentInbound(recentInbound.getD0());
            //进港时间
            vo.setInboundTime(recentInbound.getD1());
        }

        //最近离港航班
        List<FiveD> recentOutboundList = delayLiveMapper.getRecentOutbound();
        if (null != recentOutboundList && recentOutboundList.size() > 0) {
            FiveD recentOutbound = delayLiveMapper.getRecentOutbound().get(0);
            vo.setRecentOutbound(recentOutbound.getD0());
            //离港时间
            vo.setOutboundTime(recentOutbound.getD1());
        }

        //本小时和未来一小时起降航班数量
//        List<VAordcount1hour> hourList = vAordcount1hourMapper.get();
//        if (null != hourList && hourList.size()>0) {
//            VAordcount1hour hour = hourList.get(0);
//            List<FiveD> fiveDListTable5 = Lists.newArrayList();
//            for (int i = 0;i < 2;i++) {
//                FiveD fiveD = new FiveD();
//                if (i == 0) {
//                    fiveD.setD0("起飞数量");
//                    //过去一小时
//                    int lastFlightNum_D = vAordcount1hourMapper.getLastFlightNum_D();
//                    fiveD.setD1(String.valueOf(lastFlightNum_D));
//                    //当前一小时
//                    fiveD.setD2(String.valueOf(hour.getDcountthish()));
//                    //未来一小时
//                    fiveD.setD3(String.valueOf(hour.getDcountnexth()));
//                    //合计，要加上过去一小时的
//                    fiveD.setD4(String.valueOf(hour.getDcount().intValue()+lastFlightNum_D));
//                } else {
//                    fiveD.setD0("降落数量");
//                    //过去一小时
//                    int lastFlightNum_A = vAordcount1hourMapper.getLastFlightNum_A();
//                    fiveD.setD1(String.valueOf(lastFlightNum_A));
//                    //当前一小时
//                    fiveD.setD1(String.valueOf(hour.getAcountthish()));
//                    //未来一小时
//                    fiveD.setD2(String.valueOf(hour.getAcountnexth()));
//                    //合计，要加上过去一小时的
//                    fiveD.setD3(String.valueOf(hour.getAcount().intValue()+lastFlightNum_A));
//                }
//                fiveDListTable5.add(fiveD);
//            }
//            vo.setTableData5(fiveDListTable5);
//        }

        return vo;
    }


    public DelayNumberVO getDelayInfoByMobile(@Param("params") Map params){
        DelayNumberVO dnv = new DelayNumberVO();
        Map<String,Object>  map = delayLiveMapper.getDelayInfoByMobile(params);
        int []executedList = new int[]{0,0,0,0};
        int []nonExecutionList = new int[]{0,0,0,0};
        if(map != null){
            executedList[3] = Integer.parseInt(map.get("COUNT60Y").toString());
            nonExecutionList[3] = Integer.parseInt(map.get("COUNT60N").toString());
            executedList[2] = Integer.parseInt(map.get("COUNT120Y").toString());
            nonExecutionList[2] = Integer.parseInt(map.get("COUNT120N").toString());
            executedList[1] = Integer.parseInt(map.get("COUNT180Y").toString());
            nonExecutionList[1] = Integer.parseInt(map.get("COUNT180N").toString());
            executedList[0] = Integer.parseInt(map.get("COUNT240Y").toString());
            nonExecutionList[0] = Integer.parseInt(map.get("COUNT240N").toString());
        }
        dnv.setExecutedList(executedList);
        dnv.setNonExecutionList(nonExecutionList);

        return dnv;
    }
}
