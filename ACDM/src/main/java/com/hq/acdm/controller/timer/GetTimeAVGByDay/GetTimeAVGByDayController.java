package com.hq.acdm.controller.timer.GetTimeAVGByDay;

import com.hq.acdm.model.timer.GetTimeAVGByDay.GetTimeAVGByDay;
import com.hq.acdm.service.timer.GetTimeAVGByDay.GetTimeAVGByDayService;
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
public class GetTimeAVGByDayController extends TimerTask{
    private static boolean GetTimeAVGByDayIsRunning = false;
    private WebApplicationContext context = null;
    private GetTimeAVGByDayService getTimeAVGByDayService = null;

    public GetTimeAVGByDayController(WebApplicationContext context, GetTimeAVGByDayService getTimeAVGByDayService) {
        this.context = context;
        this.getTimeAVGByDayService = getTimeAVGByDayService;
    }

    public GetTimeAVGByDayController() {
    }

    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        if(!GetTimeAVGByDayIsRunning){
            try {
                GetTimeAVGByDayIsRunning = true;
                context.getServletContext().log(df.format(new Date())+"：开始执行GetTimeAVGByDay指定任务");
                System.out.println(df.format(new Date())+"：开始执行GetTimeAVGByDay指定任务");
                Calendar ca = Calendar.getInstance();
                int hour=ca.get(Calendar.HOUR_OF_DAY);//小时
                List<GetTimeAVGByDay> list = new ArrayList<>();
                List<GetTimeAVGByDay> conditionList = new ArrayList<>();
                if(hour>=7&&hour<10){
                    list = getTimeAVGByDayService.queryHISTORY_TAXI_TIME_AVG_By7_10();
                }else if(hour>=10&&hour<12){
                    list = getTimeAVGByDayService.queryHISTORY_TAXI_TIME_AVG_By10_12();
                }else{
                    list = getTimeAVGByDayService.queryHISTORY_TAXI_TIME_AVG_ByOTHER();
                }
                if(list.size()>0){
                    for(int i=0;i<list.size();i++){
                        Map<String,Object> map = new HashMap<>();
//                        map.put("AIRCRAFT_TYPE",);
//                        map.put("STAND",);
//                        map.put("A_OR_D",);
//                        map.put("TIME_RANGE",);
//                        map.put("RWY",);
//                        map.put("TAXITIMEAVG",);
//                        map.put("TAXITIME",);
                        conditionList = getTimeAVGByDayService.queryTAXI_TIME_TABLE_BYPK(map);
                        if(conditionList.size()>0){
                            getTimeAVGByDayService.updateTAXI_TIME_TABLE(map);
                        }else{
                            getTimeAVGByDayService.insertTAXI_TIME_TABLE(map);
                        }
                    }
                }
                GetTimeAVGByDayIsRunning = false;
                context.getServletContext().log(df.format(new Date())+"：完成GetTimeAVGByDay指定任务");
                System.out.println(df.format(new Date())+"：完成GetTimeAVGByDay指定任务");
            }catch (Exception e){
                System.out.println(df.format(new Date())+"：GetTimeAVGByDay错误信息："+e.toString());
                context.getServletContext().log(df.format(new Date())+"：GetTimeAVGByDay错误信息："+e.toString());
            }finally {
                System.out.println(df.format(new Date())+"：1小时之后再次GetTimeAVGByDay执行");
                context.getServletContext().log(df.format(new Date())+"：1小时之后再次GetTimeAVGByDay执行");
            }
        }else {
            System.out.println(df.format(new Date())+"：上一次任务执行GetTimeAVGByDay转存还未结束");
            context.getServletContext().log(df.format(new Date())+"：上一次任务执行GetTimeAVGByDay转存还未结束");
        }
    }

}
