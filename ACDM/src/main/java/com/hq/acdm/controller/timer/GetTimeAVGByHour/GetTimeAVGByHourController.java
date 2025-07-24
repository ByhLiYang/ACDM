package com.hq.acdm.controller.timer.GetTimeAVGByHour;

import com.hq.acdm.model.timer.GetTimeAVGByHour.GetTimeAVGByHour;
import com.hq.acdm.model.timer.MilestoneHistoricalLog.MilestoneHistoricalLog;
import com.hq.acdm.service.timer.GetTimeAVGByHour.GetTimeAVGByHourService;
import com.hq.acdm.service.timer.MilestoneHistoricalLog.MilestoneHistoricalLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/14 0014 9:28
 */
@Slf4j
@Configuration
public class GetTimeAVGByHourController extends TimerTask {
    private static boolean GetTimeAVGByHourIsRunning = false;
    private WebApplicationContext context = null;
    private GetTimeAVGByHourService getTimeAVGByHourService = null;
    public GetTimeAVGByHourController() {
    }
    public GetTimeAVGByHourController(GetTimeAVGByHourService getTimeAVGByHourService, WebApplicationContext context) {
        this.getTimeAVGByHourService = getTimeAVGByHourService;
        this.context = context;
    }
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        if(!GetTimeAVGByHourIsRunning){
            try {
                GetTimeAVGByHourIsRunning = true;
                context.getServletContext().log(df.format(new Date())+"：开始执行GetTimeAVGByHour指定任务");
                System.out.println(df.format(new Date())+"：开始执行GetTimeAVGByHour指定任务");
                List<GetTimeAVGByHour> getTimeAVGByHourList = getTimeAVGByHourService.queryRecord();
                int modifyCount = -1;
                if(getTimeAVGByHourList.size()>0){
                    for(int i=0;i<getTimeAVGByHourList.size();i++){
                        Map<String,Object> queryMap = new HashMap<>();
                        queryMap.put("AIRCRAFT_TYPE",getTimeAVGByHourList.get(i).getAIRPORTTYPE());
                        queryMap.put("STAND",getTimeAVGByHourList.get(i).getSTAND());
                        queryMap.put("A_OR_D",getTimeAVGByHourList.get(i).getA_OR_D());
                        queryMap.put("HOURTIME",getTimeAVGByHourList.get(i).getHOURTIME());
                        queryMap.put("RWY",getTimeAVGByHourList.get(i).getRWY());
                        queryMap.put("OPERATIONAL_DATE",getTimeAVGByHourList.get(i).getOPERATIONAL_DATE().substring(0,10));
                        queryMap.put("SLIDE_TIME",getTimeAVGByHourList.get(i).getSLIDE_TIME());
                        Map<String,Object> insertMap = new HashMap<>();
                        insertMap.put("AIRCRAFT_TYPE",getTimeAVGByHourList.get(i).getAIRPORTTYPE());
                        insertMap.put("STAND",getTimeAVGByHourList.get(i).getSTAND());
                        insertMap.put("A_OR_D",getTimeAVGByHourList.get(i).getA_OR_D());
                        insertMap.put("HOURTIME",getTimeAVGByHourList.get(i).getHOURTIME());
                        insertMap.put("RWY",getTimeAVGByHourList.get(i).getRWY());
                        insertMap.put("OPERATIONAL_DATE",onlyDate.parse(getTimeAVGByHourList.get(i).getOPERATIONAL_DATE()));
                        insertMap.put("SLIDE_TIME",getTimeAVGByHourList.get(i).getSLIDE_TIME());
                        List<GetTimeAVGByHour> list = getTimeAVGByHourService.queryHistoricalTaxiTimeRecord(queryMap);
                        if(getTimeAVGByHourList.get(i).getAIRPORTTYPE()!=null&&getTimeAVGByHourList.get(i).getSTAND()!=null
                          &&getTimeAVGByHourList.get(i).getA_OR_D()!=null&&getTimeAVGByHourList.get(i).getHOURTIME()!=null
                          &&getTimeAVGByHourList.get(i).getRWY()!=null&&getTimeAVGByHourList.get(i).getOPERATIONAL_DATE()!=null){
                            if(list.size()>0){//如果存在就更新
                                modifyCount = getTimeAVGByHourService.updateHistoricalTaxiTimeRecord(queryMap);
                                context.getServletContext().log(df.format(new Date())+"：更新一条GetTimeAVGByHour数据");
                                System.out.println(df.format(new Date())+"：更新一条GetTimeAVGByHour数据");
                            }else{//不存在就插入
                                modifyCount = getTimeAVGByHourService.insertHistoricalTaxiTimeRecord(insertMap);
                                context.getServletContext().log(df.format(new Date())+"：插入一条GetTimeAVGByHour数据");
                                System.out.println(df.format(new Date())+"：插入一条GetTimeAVGByHour数据");
                            }
                            if(modifyCount>0){
                                getTimeAVGByHourService.updateDailyRunway(queryMap);
                                context.getServletContext().log(df.format(new Date())+"：更新一条DailyRunway数据");
                                System.out.println(df.format(new Date())+"：更新一条DailyRunway数据");
                            }
                        }else{
                            context.getServletContext().log(df.format(new Date())+"：跳过一条GetTimeAVGByHour数据");
                            System.out.println(df.format(new Date())+"：跳过一条GetTimeAVGByHour数据");
                            continue;
                        }
                    }
                }
                GetTimeAVGByHourIsRunning = false;
                context.getServletContext().log(df.format(new Date())+"：完成执行指定任务GetTimeAVGByHour");
                System.out.println(df.format(new Date())+"：完成执行指定任务GetTimeAVGByHour");
            }catch (Exception e){
                System.out.println(df.format(new Date())+"：GetTimeAVGByHour错误信息："+e.toString());
                context.getServletContext().log(df.format(new Date())+"：GetTimeAVGByHour错误信息："+e.toString());
            }finally {
                System.out.println(df.format(new Date())+"：1小时之后再次GetTimeAVGByHour执行");
                context.getServletContext().log(df.format(new Date())+"：1小时之后再次GetTimeAVGByHour执行");
            }
        }else {
            System.out.println(df.format(new Date())+"：上一次任务执行GetTimeAVGByHour转存还未结束");
            context.getServletContext().log(df.format(new Date())+"：上一次任务执行GetTimeAVGByHour转存还未结束");
        }
    }
}
