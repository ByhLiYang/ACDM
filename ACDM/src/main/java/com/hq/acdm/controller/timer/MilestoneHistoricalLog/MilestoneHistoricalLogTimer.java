package com.hq.acdm.controller.timer.MilestoneHistoricalLog;

import com.hq.acdm.model.timer.MilestoneHistoricalLog.MilestoneHistoricalLog;
import com.hq.acdm.service.timer.MilestoneHistoricalLog.MilestoneHistoricalLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/12 0012 15:16
 */
@Slf4j
@Configuration
public class MilestoneHistoricalLogTimer implements Runnable{
    private static boolean MilestoneHistoricalLogIsRunning = false;
    private WebApplicationContext context = null;
    private MilestoneHistoricalLogService milestoneHistoricalLogService = null;
    public MilestoneHistoricalLogTimer() {
    }
    public MilestoneHistoricalLogTimer(MilestoneHistoricalLogService milestoneHistoricalLogService, WebApplicationContext context) {
        this.milestoneHistoricalLogService = milestoneHistoricalLogService;
        this.context = context;
    }
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        if(!MilestoneHistoricalLogIsRunning){
            try {
                MilestoneHistoricalLogIsRunning = true;
                context.getServletContext().log(df.format(new Date())+"：开始执行MilestoneHistoricalLog指定任务");
                System.out.println(df.format(new Date())+"：开始执行MilestoneHistoricalLog指定任务");
                int tempNumberCount = milestoneHistoricalLogService.countMDL().getCountNumber();
                int deleteCount = 0;
                if(tempNumberCount>0){
                    List<MilestoneHistoricalLog> list = milestoneHistoricalLogService.queryMDL();
                    for(int i=0;i<list.size();i++){
                        Map<String,Object> map = new HashMap<>();
                        map.put("operational_date",onlyDate.format(list.get(i).getOPERATIONAL_DATE()));
                        map.put("flight_no_iata",list.get(i).getFLIGHT_NO_IATA());
                        map.put("a_or_d",list.get(i).getA_OR_D());
                        map.put("flight_repeat_count",list.get(i).getFLIGHT_REPEAT_COUNT());
                        map.put("milestone_id",list.get(i).getMILESTONE_ID());
                        map.put("ds_id",list.get(i).getDS_ID());
                        map.put("messagetime",df.format(list.get(i).getMESSAGETIME()));
                        if(milestoneHistoricalLogService.queryMHLByCondition(map).getCountNumber()>0){
                            deleteCount = deleteCount +1;
                            milestoneHistoricalLogService.deleteMHL(map);
                        }
                        milestoneHistoricalLogService.insertMHL(map);
                        milestoneHistoricalLogService.deleteMDL(map);//删除
                    }
                    
                    context.getServletContext().log(df.format(new Date())+"：删除："+String.valueOf(deleteCount)+"  插入："+String.valueOf(list.size()));
                    System.out.println(df.format(new Date())+"：删除："+String.valueOf(deleteCount)+"  插入："+String.valueOf(list.size()));
                }
                MilestoneHistoricalLogIsRunning = false;
                context.getServletContext().log(df.format(new Date())+"：完成执行指定任务MilestoneHistoricalLog");
                System.out.println(df.format(new Date())+"：完成执行指定任务MilestoneHistoricalLog");
            }catch (Exception e){
                System.out.println(df.format(new Date())+"：MilestoneHistoricalLog错误信息："+e.toString());
                context.getServletContext().log(df.format(new Date())+"：MilestoneHistoricalLog错误信息："+e.toString());
            }finally {
                System.out.println(df.format(new Date())+"：12小时之后再次MilestoneHistoricalLog执行");
                context.getServletContext().log(df.format(new Date())+"：12小时之后再次MilestoneHistoricalLog执行");
            }
        }else {
            System.out.println(df.format(new Date())+"：上一次任务执行MilestoneHistoricalLog转存还未结束");
            context.getServletContext().log(df.format(new Date())+"：上一次任务执行MilestoneHistoricalLog转存还未结束");
        }
    }
}
