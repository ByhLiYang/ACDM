package com.hq.acdm.controller.index;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.index.CompanyDuty;
import com.hq.acdm.model.index.VDelayFlightSum;
import com.hq.acdm.model.index.VSequenceArrivalFetchrows;
import com.hq.acdm.model.index.VSequenceDepartureFetchrows;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.index.IIndexService;
import com.hq.acdm.service.realtimeSituation.FlightChartService;
import com.hq.acdm.service.realtimeSituation.FlightIndexService;
import com.hq.acdm.service.realtimeSituation.PassengerIndexService;
import com.hq.acdm.service.rscMonitors.RealtimeStandService;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.index.BaseSituationVo;
import com.hq.acdm.vo.index.DelayFlightVo;
import com.hq.acdm.vo.index.FlightNumVo;
import com.hq.acdm.vo.index.WeatherAndDutyVo;
import com.hq.acdm.vo.realtimeSituation.*;
import com.hq.acdm.vo.rscMonitors.BaseStand;
import com.hq.acdm.vo.rscMonitors.StandStatusVo;
import com.hq.acdm.vo.supervision.managermonitor.FourD;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lizhifeng
 * @Date 2018/9/3 0003
 * @Description:
 */
@Api(description = "系统首页Api")
@RestController
@RequestMapping("/index/situation")
public class IndexController {

    @Resource
    private IIndexService indexService;
    @Resource
    private FlightIndexService flightIndexService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;
    @Resource
    private FlightChartService flightChartService;
    @Resource
    private RealtimeStandService realtimeStandService;
    @Resource
    private PassengerIndexService passengerIndexService;

