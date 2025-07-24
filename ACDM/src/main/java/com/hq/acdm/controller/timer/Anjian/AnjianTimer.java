package com.hq.acdm.controller.timer.Anjian;

import com.hq.acdm.mysql.AreaPeopleNumber;
import com.hq.acdm.service.timer.Anjian.AnjianService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/15 0015 9:04
 */
@Slf4j
@Configuration
public class AnjianTimer implements Runnable{
    private static boolean anjianHistoricalIsRunning = false;
    private WebApplicationContext webApplicationContext = null;
    private AnjianService anjianService;

    public AnjianTimer(WebApplicationContext webApplicationContext, AnjianService anjianService) {
        this.webApplicationContext = webApplicationContext;
        this.anjianService = anjianService;
    }

    public AnjianTimer() {
    }

    @Override
    public void run() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        SimpleDateFormat onlyDate = new SimpleDateFormat("yyyy-mm-dd");
        if(!anjianHistoricalIsRunning){
            try {
                anjianHistoricalIsRunning = true;
                webApplicationContext.getServletContext().log(df.format(new Date()) + "：开始计算转存安检人数数据");
                System.out.println(df.format(new Date()) + "：开始计算转存安检人数数据");
                List<AreaPeopleNumber> list = anjianService.queryHistoricalPax_num();
                if(list.size()>0){
                    for(int i=0;i<list.size();i++){
                        Map<String,Object> map  = new HashMap<>();
                        map.put("TERMINAL",list.get(i).getTERMINAL());
                        map.put("UPDATETIME",list.get(i).getUPDATETIME());
                        map.put("AREA",list.get(i).getAREA());
                        List<AreaPeopleNumber> isExist = anjianService.queryByCondition(map);
                        if(isExist.size()>0){
                            anjianService.deleteDuplicateDate(map);
                            anjianService.insertHistoricalPax_num(map);
                            anjianService.deleteHistoricalPax_num(map);
                        }else{
                            anjianService.insertHistoricalPax_num(map);
                            anjianService.deleteHistoricalPax_num(map);
                        }
                    }
                    webApplicationContext.getServletContext().log(df.format(new Date()) + "：转存安检人数结束");
                    System.out.println(df.format(new Date()) + "：转存安检人数结束");
                    anjianHistoricalIsRunning = false;
                }else{
                    webApplicationContext.getServletContext().log(df.format(new Date()) + "：没有最新数据");
                    System.out.println(df.format(new Date()) + "：没有最新数据");
                }
            }catch (Exception e){
                System.out.println(df.format(new Date())+"：转存安检人数错误信息："+e.toString());
                webApplicationContext.getServletContext().log(df.format(new Date())+"：转存安检人数错误信息："+e.toString());
            }finally {
                System.out.println(df.format(new Date())+"：明日一点再次执行");
                webApplicationContext.getServletContext().log(df.format(new Date())+"：明日一点再次执行");
            }

        }else{
            System.out.println(df.format(new Date())+"：上一次定时任务还未结束");
            webApplicationContext.getServletContext().log(df.format(new Date())+"：上一次定时任务还未结束");
        }
    }
}
