package com.hq.acdm.controller.timer.Historical_Flight_Add_Details_More;

import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightAddDetailsMore;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;
import com.hq.acdm.service.timer.Historical_Flight_Master.HistoricalFlightMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/12 0012 11:00
 */
@Slf4j
@Configuration
public class HistoricalFlightAddDetailsMore implements Runnable{
    private static boolean HistoricalFlightAddDetailsMoreIsRunning = false;
    private WebApplicationContext context = null;
    private HistoricalFlightMasterService historicalFlightMasterService = null;
    public HistoricalFlightAddDetailsMore() {
    }
    public HistoricalFlightAddDetailsMore(HistoricalFlightMasterService historicalFlightMasterService, WebApplicationContext context) {
        this.historicalFlightMasterService = historicalFlightMasterService;
        this.context = context;
    }
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        if(!HistoricalFlightAddDetailsMoreIsRunning){
            try{
                HistoricalFlightAddDetailsMoreIsRunning = true;
                context.getServletContext().log(df.format(new Date())+"：开始执行HistoricalFlightAddDetailsMore指定任务");
                System.out.println(df.format(new Date())+"：开始执行HistoricalFlightAddDetailsMore指定任务");
                int tempNumberCount = historicalFlightMasterService.countDFADM().getCountNumber();
                int deleteCount = 0;
                if(tempNumberCount>0){
                    List<DailyFlightAddDetailsMore> list = historicalFlightMasterService.queryDFADM();
                    for(int i=0;i<list.size();i++){
                        Map<String,Object> map = new HashMap<>();
                        map.put("operational_date",onlyDate.format(list.get(i).getOperationalDate()));
                        map.put("flight_no_iata",list.get(i).getFlightNoIata());
                        map.put("a_or_d",list.get(i).getaOrD());
                        map.put("flight_repeat_count",list.get(i).getFlightRepeatCount());
                        if(historicalFlightMasterService.queryHFADMByCondition(map).getCountNumber()>0){
                            deleteCount = deleteCount +1;
                            historicalFlightMasterService.deleteHFADM(map);
                        }
                        historicalFlightMasterService.insertHFADM(map);
                        historicalFlightMasterService.deleteDFADM(map);//删除
                    }

                    context.getServletContext().log(df.format(new Date())+"：删除："+String.valueOf(deleteCount)+"  插入："+String.valueOf(list.size()));
                    System.out.println(df.format(new Date())+"：删除："+String.valueOf(deleteCount)+"  插入："+String.valueOf(list.size()));
                }
                HistoricalFlightAddDetailsMoreIsRunning = false;
                context.getServletContext().log(df.format(new Date())+"：完成执行指定任务HistoricalFlightAddDetailsMore");
                System.out.println(df.format(new Date())+"：完成执行指定任务HistoricalFlightAddDetailsMore");


            }
            catch (Exception e){
                System.out.println(df.format(new Date())+"：HistoricalFlightAddDetailsMore错误信息："+e.toString());
                context.getServletContext().log(df.format(new Date())+"：HistoricalFlightAddDetailsMore错误信息："+e.toString());
            }
            finally {
                System.out.println(df.format(new Date())+"：12小时之后再次HistoricalFlightAddDetailsMore执行");
                context.getServletContext().log(df.format(new Date())+"：12小时之后再次HistoricalFlightAddDetailsMore执行");
            }
        }else{
            System.out.println(df.format(new Date())+"：上一次任务执行HistoricalFlightAddDetailsMore转存还未结束");
            context.getServletContext().log(df.format(new Date())+"：上一次任务执行HistoricalFlightAddDetailsMore转存还未结束");
        }
    }
}
