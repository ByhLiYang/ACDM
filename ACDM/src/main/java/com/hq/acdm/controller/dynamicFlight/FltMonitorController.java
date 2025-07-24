package com.hq.acdm.controller.dynamicFlight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecord;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltSearchService;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.util.*;
import com.hq.acdm.vo.dynamicFlight.*;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.transaction.xa.EhcacheXAException;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.Random;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "航班动态监控")
@RestController
@RequestMapping("/dynamicFlight/FltMonitor")
public class FltMonitorController {

    @Resource
    private FltMonitorService fltMonitorService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private FltSearchService fltSearchService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;

    @ApiOperation(httpMethod = "POST", value = "航班动态监控列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFltInfo.json", method = RequestMethod.POST)
    public ServerResponse getFltInfo(@ApiParam("航班动态监控列表")
                         @RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,
                         @RequestParam("flno") String flno,@RequestParam("airlines") String airlines,
                         @RequestParam("notRun") String notRun,@RequestParam("delay") String delay,
                         @RequestParam("agent") String agent,@RequestParam("indexYW") String indexYW,
                                     @RequestParam("altA") String altA,
                                     @RequestParam("altD") String altD,@RequestParam("rtnA") String rtnA,
                                     @RequestParam("rtnD") String rtnD,@RequestParam("cancel") String cancel,
                         HttpServletRequest request, HttpServletResponse response) {

        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = UsersService.findDepartment(sysUser.getEmployeeId());
            //用户为地服用户时，设置查询条件
            if ("IGO".equals(dept)){
                condition= ConstantUtil.IGO;
            }
            //用户为国航用户时，设置查询条件
            if ("CCA".equals(dept)){
                condition= ConstantUtil.CCA;
            }
            //用户为南航用户时，设置查询条件
            if ("CSN".equals(dept)){
                condition= ConstantUtil.CSN;
            }
            //用户为东航用户时，设置查询条件
            if ("CES".equals(dept)){
                condition= ConstantUtil.CES;
            }
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startTime",startTime);
        queryMap.put("endTime",endTime);
        queryMap.put("flno",flno);
        queryMap.put("airlines",airlines);
        queryMap.put("appExecDate","");
        queryMap.put("notRun",notRun);
        queryMap.put("delay",delay);
        queryMap.put("indexYW",indexYW);
        queryMap.put("agent",agent);
        queryMap.put("dept",dept);
        queryMap.put("agentSys",condition);
        queryMap.put("altA",altA);
        queryMap.put("altD",altD);
        queryMap.put("rtnA",rtnA);
        queryMap.put("rtnD",rtnD);
        queryMap.put("cancel",cancel);
        List<TLocalFlightInfoVo> tLocalFlightInfoList = fltMonitorService.findFltInfo(queryMap);
        return ServerResponse.createBySuccess(tLocalFlightInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "延误航班动态监控列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getDelayFltInfo.json", method = RequestMethod.POST)
    public ServerResponse getDelayFltInfo(@ApiParam("延误航班动态监控列表")
                                     @RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,
                                     @RequestParam("flno") String flno,@RequestParam("airlines") String airlines,
                                     @RequestParam("notRun") String notRun,@RequestParam("delay") String delay,
                                     @RequestParam("agent") String agent,
                                     HttpServletRequest request, HttpServletResponse response) {

        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = UsersService.findDepartment(sysUser.getEmployeeId());
            //用户为地服用户时，设置查询条件
            if ("IGO".equals(dept)){
                condition= ConstantUtil.IGO;
            }
            //用户为国航用户时，设置查询条件
            if ("CCA".equals(dept)){
                condition= ConstantUtil.CCA;
            }
            //用户为南航用户时，设置查询条件
            if ("CSN".equals(dept)){
                condition= ConstantUtil.CSN;
            }
            //用户为东航用户时，设置查询条件
            if ("CES".equals(dept)){
                condition= ConstantUtil.CES;
            }
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startTime",startTime);
        queryMap.put("endTime",endTime);
        queryMap.put("flno",flno);
        queryMap.put("airlines",airlines);
        queryMap.put("appExecDate","");
        queryMap.put("notRun",notRun);
        queryMap.put("delay",delay);
        queryMap.put("agent",agent);
        queryMap.put("dept",dept);
        queryMap.put("agentSys",condition);
        List<TLocalFlightInfoVo> tLocalFlightInfoList = fltMonitorService.findFltInfo(queryMap);
        return ServerResponse.createBySuccess(tLocalFlightInfoList);
    }

    @ApiOperation(httpMethod = "GET", value = "航空公司二字码", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllCompany.json", method = RequestMethod.GET)
    public ServerResponse findAllCompany() {
        List<String> allCompany = fltMonitorService.findAllCompany();
        return ServerResponse.createBySuccess(allCompany);
    }

    @ApiOperation(httpMethod = "GET", value = "航班流控信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllControlInfo.json", method = RequestMethod.GET)
    public ServerResponse findAllControlInfo(@ApiParam("航班流控信息")
                                          @RequestParam("flightId") String flightId,
                                          HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        if (flightId != null && !"".equals(flightId)){
            flightIdInt = Integer.parseInt(flightId);
        }
        queryMap.put("flightId",flightIdInt);
        List<TControlInfoVo> list = fltMonitorService.findAllControlInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "GET", value = "航班详细信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFlightDetails.json", method = RequestMethod.GET)
    public ServerResponse findFlightDetails(@ApiParam("航班详细信息")
                                          @RequestParam("flightId") String flightId,
                                          HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        if (flightId != null && !"".equals(flightId)){
            if(!"undefined".equals(flightId)){
                flightIdInt = Integer.parseInt(flightId);
            }else{
                flightIdInt = 0;
            }
        }
        queryMap.put("flightId",flightIdInt);
        List<FlightDetailsInfoVo> list = fltMonitorService.findFlightDetails(queryMap);
        if (list!=null&&list.size()>0){
            for (int i = 0; i <list.size() ; i++) {
               if (i==0){
                   FlightDetailsInfoVo vo=list.get(i);
                   String flnoA=vo.getFlnoA();
                   String exec_dateA=vo.getExec_dateA();

                   if (StringUtil.isNotEmpty(flnoA)&&StringUtil.isNotEmpty(exec_dateA)){
                       String jgxlzs=vo.getBagCountA();
                       if (StringUtil.isNotEmpty(jgxlzs))vo.setJgxlzs(Integer.parseInt(jgxlzs));
                       queryMap.put("flno",flnoA);
                       queryMap.put("exec_date",exec_dateA);
                       queryMap.put("dora","A");
                       XlVo voa = fltMonitorService.findXl(queryMap);
                       if (voa!=null){
                           vo.setXj(voa.getXj());
                           vo.setXjs(DateTimeUtil.timeDayFormatByStr(voa.getXjend()));
                           vo.setXjend(DateTimeUtil.timeDayFormatByStr(voa.getXjend()));
                           vo.setDd(voa.getDd());
                           vo.setDds(DateTimeUtil.timeDayFormatByStr(voa.getDds()));
                           vo.setDdend(DateTimeUtil.timeDayFormatByStr(voa.getDdend()));
                       }
                   }
                   String flnoD=vo.getFlnoD();
                   String exec_dateD=vo.getExec_dateD();
                   if (StringUtil.isNotEmpty(flnoD)&&StringUtil.isNotEmpty(exec_dateD)){
                       queryMap.put("flno",flnoD);
                       queryMap.put("exec_date",exec_dateD);
                       queryMap.put("dora","D");
                       XlVo vod = fltMonitorService.findXl(queryMap);
                       if (vod!=null){
                           vo.setZj(vod.getZj());
                           vo.setZjs(DateTimeUtil.timeDayFormatByStr(vod.getZjs()));
                           vo.setZjend(DateTimeUtil.timeDayFormatByStr(vod.getZjend()));
                           vo.setAj(vod.getAj());
                           if (vod.getAj()>vo.getZj()) vo.setZj(vod.getAj());
                           vo.setAjs(DateTimeUtil.timeDayFormatByStr(vod.getAjs()));
                           vo.setAjend(DateTimeUtil.timeDayFormatByStr(vod.getAjend()));
                           vo.setFj(vod.getFj());
                           if (vod.getFj()>vo.getZj()) vo.setZj(vod.getFj());
                           vo.setFjs(DateTimeUtil.timeDayFormatByStr(vod.getFjs()));
                           vo.setFjend(DateTimeUtil.timeDayFormatByStr(vod.getFjend()));
                           vo.setZc(vod.getZc());
                           if (vod.getZc()>vo.getZj()) vo.setZj(vod.getZc());
                           vo.setZcs(DateTimeUtil.timeDayFormatByStr(vod.getZcs()));
                           vo.setZcend(DateTimeUtil.timeDayFormatByStr(vod.getZcend()));
                           vo.setZji(vod.getZji());
                           if (vod.getZji()>vo.getZj()) vo.setZj(vod.getZji());
                           vo.setZjis(DateTimeUtil.timeDayFormatByStr(vod.getZjis()));
                           vo.setZjiend(DateTimeUtil.timeDayFormatByStr(vod.getZjiend()));

                       }

                       queryMap.put("paxflightno",vo.getFlightIdD());
                       LKVo lkd = fltMonitorService.selectTotalBoardingPaxCount(vo.getFlightIdD());
                       if (lkd!=null){
                           vo.setZjLK(lkd.getZjLK());
                           vo.setZjLKS(DateTimeUtil.timeDayFormatByStr(lkd.getZjLKS()));
                           vo.setZjLKEND(DateTimeUtil.timeDayFormatByStr(lkd.getZjLKEND()));
                           vo.setAjLK(lkd.getAjLK());
                           if (lkd.getAjLK()>vo.getZjLK()) vo.setZjLK(lkd.getAjLK());
                           vo.setAjLKS(DateTimeUtil.timeDayFormatByStr(lkd.getAjLKS()));
                           vo.setAjLKEND(DateTimeUtil.timeDayFormatByStr(lkd.getAjLKEND()));
                           vo.setHj(lkd.getHj());
                           if (lkd.getHj()>vo.getZjLK()) vo.setZjLK(lkd.getHj());
                           vo.setHjEND(DateTimeUtil.timeDayFormatByStr(lkd.getHjEND()));
                           vo.setHjS(DateTimeUtil.timeDayFormatByStr(lkd.getHjS()));
                           vo.setDj(lkd.getDj());
                           if (lkd.getDj()>vo.getZjLK()) vo.setZjLK(lkd.getDj());
                           vo.setDjS(DateTimeUtil.timeDayFormatByStr(lkd.getDjS()));
                           vo.setDjEND(DateTimeUtil.timeDayFormatByStr(lkd.getDjEND()));


                       }
                   }
               }
            }
        }

        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "GET", value = "航班鱼骨图详细信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFishboneDiagramInfo.json", method = RequestMethod.GET)
    public ServerResponse findFishboneDiagramInfo(@ApiParam("航班鱼骨图详细信息")
                                            @RequestParam("flightId") String flightId,
                                            HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        if (flightId != null && !"".equals(flightId)){
            if(!"undefined".equals(flightId)){
                flightIdInt = Integer.parseInt(flightId);
            }else{
                flightIdInt = 0;
            }
        }
        queryMap.put("flightId",flightIdInt);

        List<FishboneDiagramVo> list = fltMonitorService.findFishboneDiagramInfoByFlightId(queryMap);
        /*
        String nowTime = DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm");
        //Random random = new Random();
        List<FishboneDiagramVo> listReturn = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> list = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> listFishboneDiagramVo = fltMonitorService.findNodeConfigColumnInfo();
        for (int i=0;i<listFishboneDiagramVo.size();i++){
            FishboneDiagramVo fdVo = listFishboneDiagramVo.get(i);
            String NODE_COLUMN = fdVo.getNodeColumn();
            String NODE_ESTIMATE_COLUMN = fdVo.getNodeEstimateColumn();
            if(i==0){
                queryMap.put("nodeColumn",NODE_COLUMN);
                queryMap.put("nodeEstimateColumn",NODE_ESTIMATE_COLUMN);
            }else{
                queryMap.remove("nodeColumn");
                queryMap.remove("nodeEstimateColumn");
                queryMap.put("nodeColumn",NODE_COLUMN);
                queryMap.put("nodeEstimateColumn",NODE_ESTIMATE_COLUMN);
            }
            Map<String,Object> map = fltMonitorService.findFishboneDiagramInfo(queryMap);
            if(map != null){
                fdVo.setValue(map.get(NODE_COLUMN) == null ? "" : map.get(NODE_COLUMN).toString());
                fdVo.setEstimateValue(map.get(NODE_ESTIMATE_COLUMN) == null ? "" : map.get(NODE_ESTIMATE_COLUMN).toString());
            }else{
                fdVo.setValue("");
                fdVo.setEstimateValue("");
            }
            //判断状态//状态最新：正常2、未录入0、晚于正常完成3，应开始实际未开始1
            if("".equals(fdVo.getEstimateValue())){
                if(!"".equals(fdVo.getValue())){
                    fdVo.setState("2");
                }else{
                    fdVo.setState("0");
                }
            }else{
                if(!"".equals(fdVo.getValue())){
                    if(fdVo.getEstimateValue().compareTo(fdVo.getValue()) > 0){
                        fdVo.setState("2");
                    }
                    if(fdVo.getEstimateValue().compareTo(fdVo.getValue()) == 0){
                        fdVo.setState("2");
                    }
                    if(fdVo.getEstimateValue().compareTo(fdVo.getValue()) < 0){
                        fdVo.setState("3");
                    }
                }else{
                    if(fdVo.getEstimateValue().compareTo(nowTime) > 0){
                        fdVo.setState("0");
                    }
                    if(fdVo.getEstimateValue().compareTo(nowTime) == 0){
                        fdVo.setState("1");
                    }
                    if(fdVo.getEstimateValue().compareTo(nowTime) < 0){
                        fdVo.setState("1");
                    }
                }
            }
            //fdVo.setState("2");//String.valueOf(random.nextInt(4))
            list.add(fdVo);
        }

        for(int j=0;j<list.size();j++){
            FishboneDiagramVo vo = list.get(j);
            vo.setValue(DateTimeUtil.timeDayFormatByStr(vo.getValue()));
            listReturn.add(vo);
        }
        */
        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "GET", value = "航班甘特图详细信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findGanttChartInfo.json", method = RequestMethod.GET)
    public ServerResponse findGanttChartInfo(@ApiParam("航班甘特图详细信息")
                                                  @RequestParam("flightId") String flightId,
                                                  HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        if (flightId != null && !"".equals(flightId)){
            flightIdInt = Integer.parseInt(flightId);
        }
        queryMap.put("flightId",flightIdInt);

        /*
        Random random = new Random();
        List<FishboneDiagramVo> list = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> listFishboneDiagramVo = fltMonitorService.findNodeConfigColumnInfo();
        for (int i=0;i<listFishboneDiagramVo.size();i++){
            FishboneDiagramVo fdVo = listFishboneDiagramVo.get(i);
            String NODE_COLUMN = fdVo.getNodeColumn();
            String NODE_ESTIMATE_COLUMN = fdVo.getNodeEstimateColumn();
            if(i==0){
                queryMap.put("nodeColumn",NODE_COLUMN);
                queryMap.put("nodeEstimateColumn",NODE_ESTIMATE_COLUMN);
            }else{
                queryMap.remove("nodeColumn");
                queryMap.remove("nodeEstimateColumn");
                queryMap.put("nodeColumn",NODE_COLUMN);
                queryMap.put("nodeEstimateColumn",NODE_ESTIMATE_COLUMN);
            }
            Map<String,Object> map = fltMonitorService.findFishboneDiagramInfo(queryMap);
            if(map != null){
                fdVo.setValue(map.get(NODE_COLUMN) == null ? "" : map.get(NODE_COLUMN).toString());
                fdVo.setEstimateValue(map.get(NODE_ESTIMATE_COLUMN) == null ? "" : map.get(NODE_ESTIMATE_COLUMN).toString());
            }else{
                fdVo.setValue("");
                fdVo.setEstimateValue("");
            }
            fdVo.setState(String.valueOf(random.nextInt(4)));
            list.add(fdVo);
        }
        */
        List<String> listParams = new ArrayList<String>();
        List<FishboneDiagramVo> list = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> listFishboneDiagramVo = fltMonitorService.findNodeConfigColumnInfo();
        for (int i=0;i<listFishboneDiagramVo.size();i++){
            listParams.add(listFishboneDiagramVo.get(i).getNodeColumn());
            listParams.add(listFishboneDiagramVo.get(i).getNodeEstimateColumn());
        }
        //获取节点数据
        List<Map<String,Object>> listFishData = fltMonitorService.findFishboneDiagramData(listParams,queryMap);

        if(listFishData != null && listFishData.size() > 0){
            for (int k=0;k<listFishboneDiagramVo.size();k++){
                FishboneDiagramVo fdVo = listFishboneDiagramVo.get(k);
                for (int j=0;j<listFishData.size();j++){
                    Map<String,Object> map = listFishData.get(j);
                    if(fdVo.getNodeColumn() != null && !"".equals(fdVo.getNodeColumn())){
                        fdVo.setValue(JexlUtil.convertToCode(fdVo.getNodeColumn(),map) == null ? "" : JexlUtil.convertToCode(fdVo.getNodeColumn(),map).toString());
                    }else{
                        fdVo.setValue("");
                    }
                    if(fdVo.getNodeEstimateColumn() != null && !"".equals(fdVo.getNodeEstimateColumn())){
                        fdVo.setEstimateValue(JexlUtil.convertToCode(fdVo.getNodeEstimateColumn(),map) == null ? "" : JexlUtil.convertToCode(fdVo.getNodeEstimateColumn(),map).toString());
                    }else{
                        fdVo.setEstimateValue("");
                    }
                }

                list.add(fdVo);
            }
        }

        String nowTime = DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String[]> startTimeList = new ArrayList<String[]>();
        List<String[]> endTimeList = new ArrayList<String[]>();
        List<String[]> startTimeExpectedList = new ArrayList<String[]>();
        List<String[]> endTimeExpectedList = new ArrayList<String[]>();
        List<String[]> statusList = new ArrayList<String[]>();
        String []startTimeArr = new String[13];//实际开始时间
        String []endTimeArr = new String[13];//实际结束时间
        String []startTimeExpectedArr = new String[13];//预计开始时间
        String []endTimeExpectedArr = new String[13];//预计结束时间
        String []statusArr = new String[13];//状态//--进行中的传#fff 其他都传#3a4154  不要有空的
        try{
            for(int j=0;j<list.size();j++){
                FishboneDiagramVo vo = list.get(j);
                //前站起飞
                if(vo.getNodeColumn().equals("ATOT_A")){
//                    startTimeArr[0] = vo.getValue();
//                    if(vo.getValue() != null && !vo.getValue().equals("")){
//                        Date date = sdf.parse(vo.getValue()+":00");
//                        Date afterDate = new Date(date.getTime() + 60000);
//                        endTimeArr[0] = sdf.format(afterDate).substring(0,16);
//                    }else{
//                        endTimeArr[0] = vo.getValue();
//                    }
                    startTimeArr[0] = "";
                    endTimeArr[0] = "";
                    startTimeExpectedArr[0] = "";
                    endTimeExpectedArr[0] = "";
                    statusArr[0] = "#3a4154";
                }
                //实际落地
                if(vo.getNodeColumn().equals("ALDT")){
                    startTimeArr[1] = vo.getValue();
                    if(vo.getValue() != null && !vo.getValue().equals("")){
                        Date date = sdf.parse(vo.getValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeArr[1] = sdf.format(afterDate).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[1] = "#fff";
                        }else{
                            statusArr[1] = "#3a4154";
                        }
                    }else{
                        endTimeArr[1] = vo.getValue();
                        statusArr[1] = "#fff";
                    }
                }
                //计划落地
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("SIBT")){
                    startTimeExpectedArr[1] = vo.getEstimateValue();
                    if(vo.getEstimateValue() != null && !vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(vo.getEstimateValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[1] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[1] = vo.getEstimateValue();
                    }
                }

                //进离港地面移交
                if(vo.getNodeColumn().equals("A_GRND_TSF_TM")){
                    startTimeArr[2] = vo.getValue();
                    startTimeExpectedArr[2] = "";
                }
                if(vo.getNodeColumn().equals("D_GRND_TSF_TM")){
                    if(!startTimeArr[2].equals("") && vo.getValue().equals("")){
                        endTimeArr[2] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[2] = "#fff";
                        }else{
                            statusArr[2] = "#3a4154";
                        }
                    }else{
                        endTimeArr[2] = vo.getValue();
                        statusArr[2] = "#fff";
                    }
                    endTimeExpectedArr[2] = "";
                }
                //实际挡撤轮档
                if(vo.getNodeColumn().equals("AIBT")){
                    startTimeArr[3] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AOBT")){
                    if(!startTimeArr[3].equals("") && vo.getValue().equals("")){
                        endTimeArr[3] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[3] = "#fff";
                        }else{
                            statusArr[3] = "#3a4154";
                        }
                    }else{
                        endTimeArr[3] = vo.getValue();
                        statusArr[3] = "#fff";
                    }
                }
                //预计挡撤轮档
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EIBT")){
                    startTimeExpectedArr[3] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EOBT")){
                    if(!startTimeExpectedArr[3].equals("") && vo.getEstimateValue().equals("")){
                        endTimeExpectedArr[3] = sdf.format(new Date()).substring(0,16);
                    }else{
                        endTimeExpectedArr[3] = vo.getEstimateValue();
                    }
                }
                //实际靠撤客梯车时间
                if(vo.getNodeColumn().equals("ARSL")){
                    startTimeArr[4] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("ALSW")){
                    if(!startTimeArr[4].equals("") && vo.getValue().equals("")){
                        endTimeArr[4] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[4] = "#fff";
                        }else{
                            statusArr[4] = "#3a4154";
                        }
                    }else{
                        endTimeArr[4] = vo.getValue();
                        statusArr[4] = "#fff";
                    }
                }
                //预计靠撤客梯车时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ERSL")){
                    startTimeExpectedArr[4] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ELSW")){
                    if(!startTimeExpectedArr[4].equals("") && vo.getEstimateValue().equals("")){
                        endTimeExpectedArr[4] = sdf.format(new Date()).substring(0,16);
                    }else{
                        endTimeExpectedArr[4] = vo.getEstimateValue();
                    }
                }
                //实际开关客舱门时间
                if(vo.getNodeColumn().equals("ATDO")){
                    startTimeArr[5] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("ATDC")){
                    if(!startTimeArr[5].equals("") && vo.getValue().equals("")){
                        endTimeArr[5] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[5] = "#fff";
                        }else{
                            statusArr[5] = "#3a4154";
                        }
                    }else{
                        endTimeArr[5] = vo.getValue();
                        statusArr[5] = "#fff";
                    }
                }
                //预计开关客舱门时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ETDO")){
                    startTimeExpectedArr[5] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ETDC")){
                    if(!startTimeExpectedArr[5].equals("") && vo.getEstimateValue().equals("")){
                        endTimeExpectedArr[5] = sdf.format(new Date()).substring(0,16);
                    }else{
                        endTimeExpectedArr[5] = vo.getEstimateValue();
                    }
                }
                //实际开关货舱门时间
                if(vo.getNodeColumn().equals("ATFO")){
                    startTimeArr[6] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("ATFC")){
                    if(!startTimeArr[6].equals("") && vo.getValue().equals("")){
                        endTimeArr[6] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[6] = "#fff";
                        }else{
                            statusArr[6] = "#3a4154";
                        }
                    }else{
                        endTimeArr[6] = vo.getValue();
                        statusArr[6] = "#fff";
                    }
                }
                //预计开关货舱门时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ETFO")){
                    startTimeExpectedArr[6] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ETFC")){
                    if(!startTimeExpectedArr[6].equals("") && vo.getEstimateValue().equals("")){
                        endTimeExpectedArr[6] = sdf.format(new Date()).substring(0,16);
                    }else{
                        endTimeExpectedArr[6] = vo.getEstimateValue();
                    }
                }
                //实际保洁时间
                if(vo.getNodeColumn().equals("ASCT")){
                    startTimeArr[7] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AFCT")){
                    if(!startTimeArr[7].equals("") && vo.getValue().equals("")){
                        endTimeArr[7] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[7] = "#fff";
                        }else{
                            statusArr[7] = "#3a4154";
                        }
                    }else{
                        endTimeArr[7] = vo.getValue();
                        statusArr[7] = "#fff";
                    }
                }
                // 预计保洁时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ESCT")){
                    startTimeExpectedArr[7] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EFCT")){
                    if(!startTimeExpectedArr[7].equals("") && vo.getEstimateValue().equals("")){
                        endTimeExpectedArr[7] = sdf.format(new Date()).substring(0,16);
                    }else{
                        endTimeExpectedArr[7] = vo.getEstimateValue();
                    }
                }
                //实际加油时间
                if(vo.getNodeColumn().equals("ASR")){
                    startTimeArr[8] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AER")){
                    if(!startTimeArr[8].equals("") && vo.getValue().equals("")){
                        endTimeArr[8] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[8] = "#fff";
                        }else{
                            statusArr[8] = "#3a4154";
                        }
                    }else{
                        endTimeArr[8] = vo.getValue();
                        statusArr[8] = "#fff";
                    }
                }
                //预计加油时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ESR")){
                    startTimeExpectedArr[8] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EER")){
                    if(!startTimeExpectedArr[8].equals("") && vo.getEstimateValue().equals("")){
                        endTimeExpectedArr[8] = sdf.format(new Date()).substring(0,16);
                    }else{
                        endTimeExpectedArr[8] = vo.getEstimateValue();
                    }
                }
                //实际配餐时间
                if(vo.getNodeColumn().equals("ASC")){
                    startTimeArr[9] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AEC")){
                    if(!startTimeArr[9].equals("") && vo.getValue().equals("")){
                        endTimeArr[9] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[9] = "#fff";
                        }else{
                            statusArr[9] = "#3a4154";
                        }
                    }else{
                        endTimeArr[9] = vo.getValue();
                        statusArr[9] = "#fff";
                    }

                }
                //预计配餐时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ESC")){
                    startTimeExpectedArr[9] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EEC")){
                    if(!startTimeExpectedArr[9].equals("") && vo.getEstimateValue().equals("")){
                        endTimeExpectedArr[9] = sdf.format(new Date()).substring(0,16);
                    }else{
                        endTimeExpectedArr[9] = vo.getEstimateValue();
                    }

                }
                //实际登机时间
                if(vo.getNodeColumn().equals("ASBT")){
                    startTimeArr[10] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AEBT")){
                    if(!startTimeArr[10].equals("") && vo.getValue().equals("")){
                        endTimeArr[10] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[10] = "#fff";
                        }else{
                            statusArr[10] = "#3a4154";
                        }
                    }else{
                        endTimeArr[10] = vo.getValue();
                        statusArr[10] = "#fff";
                    }
                }
                //预计登机时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ESBT")){
                    startTimeExpectedArr[10] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EEBT")){
                    if(!startTimeExpectedArr[10].equals("") && vo.getEstimateValue().equals("")){
                        endTimeExpectedArr[10] = sdf.format(new Date()).substring(0,16);
                    }else{
                        endTimeExpectedArr[10] = vo.getEstimateValue();
                    }
                }
                //机务放行时间
                if(vo.getNodeColumn().equals("AACT")){
                    startTimeArr[11] = vo.getValue();
                    startTimeExpectedArr[11] = "";
                    if(vo.getValue() != null && !vo.getValue().equals("")){
                        Date date = sdf.parse(vo.getValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeArr[11] = sdf.format(afterDate).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[11] = "#fff";
                        }else{
                            statusArr[11] = "#3a4154";
                        }
                    }else{
                        endTimeArr[11] = vo.getValue();
                        statusArr[11] = "#fff";
                    }
                    endTimeExpectedArr[11] = "";
                }
                //实际起飞时间
                if(vo.getNodeColumn().equals("ATOT")){
                    startTimeArr[12] = vo.getValue();
                    if(vo.getValue() != null && !vo.getValue().equals("")){
                        Date date = sdf.parse(vo.getValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeArr[12] = sdf.format(afterDate).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[12] = "#fff";
                        }else{
                            statusArr[12] = "#3a4154";
                        }
                    }else{
                        endTimeArr[12] = vo.getValue();
                        statusArr[12] = "#fff";
                    }
                }
                //计划起飞时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("SOBT")){
                    startTimeExpectedArr[12] = vo.getEstimateValue();
                    if(vo.getEstimateValue() != null && !vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(vo.getEstimateValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[12] = sdf.format(afterDate).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[12] = "#fff";
                        }else{
                            statusArr[12] = "#3a4154";
                        }
                    }else{
                        endTimeExpectedArr[12] = vo.getEstimateValue();
                        statusArr[12] = "#fff";
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        for (int k=1;k<startTimeArr.length;k++){
            if(k==2){continue;}
            String []arrStrSt = new String[]{startTimeArr[k]};
            startTimeList.add(arrStrSt);
        }
        for (int m=1;m<endTimeArr.length;m++){
            if(m==2){continue;}
            String []arrStrEt = new String[]{endTimeArr[m]};
            endTimeList.add(arrStrEt);
        }
        for (int n=1;n<startTimeExpectedArr.length;n++){
            if(n==2){continue;}
            String []arrStrStExp = new String[]{startTimeExpectedArr[n]};
            startTimeExpectedList.add(arrStrStExp);
        }
        for (int p=1;p<endTimeExpectedArr.length;p++){
            if(p==2){continue;}
            String []arrStrEtExp = new String[]{endTimeExpectedArr[p]};
            endTimeExpectedList.add(arrStrEtExp);
        }
        for (int q=1;q<statusArr.length;q++){
            if(q==2){continue;}
            String []arrStatus = new String[]{statusArr[q]};
            statusList.add(arrStatus);
        }
        GanttChartVo gcVo = new GanttChartVo();
        gcVo.setStartTimeList(startTimeList);
        gcVo.setEndTimeList(endTimeList);
        gcVo.setStartTimeExpectedList(startTimeExpectedList);
        gcVo.setEndTimeExpectedList(endTimeExpectedList);
        gcVo.setLineState(statusList);

        return ServerResponse.createBySuccess(gcVo);

    }


    @ApiOperation(httpMethod = "GET", value = "航班事件查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFlightEvent.json", method = RequestMethod.GET)
    public ServerResponse findFlightEvent(@ApiParam("航班事件查询")
                                          @RequestParam("flightIdD") String flightIdD,
                                          @RequestParam("flightIdA") String flightIdA,
                                          HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("flightIdD",flightIdD);
        queryMap.put("flightIdA",flightIdA);
        FlightEventReturnVo vo = fltMonitorService.findFlightEvent(queryMap);
        return ServerResponse.createBySuccess(vo);
    }


    @ApiOperation(httpMethod = "GET", value = "航班监控预设字段查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findPresetFieldJK.json", method = RequestMethod.GET)
    public ServerResponse findPresetFieldJK(HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String employeeId = "Admin";
        if(sysUser != null){
            employeeId = sysUser.getEmployeeId();
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("loginName",employeeId);
        List<PresetFieldJKVo> presetFieldJKList = fltMonitorService.findPresetFieldJK(queryMap);
        return ServerResponse.createBySuccess(presetFieldJKList.get(0));
    }


    @ApiOperation(httpMethod = "POST", value = "航班监控预设字段存储", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertPresetFieldJK.json", method = RequestMethod.POST)
    public ServerResponse insertPresetFieldJK(@ApiParam("航班监控预设字段存储")
                                            @RequestParam("data") String data,
                                            HttpServletRequest request, HttpServletResponse response) {
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String employeeId = "Admin";
        if(sysUser != null){
            employeeId = sysUser.getEmployeeId();
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("data",data);
        queryMap.put("loginName",employeeId);
        return ServerResponse.createBySuccess(fltMonitorService.insertPresetFieldJK(queryMap));
    }




    @ApiOperation(httpMethod = "GET", value = "航班甘特图详细信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findGanttChartInfoById.json", method = RequestMethod.GET)
    public ServerResponse findGanttChartInfoById(@ApiParam("航班甘特图详细信息")
                                             @RequestParam("flightId") String flightId,
                                             HttpServletRequest request, HttpServletResponse response) {
        Random random = new Random();
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        if (flightId != null && !"".equals(flightId)){
            flightIdInt = Integer.parseInt(flightId);
        }
        queryMap.put("flightId",flightIdInt);

        /*
        List<FishboneDiagramVo> list = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> listFishboneDiagramVo = fltMonitorService.findNodeConfigColumnInfo();
        for (int i=0;i<listFishboneDiagramVo.size();i++){
            FishboneDiagramVo fdVo = listFishboneDiagramVo.get(i);
            String NODE_COLUMN = fdVo.getNodeColumn();
            String NODE_ESTIMATE_COLUMN = fdVo.getNodeEstimateColumn();
            if(i==0){
                queryMap.put("nodeColumn",NODE_COLUMN);
                queryMap.put("nodeEstimateColumn",NODE_ESTIMATE_COLUMN);
            }else{
                queryMap.remove("nodeColumn");
                queryMap.remove("nodeEstimateColumn");
                queryMap.put("nodeColumn",NODE_COLUMN);
                queryMap.put("nodeEstimateColumn",NODE_ESTIMATE_COLUMN);
            }
            Map<String,Object> map = fltMonitorService.findFishboneDiagramInfo(queryMap);
            if(map != null){
                fdVo.setValue(map.get(NODE_COLUMN) == null ? "" : map.get(NODE_COLUMN).toString());
                fdVo.setEstimateValue(map.get(NODE_ESTIMATE_COLUMN) == null ? "" : map.get(NODE_ESTIMATE_COLUMN).toString());
            }else{
                fdVo.setValue("");
                fdVo.setEstimateValue("");
            }
            fdVo.setState(String.valueOf(random.nextInt(4)));
            list.add(fdVo);
        }
        */
        List<String> listParams = new ArrayList<String>();
        List<FishboneDiagramVo> list = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> listFishboneDiagramVo = fltMonitorService.findNodeConfigColumnInfo();
        for (int i=0;i<listFishboneDiagramVo.size();i++){
            listParams.add(listFishboneDiagramVo.get(i).getNodeColumn());
            listParams.add(listFishboneDiagramVo.get(i).getNodeEstimateColumn());
        }
        //获取节点数据
        List<Map<String,Object>> listFishData = fltMonitorService.findFishboneDiagramData(listParams,queryMap);

        if(listFishData != null && listFishData.size() > 0){
            for (int k=0;k<listFishboneDiagramVo.size();k++){
                FishboneDiagramVo fdVo = listFishboneDiagramVo.get(k);
                for (int j=0;j<listFishData.size();j++){
                    Map<String,Object> map = listFishData.get(j);
                    if(fdVo.getNodeColumn() != null && !"".equals(fdVo.getNodeColumn())){
                        fdVo.setValue(JexlUtil.convertToCode(fdVo.getNodeColumn(),map) == null ? "" : JexlUtil.convertToCode(fdVo.getNodeColumn(),map).toString());
                    }else{
                        fdVo.setValue("");
                    }
                    if(fdVo.getNodeEstimateColumn() != null && !"".equals(fdVo.getNodeEstimateColumn())){
                        fdVo.setEstimateValue(JexlUtil.convertToCode(fdVo.getNodeEstimateColumn(),map) == null ? "" : JexlUtil.convertToCode(fdVo.getNodeEstimateColumn(),map).toString());
                    }else{
                        fdVo.setEstimateValue("");
                    }
                }
                list.add(fdVo);
            }
        }

        String nowTime = DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> startTimeList = new ArrayList<String>();
        List<String> endTimeList = new ArrayList<String>();
        List<String> startTimeExpectedList = new ArrayList<String>();
        List<String> endTimeExpectedList = new ArrayList<String>();
        List<String> statusList = new ArrayList<String>();
        List<String> nodeNameList = new ArrayList<String>();
        String []startTimeArr = new String[14];//实际开始时间
        String []endTimeArr = new String[14];//实际结束时间
        String []startTimeExpectedArr = new String[14];//预计开始时间
        String []endTimeExpectedArr = new String[14];//预计结束时间
        String []statusArr = new String[14];//状态//--进行中的传#fff 其他都传#3a4154  不要有空的
        String []nodeNameArr = new String[14];//节点中文名
        try{
            for(int j=0;j<list.size();j++){
                FishboneDiagramVo vo = list.get(j);
                //前站起飞
                if(vo.getNodeColumn().equals("ATOT_A")){
//                    startTimeArr[0] = vo.getValue();
//                    if(vo.getValue() != null && !vo.getValue().equals("")){
//                        Date date = sdf.parse(vo.getValue()+":00");
//                        Date afterDate = new Date(date.getTime() + 60000);
//                        endTimeArr[0] = sdf.format(afterDate).substring(0,16);
//                    }else{
//                        endTimeArr[0] = vo.getValue();
//                    }
                    startTimeArr[0] = "";
                    endTimeArr[0] = "";
                    startTimeExpectedArr[0] = "";
                    endTimeExpectedArr[0] = "";
                    statusArr[0] = "#3a4154";
                    nodeNameArr[0] = "";
                }
                //实际落地
                if(vo.getNodeColumn().equals("ALDT")){
                    startTimeArr[1] = vo.getValue();
                    if(vo.getValue() != null && !vo.getValue().equals("")){
                        Date date = sdf.parse(vo.getValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeArr[1] = sdf.format(afterDate).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[1] = "#fff";
                        }else{
                            statusArr[1] = "#3a4154";
                        }
                    }else{
                        endTimeArr[1] = vo.getValue();
                        statusArr[1] = "#fff";
                    }
                    nodeNameArr[1] = "落地";
                }
                //计划落地
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("SIBT")){
                    startTimeExpectedArr[1] = vo.getEstimateValue();
                    if(vo.getEstimateValue() != null && !vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(vo.getEstimateValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[1] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[1] = vo.getEstimateValue();
                    }
                }

                //进离港地面移交
                if(vo.getNodeColumn().equals("A_GRND_TSF_TM")){
                    startTimeArr[2] = vo.getValue();
                    startTimeExpectedArr[2] = "";
                }
                if(vo.getNodeColumn().equals("D_GRND_TSF_TM")){
                    if(!startTimeArr[2].equals("") && vo.getValue().equals("")){
                        endTimeArr[2] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[2] = "#fff";
                        }else{
                            statusArr[2] = "#3a4154";
                        }
                    }else{
                        endTimeArr[2] = vo.getValue();
                        statusArr[2] = "#fff";
                    }
                    endTimeExpectedArr[2] = "";
                    nodeNameArr[2] = "进离港移交";
                }
                //实际挡撤轮档
                if(vo.getNodeColumn().equals("AIBT")){
                    startTimeArr[3] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AOBT")){
                    if(!startTimeArr[3].equals("") && vo.getValue().equals("")){
                        endTimeArr[3] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[3] = "#fff";
                        }else{
                            statusArr[3] = "#3a4154";
                        }
                    }else{
                        endTimeArr[3] = vo.getValue();
                        statusArr[3] = "#fff";
                    }
                    nodeNameArr[3] = "挡撤轮档";
                }
                //预计挡撤轮档
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EIBT")){
                    startTimeExpectedArr[3] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EOBT")){
                    if(!startTimeExpectedArr[3].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[3]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[3] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[3] = vo.getEstimateValue();
                    }
                }
                //实际靠撤客梯车时间
                if(vo.getNodeColumn().equals("ARSL")){
                    startTimeArr[4] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("ALSW")){
                    if(!startTimeArr[4].equals("") && vo.getValue().equals("")){
                        endTimeArr[4] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[4] = "#fff";
                        }else{
                            statusArr[4] = "#3a4154";
                        }
                    }else{
                        endTimeArr[4] = vo.getValue();
                        statusArr[4] = "#fff";
                    }
                    nodeNameArr[4] = "靠离桥/对撤车";
                }
                //预计靠撤客梯车时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ERSL")){
                    startTimeExpectedArr[4] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ELSW")){
                    if(!startTimeExpectedArr[4].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[4]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[4] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[4] = vo.getEstimateValue();
                    }
                }
                //实际开关客舱门时间
                if(vo.getNodeColumn().equals("ATDO")){
                    startTimeArr[5] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("ATDC")){
                    if(!startTimeArr[5].equals("") && vo.getValue().equals("")){
                        endTimeArr[5] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[5] = "#fff";
                        }else{
                            statusArr[5] = "#3a4154";
                        }
                    }else{
                        endTimeArr[5] = vo.getValue();
                        statusArr[5] = "#fff";
                    }
                    nodeNameArr[5] = "开关客舱门";
                }
                //预计开关客舱门时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ETDO")){
                    startTimeExpectedArr[5] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ETDC")){
                    if(!startTimeExpectedArr[5].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[5]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[5] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[5] = vo.getEstimateValue();
                    }
                }
                //实际开关货舱门时间
                if(vo.getNodeColumn().equals("ATFO")){
                    startTimeArr[6] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("ATFC")){
                    if(!startTimeArr[6].equals("") && vo.getValue().equals("")){
                        endTimeArr[6] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[6] = "#fff";
                        }else{
                            statusArr[6] = "#3a4154";
                        }
                    }else{
                        endTimeArr[6] = vo.getValue();
                        statusArr[6] = "#fff";
                    }
                    nodeNameArr[6] = "开关货舱门";
                }
                //预计开关货舱门时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ETFO")){
                    startTimeExpectedArr[6] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ETFC")){
                    if(!startTimeExpectedArr[6].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[6]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[6] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[6] = vo.getEstimateValue();
                    }
                }
                //实际保洁时间
                if(vo.getNodeColumn().equals("ASCT")){
                    startTimeArr[7] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AFCT")){
                    if(!startTimeArr[7].equals("") && vo.getValue().equals("")){
                        endTimeArr[7] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[7] = "#fff";
                        }else{
                            statusArr[7] = "#3a4154";
                        }
                    }else{
                        endTimeArr[7] = vo.getValue();
                        statusArr[7] = "#fff";
                    }
                    nodeNameArr[7] = "保洁时间";
                }
                // 预计保洁时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ESCT")){
                    startTimeExpectedArr[7] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EFCT")){
                    if(!startTimeExpectedArr[7].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[7]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[7] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[7] = vo.getEstimateValue();
                    }
                }
                //实际加油时间
                if(vo.getNodeColumn().equals("ASR")){
                    startTimeArr[8] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AER")){
                    if(!startTimeArr[8].equals("") && vo.getValue().equals("")){
                        endTimeArr[8] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[8] = "#fff";
                        }else{
                            statusArr[8] = "#3a4154";
                        }
                    }else{
                        endTimeArr[8] = vo.getValue();
                        statusArr[8] = "#fff";
                    }
                    nodeNameArr[8] = "加油时间";
                }
                //预计加油时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ESR")){
                    startTimeExpectedArr[8] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EER")){
                    if(!startTimeExpectedArr[8].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[8]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[8] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[8] = vo.getEstimateValue();
                    }
                }
                //实际配餐时间
                if(vo.getNodeColumn().equals("ASC")){
                    startTimeArr[9] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AEC")){
                    if(!startTimeArr[9].equals("") && vo.getValue().equals("")){
                        endTimeArr[9] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[9] = "#fff";
                        }else{
                            statusArr[9] = "#3a4154";
                        }
                    }else{
                        endTimeArr[9] = vo.getValue();
                        statusArr[9] = "#fff";
                    }
                    nodeNameArr[9] = "配餐时间";
                }
                //预计配餐时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ESC")){
                    startTimeExpectedArr[9] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EEC")){
                    if(!startTimeExpectedArr[9].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[9]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[9] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[9] = vo.getEstimateValue();
                    }

                }
                //实际除冰时间
                if(vo.getNodeColumn().equals("ACDT")){
                    startTimeArr[10] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AEDT")){
                    if(!startTimeArr[10].equals("") && vo.getValue().equals("")){
                        endTimeArr[10] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[10] = "#fff";
                        }else{
                            statusArr[10] = "#3a4154";
                        }
                    }else{
                        endTimeArr[10] = vo.getValue();
                        statusArr[10] = "#fff";
                    }
                    nodeNameArr[10] = "除冰时间";
                }
                //预计除冰时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ECDT")){
                    startTimeExpectedArr[10] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EEDT")){
                    if(!startTimeExpectedArr[10].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[10]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[10] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[10] = vo.getEstimateValue();
                    }

                }
                //实际登机时间
                if(vo.getNodeColumn().equals("ASBT")){
                    startTimeArr[11] = vo.getValue();
                }
                if(vo.getNodeColumn().equals("AEBT")){
                    if(!startTimeArr[11].equals("") && vo.getValue().equals("")){
                        endTimeArr[11] = sdf.format(new Date()).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[11] = "#fff";
                        }else{
                            statusArr[11] = "#3a4154";
                        }
                    }else{
                        endTimeArr[11] = vo.getValue();
                        statusArr[11] = "#fff";
                    }
                    nodeNameArr[11] = "登机时间";
                }
                //预计登机时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ESBT")){
                    startTimeExpectedArr[11] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EEBT")){
                    if(!startTimeExpectedArr[11].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[11]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[11] = sdf.format(afterDate).substring(0,16);
                    }else{
                        endTimeExpectedArr[11] = vo.getEstimateValue();
                    }
                }
                //机务放行时间
                if(vo.getNodeColumn().equals("AACT")){
                    startTimeArr[12] = vo.getValue();
                    startTimeExpectedArr[12] = "";
                    if(vo.getValue() != null && !vo.getValue().equals("")){
                        Date date = sdf.parse(vo.getValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeArr[12] = sdf.format(afterDate).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[12] = "#fff";
                        }else{
                            statusArr[12] = "#3a4154";
                        }
                    }else{
                        endTimeArr[12] = vo.getValue();
                        statusArr[12] = "#fff";
                    }
                    endTimeExpectedArr[12] = "";
                    nodeNameArr[12] = "机务放行";
                }
                //实际起飞时间
                if(vo.getNodeColumn().equals("ATOT")){
                    startTimeArr[13] = vo.getValue();
                    if(vo.getValue() != null && !vo.getValue().equals("")){
                        Date date = sdf.parse(vo.getValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeArr[13] = sdf.format(afterDate).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[13] = "#fff";
                        }else{
                            statusArr[13] = "#3a4154";
                        }
                    }else{
                        endTimeArr[13] = vo.getValue();
                        statusArr[13] = "#fff";
                    }
                    nodeNameArr[13] = "起飞";
                }
                //计划起飞时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("SOBT")){
                    startTimeExpectedArr[13] = vo.getEstimateValue();
                    if(vo.getEstimateValue() != null && !vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(vo.getEstimateValue()+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[13] = sdf.format(afterDate).substring(0,16);
                        if(vo.getValue().compareTo(nowTime) > 0){
                            statusArr[13] = "#fff";
                        }else{
                            statusArr[13] = "#3a4154";
                        }
                    }else{
                        endTimeExpectedArr[13] = vo.getEstimateValue();
                        statusArr[13] = "#fff";
                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        for (int k=1;k<startTimeArr.length;k++){
            startTimeList.add(startTimeArr[k]);
        }
        for (int m=1;m<endTimeArr.length;m++){
            endTimeList.add(endTimeArr[m]);
        }
        for (int n=1;n<startTimeExpectedArr.length;n++){
            startTimeExpectedList.add(startTimeExpectedArr[n]);
        }
        for (int p=1;p<endTimeExpectedArr.length;p++){
            endTimeExpectedList.add(endTimeExpectedArr[p]);
        }
        for (int q=1;q<statusArr.length;q++){
            statusList.add(statusArr[q]);
        }
        for (int r=1;r<nodeNameArr.length;r++){
            nodeNameList.add(nodeNameArr[r]);
        }
        GanttChartInfoVo gciVo = new GanttChartInfoVo();
        gciVo.setStartTimeList(startTimeList);
        gciVo.setEndTimeList(endTimeList);
        gciVo.setStartTimeExpectedList(startTimeExpectedList);
        gciVo.setEndTimeExpectedList(endTimeExpectedList);
        gciVo.setLineState(statusList);
        gciVo.setNodeName(nodeNameList);

        return ServerResponse.createBySuccess(gciVo);

    }


    @ApiOperation(httpMethod = "POST", value = "航班详细修改TOBT", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateTobt.json", method = RequestMethod.POST)
    public ServerResponse updateTobt(@ApiParam("航班ID") @RequestParam("flightId") String flightId,
                                     @ApiParam("TOBT值") @RequestParam("tobt") String tobt,
                                     @ApiParam("航班号") @RequestParam("flno") String flno,
                                     @ApiParam("执行日期") @RequestParam("execDate") String execDate,
                                     HttpServletRequest request, HttpServletResponse response) throws ParseException {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        if (flightId != null && !"".equals(flightId)){
            if(!"undefined".equals(flightId)){
                flightIdInt = Integer.parseInt(flightId);
            }else{
                flightIdInt = 0;
            }
        }
        String cobt = fltSearchService.findCOBTByID(flightId);
        int i = 0;
        queryMap.put("flightId",flightIdInt);
        queryMap.put("tobt",tobt);
        TMultiDatasourceRecord record = new TMultiDatasourceRecord();
        record.setField("tobt");
        record.setTable("TLocalFlightInfo");
        record.setRecordId(flno+"-"+execDate.replaceAll("-","")+"-D");
        record.setDatasource("MANUAL");
        record.setRecordTime(new Date());
        if (null!=cobt&&!"".equals(cobt)){
            if (DateTimeUtil.compareStr(DateTimeUtil.dateToStr(new Date()),DateTimeUtil.plusMinute(-40,cobt,"yyyy-MM-dd HH:mm:ss"))){
                i = fltMonitorService.updateTobt(queryMap);
                fltMonitorService.updateTMultiDatasourceRecord(record);
            }
        }else {
            i = fltMonitorService.updateTobt(queryMap);
            fltMonitorService.updateTMultiDatasourceRecord(record);
        }
        return ServerResponse.createBySuccess(i);
    }


    @ApiOperation(httpMethod = "POST", value = "修改航班鱼骨图详细信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateFishboneDiagramNodeInfo.json", method = RequestMethod.POST)
    public ServerResponse updateFishboneDiagramNodeInfo(@ApiParam("修改航班鱼骨图详细信息")
                                                  @RequestParam("flightId") String flightId,
                                                  @RequestParam("nodeColumn") String nodeColumn,
                                                  @RequestParam("value") String value,
                                                  @RequestParam(value="userName", required=false) String userName,
                                                  @RequestParam(value="mark", required=false) String mark,
                                                  HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        int i=0;
        if (flightId != null && !"".equals(flightId)){
            if(!"undefined".equals(flightId)){
                flightIdInt = Integer.parseInt(flightId);
            }else{
                flightIdInt = 0;
            }
        }
        queryMap.put("flightId",flightIdInt);
        queryMap.put("nodeColumn",nodeColumn);
        queryMap.put("value",value);
        queryMap.put("mark",mark);
        try {
            String username="";
            if (StringUtil.isNotEmpty(userName)){
                username=userName;
            }else {
                String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
                String cacheValue = sysCacheService.getFromCache(loginToken);
                Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
                });

                if (sysUser!=null)username=sysUser.getUserId();
            }
            queryMap.put("username",username);

            i = fltMonitorService.updateFishboneDiagramNodeInfo(queryMap);


            queryMap.put("source",nodeColumn.substring(0,1).toUpperCase()+nodeColumn.substring(1).toLowerCase());



            queryMap.put("filed",nodeColumn);
            if (StringUtil.isNotEmpty(value))
            fltMonitorService.insertTlocalForprivate(queryMap);
        }catch (Exception ex){

        }

        return ServerResponse.createBySuccess(i);
    }


    @ApiOperation(httpMethod = "POST", value = "根据流控ID查询受影响的航班信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFlightByFlowControlId.json", method = RequestMethod.POST)
    public ServerResponse findFlightByFlowControlId(@ApiParam("流控ID")
                                                        @RequestParam("controlId") String controlId,
                                                        HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("controlId",controlId);
        List<FlightFlowControlVo> list = fltMonitorService.findFlightByFlowControlId(queryMap);
        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "POST", value = "查询行李流程", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findXl.json", method = RequestMethod.POST)
    public ServerResponse findXl(@ApiParam("查询行李流程")
                                            @RequestBody String AddDataObject,
                                            HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

       /* String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });*/

        JSONObject j=new JSONObject(AddDataObject);
        Map<String, Object> queryMap = new HashMap<>();
        String flnoA=j.optString("flnoA");
        String exec_dateA=j.optString("exec_dateA");
        XlVo vo=new XlVo();
        if (StringUtil.isNotEmpty(flnoA)&&StringUtil.isNotEmpty(exec_dateA)){
            queryMap.put("flno",flnoA);
            queryMap.put("exec_date",exec_dateA);
            queryMap.put("dora","A");
            XlVo voa = fltMonitorService.findXl(queryMap);
            if (voa!=null){
                vo.setXj(voa.getXj());
                vo.setXjs(DateTimeUtil.timeDayFormatByStr(voa.getXjend()));
                vo.setXjend(DateTimeUtil.timeDayFormatByStr(voa.getXjend()));
                vo.setDd(voa.getDd());
                vo.setDds(DateTimeUtil.timeDayFormatByStr(voa.getDds()));
                vo.setDdend(DateTimeUtil.timeDayFormatByStr(voa.getDdend()));
            }
        }
        String flnoD=j.optString("flnoD");
        String exec_dateD=j.optString("exec_dateD");
        if (StringUtil.isNotEmpty(flnoD)&&StringUtil.isNotEmpty(exec_dateD)){
            queryMap.put("flno",flnoD);
            queryMap.put("exec_date",exec_dateD);
            queryMap.put("dora","D");
            XlVo vod = fltMonitorService.findXl(queryMap);
            if (vod!=null){
                vo.setZj(vod.getZj());
                vo.setZjs(DateTimeUtil.timeDayFormatByStr(vod.getZjs()));
                vo.setZjend(DateTimeUtil.timeDayFormatByStr(vod.getZjend()));
                vo.setAj(vod.getAj());
                if (vod.getAj()>vo.getZj()) vo.setZj(vod.getAj());
                vo.setAjs(DateTimeUtil.timeDayFormatByStr(vod.getAjs()));
                vo.setAjend(DateTimeUtil.timeDayFormatByStr(vod.getAjend()));
                vo.setFj(vod.getFj());
                if (vod.getFj()>vo.getZj()) vo.setZj(vod.getFj());
                vo.setFjs(DateTimeUtil.timeDayFormatByStr(vod.getFjs()));
                vo.setFjend(DateTimeUtil.timeDayFormatByStr(vod.getFjend()));
                vo.setZc(vod.getZc());
                if (vod.getZc()>vo.getZj()) vo.setZj(vod.getZc());
                vo.setZcs(DateTimeUtil.timeDayFormatByStr(vod.getZcs()));
                vo.setZcend(DateTimeUtil.timeDayFormatByStr(vod.getZcend()));
                vo.setZji(vod.getZji());
                if (vod.getZji()>vo.getZj()) vo.setZj(vod.getZji());
                vo.setZjis(DateTimeUtil.timeDayFormatByStr(vod.getZjis()));
                vo.setZjiend(DateTimeUtil.timeDayFormatByStr(vod.getZjiend()));

            }
        }


        return ServerResponse.createBySuccess(vo);
    }


}
