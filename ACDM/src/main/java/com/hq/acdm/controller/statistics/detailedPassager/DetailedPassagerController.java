package com.hq.acdm.controller.statistics.detailedPassager;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.detainedPassage.DetainedPassage;
import com.hq.acdm.service.statistics.detainedPassage.DetainedPassageService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:40
 */

@Api(description = "滞留旅客状态查询")
@RestController
@RequestMapping("/passengerFlowSupervision/passengerStuck")
@Slf4j
public class DetailedPassagerController {

    @Resource
    private DetainedPassageService detainedPassageService;
   //滞留旅客
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(//@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                               // @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                @ApiParam("航站楼") @RequestParam("terminal") String terminal,
                                @ApiParam("登机区域") @RequestParam("areaid") String areaid,
                                @ApiParam("登机口") @RequestParam("gate") String gate,
                                @ApiParam("延误时间") @RequestParam("delaytime") String delaytime,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------DetailedPassagerController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
       // queryMap.put("startDate",startDate);
     //  queryMap.put("endDate",endDate);
        queryMap.put("terminal",terminal);
        queryMap.put("areaid",areaid);
        queryMap.put("gate",gate);
        queryMap.put("delaytime",delaytime);
        queryMap.put("airCompany",airCompany);

        List<DetainedPassage> detainedPassage = detainedPassageService.queryDetainedPassage(queryMap);
        return ServerResponse.createBySuccess(detainedPassage);
    }
    //登机异常
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryAnomaly.json", method = RequestMethod.POST)
    public ServerResponse queryAnomaly(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------DetailedPassagerController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);

        List<DetainedPassage> detainedPassage = detainedPassageService.queryDetainedPassage(queryMap);
        return ServerResponse.createBySuccess(detainedPassage);
    }
}
