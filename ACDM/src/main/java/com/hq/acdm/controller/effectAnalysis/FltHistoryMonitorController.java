package com.hq.acdm.controller.effectAnalysis;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.effectAnalysis.FltHistoryMonitorService;
import com.hq.acdm.util.*;
import com.hq.acdm.util.excel.JxlsBuilder;
import com.hq.acdm.vo.dynamicFlight.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "效能分析-历史监控")
@RestController
@RequestMapping("/effectAnalysis/fltHistoryMonitor")
public class FltHistoryMonitorController {

    @Resource
    private FltMonitorService fltMonitorService;
    @Resource
    private FltHistoryMonitorService fltHistoryMonitorService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;

    @ApiOperation(httpMethod = "POST", value = "航班历史动态监控列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFltInfo.json", method = RequestMethod.POST)
    public ServerResponse getFltInfo(@ApiParam("航班历史动态监控列表")
                         @RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,
                         @RequestParam("flno") String flno,@RequestParam("airlines") String airlines,
                         @RequestParam("delay") String delay,@RequestParam("agent") String agent,
                         @RequestParam("adep") String adep,@RequestParam("ades") String ades,
                                     @RequestParam("fx") String fx,
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
        queryMap.put("startExecDate",startTime.substring(0,10));
        queryMap.put("endExecDate",endTime.substring(0,10));
        queryMap.put("flno",flno);
        queryMap.put("airlines",airlines);
        queryMap.put("adep",adep);
        queryMap.put("ades",ades);
        queryMap.put("delay",delay);
        queryMap.put("agent",agent);
        queryMap.put("dept",dept);
        queryMap.put("agentSys",condition);
        queryMap.put("fx",fx);
        List<TLocalFlightInfoVo> tLocalFlightInfoList = fltHistoryMonitorService.findFltInfo(queryMap);

        return ServerResponse.createBySuccess(tLocalFlightInfoList);
    }

    @ApiOperation(httpMethod = "GET", value = "航空公司二字码", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllCompany.json", method = RequestMethod.GET)
    public ServerResponse findAllCompany() {
        List<String> allCompany = fltHistoryMonitorService.findAllCompany();
        return ServerResponse.createBySuccess(allCompany);
    }

    @ApiOperation(httpMethod = "GET", value = "机场三字码", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllAirCode.json", method = RequestMethod.GET)
    public ServerResponse findAllAirCode() {
        List<String> allAirCode = fltHistoryMonitorService.findAllAirCode();
        return ServerResponse.createBySuccess(allAirCode);
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
        List<TControlInfoVo> list = fltHistoryMonitorService.findAllControlInfo(queryMap);
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
            flightIdInt = Integer.parseInt(flightId);
        }
        queryMap.put("flightId",flightIdInt);
        List<FlightDetailsInfoVo> list = fltHistoryMonitorService.findFlightDetails(queryMap);
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
            flightIdInt = Integer.parseInt(flightId);
        }
        queryMap.put("flightId",flightIdInt);


        String nowTime = DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm");
        //Random random = new Random();
        List<FishboneDiagramVo> listReturn = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> list = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> listFishboneDiagramVo = fltHistoryMonitorService.findNodeConfigColumnInfo();
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
            Map<String,Object> map = fltHistoryMonitorService.findFishboneDiagramInfo(queryMap);
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

        return ServerResponse.createBySuccess(listReturn);
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

        Random random = new Random();
        List<FishboneDiagramVo> list = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> listFishboneDiagramVo = fltHistoryMonitorService.findNodeConfigColumnInfo();
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
            Map<String,Object> map = fltHistoryMonitorService.findFishboneDiagramInfo(queryMap);
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
        FlightEventReturnVo vo = fltHistoryMonitorService.findFlightEvent(queryMap);
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
        List<PresetFieldJKVo> presetFieldJKList = fltHistoryMonitorService.findPresetFieldJK(queryMap);
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
        return ServerResponse.createBySuccess(fltHistoryMonitorService.insertPresetFieldJK(queryMap));
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

        List<FishboneDiagramVo> list = new ArrayList<FishboneDiagramVo>();
        List<FishboneDiagramVo> listFishboneDiagramVo = fltHistoryMonitorService.findNodeConfigColumnInfo();
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
            Map<String,Object> map = fltHistoryMonitorService.findFishboneDiagramInfo(queryMap);
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

        String nowTime = DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> startTimeList = new ArrayList<String>();
        List<String> endTimeList = new ArrayList<String>();
        List<String> startTimeExpectedList = new ArrayList<String>();
        List<String> endTimeExpectedList = new ArrayList<String>();
        List<String> statusList = new ArrayList<String>();
        List<String> nodeNameList = new ArrayList<String>();
        String []startTimeArr = new String[13];//实际开始时间
        String []endTimeArr = new String[13];//实际结束时间
        String []startTimeExpectedArr = new String[13];//预计开始时间
        String []endTimeExpectedArr = new String[13];//预计结束时间
        String []statusArr = new String[13];//状态//--进行中的传#fff 其他都传#3a4154  不要有空的
        String []nodeNameArr = new String[13];//节点中文名
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
                    nodeNameArr[10] = "登机时间";
                }
                //预计登机时间
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("ESBT")){
                    startTimeExpectedArr[10] = vo.getEstimateValue();
                }
                if(vo.getNodeEstimateColumn() != null && vo.getNodeEstimateColumn().equals("EEBT")){
                    if(!startTimeExpectedArr[10].equals("") && vo.getEstimateValue().equals("")){
                        Date date = sdf.parse(startTimeExpectedArr[10]+":00");
                        Date afterDate = new Date(date.getTime() + 60000);
                        endTimeExpectedArr[10] = sdf.format(afterDate).substring(0,16);
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
                    nodeNameArr[11] = "机务放行";
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
                    nodeNameArr[12] = "起飞";
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



    @ApiOperation(httpMethod = "POST", value = "航班历史监控EXECL导出", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/exportHistoryFltInfo.json", method = RequestMethod.POST)
    public void exportHistoryFltInfo(@ApiParam("航班历史监控EXECL导出")
                                     @RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,
                                     @RequestParam("flno") String flno,@RequestParam("airlines") String airlines,
                                     @RequestParam("delay") String delay,@RequestParam("agent") String agent,
                                     @RequestParam("adep") String adep,@RequestParam("ades") String ades,
                                     HttpServletRequest request, HttpServletResponse response) throws Exception {

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
        queryMap.put("startExecDate",startTime.substring(0,10));
        queryMap.put("endExecDate",endTime.substring(0,10));
        queryMap.put("flno",flno);
        queryMap.put("airlines",airlines);
        queryMap.put("adep",adep);
        queryMap.put("ades",ades);
        queryMap.put("delay",delay);
        queryMap.put("agent",agent);
        queryMap.put("dept",dept);
        queryMap.put("agentSys",condition);
        List<TLocalFlightInfoVo> tLocalFlightInfoList = fltHistoryMonitorService.findFltInfoNoDateFormat(queryMap);

        OutputStream out = response.getOutputStream();
        JxlsBuilder jxlsBuilder = JxlsBuilder
                .getBuilder(ResourceUtils.getFile("classpath:template/historyFlightInfo.xlsx").getAbsolutePath())
                .out(out)
                .ignoreImageMiss(true)
                .putVar("lnrList", tLocalFlightInfoList)
                .build();

        out.close();
    }

}
