package com.hq.acdm.controller.statistics.releaseNormal;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.releaseNormal.ReleaseNormal;
import com.hq.acdm.service.statistics.releaseNormal.ReleaseNormalService;
import com.hq.acdm.vo.statistics.releaseNormal.AtotReleaseNormal;
import com.hq.acdm.vo.statistics.releaseNormal.CtotReleaseNormal;
import com.hq.acdm.vo.statistics.releaseNormal.NewReleaseNormal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangrui
 * @date 2018/9/21 0020 14:40
 */

@Api(description = "放行正常率")
@RestController
@RequestMapping("/statisticalReport/CTOTATOTReleaseNormalRate")
@Slf4j
public class ReleaseNormalController {

    @Resource
    private ReleaseNormalService releaseNormalService;

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ServerResponse query(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                HttpServletRequest request, HttpServletResponse response) {
/*        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);*/
        List<ReleaseNormal> releaseNormal = releaseNormalService.queryReleaseNormal(startDate, endDate);

        Map<String,String> dataMap=new HashMap<String,String>();

        for(int i=0;i<releaseNormal.size();i++){
            dataMap.put("GZS", releaseNormal.get(i).getGzs().toString());
            dataMap.put("CTOTGZZC",  releaseNormal.get(i).getCtotgzzc().toString());
            dataMap.put("ATOTGZZC",  releaseNormal.get(i).getAtotgzzc().toString());
            dataMap.put("SFS", releaseNormal.get(i).getSfs().toString());
            dataMap.put("CTOTSFZC", releaseNormal.get(i).getCtotsfzc().toString());
            dataMap.put("ATOTSFZC", releaseNormal.get(i).getAtotsfzc().toString());
        }

        Double ATOTSFZC=Double.parseDouble(dataMap.get("ATOTSFZC"));
        Double ATOTGZZC=Double.parseDouble(dataMap.get("ATOTGZZC"));
        Double CTOTSFZC=Double.parseDouble(dataMap.get("CTOTSFZC"));
        Double CTOTGZZC=Double.parseDouble(dataMap.get("CTOTGZZC"));
        Double SFS=Double.parseDouble(dataMap.get("SFS"));
        Double GZS=Double.parseDouble(dataMap.get("GZS"));

        NewReleaseNormal newReleaseNormal=new NewReleaseNormal();
        AtotReleaseNormal atotReleaseNormal=new AtotReleaseNormal();
        CtotReleaseNormal ctotReleaseNormal=new CtotReleaseNormal();
        atotReleaseNormal.setRow("基于ATOT计算");
        if(GZS==0&&SFS==0){
            atotReleaseNormal.setRate("0%");
            ctotReleaseNormal.setRate("0%");
        }else if(SFS==0){
            atotReleaseNormal.setInitRate("0%");
            ctotReleaseNormal.setInitRate("0%");
        }else if(GZS==0){
            atotReleaseNormal.setOverRate("0%");
            ctotReleaseNormal.setOverRate("0%");
        }else{
            atotReleaseNormal.setInitRate(String.format("%.2f", ATOTSFZC/SFS*100)+"%");
            atotReleaseNormal.setOverRate(String.format("%.2f", ATOTGZZC/GZS*100)+"%");
            atotReleaseNormal.setRate(String.format("%.2f", (ATOTSFZC+ATOTGZZC)/(GZS+SFS)*100)+"%");

            ctotReleaseNormal.setInitRate(String.format("%.2f", CTOTSFZC/SFS*100)+"%");
            ctotReleaseNormal.setOverRate(String.format("%.2f", CTOTGZZC/GZS*100)+"%");
            ctotReleaseNormal.setRate(String.format("%.2f", (CTOTSFZC+CTOTGZZC)/(GZS+SFS)*100)+"%");
        }
        atotReleaseNormal.setInitZC(String.valueOf(ATOTSFZC.intValue()));
        atotReleaseNormal.setOverZC(String.valueOf(ATOTGZZC.intValue()));

        ctotReleaseNormal.setRow("基于CTOT计算");
        ctotReleaseNormal.setInitZC(String.valueOf(CTOTSFZC.intValue()));
        ctotReleaseNormal.setOverZC(String.valueOf(CTOTGZZC.intValue()));

        ctotReleaseNormal.setInitCount(String.valueOf(SFS.intValue()));
        ctotReleaseNormal.setOverCount(String.valueOf(GZS.intValue()));

        atotReleaseNormal.setInitCount(String.valueOf(SFS.intValue()));
        atotReleaseNormal.setOverCount(String.valueOf(GZS.intValue()));

        List<AtotReleaseNormal> atotReleaseNormalList=new ArrayList<>();
        List<CtotReleaseNormal> ctotReleaseNormalList=new ArrayList<>();
        atotReleaseNormalList.add(atotReleaseNormal);
        ctotReleaseNormalList.add(ctotReleaseNormal);

        newReleaseNormal.setTableData1(atotReleaseNormalList);
        newReleaseNormal.setTableData2(ctotReleaseNormalList);
        return ServerResponse.createBySuccess(newReleaseNormal);
    }
}
