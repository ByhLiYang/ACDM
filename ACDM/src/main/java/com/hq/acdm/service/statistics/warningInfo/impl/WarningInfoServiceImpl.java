package com.hq.acdm.service.statistics.warningInfo.impl;

import com.hq.acdm.dao.statistics.WarningInfoMapper;
import com.hq.acdm.model.statistics.warningInfo.*;
import com.hq.acdm.service.statistics.warningInfo.WarningInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/29 0029 15:16
 */
@Service("WarningInfoService")
public class WarningInfoServiceImpl implements WarningInfoService{
    @Resource
    private WarningInfoMapper warningInfoMapper;

    @Override
    public int INSERT_OPERATION_LOG(Map<String, Object> map) {
        return warningInfoMapper.INSERT_OPERATION_LOG(map);
    }


    @Override
    public Map<String, Object> queryWarningInfo() throws ParseException {
        Map<String,Object> map = new HashMap<>();
        Date currentDate = new Date();
//        Calendar calendar=Calendar.getInstance();
//        calendar.setTime(currentDate);
//        calendar.get(Calendar.HOUR);
        SimpleDateFormat sdateformat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        // 取得高峰时间段（8点~23点）每小时出港航班执行率
        List<ExecutionModel> list_SELECT_EXECRATE_08_23 = warningInfoMapper.SELECT_EXECRATE_08_23();
        List<String> list_hour_SELECT_EXECRATE_08_23 = new ArrayList<>();
        List<String> list_rate_SELECT_EXECRATE_08_23 = new ArrayList<>();
        List<String> list_modifyExecuteRate = new ArrayList<>();
        Map<Integer,Double> map1 = new HashMap<>();
        List<WarningInfo> listWariningInfo = warningInfoMapper.QUERY_OPERATION_LOG();

        for(ExecutionModel executionModel:list_SELECT_EXECRATE_08_23){
            list_hour_SELECT_EXECRATE_08_23.add(executionModel.getAHOUR());
            list_rate_SELECT_EXECRATE_08_23.add(executionModel.getARATE());
        }
        for(int i=0;i<list_hour_SELECT_EXECRATE_08_23.size();i++){
            map1.put(i,Double.valueOf(list_rate_SELECT_EXECRATE_08_23.get(i)));
            if(Double.valueOf(list_hour_SELECT_EXECRATE_08_23.get(i))<=currentDate.getHours()){
                list_modifyExecuteRate.add(list_rate_SELECT_EXECRATE_08_23.get(i));
            }
        }
        if(list_SELECT_EXECRATE_08_23.size()>0){
            map.put("executeHour",list_hour_SELECT_EXECRATE_08_23);
            map.put("executeRate",list_modifyExecuteRate);
        }else{
            map.put("executeHour","error");
            map.put("executeRate","error");
        }

        // 取得高峰时间段（8点~23点）出港延误1小时以上未起飞的航班数（按每小时统计）
        List<ExecutionModel> list_SELECT_DELAY1H_UNEXEC_08_23 = warningInfoMapper.SELECT_DELAY1H_UNEXEC_08_23();
        List<String> list_hour_SELECT_DELAY1H_UNEXEC_08_23 = new ArrayList<>();
        List<String> list_rate_SELECT_DELAY1H_UNEXEC_08_23 = new ArrayList<>();
        List<String> list_modify_execute_delay = new ArrayList<>();
        for(ExecutionModel executionModel:list_SELECT_DELAY1H_UNEXEC_08_23){
            list_hour_SELECT_DELAY1H_UNEXEC_08_23.add(executionModel.getAHOUR());
            list_rate_SELECT_DELAY1H_UNEXEC_08_23.add(executionModel.getARATE());
        }
        for(int i=0;i<list_hour_SELECT_DELAY1H_UNEXEC_08_23.size();i++){
            if(Double.valueOf(list_hour_SELECT_DELAY1H_UNEXEC_08_23.get(i))<=currentDate.getHours()){
                list_modify_execute_delay.add(list_rate_SELECT_DELAY1H_UNEXEC_08_23.get(i));
            }
        }
        if(list_SELECT_DELAY1H_UNEXEC_08_23.size()>0){
            map.put("executeDelayHour",list_hour_SELECT_DELAY1H_UNEXEC_08_23);
            map.put("executeDelayRate",list_modify_execute_delay);
        }else{
            map.put("executeDelayHour","error");
            map.put("executeDelayRate","error");
        }

        // 取得当日计划、已执行、已取消
        List<V_UTIL_DAILY_FLIGHTModel> list_SELECT_BASIC_DATA_01 = warningInfoMapper.SELECT_BASIC_DATA_01();
        if(list_SELECT_BASIC_DATA_01.size()>0){
            map.put("executeToday",list_SELECT_BASIC_DATA_01.get(0).getFLIGHT_NUM());
            map.put("executeReady",list_SELECT_BASIC_DATA_01.get(0).getALREADY_NUM());
            map.put("cancelReady",list_SELECT_BASIC_DATA_01.get(0).getCANCEL_NUM());
        }else{
            map.put("executeToday","error");
            map.put("executeReady","error");
            map.put("cancelReady","error");
        }
        // 取得当前计划数
        List<ScheduleModel> list_SELECT_BASIC_DATA_02 = warningInfoMapper.SELECT_BASIC_DATA_02();
        if(list_SELECT_BASIC_DATA_02.size()>0){
            map.put("scheduleNum",list_SELECT_BASIC_DATA_02.get(0).getFLIGHT_NUM());
        }else{
            map.put("scheduleNum","error");
        }
        // 取得返航备降数
        List<ReturnFlightNumberModel> list_SELECT_BASIC_DATA_03 = warningInfoMapper.SELECT_BASIC_DATA_03();
        if(list_SELECT_BASIC_DATA_03.size()>0){
            map.put("returnNum",list_SELECT_BASIC_DATA_03.get(0).getFLIGHT_NUM());
        }else{
            map.put("returnNum","error");
        }
        // 取得出港延误数
        List<OutBoundDelayModel> list_SELECT_BASIC_DATA_04 = warningInfoMapper.SELECT_BASIC_DATA_04();
        if(list_SELECT_BASIC_DATA_04.size()>0){
            map.put("startReady",list_SELECT_BASIC_DATA_04.get(0).getEXCNT());
            map.put("unStartReady",list_SELECT_BASIC_DATA_04.get(0).getUNCNT());
            map.put("start2Ready",list_SELECT_BASIC_DATA_04.get(0).getEX2CNT());
            map.put("unStart2Ready",list_SELECT_BASIC_DATA_04.get(0).getUN2CNT());
        }else{
            map.put("startReady","error");
            map.put("unStartReady","error");
            map.put("start2Ready","error");
            map.put("unStart2Ready","error");
        }
        // 取得前小时和本小时执行数和计划数
        List<ThisHourExcuteScheduleModel> list_SELECT_BASIC_DATA_05 = warningInfoMapper.SELECT_BASIC_DATA_05();
        if(list_SELECT_BASIC_DATA_05.size()>0){
            map.put("hour8scheduleReady",list_SELECT_BASIC_DATA_05.get(0).getPREDCNT());
            map.put("hour8executeReady",list_SELECT_BASIC_DATA_05.get(0).getPREACNT());
            map.put("hourScheduleReady",list_SELECT_BASIC_DATA_05.get(0).getTHISHOURDCNT());
            map.put("hourExecuteReady",list_SELECT_BASIC_DATA_05.get(0).getTHISHOURACNT());
        }else{
            map.put("hour8scheduleReady","error");
            map.put("hour8executeReady","error");
            map.put("hourScheduleReady","error");
            map.put("hourExecuteReady","error");
        }
        // 取得可用机位数
        List<StandModel> list_SELECT_BASIC_DATA_06 = warningInfoMapper.SELECT_BASIC_DATA_06();
        if(list_SELECT_BASIC_DATA_06.size()>0){
            map.put("stand",list_SELECT_BASIC_DATA_06.get(0).getSTANDS());
        }else{
            map.put("stand","error");

        }
        // 取得当前预警的状态
        List<CurrentWarningStatusModel> list_SELECT_BASIC_DATA_07 = warningInfoMapper.SELECT_BASIC_DATA_07();
        if(list_SELECT_BASIC_DATA_07.size()>0){
            map.put("preWarningStatus",list_SELECT_BASIC_DATA_07.get(0).getCURSTATUS());
        }else{
            map.put("preWarningStatus","error");
        }
        // 出港延误1小时以上未起飞的航班数占当日出港航班计划数的比率
        List<ExecutionModel> list_SELECT_DELAY1H_UNEXEC = warningInfoMapper.SELECT_DELAY1H_UNEXEC();
        if(list_SELECT_DELAY1H_UNEXEC.size()>0){
            map.put("preWarningPercentage",list_SELECT_DELAY1H_UNEXEC.get(0).getARATE());
        }else{
            map.put("preWarningPercentage","error");
        }
        // 机场无航班起降小时数
        List<NoFlightHourModel> list_SELECT_UNEXEC_HOURS = warningInfoMapper.SELECT_UNEXEC_HOURS();
        List<String> listSELECT_UNEXEC_HOUR = new ArrayList<>();
        for(int i=0;i<list_SELECT_UNEXEC_HOURS.size();i++){
            listSELECT_UNEXEC_HOUR.add(list_SELECT_UNEXEC_HOURS.get(i).getADT());
        }
//        if(list_SELECT_UNEXEC_HOURS.size()>0){
//            map.put("hourNoFlight",list_SELECT_UNEXEC_HOURS.get(0).getADT());
//        }else{
//            map.put("hourNoFlight","error");
//        }
        // 未来1小时出港执行率
        List<ExecutionModel> list_SELECT_EXECDRATE_1HOURAFTER = warningInfoMapper.SELECT_EXECDRATE_1HOURAFTER();
        if(list_SELECT_EXECDRATE_1HOURAFTER.size()>0){
            map.put("hourNextD",list_SELECT_EXECDRATE_1HOURAFTER.get(0).getARATE());
        }else{
            map.put("hourNextD","error");
        }
        // 未来1小时进港执行率
        List<ExecutionModel> list_SELECT_EXECARATE_1HOURAFTER = warningInfoMapper.SELECT_EXECARATE_1HOURAFTER();
        if(list_SELECT_EXECARATE_1HOURAFTER.size()>0){
            map.put("hourNextA",list_SELECT_EXECARATE_1HOURAFTER.get(0).getARATE());
        }else{
            map.put("hourNextA","error");
        }
        // 本小时出港执行率
        List<ExecutionModel> list_SELECT_EXECDRATE_THISHOUR = warningInfoMapper.SELECT_EXECDRATE_THISHOUR();
        if(list_SELECT_EXECDRATE_THISHOUR.size()>0){
            map.put("thisHourD",list_SELECT_EXECDRATE_THISHOUR.get(0).getARATE());
            if("error".equals(map.get("hourNextD"))){
                map.put("hourCompareD","error");
            }else{
                double nextD = Double.valueOf((String) map.get("hourNextD"));
                double thisD = Double.valueOf(list_SELECT_EXECDRATE_THISHOUR.get(0).getARATE());
                if((nextD-thisD)>0){
                    map.put("hourCompareD","上升趋势");
                }else if((nextD-thisD)==0){
                    map.put("hourCompareD","相等趋势");
                }else if((nextD-thisD)<0){
                    map.put("hourCompareD","下降趋势");
                }
            }
        }else{
            map.put("thisHourD","error");
            map.put("hourCompareD","error");
        }
        // 本小时进港执行率
        List<ExecutionModel> list_SELECT_EXECARATE_THISHOUR = warningInfoMapper.SELECT_EXECARATE_THISHOUR();
        if(list_SELECT_EXECARATE_THISHOUR.size()>0){
            map.put("thisHourA",list_SELECT_EXECARATE_THISHOUR.get(0).getARATE());
            if("error".equals(map.get("hourNextA"))){
                map.put("hourCompareA","error");
            }else{
                double nextA = Double.valueOf((String) map.get("hourNextA"));
                double thisA = Double.valueOf(list_SELECT_EXECARATE_THISHOUR.get(0).getARATE());
                if((nextA-thisA)>0){
                    map.put("hourCompareA","上升趋势");
                }else if((nextA-thisA)==0){
                    map.put("hourCompareA","相等趋势");
                }else if((nextA-thisA)<0){
                    map.put("hourCompareA","下降趋势");
                }
            }
        }else{
            map.put("thisHourA","error");
            map.put("hourCompareA","error");
        }
        Date now = new Date();
        int hour = now.getHours();
        int j1hours = 0;
        hour = hour - 8;
        for(int i=1;i<16;i++){
            if((hour-i)>=0 && map1.get(hour-i)<50){
                j1hours = j1hours +1;
            }else{
                break;
            }
        }

        double j2rate = Double.valueOf(list_SELECT_DELAY1H_UNEXEC.get(0).getARATE());
        int j3hours = 0;
        int maxspan = 0, tmpspan = 0;
        if(listSELECT_UNEXEC_HOUR.size()>=2){
            for(int i=1;i<listSELECT_UNEXEC_HOUR.size();i++){
                Date date1 = null;
                Date date2 = null;
                date1 = sdateformat.parse(listSELECT_UNEXEC_HOUR.get(i-1));
                date2 = sdateformat.parse(listSELECT_UNEXEC_HOUR.get(i));
                tmpspan = (int)(date2.getTime()-date1.getTime())/(60*1000);
                if(tmpspan > maxspan){
                    maxspan = tmpspan;
                }
            }
            j3hours = maxspan / 60;
        }
        String ewarning = "noneed";
        int condition11 = 0, condition12 = 0, condition21 = 0, condition22 = 0, condition31 = 0, condition32 = 0;
        if (j1hours >= 4 && j2rate >= 10) {
            ewarning = "yellow";
            condition11 = 1;
        }
        if (j3hours >= 1) {
            ewarning = "yellow";
            condition12 = 1;
        }
        if (j1hours >= 6 && j2rate >= 15) {
            ewarning = "orange";
            condition21 = 1;
        }
        if (j3hours >= 2) {
            ewarning = "orange";
            condition22 = 1;
        }
        if (j1hours >= 8 && j2rate >= 20) {
            ewarning = "red";
            condition31 = 1;
        }
        if (j3hours >= 3) {
            ewarning = "red";
            condition32 = 1;
        }
        map.put("hourConsecutive",j1hours);
        map.put("hourNoFlight",j3hours);
        map.put("EWARNING", ewarning);
        if (condition31 > 0 || condition32 > 0) {
            if (condition31 > 0 && condition32 > 0) { map.put("CONDITION", 3);
                map.put("CONDITION1","满足条件一（红色响应）和条件二（红色响应）");
            }
            else if (condition31 > 0) { map.put("CONDITION", 1);
                map.put("CONDITION1","满足条件一（红色响应），不满足条件二（红色响应）");
            }
            else if (condition32 > 0) { map.put("CONDITION", 2);
                map.put("CONDITION1","不满足条件一（红色响应），满足条件二（红色响应）");}
        } else if (condition21 > 0 || condition22 > 0) {
            if (condition21 > 0 && condition22 > 0) { map.put("CONDITION", 3);
                map.put("CONDITION1","满足条件一（橙色响应）和条件二（橙色响应）");

            }
            else if (condition21 > 0) { map.put("CONDITION", 1);
                map.put("CONDITION1","满足条件一（橙色响应），不满足条件二（橙色响应）");
            }
            else if (condition22 > 0) { map.put("CONDITION", 2);
                map.put("CONDITION1","不满足条件一（橙色响应），满足条件二（橙色响应）");
            }
        } else if (condition11 > 0 || condition12 > 0) {
            if (condition11 > 0 && condition12 > 0) { map.put("CONDITION", 3);
                map.put("CONDITION1","满足条件一（黄色响应）和条件二（黄色响应）");
            }
            else if (condition11 > 0) { map.put("CONDITION", 1);
                map.put("CONDITION1","满足条件一（黄色响应），不满足条件二（黄色响应）");
            }
            else if (condition12 > 0) { map.put("CONDITION", 2);
                map.put("CONDITION1","不满足条件一（黄色响应），满足条件二（黄色响应）");
            }
        } else {
            map.put("CONDITION", 0);
            map.put("CONDITION1","不满足条件一和条件二");
        }
        if(listWariningInfo.size()>0){
            map.put("HistoryStatus", listWariningInfo.get(0).getCURSTATUS());
        }else{
            map.put("HistoryStatus", '0');
        }
        WarningInfo warningInfo = warningInfoMapper.queryStatus();
            map.put("ModifyStatusTime",warningInfo.getDTIME());
            map.put("ModifyStatus",warningInfo.getCURSTATUS());
        return map;
    }
}
