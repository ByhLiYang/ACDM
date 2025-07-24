package com.hq.acdm.service.coordinatedOprt.impl;

import com.hq.acdm.dao.coordinatedOprt.*;
import com.hq.acdm.dao.realtimeSituation.FlightIndexMapper;
import com.hq.acdm.service.coordinatedOprt.DelayPrejudgeService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.vo.coordinatedOprt.*;
import org.apache.ibatis.annotations.Param;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class DelayPrejudgeServiceImpl implements DelayPrejudgeService {

    @Resource
    private DelayPrejudgeMapper delayPrejudgeMapper;
    @Resource
    private FlightIndexMapper flightIndexMapper;
    @Resource
    private TEmergencyDisposalMapper tEmergencyDisposalMapper;
    @Resource
    private TEdTaskConfigMapper tEdTaskConfigMapper;
    @Resource
    private TEdDynTaskMapper tEdDynTaskMapper;
    @Resource
    private TEdResponseMapper tEdResponseMapper;
    @Resource
    private TEdWarningMapper tEdWarningMapper;

    //航班执行情况
    @Override
    public List<DelayPrejudgeHBZXQKVo> findFligthExecInfo() {
        return delayPrejudgeMapper.findFligthExecInfo();
    }

    //机场运行效率
    @Override
    public List<DelayPrejudgeJCYXXLVo> findAirRunEfficiency(){
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("agent","");
        int kyjws = flightIndexMapper.getJWZS(queryMap)-flightIndexMapper.getZYJW(queryMap);
        List<DelayPrejudgeJCYXXLVo> list = delayPrejudgeMapper.findAirRunEfficiency();
        list.get(0).setKyjws(kyjws+"");
        return list;
    }

    //执行率
    @Override
    public List<DelayPrejudgeExeVarVo> findExeRate(){
        return delayPrejudgeMapper.findExeRate();
    }

    //出港延误一小时以上未起飞航班数
    @Override
    public List<DelayPrejudgeExeVarVo> findDelayNotTakingOff(){
        List<DelayPrejudgeExeVarVo> voList = new ArrayList<DelayPrejudgeExeVarVo>();
        List<DelayPrejudgeExeVarVo> list = delayPrejudgeMapper.findDelayNotTakingOff();
        String []hbs = new String[]{"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
        if(list != null && list.size()>0){
            for(int i=0;i<list.size();i++){
                if("08".equals(list.get(i).getTimeH())){
                    hbs[0] = list.get(i).getRate();
                }
                if("09".equals(list.get(i).getTimeH())){
                    hbs[1] = list.get(i).getRate();
                }
                if("10".equals(list.get(i).getTimeH())){
                    hbs[2] = list.get(i).getRate();
                }
                if("11".equals(list.get(i).getTimeH())){
                    hbs[3] = list.get(i).getRate();
                }
                if("12".equals(list.get(i).getTimeH())){
                    hbs[4] = list.get(i).getRate();
                }
                if("13".equals(list.get(i).getTimeH())){
                    hbs[5] = list.get(i).getRate();
                }
                if("14".equals(list.get(i).getTimeH())){
                    hbs[6] = list.get(i).getRate();
                }
                if("15".equals(list.get(i).getTimeH())){
                    hbs[7] = list.get(i).getRate();
                }
                if("16".equals(list.get(i).getTimeH())){
                    hbs[8] = list.get(i).getRate();
                }
                if("17".equals(list.get(i).getTimeH())){
                    hbs[9] = list.get(i).getRate();
                }
                if("18".equals(list.get(i).getTimeH())){
                    hbs[10] = list.get(i).getRate();
                }
                if("19".equals(list.get(i).getTimeH())){
                    hbs[11] = list.get(i).getRate();
                }
                if("20".equals(list.get(i).getTimeH())){
                    hbs[12] = list.get(i).getRate();
                }
                if("21".equals(list.get(i).getTimeH())){
                    hbs[13] = list.get(i).getRate();
                }
                if("22".equals(list.get(i).getTimeH())){
                    hbs[14] = list.get(i).getRate();
                }
                if("23".equals(list.get(i).getTimeH())){
                    hbs[15] = list.get(i).getRate();
                }
            }

            for(int k=0;k<hbs.length;k++){
                DelayPrejudgeExeVarVo ev = new DelayPrejudgeExeVarVo();
                if(k<2){
                    int kk = k+8;
                    ev.setTimeH("0"+kk);
                }else{
                    ev.setTimeH(k+8+"");
                }
                ev.setRate(hbs[k]);
                voList.add(ev);
            }
        }else{
            for(int j=8;j<24;j++){
                DelayPrejudgeExeVarVo dpevv = new DelayPrejudgeExeVarVo();
                if(j<10){
                    dpevv.setTimeH("0"+j);
                }else{
                    dpevv.setTimeH(j+"");
                }
                dpevv.setRate("0");
                voList.add(dpevv);
            }
        }
        return voList;
    }

    //出港延误1小时以上未起飞的航班数占当日出港航班计划数的比率
    public List<DelayPrejudgeExeVarVo> findDelayNotTakingOffRate1H(){
        return delayPrejudgeMapper.findDelayNotTakingOffRate1H();
    }

    //机场航班起降小时数(相减得相差小时数)
    public List<String> findTakingOffH(){
        return delayPrejudgeMapper.findTakingOffH();
    }

    //未来1小时出港执行率
    public List<String> findFuture1HFltDRate(){
        return delayPrejudgeMapper.findFuture1HFltDRate();
    }

    //未来1小时进港执行率
    public List<String> findFuture1HFltARate(){
        return delayPrejudgeMapper.findFuture1HFltARate();
    }

    //本小时出港执行率
    public List<String> findFutureCurrHFltDRate(){
        return delayPrejudgeMapper.findFutureCurrHFltDRate();
    }

    //本小时出港执行率
    public List<String> findFutureCurrHFltARate(){
        return delayPrejudgeMapper.findFutureCurrHFltARate();
    }
    //航延预判数据信息
    public Map<String,Object> findDelayPrejudgeInfo(){
        Map<String,Object> map = new HashMap<String,Object>();
        Date currentDate = new Date();
        SimpleDateFormat sdateformat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        try{
            // 取得高峰时间段（8点~23点）每小时出港航班执行率
            List<DelayPrejudgeExeVarVo> list_SELECT_EXECRATE_08_23 = this.findExeRate();
            List<String> list_hour_SELECT_EXECRATE_08_23 = new ArrayList<>();
            List<String> list_rate_SELECT_EXECRATE_08_23 = new ArrayList<>();
            List<String> list_modifyExecuteRate = new ArrayList<>();
            Map<Integer,Double> map1 = new HashMap<>();
            for(DelayPrejudgeExeVarVo vo : list_SELECT_EXECRATE_08_23){
                list_hour_SELECT_EXECRATE_08_23.add(vo.getTimeH());
                list_rate_SELECT_EXECRATE_08_23.add(vo.getRate());
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
            List<DelayPrejudgeExeVarVo> list_SELECT_DELAY1H_UNEXEC_08_23 = this.findDelayNotTakingOff();
            List<String> list_hour_SELECT_DELAY1H_UNEXEC_08_23 = new ArrayList<>();
            List<String> list_rate_SELECT_DELAY1H_UNEXEC_08_23 = new ArrayList<>();
            List<String> list_modify_execute_delay = new ArrayList<>();
            for(DelayPrejudgeExeVarVo vo : list_SELECT_DELAY1H_UNEXEC_08_23){
                list_hour_SELECT_DELAY1H_UNEXEC_08_23.add(vo.getTimeH());
                list_rate_SELECT_DELAY1H_UNEXEC_08_23.add(vo.getRate());
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
            //航班执行情况
            List<DelayPrejudgeHBZXQKVo> listFligthExecInfo = findFligthExecInfo();
            if(listFligthExecInfo != null && listFligthExecInfo.size() > 0){
                map.put("executeToday",listFligthExecInfo.get(0).getPlanDay());//当日计划
                map.put("scheduleNum",listFligthExecInfo.get(0).getPlanCurr());//当前计划
                map.put("executeReady",listFligthExecInfo.get(0).getExecOk());//已执行
                map.put("cancelReady",listFligthExecInfo.get(0).getCancel());//已取消
                map.put("returnNum",listFligthExecInfo.get(0).getRtnAlt());//返航备降
                map.put("startReady",listFligthExecInfo.get(0).getDelayQf());//出港延误起飞
                map.put("unStartReady",listFligthExecInfo.get(0).getDelayNotQf());//出港延误未起飞
                map.put("start2Ready",listFligthExecInfo.get(0).getDelayQf2h());//出港延误2小时起飞
                map.put("unStart2Ready",listFligthExecInfo.get(0).getDelayNotQf2h());//出港延误2小时未起飞
            }else{
                map.put("executeToday","error");
                map.put("scheduleNum","error");
                map.put("executeReady","error");
                map.put("cancelReady","error");
                map.put("returnNum","error");
                map.put("startReady","error");
                map.put("unStartReady","error");
                map.put("start2Ready","error");
                map.put("unStart2Ready","error");
            }
            //机场运行效率
            List<DelayPrejudgeJCYXXLVo> listAirRunEfficiency = findAirRunEfficiency();
            if(listAirRunEfficiency != null && listAirRunEfficiency.size()>0){
                map.put("hour1scheduleReady",listAirRunEfficiency.get(0).getHbjhQ2h());//前1小时计划班次
                map.put("hour1executeReady",listAirRunEfficiency.get(0).getHbzxQ2h());//前1小时执行班次
                map.put("hourScheduleReady",listAirRunEfficiency.get(0).getHbjhQ1h());//本小时计划班次
                map.put("hourExecuteReady",listAirRunEfficiency.get(0).getHbzxQ1h());//本小时执行班次
                map.put("stand",listAirRunEfficiency.get(0).getKyjws());//可用机位数
            }else{
                map.put("hour8scheduleReady","error");
                map.put("hour8executeReady","error");
                map.put("hourScheduleReady","error");
                map.put("hourExecuteReady","error");
                map.put("stand","error");
            }
            // 出港延误1小时以上未起飞的航班数占当日出港航班计划数的比率
            List<DelayPrejudgeExeVarVo> list_SELECT_DELAY1H_UNEXEC = this.findDelayNotTakingOffRate1H();
            if(list_SELECT_DELAY1H_UNEXEC.size()>0){
                map.put("preWarningPercentage",list_SELECT_DELAY1H_UNEXEC.get(0).getRate());
            }else{
                map.put("preWarningPercentage","error");
            }
            // 机场无航班起降小时数
            List<String> listSELECT_UNEXEC_HOUR = this.findTakingOffH();
            // 未来1小时出港执行率
            List<String> list_SELECT_EXECDRATE_1HOURAFTER = this.findFuture1HFltDRate();
            if(list_SELECT_EXECDRATE_1HOURAFTER.size()>0){
                map.put("hourNextD",list_SELECT_EXECDRATE_1HOURAFTER.get(0));
            }else{
                map.put("hourNextD","error");
            }
            // 未来1小时进港执行率
            List<String> list_SELECT_EXECARATE_1HOURAFTER = this.findFuture1HFltDRate();
            if(list_SELECT_EXECARATE_1HOURAFTER.size()>0){
                map.put("hourNextA",list_SELECT_EXECARATE_1HOURAFTER.get(0));
            }else{
                map.put("hourNextA","error");
            }
            // 本小时出港执行率
            List<String> list_SELECT_EXECDRATE_THISHOUR = this.findFutureCurrHFltDRate();
            if(list_SELECT_EXECDRATE_THISHOUR.size()>0){
                map.put("thisHourD",list_SELECT_EXECDRATE_THISHOUR.get(0));
                if("error".equals(map.get("hourNextD"))){
                    map.put("hourCompareD","error");
                }else{
                    double nextD = Double.valueOf((String) map.get("hourNextD"));
                    double thisD = Double.valueOf(list_SELECT_EXECDRATE_THISHOUR.get(0));
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
            List<String> list_SELECT_EXECARATE_THISHOUR = this.findFutureCurrHFltARate();
            if(list_SELECT_EXECARATE_THISHOUR.size()>0){
                map.put("thisHourA",list_SELECT_EXECARATE_THISHOUR.get(0));
                if("error".equals(map.get("hourNextA"))){
                    map.put("hourCompareA","error");
                }else{
                    double nextA = Double.valueOf((String) map.get("hourNextA"));
                    double thisA = Double.valueOf(list_SELECT_EXECARATE_THISHOUR.get(0));
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

            double j2rate = Double.valueOf(String.valueOf(list_SELECT_DELAY1H_UNEXEC.get(0).getRate()));
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
           /* String ewarning = "noneed";
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
            }*/

            String ewarning = "n";
            int condition11 = 0, condition12 = 0, condition21 = 0, condition22 = 0, condition31 = 0, condition32 = 0;
            if (j2rate >= 10 && j2rate < 15) {
                ewarning = "y";
            }else if (j1hours >= 15 && j2rate < 20) {
                ewarning = "o";
            }else if (j1hours >= 20) {
                ewarning = "r";
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
        }catch(ParseException e){
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<FutureDelayVo> findFtDelays() {
        List<FutureDelayVo> list = delayPrejudgeMapper.findFtDelays();
//        合并同航班ID的多条记录
        Map<String,FutureDelayVo> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            //存在同航班ID时，合并LEVEL，REASON
            if (map.containsKey(list.get(i).getFLIGHTID())){
                if (list.get(i).getLEVEL().equals("RED")){
                    map.get(list.get(i).getFLIGHTID()).setLEVEL("RED");
                }
                map.get(list.get(i).getFLIGHTID()).setREASON(map.get(list.get(i).getFLIGHTID()).getREASON()+','+list.get(i).getREASON());
            }else {
                map.put(list.get(i).getFLIGHTID(),list.get(i));
            }
        }
        List<FutureDelayVo> reList = new ArrayList<>();
        for (String key : map.keySet()){
            map.get(key).setSOBT(DateTimeUtil.timeDayFormatByStr(map.get(key).getSOBT()));
            reList.add(map.get(key));
        }
        return reList;
    }

    @Override
    public TEmergencyDisposal findWarningId() {
        TEmergencyDisposalExample tede = new TEmergencyDisposalExample();
        TEmergencyDisposalExample.Criteria criteria = tede.createCriteria();
        criteria.andLevelNotEqualTo("n");
        List<TEmergencyDisposal> listTed = tEmergencyDisposalMapper.selectByExample(tede);
        if (null!=listTed&&listTed.size()>0&&null!=listTed.get(0)){
            return listTed.get(0);
        }
        return null;
    }

    @Override
    public TEmergencyDisposal findWarningChat(String level,String edId) {
        TEmergencyDisposal ted = new TEmergencyDisposal();
        if (null==edId||"".equals(edId)){
            //生成一条应急处置记录
            ted.setId(UUID.randomUUID().toString().replace("-",""));
            ted.setStartTime(new Date());
            if ("y".equals(level)){
                ted.setLevel("y");
                ted.setReason("由于满足黄色响应（大于10%），建议启动黄色预警");
            }else if ("o".equals(level)){
                ted.setLevel("o");
                ted.setReason("由于满足橙色响应（大于15%），建议启动橙色预警");
            }else if ("r".equals(level)){
                ted.setLevel("r");
                ted.setReason("由于满足红色响应（大于20%），建议启动红色预警");
            }else{
                ted.setLevel("n");
            }
            int result = tEmergencyDisposalMapper.insertSelective(ted);
            //根据预警等级查询对应处置任务清单
            TEdTaskConfigExample tetce = new TEdTaskConfigExample();
            TEdTaskConfigExample.Criteria tetcCriteria = tetce.createCriteria();
            tetcCriteria.andLevelEqualTo(ted.getLevel());
            List<TEdTaskConfig> listTetc = tEdTaskConfigMapper.selectByExample(tetce);
            //根据预警等级生成对应的处置任务清单
            if (null!=listTetc&&result>0){
                TEdDynTask tedt = new TEdDynTask();
                tedt.setEdId(ted.getId());
                tedt.setCreateTime(new Date());
                tedt.setStartTime(new Date());
                for (int i = 0; i < listTetc.size(); i++) {
                    tedt.setId(UUID.randomUUID().toString().replace("-",""));
                    tedt.setTaskName(listTetc.get(i).getTaskName());
                    tEdDynTaskMapper.insertSelective(tedt);
                }
            }
        }else{
            ted.setLevel(level);
            ted.setId(edId);
            ted.setStartTime(new Date());
            if ("y".equals(level)){
                ted.setReason("由于满足黄色响应（大于10%），建议启动黄色预警");
            }else if ("o".equals(level)){
                ted.setReason("由于满足橙色响应（大于15%），建议启动橙色预警");
            }else if ("r".equals(level)){
                ted.setReason("由于满足红色响应（大于20%），建议启动红色预警");
            }else{
                ted.setLevel("n");
            }
            tEmergencyDisposalMapper.updateByPrimaryKeySelective(ted);
        }

        //查询返回处置记录
        return ted;
    }

    @Override
    public List<TEdDynTask> findTaskList(String edId) {
        TEdDynTaskExample tedte = new TEdDynTaskExample();
        TEdDynTaskExample.Criteria tedtCriteria = tedte.createCriteria();
        tedtCriteria.andEdIdEqualTo(edId);
        return tEdDynTaskMapper.selectByExample(tedte);
    }

    @Override
    public TEdResponse findResponseEt(String edId) {
        TEdResponseExample tere = new TEdResponseExample();
        TEdResponseExample.Criteria terCriteria = tere.createCriteria();
        terCriteria.andEdIdEqualTo(edId);
        List<TEdResponse> listTer = tEdResponseMapper.selectByExample(tere);
        if (null==listTer||listTer.size()==0||null==listTer.get(0)){
            TEdResponse ter = new TEdResponse();
            ter.setEdId(edId);
            return ter;
        }else{
            return listTer.get(0);
        }
    }

    @Override
    public TEdResponse findResponseCalc(String edId) {
        //启动延误预警-响应表实时航班信息
        TEdResponse ter = delayPrejudgeMapper.findFltResponse();
        if (null==ter){
            ter = new TEdResponse();
        }
        ter.setEdId(edId);
        return ter;
    }

    @Override
    public TEdWarning findWarningInfo(String edId) {
        TEdWarningExample tewe = new TEdWarningExample();
        TEdWarningExample.Criteria tewCriteria = tewe.createCriteria();
        tewCriteria.andEdIdEqualTo(edId);
        List<TEdWarning> listTew = tEdWarningMapper.selectByExample(tewe);
        if (null==listTew||listTew.size()==0||null==listTew.get(0)){
            TEdWarning tew = new TEdWarning();
            tew.setEdId(edId);
            return tew;
        }else{
            return listTew.get(0);
        }
    }

    @Override
    public int updateEmgcDsps(TEdDynTask tEdDynTask) {
        return tEdDynTaskMapper.updateByPrimaryKeySelective(tEdDynTask);
    }

    @Override
    public int updateEdResponse(TEdResponse tEdResponse) {
        if (null==tEdResponse.getId()||"".equals(tEdResponse.getId())){
            tEdResponse.setId(UUID.randomUUID().toString().replace("-",""));
            tEdResponse.setCreateTime(new Date());
            return tEdResponseMapper.insertSelective(tEdResponse);
        }
        tEdResponse.setUpdateTime(new Date());
        return tEdResponseMapper.updateByPrimaryKeySelective(tEdResponse);
    }

    @Override
    public int updateEdWarning(TEdWarning tEdWarning) {
        if (null==tEdWarning.getId()||"".equals(tEdWarning.getId())){
            tEdWarning.setId(UUID.randomUUID().toString().replace("-",""));
            tEdWarning.setCreateTime(new Date());
            return tEdWarningMapper.insertSelective(tEdWarning);
        }
        tEdWarning.setUpdateTime(new Date());
        return tEdWarningMapper.updateByPrimaryKeySelective(tEdWarning);
    }

    @Override
    public FutureDelayXVo findFtDelaysX() {
        List<FutureDelayVo> list = delayPrejudgeMapper.findFtDelaysX();
//        合并同航班ID的多条记录
        Map<String,FutureDelayVo> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            //存在同航班ID时，合并LEVEL，REASON
            if (map.containsKey(list.get(i).getFLIGHTID())){
                if (list.get(i).getLEVEL().equals("RED")){
                    map.get(list.get(i).getFLIGHTID()).setLEVEL("RED");
                }
                map.get(list.get(i).getFLIGHTID()).setREASON(map.get(list.get(i).getFLIGHTID()).getREASON()+','+list.get(i).getREASON());
            }else {
                map.put(list.get(i).getFLIGHTID(),list.get(i));
            }
        }
        List<FutureDelayVo> reList = new ArrayList<>();
        FutureDelayXVo reList2 = new FutureDelayXVo();
        int nums=0;
        String endtime="";
        for (String key : map.keySet()){
            nums++;
            map.get(key).setSOBT(DateTimeUtil.timeDayFormatByStr(map.get(key).getSOBT()));
            map.get(key).setFXLJ(DateTimeUtil.timeDayFormatByStr(map.get(key).getFXLJ()));
            if (endtime.compareTo( map.get(key).getFXLJ())<0)
                endtime=map.get(key).getFXLJ();
            reList.add(map.get(key));
        }
        reList2.setNums(nums);
        reList2.setEndtime(endtime);
        reList2.setReList(reList);
        return reList2;
    }
}
