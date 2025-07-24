package com.hq.acdm.controller.dynamicFlight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.TDelayCoordination;
import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecord;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.dynamicFlight.FltSituationService;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.util.*;
import com.hq.acdm.vo.dynamicFlight.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.ArrayStack;
import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "航班动态航班态势")
@RestController
@RequestMapping("/dynamicFlight/FltSituation")
public class FltSituationController {

    @Resource
    private FltSituationService fltSituationService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private UsersService usersService;
    @Resource
    private FltMonitorService fltMonitorService;

    @ApiOperation(httpMethod = "GET", value = "航班动态航班态势临界落地", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getCriticalFltA.json", method = RequestMethod.GET)
    public ServerResponse getCriticalFltA() {
        List<CriticalFltAVo> listFltA = fltSituationService.findCriticalFltA();
        return ServerResponse.createBySuccess(listFltA);
    }

    @ApiOperation(httpMethod = "GET", value = "临界航班", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getCriticalFltRls.json", method = RequestMethod.GET)
    public ServerResponse getCriticalFltRls(HttpServletRequest request) {
        Map<String, Object> queryMap = new HashMap<>();
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = usersService.findDepartment(sysUser.getEmployeeId());
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        List<CriticalFltRlsVo> list = fltSituationService.findCriticalFltRls(queryMap);
        for (CriticalFltRlsVo cfrv:list){
            if (null==cfrv.getSobt()){
                cfrv.setSobt("");
            }
            if (null==cfrv.getAobt()){
                cfrv.setAobt("");
            }
            if (null==cfrv.getAtdc()){
                cfrv.setAtdc("");
            }
            if (null==cfrv.getFxlj()){
                cfrv.setFxlj("");
            }
            if (null==cfrv.getTtot()){
                cfrv.setTtot("");
            }
        }

        List<CriticalFltRlsVo> listOpen = fltSituationService.findCriticalFltRlsOpen(queryMap);
        for (CriticalFltRlsVo cfrv:listOpen){
            if (null==cfrv.getSobt()){
                cfrv.setSobt("");
            }
            if (null==cfrv.getAobt()){
                cfrv.setAobt("");
            }
            if (null==cfrv.getAtdc()){
                cfrv.setAtdc("");
            }
            if (null==cfrv.getFxlj()){
                cfrv.setFxlj("");
            }
            if (null==cfrv.getTtot()){
                cfrv.setTtot("");
            }
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("atdcClose",list);
        map.put("atdcOpen",listOpen);
        return ServerResponse.createBySuccess(map);
    }

    @ApiOperation(httpMethod = "GET", value = "航司关注", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getCriticalFltIWt.json", method = RequestMethod.GET)
    public ServerResponse getCriticalFltIWt(HttpServletRequest request) {
        Map<String, Object> queryMap = new HashMap<>();
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = usersService.findDepartment(sysUser.getEmployeeId());
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        List<CriticalFltRlsVo> list = fltSituationService.findCriticalFltIWt(queryMap);
        for (CriticalFltRlsVo cfrv:list){
            if (null==cfrv.getSobt()){
                cfrv.setSobt("");
            }
            if (null==cfrv.getAobt()){
                cfrv.setAobt("");
            }
            if (null==cfrv.getAtdc()){
                cfrv.setAtdc("");
            }
            if (null==cfrv.getFxlj()){
                cfrv.setFxlj("");
            }
            if (null==cfrv.getTtot()){
                cfrv.setTtot("");
            }
        }
        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "GET", value = "航班动态航班态势临界起飞", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getCriticalFltD.json", method = RequestMethod.GET)
    public ServerResponse getCriticalFltD() {
        List<CriticalFltDVo> listFltD = fltSituationService.findCriticalFltD();
        return ServerResponse.createBySuccess(listFltD);
    }


    @ApiOperation(httpMethod = "GET", value = "航班关注", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateFlightFocus.json", method = RequestMethod.GET)
    public ServerResponse updateFlightFocus(@ApiParam("航班关注")
                                          @RequestParam("flightId") String flightId,
                                            @RequestParam("flag") String flag,
                                          HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        int flagInt = 0;
        if (flightId != null && !"".equals(flightId)){
            flightIdInt = Integer.parseInt(flightId);
        }
        if (flag != null && !"".equals(flag)){
            flagInt = Integer.parseInt(flag);
        }
        queryMap.put("flightId",flightIdInt);
        queryMap.put("flag",flagInt);
        int i = fltSituationService.updateFlightFocus(queryMap);
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "查询航班是否已点击协调", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getIsCoordination.json", method = RequestMethod.GET)
    public ServerResponse getIsCoordination(@ApiParam("航班ID")
                                            @RequestParam("flightId") String flightId,
                                            HttpServletRequest request, HttpServletResponse response) {
        return ServerResponse.createBySuccess(fltSituationService.findIsCoordination(flightId));
    }
    @ApiOperation(httpMethod = "POST", value = "航班协调", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateDelayCoordination.json", method = RequestMethod.POST)
    public ServerResponse updateDelayCoordination(@ApiParam("航班协调")
                                                  @RequestParam("flightId") String flightId,
                                                  @RequestParam("priority") String priority,
                                                  @RequestParam("state") String state,
                                                  HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        int flagInt = 0;
        if (flightId != null && !"".equals(flightId)){
            flightIdInt = Integer.parseInt(flightId);
        }
        int i = 0;
        queryMap.put("flightId",flightIdInt);

        List<TDelayCoordination> tdcModList = fltSituationService.selectByFlightId(flightId);
        if(tdcModList == null || tdcModList.size() == 0){
            List<TDelayCoordination> dcList = fltSituationService.selectDelayCoordinationInfo(queryMap);
            if(dcList != null && dcList.size() > 0){
                TDelayCoordination tdc = dcList.get(0);
                tdc.setId(UUID.randomUUID().toString().replaceAll("-",""));
                tdc.setState(state);
                tdc.setPriority(priority);
                tdc.setCreateEmp("Admin");
                tdc.setCreateTm(new Date());
                i = fltSituationService.insertTDelayCoordination(tdc);
            }
        }else{
            queryMap.put("state",state);
            if ("2".equals(state))
                queryMap.put("state2",state);
            i = fltSituationService.updateTDelayCoordinationState(queryMap);
        }
        return ServerResponse.createBySuccess(i);
    }

    @ApiOperation(httpMethod = "POST", value = "取消航班协调", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateTDelayCoordinationState.json", method = RequestMethod.POST)
    public ServerResponse updateTDelayCoordinationState(@ApiParam("取消协调航班ID")
                                                  @RequestParam("flightId") String flightId,
                                                  @RequestParam("state") String state,
                                                  HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        int flagInt = 0;
        if (flightId != null && !"".equals(flightId)){
            flightIdInt = Integer.parseInt(flightId);
        }
        int i = 0;
        queryMap.put("flightId",flightIdInt);
        queryMap.put("state",state);
        if ("2".equals(state))
        queryMap.put("state2",state);
        i = fltSituationService.updateTDelayCoordinationState(queryMap);

        return ServerResponse.createBySuccess(i);
    }

    @ApiOperation(httpMethod = "GET", value = "航班时间轴排序", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFltScheduling.json", method = RequestMethod.GET)
    public ServerResponse<List<FltSchedulingVo>> getFltScheduling() {
        return ServerResponse.createBySuccess(fltSituationService.findFltScheduling());
    }
    @ApiOperation(httpMethod = "GET", value = "查询今日有效航班id", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findControlId.json", method = RequestMethod.GET)
    public ServerResponse<List<ControlInfoVo>> findControlId() {
        return ServerResponse.createBySuccess(fltSituationService.findControlId(null));
    }

    @ApiOperation(httpMethod = "POST", value = "航班时间轴排序", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFltTimeAxis.json", method = RequestMethod.POST)
    public ServerResponse<List<FltTimeAxisVo>> getFltTimeAxis(@ApiParam("航班时间轴排序")
                                                                  @RequestBody String AddDataObject) {
        Map<String, Object> queryMap = new HashMap<>();
        List<FltTimeAxisVo> relist=new ArrayList<FltTimeAxisVo>();
        List<FltTimeAxisVo> list=new ArrayList<FltTimeAxisVo>();

        try {
            JSONObject json = new JSONObject(AddDataObject);
            String type=json.optString("type");
            String flno=json.optString("flno");
            queryMap.put("flno",flno);
            String controlIds = json.optString("controlIds");
            String fuids="";
            if(StringUtil.isNotEmpty(controlIds)){
                String []  jsonArray=controlIds.split(",");
                for (int i = 0; i < jsonArray.length; i++) {
                    String h = jsonArray[i] + "";

                    if(i==jsonArray.length-1){
                        fuids+="'"+h+"'";
                    }else {
                        fuids+="'"+h+"',";
                    }
                }
            }

            queryMap.put("fuids",fuids);
            if ("CTOT".equals(type)){
                list=fltSituationService.findFltTimeAxis(queryMap);
            }else if("TOBT".equals(type)){
                list=fltSituationService.findFltTimeAxisTobt(queryMap);
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }


        FltTimeAxisVo vo=null;
        for (int i = 0; i <list.size() ; i++) {
            vo=list.get(i);
            vo.setShorttimes(DateTimeUtil.reDayFormatByStr(vo.getShorttimes()));
            relist.add(vo);
        }
        return ServerResponse.createBySuccess(relist);
    }
    @ApiOperation(httpMethod = "POST", value = "修改时间轴", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateTimeAxis.json", method = RequestMethod.POST)
    public ServerResponse updateTimeAxis(@ApiParam("修改时间轴")
                                            @RequestParam("flid") String flid,
                                            @RequestParam("updateTime") String updateTime,
                                            @RequestParam("type") String type,
                                            @RequestParam("flno") String flno,
                                            @RequestParam("execDate") String execDate,
                                            HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        Date time = null;
        if (flid != null && !"".equals(flid)){
            flightIdInt = Integer.parseInt(flid);

        }
        if (updateTime != null && !"".equals(updateTime)){
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = dateFormat.format(now);
            updateTime=updateTime.trim();
            updateTime=updateTime.replace(" ","+");
            if (updateTime.contains("+")){
                currentDate=dateFormat.format(new Date(now.getTime()+24*60*60*1000));
                updateTime=currentDate+" "+updateTime.substring(0,5)+":00";
            }else if(updateTime.contains("-")){
                currentDate=dateFormat.format(new Date(now.getTime()-24*60*60*1000));
                updateTime=currentDate+" "+updateTime.substring(0,5)+":00";
            }else if(updateTime.length()==5){
                updateTime=currentDate+" "+updateTime+":00";
            }

            time= DateTimeUtil.strToDate(updateTime);
            queryMap.put("flid",flightIdInt);
            queryMap.put("updateTime",time);
            if ("CTOT".equals(type)){
                int i = fltSituationService.updateTimeAxis(queryMap);
            }else if ("TOBT".equals(type)){
                queryMap.put("flightId",flightIdInt);
                queryMap.put("tobt",updateTime);
                int i = fltMonitorService.updateTobt(queryMap);
                TMultiDatasourceRecord record = new TMultiDatasourceRecord();
                record.setField("tobt");
                record.setTable("TLocalFlightInfo");
                record.setRecordId(flno+"-"+execDate.replaceAll("-","")+"-D");
                record.setDatasource("MANUAL");
                record.setRecordTime(new Date());
                fltMonitorService.updateTMultiDatasourceRecord(record);
            }

        }

        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "协调处置事件", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertCD.json", method = RequestMethod.POST)
    public ServerResponse insertCD(@ApiParam("协调处置事件")
                                         @RequestParam("flightId") String flightId,
                                         @RequestParam("type") String type,
                                         @RequestParam("afid") String afid,
                                         HttpServletRequest request, HttpServletResponse response) {
           //ENSURE 保障， COORDINATE 协调  ，EXCHANGE 互换
        SimpleDateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         //主航班
         TCoordinatedDisposal vo=fltSituationService.selectByFlid(flightId);
         if (vo!=null){
             vo.setEventType(type);
             vo.setId(UUID.randomUUID().toString().replaceAll("-",""));
             vo.setUpdateTm(new Date());
             String YWLJ=vo.getYwlj()!=null?DateTimeUtil.timeDayFormatByDate2(vo.getYwlj()):"";
             String atdc=vo.getAtdc()!=null?DateTimeUtil.timeDayFormatByDate2(vo.getAtdc()):"";
             String ALDT=vo.getAldt()!=null?DateTimeUtil.timeDayFormatByDate2(vo.getAldt()):"";
             String ATOT=vo.getAtot()!=null?DateTimeUtil.timeDayFormatByDate2(vo.getAtot()):"";
             String CTOT=vo.getCdm()!=null?DateTimeUtil.timeDayFormatByDate2(vo.getCdm()):"";
             Date cdm=vo.getCdm();

             if ("ENSURE".equals(type)){
                 String getFlightTm=fltSituationService.findFlightTm(flightId);
                 String SS=vo.getFlno()+"航班的临界时间为"+YWLJ+"，运管委管在航班落地前发现该航班已落地延误，如果启动快速过站应当可以追回延误时间，"
                         +vo.getFlno()+"航班"+ALDT+"在武汉落地后，运管委，航司通知该航班启动快速过站，该航班于"+atdc+"关闭舱门。" +
                         "运管委在"+getFlightTm+"提前介入与塔台协调沟通，保障该航班准备好后能立即开车离场，" +
                         "经过多方努力和全力保障该航班于"+ATOT+"分起飞，避免了"+vo.getFlno()+"航班的延误发生.";
                 vo.setRmk(SS);
             }
             if ("COORDINATE".equals(type)){
                 String getFlightTm=fltSituationService.findFlightTm(flightId);
                 String SS=vo.getFlno()+"航班的临界时间为"+YWLJ+"，运管委管制席位在航班时刻"+getFlightTm+"前发现该航班的" +
                         "CDM起飞时间为"+CTOT+"，处于延误边缘，运管委介入与塔台协调后，" +
                         "该航班最后于"+ATOT+"分起飞，避免了"+vo.getFlno()+"的延误发生.";
                 vo.setRmk(SS);
             }
             if ("EXCHANGE".equals(type)){
                 if (afid != null && !"".equals(afid)){
                     vo.setAfid(Long.parseLong(afid));
                     //互换航班
                     TCoordinatedDisposal afvo=fltSituationService.selectByFlid(afid);
                     if (afvo!=null){
                         String getFlightTm=fltSituationService.findFlightTm(afid);
                         String CTOT2=afvo.getCdm()!=null?DateTimeUtil.timeDayFormatByDate2(afvo.getCdm()):"";
                         String fl=afvo.getFlno().substring(0,2);

                         String hs="地服";
                         if (ConstantUtil.CCA.contains(fl)){
                             hs="国航";
                         }
                         if (ConstantUtil.CES.contains(fl)){
                             hs="东航";
                         }
                         if (ConstantUtil.CSN.contains(fl)){
                             hs="南航";
                         }
                         if (ConstantUtil.AIRLINES_HUO_YUN.contains(fl)){
                             hs="货运";
                         }
                         String SS="背景：落"+afvo.getFlno()+"航班"+CTOT2+"分钟一架，CDM同意放行排序\n" +
                                 "事件经过："+vo.getFlno()+"和"+afvo.getFlno()+"都是执行武汉—"+vo.getRmk()+"的航班任务，" +
                                 "CDM系统给出的起飞时间分别为"+CTOT+"和"+CTOT2+"，" +
                                 getFlightTm+"时"+hs+"航司发现"+afvo.getFlno()+"航班如果"+CTOT2+"起飞该航班就会延误，此时"+afvo.getFlno()+"到"+vo.getRmk()+"的航班已经延误，" +
                                 "如果把"+vo.getFlno()+"航班的起飞时刻给"+afvo.getFlno()+"航班可以保障"+afvo.getFlno()+"航班不出现延误，此时运管委管制席位介入，" +
                                 "与塔台协调将两个航班的CDM时间进行互换，最后保障了"+afvo.getFlno()+"航班正常起飞，避免了延误。\n";
                         vo.setRmk(SS);
                         vo.setCdm(afvo.getCdm());
                         afvo.setCdm(cdm);
                         afvo.setRmk(SS);
                         int res =fltSituationService.updateCDByPrimaryKeySelective(afvo);
                         afvo.setEventType(type);
                         afvo.setId(UUID.randomUUID().toString().replaceAll("-",""));
                         afvo.setUpdateTm(new Date());
                         if (res==0){
                             afvo.setCreateTm(new Date());
                             afvo.setUpdateTm(new Date());
                             fltSituationService.insertCDSelective(afvo);
                         }
                     }

                 }

             }

             int res =fltSituationService.updateCDByPrimaryKeySelective(vo);

             if (res==0){
                 vo.setCreateTm(new Date());
                 vo.setUpdateTm(new Date());
                 fltSituationService.insertCDSelective(vo);
             }


         }


        return ServerResponse.createBySuccess();
    }


    @ApiOperation(httpMethod = "GET", value = "航班动态航班态势小延误协调", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getDelayCoordinationInfo.json", method = RequestMethod.GET)
    public ServerResponse getDelayCoordinationInfo(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = usersService.findDepartment(sysUser.getEmployeeId());
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        List<DelayCoordinationVo> list= fltSituationService.findDelayCoordinationInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "GET", value = "航班动态航班态势协调完成", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getTobtToCobtInfo.json", method = RequestMethod.GET)
    public ServerResponse getTobtToCobtInfo(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = usersService.findDepartment(sysUser.getEmployeeId());
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        List<DelayCoordinationVo> list = fltSituationService.findTobtToCobtInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }



    @ApiOperation(httpMethod = "POST", value = "协调延误统计查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findCoordinationDelayCountInfo.json", method = RequestMethod.POST)
    public ServerResponse findCoordinationDelayCountInfo(@RequestParam("startDate") String startDate,
                                                         @RequestParam("endDate") String endDate,
                                                         HttpServletRequest request) {
        Map<String, Object> queryMap = new HashMap<>();
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String condition = "";
        String dept = "";
        if(sysUser != null){
            dept = usersService.findDepartment(sysUser.getEmployeeId());
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
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        List<CoordinationDelayCountVo> list = fltSituationService.findCoordinationDelayCountInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "POST", value = "取消航班协调", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateTDelayCoordinationContent.json", method = RequestMethod.POST)
    public ServerResponse updateTDelayCoordinationContent(@ApiParam("协调航班ID") @RequestParam("flightId") String flightId,
                                                          @ApiParam("流量控制原因") @RequestParam("reason") String reason,
                                                          @ApiParam("协调单位及内容") @RequestParam("unitAndContent") String unitAndContent,
                                                          @ApiParam("协调员") @RequestParam("coordinator") String coordinator,
                                                        HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        int flightIdInt = 0;
        if (flightId != null && !"".equals(flightId)){
            flightIdInt = Integer.parseInt(flightId);
        }
        int i = 0;
        queryMap.put("flightId",flightIdInt);
        queryMap.put("flowControlReason",reason);
        queryMap.put("coordinationUnitAndContent",unitAndContent);
        queryMap.put("coordinator",coordinator);
        i = fltSituationService.updateTDelayCoordinationContent(queryMap);

        return ServerResponse.createBySuccess(i);
    }

}
