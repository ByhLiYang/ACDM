package com.hq.acdm.controller.realtimeSituation;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.realtimeSituation.FlightIndexService;
import com.hq.acdm.service.rscMonitors.RealtimeStandService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.realtimeSituation.FlightIndexVo;
import com.hq.acdm.vo.realtimeSituation.FlightHandTerminalVo;
import com.hq.acdm.vo.realtimeSituation.FltDetailIdxVo;
import com.hq.acdm.vo.realtimeSituation.FltRlsIdxAptVo;
import com.hq.acdm.vo.realtimeSituation.FltRlsIdxVo;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.vo.rscMonitors.BaseStand;
import com.hq.acdm.vo.rscMonitors.StandStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/25 11:09
 * @Description
 */
@Api(description = "实况航班指标")
@RestController
@RequestMapping("/realtimeSituation/flightIndex")
public class FlightIndexController {
    @Resource
    private FlightIndexService flightIndexService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private UsersService UsersService;
    @Resource
    private RealtimeStandService realtimeStandService;
    @ApiOperation(httpMethod = "GET", value = "实况航班总览指标", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFlightIndex.json", method = RequestMethod.GET)
    public ServerResponse<FlightIndexVo> getFlightIndex(HttpServletRequest request) {
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
        return ServerResponse.createBySuccess(flightIndexService.findFlightIndex(queryMap));
    }
    @ApiOperation(httpMethod = "GET", value = "实况进港详细指标", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getAFltDetailIdx.json", method = RequestMethod.GET)
    public ServerResponse<List<FltDetailIdxVo>> getAFltDetailIdx(HttpServletRequest request) {
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
        return ServerResponse.createBySuccess(flightIndexService.findAFltDetailIdx(queryMap));
    }
    @ApiOperation(httpMethod = "GET", value = "实况出港详细指标", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getDFltDetailIdx.json", method = RequestMethod.GET)
    public ServerResponse<List<FltDetailIdxVo>> getDFltDetailIdx(HttpServletRequest request) {
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
        return ServerResponse.createBySuccess(flightIndexService.findDFltDetailIdx(queryMap));
    }
    @ApiOperation(httpMethod = "GET", value = "本场放行正常率", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFltRlsIdx.json", method = RequestMethod.GET)
    public ServerResponse<FltRlsIdxVo> getFltRlsIdx(HttpServletRequest request) {
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
        return ServerResponse.createBySuccess(flightIndexService.findFltRlsIdx(queryMap));
    }
/*    @ApiOperation(httpMethod = "GET", value = "航线放行率", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFltRlsIdxByApt.json", method = RequestMethod.GET)
    public ServerResponse<FltRlsIdxVo> getFltRlsIdxByApt(@RequestParam("airports")String airports) {
        String[] airport = airports.split(",");
        return ServerResponse.createBySuccess(flightIndexService.getFltRlsIdxByApt(airport));
    }*/
    @ApiOperation(httpMethod = "GET", value = "航线放行率", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFltRlsIdxByApt.json", method = RequestMethod.GET)
    public ServerResponse<FltRlsIdxAptVo> getFltRlsIdxByApt(HttpServletRequest request) {
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
        return ServerResponse.createBySuccess(flightIndexService.findFltRlsIdxByApt(queryMap));
    }

    @ApiOperation(httpMethod = "GET", value = "机场正常性", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAirportNormality.json", method = RequestMethod.GET)
    public ServerResponse findAirportNormality(HttpServletRequest request) {
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
        FltRlsIdxVo vo = flightIndexService.findFltRlsIdx(queryMap);
        //机场正常性=起飞正常率*0.3+放行正常率*0.7
        //改为机场正常性=起飞正常率*0.5+放行正常率*0.5
        BigDecimal ariNom = new BigDecimal(vo.getZCL()).multiply(new BigDecimal("0.5"))
                .add(new BigDecimal(vo.getFXL()).multiply(new BigDecimal("0.5")))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        Map<String,Object> map = new HashMap<>();
        map.put("ariNom",ariNom);
        return ServerResponse.createBySuccess(map);
    }


    @ApiOperation(httpMethod = "GET", value = "手持终端实况航班总览指标", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getFltToHandTerminal.json", method = RequestMethod.GET)
    public ServerResponse<FlightHandTerminalVo> getFltToHandTerminal(HttpServletRequest request) {
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
        int DQZY = 0;
        int DQSY = 0;
        int JJDG = 0;
        int JJCG = 0;
        int XXSZY = 0;
        for (int i = 0; i < list.size(); i++) {
            if ("1".equals(list.get(i).getStatus())){
                CQZY++;
            }
            if ("0".equals(list.get(i).getStatus())){
                JJDG++;
            }
            if ("3".equals(list.get(i).getStatus())){
                JJCG++;
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
        DQZY=YJWZY+JJWZY;
        DQSY=YJWZS+JJWZS-DQZY;
        XXSZY=DQZY+(JJDG-JJCG);
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
        fhtv.setDqzy(DQZY);
        fhtv.setDqsy(DQSY);
        fhtv.setJjdg(JJDG);
        fhtv.setJjcg(JJCG);
        fhtv.setXxszy(XXSZY);
        fhtv.setZyb(new BigDecimal(DQZY*100.00/(YJWZS+JJWZS)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        return ServerResponse.createBySuccess(fhtv);
    }

}
