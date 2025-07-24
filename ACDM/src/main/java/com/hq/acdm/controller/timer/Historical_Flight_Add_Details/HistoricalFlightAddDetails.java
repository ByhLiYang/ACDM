package com.hq.acdm.controller.timer.Historical_Flight_Add_Details;

import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightAddDetails;
import com.hq.acdm.model.timer.HistoricalFlightMaster.DailyFlightMaster;
import com.hq.acdm.service.timer.Historical_Flight_Master.HistoricalFlightMasterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/12 0012 10:09
 */

@Slf4j
@Configuration
public class HistoricalFlightAddDetails implements Runnable {
    private static boolean HistoricalFlightMasterDetailsIsRunning = false;
    private WebApplicationContext context = null;
    private HistoricalFlightMasterService historicalFlightMasterService = null;
    public HistoricalFlightAddDetails(HistoricalFlightMasterService historicalFlightMasterService, WebApplicationContext context) {
        this.historicalFlightMasterService = historicalFlightMasterService;
        this.context = context;
    }
    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        if(!HistoricalFlightMasterDetailsIsRunning) {
            try {
                HistoricalFlightMasterDetailsIsRunning = true;

                context.getServletContext().log(df.format(new Date()) + "：开始执行HistoricalFlightAddDetails指定任务");
                System.out.println(df.format(new Date()) + "：开始执行HistoricalFlightAddDetails指定任务");
                int tempNumberCount = historicalFlightMasterService.countDFAD().getCountNumber();

                if (tempNumberCount > 0) {
                    int delete = 0;
                    List<DailyFlightAddDetails> list = historicalFlightMasterService.queryDFAD();
                    for (int i = 0; i < list.size(); i++) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("operational_date", onlyDate.format(list.get(i).getOPERATIONAL_DATE()));
                        map.put("flight_no_iata", list.get(i).getFLIGHT_NO_IATA());
                        map.put("a_or_d", list.get(i).getA_OR_D());
                        map.put("flight_repeat_count", list.get(i).getFLIGHT_REPEAT_COUNT());
                        if (historicalFlightMasterService.queryHFADByCondition(map).getCountNumber() > 0) {
                            delete = delete + 1;
                            historicalFlightMasterService.deleteHFAD(map);
                        }
                        historicalFlightMasterService.insertDFAM(map);
                        historicalFlightMasterService.deleteDFAD(map);
                    }
                    context.getServletContext().log(df.format(new Date()) + "：删除：" + String.valueOf(delete) + "  插入：" + String.valueOf(list.size()));
                    System.out.println(df.format(new Date()) + "：删除：" + String.valueOf(delete) + "  插入：" + String.valueOf(list.size()));
                }
                HistoricalFlightMasterDetailsIsRunning = false;
                context.getServletContext().log(df.format(new Date())+"：完成执行HistoricalFlightMasterDetails指定任务");
                System.out.println(df.format(new Date())+"：完成执行HistoricalFlightMasterDetails指定任务");
            }
            catch (Exception e){
                System.out.println(df.format(new Date())+"：HistoricalFlightMasterDetails错误信息："+e.toString());
                context.getServletContext().log(df.format(new Date())+"：HistoricalFlightMasterDetails错误信息："+e.toString());
            }
            finally {
                System.out.println(df.format(new Date())+"：12小时之后再次HistoricalFlightMasterDetails执行");
                context.getServletContext().log(df.format(new Date())+"：12小时之后再次HistoricalFlightMasterDetails执行");
            }
        }else {
            System.out.println(df.format(new Date())+"：上一次任务执行HistoricalFlightMasterDetails转存还未结束");
            context.getServletContext().log(df.format(new Date())+"：上一次任务执行HistoricalFlightMasterDetails转存还未结束");
        }
    }
}