    @ApiOperation(httpMethod = "GET", value = "进港航班序列", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getInboundList.json", method = RequestMethod.GET)
    public ServerResponse<List<VSequenceArrivalFetchrows>> getInboundList(@RequestParam(value = "company", defaultValue = "") String company) {
        return ServerResponse.createBySuccess(indexService.geVSequenceArrivalFetchrows());
    }

    @ApiOperation(httpMethod = "GET", value = "离港航班序列", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getOutboundList.json", method = RequestMethod.GET)
    public ServerResponse<List<VSequenceDepartureFetchrows>> getOutboundList(@RequestParam(value = "company", defaultValue = "") String company) {
        return ServerResponse.createBySuccess(indexService.getVSequenceDepartureFetchrows());
    }

    @ApiOperation(httpMethod = "GET", value = "本场天气情况", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/weather.json", method = RequestMethod.GET)
    public ServerResponse<WeatherAndDutyVo> weather(@RequestParam(value = "company", defaultValue = "") String company,
                                                    HttpServletRequest request) {
        WeatherAndDutyVo vo = indexService.selectByWeatherDate();
        Map<String, Object> queryMap = new HashMap<>();
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        FlightHandTerminalVo fhtv = flightIndexService.findFltToHandTerminal(queryMap);
//APP航班实况，上半部分指标数据
        FlightIndexVo fiv = flightIndexService.findFlightIndex(queryMap);
        List<CompanyDuty> listcd = new ArrayList<>();
        CompanyDuty cd = new CompanyDuty();
//        出港旅客
        cd.setHqCompanyDuty(String.valueOf(fiv.getLK()));
//        行李
        cd.setFlightAreaDuty(String.valueOf(fiv.getXL()));
//        出港延误
        cd.setAocManager(String.valueOf(fiv.getYWS()));
//        放行不正常
        cd.setAocExternalManager(String.valueOf(fiv.getFXYWS()));
//        专机要客，先给个0，后面再改
        cd.setAocInternalManager(String.valueOf(0));
        listcd.add(cd);
        vo.setCompanyDuty(listcd);

        fhtv.setJwzs(realtimeStandService.findJWZS());
        fhtv.setBkys(realtimeStandService.findBKYS());
        fhtv.setJrtc(realtimeStandService.findJRTC());
        fhtv.setGyhb(realtimeStandService.findGYHB());
        List<StandStatusVo> list = realtimeStandService.findStandInfo();
        List<BaseStand> baseList = realtimeStandService.findBaseStand();
        int JJWZS = 0;
        int YJWZS = 0;
        int JJWZY = 0;
        int YJWZY = 0;
        int CQZY = 0;
        int BZY = 0;
        int BZS = 0;
        int CZY = 0;
        int CZS = 0;
        int DZY = 0;
        int DZS = 0;
        int EZY = 0;
        int EZS = 0;
        int FZY = 0;
        int FZS = 0;
        for (int i = 0; i < list.size(); i++) {
            if ("1".equals(list.get(i).getStatus())){
                CQZY++;
            }
            if ("1".equals(list.get(i).getStatus())||"3".equals(list.get(i).getStatus())){
                for (int j = 0; j < baseList.size(); j++) {
                    if (list.get(i).getStand().equals(baseList.get(j).getStand())){
                        if ("Y".equals(baseList.get(j).getIsremote())){
                            YJWZY++;
                        }else{
                            JJWZY++;
                        }
                        if (null!=baseList.get(j).getType()&&"B".equals(baseList.get(j).getType())){
                            BZY++;
                        }else if (null!=baseList.get(j).getType()&&"C".equals(baseList.get(j).getType())){
                            CZY++;
                        }else if (null!=baseList.get(j).getType()&&"D".equals(baseList.get(j).getType())){
                            DZY++;
                        }else if (null!=baseList.get(j).getType()&&"E".equals(baseList.get(j).getType())){
                            EZY++;
                        }else if (null!=baseList.get(j).getType()&&"F".equals(baseList.get(j).getType())){
                            FZY++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < baseList.size(); i++) {
            if ("Y".equals(baseList.get(i).getIsremote())){
                YJWZS++;
            }else{
                JJWZS++;
            }
            if (null!=baseList.get(i).getType()&&"B".equals(baseList.get(i).getType())){
                BZS++;
            }else if (null!=baseList.get(i).getType()&&"C".equals(baseList.get(i).getType())){
                CZS++;
            }else if (null!=baseList.get(i).getType()&&"D".equals(baseList.get(i).getType())){
                DZS++;
            }else if (null!=baseList.get(i).getType()&&"E".equals(baseList.get(i).getType())){
                EZS++;
            }else if (null!=baseList.get(i).getType()&&"F".equals(baseList.get(i).getType())){
                FZS++;
            }
        }
        fhtv.setCqzy(CQZY);
        fhtv.setJjwzy(JJWZY);
        fhtv.setJjwzs(JJWZS);
        fhtv.setYjwzy(YJWZY);
        fhtv.setYjwzs(YJWZS);
        fhtv.setBzy(BZY);
        fhtv.setBsy(BZS-BZY);
        fhtv.setCzy(CZY);
        fhtv.setCsy(CZS-CZY);
        fhtv.setDzy(DZY);
        fhtv.setDsy(DZS-DZY);
        fhtv.setEzy(EZY);
        fhtv.setEsy(EZS-EZY);
        fhtv.setFzy(FZY);
        fhtv.setFsy(FZS-FZY);
        List<FourD> fdList = new ArrayList<FourD>();
        String[] strArr = {"B","C","D","E"};
        for (int i=0;i<strArr.length;i++){
            FourD fd = new FourD();
            fd.setD0(strArr[i]);
            if(i == 0){fd.setD1(fhtv.getBsy()+"");}
            if(i == 1){fd.setD1(fhtv.getCsy()+"");}
            if(i == 2){fd.setD1(fhtv.getDsy()+"");}
            if(i == 3){fd.setD1(fhtv.getEsy()+"");}
            fd.setD3(fd.getMyD3());
            fdList.add(fd);
        }
        vo.setTableData2(fdList);

        return ServerResponse.createBySuccess(vo);
    }

    @ApiOperation(httpMethod = "GET", value = "航班延误情况", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delay.json", method = RequestMethod.GET)
    public ServerResponse<List<VDelayFlightSum>> delay(@RequestParam(value = "company", defaultValue = "") String company) {
        return ServerResponse.createBySuccess(indexService.getDelayFlight());
    }

    @ApiOperation(httpMethod = "GET", value = "进港航班情况", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getInbound.json", method = RequestMethod.GET)
    public ServerResponse<FlightNumVo> getInbound(@RequestParam(value = "company", defaultValue = "") String company,HttpServletRequest request) {
        Map<String, Object> queryMap = new HashMap<>();
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        HBSPerHourVo hphv = flightChartService.findHBSPerHour(queryMap);
        FlightNumVo fnv = new FlightNumVo();
        fnv.setPlanFlightNum(hphv.getAJHS());
        fnv.setActualFlightNum(hphv.getASJS());
        return ServerResponse.createBySuccess(fnv);
    }

    @ApiOperation(httpMethod = "GET", value = "出港航班情况", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getOutbound.json", method = RequestMethod.GET)
    public ServerResponse<FlightNumVo> getOutbound(@RequestParam(value = "company", defaultValue = "") String company,HttpServletRequest request) {
        Map<String, Object> queryMap = new HashMap<>();
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        HBSPerHourVo hphv = flightChartService.findHBSPerHour(queryMap);
        FlightNumVo fnv = new FlightNumVo();
        fnv.setPlanFlightNum(hphv.getDJHS());
        fnv.setActualFlightNum(hphv.getDSJS());
        return ServerResponse.createBySuccess(fnv);
    }

    @ApiOperation(httpMethod = "GET", value = "首页基本情况数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/get.json", method = RequestMethod.GET)
    public ServerResponse<BaseSituationVo> get(@RequestParam(value = "company", defaultValue = "") String company,
                                               HttpServletRequest request) {
        Map<String, Object> queryMap = new HashMap<>();
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
        queryMap.put("dept",dept);
        queryMap.put("agent",condition);
        FlightIndexVo fiv = flightIndexService.findFlightIndex(queryMap);
        FltRlsIdxVo fri = flightIndexService.findFltRlsIdx(queryMap);
        PassengerAreaVo v=passengerIndexService.findPassengerArea(queryMap);
        BaseSituationVo vo = new BaseSituationVo();
        vo.setFlightNum(fiv.getZHB());
        vo.setNormalRate(fri.getZCL()+"");
        vo.setPassRate(fri.getFXL()+"");
        vo.setExecuted(fiv.getZCS());
        vo.setNonExecution(fiv.getZHB()-fiv.getZCS());
        vo.setPreparationForDrop(fiv.getBJSA()+fiv.getBJSD());
        vo.setCancel(fiv.getQXS());
        if (v!=null){
            vo.setWaitFlightPersonNum(v.getHJQRS());
            vo.setFlightPersonNum(v.getJSRS());
            vo.setSecurityPersonNum(v.getAJQRS());
            vo.setTotalPersonNum(v.getZRS()+"");
        }

        //BaseSituationVo vo=indexService.getBaseSituation(company);
        if(vo==null||vo.getFlightNum()<=0){
            //如果查询出来实体为空或者总航班数为空,则回复给前台数据为空代码,不让前台更新大屏数据
            return ServerResponse.createByNullPointerError();
        }else{
            return ServerResponse.createBySuccess(vo);
        }
    }
}
