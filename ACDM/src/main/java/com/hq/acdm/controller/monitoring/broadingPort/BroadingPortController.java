package com.hq.acdm.controller.monitoring.broadingPort;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.broadingPort.BroadingPortDetail;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.monitoring.broadingPort.BroadingPortService;
import com.hq.acdm.service.realtimeSituation.FlightIndexService;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.realtimeSituation.FlightIndexVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:40
 */

@Api(description = "登机口使用明细表")
@RestController
@RequestMapping("/resourceRegulation/broadingPort")
@Slf4j
public class BroadingPortController {

    @Resource
    private BroadingPortService broadingPortService;
    @Resource
    private FlightIndexService flightIndexService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryDetail.json", method = RequestMethod.POST)
    public ServerResponse queryDetail(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                @ApiParam("登机口") @RequestParam("gate") String gate,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------BroadingPortController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);
        queryMap.put("gate",gate);

        List<BroadingPortDetail> broadingPortDetail = broadingPortService.queryDetail(queryMap);
        return ServerResponse.createBySuccess(broadingPortDetail);
    }


    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/querySummary.json", method = RequestMethod.POST)
    public ServerResponse querySummary(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------BroadingPortController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);

        List<BroadingPortDetail> broadingPortDetail = broadingPortService.querySummary(queryMap);
        return ServerResponse.createBySuccess(broadingPortDetail);
    }
    @ApiOperation(httpMethod = "POST", value = "查询靠桥率", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryBridgeRate.json", method = RequestMethod.POST)
    public ServerResponse queryBridgeRate(@ApiParam("开始时间")@RequestParam("planDate") String planDate,
                                       HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------BroadingPortController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("planDate",planDate);
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
        FlightIndexVo vo = flightIndexService.findFlightIndex(queryMap);
        //BroadingPortDetail str = broadingPortService.queryBridgeRate(queryMap);
        BroadingPortDetail str = new BroadingPortDetail();
        str.setBridge_rate(vo.getKQL()+"");
        return ServerResponse.createBySuccess(str);
    }
}
