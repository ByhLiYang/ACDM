package com.hq.acdm.controller.effectAnalysis;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.effectAnalysis.DelayedAnlssService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.effectAnalysis.DelayReasonVo;
import com.hq.acdm.vo.effectAnalysis.DelayedAnlssVo;
import com.hq.acdm.vo.effectAnalysis.TAtcDelayStatistics;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "效能分析")
@RestController
@RequestMapping("/effectAnalysis/delayedAnlss")
public class DelayedAnlssController {

    @Resource
    private DelayedAnlssService delayedAnlssService;

    @ApiOperation(httpMethod = "POST", value = "延误列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectDAByDate.json", method = RequestMethod.POST)
    public ServerResponse selectGZBZ(@ApiParam("延误列表")
                                         @RequestParam("execDate") String execDate,
                                     @RequestParam("agent") String agent,
                         HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        String execDateS=execDate.replace("-","");
        queryMap.put("execDate",execDateS);
        queryMap.put("agent",agent);
        List<DelayedAnlssVo> insufficientTTTVoList=null;
        List<DelayedAnlssVo> returnList=new ArrayList<DelayedAnlssVo>();
        DelayedAnlssVo vo=null;
        if(StringUtil.isNotEmpty(execDate)){
            if(!execDate.contains("-")){
                execDate=execDate.substring(0,4)+"-"+execDate.substring(4,6)+"-"+execDate.substring(6);
            }

           String returnTime= DateTimeUtil.reDayFormatByStr(execDate+" 00:00:00");
            System.out.println("时间"+returnTime);
           if(returnTime.contains("-")&&Long.parseLong(returnTime.substring(returnTime.indexOf("-")+1))>7){

               insufficientTTTVoList = delayedAnlssService.selectDelayedAnlssByDateHistory(queryMap);
           }
           else {
               insufficientTTTVoList = delayedAnlssService.selectDelayedAnlssByDate(queryMap);
           }
        }
        for (int i = 0; i <insufficientTTTVoList.size() ; i++) {
            vo=insufficientTTTVoList.get(i);
            vo.setSibt(DateTimeUtil.timeDayFormatByStr(vo.getSibt()));
            vo.setAldt(DateTimeUtil.timeDayFormatByStr(vo.getAldt()));
            vo.setSobt(DateTimeUtil.timeDayFormatByStr(vo.getSobt()));
            vo.setAtot(DateTimeUtil.timeDayFormatByStr(vo.getAtot()));
            vo.setStdc(DateTimeUtil.timeDayFormatByStr(vo.getStdc()));
            vo.setAtdc(DateTimeUtil.timeDayFormatByStr(vo.getAtdc()));
            if(StringUtil.isNotEmpty(vo.getPlanTTime())&&vo.getPlanTTime().contains(":")){
                vo.setPlanTTime(vo.getPlanTTime().substring(0,vo.getPlanTTime().lastIndexOf(":")));
            }
            returnList.add(vo);
        }

        return ServerResponse.createBySuccess(returnList);
    }
    @ApiOperation(httpMethod = "POST", value = "修改延误原因", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateReason.json", method = RequestMethod.POST)
    public ServerResponse updateReason(@ApiParam("修改延误原因")
                                     @RequestParam("flightId") String flightId,@RequestParam("reasonFC") String reasonFC,
                                       @RequestParam("reasonType") String reasonType,@RequestParam("reasonsForDelay") String reasonsForDelay,
                                      @RequestParam("rmk") String rmk,
                                     HttpServletRequest request, HttpServletResponse response) {
        DelayedAnlssVo vo=new DelayedAnlssVo();

        vo.setFlightIdD(flightId);
        vo.setReasonFc(reasonFC);
        vo.setReasonType(reasonType);
        vo.setReasonsForDelay(reasonsForDelay);
        vo.setRmk(rmk);
        delayedAnlssService.updateReason(vo);
        return   ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "延误列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectDelayedReason.json", method = RequestMethod.GET)
    public ServerResponse selectDelayedReason() {
        Map<String, Object> queryMap = new HashMap<>();
//        String execDateS=execDate.replace("-","");
//        queryMap.put("execDate",execDateS);
//        queryMap.put("agent",agent);
        List<DelayReasonVo> insufficientTTTVoList=null;
        List<DelayReasonVo> returnList=new ArrayList<DelayReasonVo>();
        List<DelayReasonVo> returnLists=new ArrayList<DelayReasonVo>();
        DelayReasonVo vo=null;
        Map<String, Object> recode = new HashMap<>();
        insufficientTTTVoList = delayedAnlssService.selectDelayedReason(queryMap);
        Map<String, Object> fcode = new HashMap<>();
        for (int i = 0; i <insufficientTTTVoList.size() ; i++) {
            vo=insufficientTTTVoList.get(i);
            if ("Y".equals(vo.getIsSuper())){
                returnList.add(vo);
                vo.setFcode(vo.getScode());
            }
            returnLists.add(vo);
        }
        recode.put("fcode",returnList);
        recode.put("scode",returnLists);
        return ServerResponse.createBySuccess(recode);
    }

    @ApiOperation(httpMethod = "POST", value = "查询ATC延误航班统计", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectDelayedReasonforCTOT.json", method = RequestMethod.POST)
    public ServerResponse selectDelayedReasonforCTOT(@ApiParam("查询ATC延误航班统计")
                                     @RequestParam("startDate") String startDate,
                                     @RequestParam("endDate") String endDate,
                                     @RequestParam("agent") String agent,
                                     HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        if (StringUtil.isNotEmpty(startDate)&&StringUtil.isEmpty(endDate)){
            endDate=startDate;
        }
        if (StringUtil.isNotEmpty(endDate)&&StringUtil.isEmpty(startDate)){
            startDate=endDate;
        }
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("agent",agent);

        List<TAtcDelayStatistics> reList=new ArrayList<TAtcDelayStatistics>();

        List<TAtcDelayStatistics> insufficientTTTVoList = delayedAnlssService.selectDelayedReasonforCTOT(queryMap);
        for (int i = 0; i <insufficientTTTVoList.size() ; i++) {
            TAtcDelayStatistics vv=insufficientTTTVoList.get(i);

//            vv.setSobt(DateTimeUtil.timeDayFormatByStr(vv.getSobt()));
//            vv.setAtot(DateTimeUtil.timeDayFormatByStr(vv.getAtot()));
//            vv.setFxlj(DateTimeUtil.timeDayFormatByStr(vv.getFxlj()));

            reList.add(vv);
        }

        return ServerResponse.createBySuccess(reList);
    }
    @ApiOperation(httpMethod = "POST", value = "根据航班id更新ATC延误航班原因", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateATCReason.json", method = RequestMethod.POST)
    public ServerResponse updateATCReason(@ApiParam("根据航班id更新ATC延误航班原因")
                                       @RequestParam("flightId") String flightId,@RequestParam("reasonsForDelay") String reasonsForDelay,
                                       HttpServletRequest request, HttpServletResponse response) {
        TAtcDelayStatistics vo=new TAtcDelayStatistics();

        vo.setFlightId(flightId);

        vo.setReasonsForDelay(reasonsForDelay);
        int a=delayedAnlssService.updateATCReason(vo);
        return   ServerResponse.createBySuccess(a);
    }

}
