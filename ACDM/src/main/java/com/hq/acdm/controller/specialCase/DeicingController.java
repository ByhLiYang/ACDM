package com.hq.acdm.controller.specialCase;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.specialCase.deicing.deicingModel;
import com.hq.acdm.model.specialCase.deicing.stand;
import com.hq.acdm.model.statistics.flightQuery.SelectModel;
import com.hq.acdm.service.specialCase.deicing.DeicingService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/2 0002 10:11
 */
@Api(description = "航班查询")
@RestController
@RequestMapping("/specialCase/deicingQuery")
@Slf4j
public class DeicingController {
    @Resource
    private DeicingService deicingService;
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse queryDeicing(@ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                        @ApiParam("航班号") @RequestParam("flightNum") String flightNum,
                                        @ApiParam("航站楼") @RequestParam("terminal") String terminal,
                                        @ApiParam("航班起始时间") @RequestParam("start") String start,
                                        @ApiParam("航班结束时间") @RequestParam("end") String end,
                                        @ApiParam("是否除冰") @RequestParam("deicingORnot") String deicingORnot,
                                        @ApiParam("除冰类型") @RequestParam("deicingType") String deicingType,
                                        @ApiParam("除冰位") @RequestParam("deicingPart") String deicingPart,
                                        @ApiParam("除冰开始时间") @RequestParam("deicingStart") String deicingStart,
                                        @ApiParam("除冰结束时间") @RequestParam("deicingEnd") String deicingEnd,
                                        HttpServletRequest request, HttpServletResponse response) {
        List<deicingModel> resultList = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("airCompany",airCompany);
        map.put("flightNum",flightNum);
        map.put("terminal",terminal);
        map.put("start",start);
        map.put("end",end);
        map.put("deicingORnot",deicingORnot);
        map.put("deicingType",deicingType);
        map.put("deicingPart",deicingPart);
        map.put("deicingStart",deicingStart);
        map.put("deicingEnd",deicingEnd);
        resultList = deicingService.selectByPk(map);
        return ServerResponse.createBySuccess(resultList);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/stand.json", method = RequestMethod.POST)
    public ServerResponse queryStand(@ApiParam("除冰类型") @RequestParam("deicingType") String deicingType,
                                         HttpServletRequest request, HttpServletResponse response) {
        List<stand> allStand = new ArrayList<>();
        if("全部".equals(deicingType)||"".equals(deicingType)||deicingType==null){
            allStand = deicingService.queryStand();
            allStand.add(new stand("南区"));
            allStand.add(new stand("北区"));
        }else if("定点除冰".equals(deicingType)){
            allStand = deicingService.queryStand();
        }else if("集中除冰".equals(deicingType)){
            allStand.add(new stand("南区"));
            allStand.add(new stand("北区"));
        }

        return ServerResponse.createBySuccess(allStand);

    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public ServerResponse updateDeicing(
            @ApiParam("是否除冰") @RequestParam("deicingORnot") String deicingORnot,
            @ApiParam("除冰类型") @RequestParam("deicingType") String deicingType,
            @ApiParam("除冰位") @RequestParam("deicingPart") String deicingPart,
            @ApiParam("除冰开始时间") @RequestParam("deicingStart") String deicingStart,
            @ApiParam("除冰结束时间") @RequestParam("deicingEnd") String deicingEnd,
            @ApiParam("进出港") @RequestParam("a_or_d") String a_or_d,
            @ApiParam("") @RequestParam("FLIGHT_REPEAT_COUNT") String FLIGHT_REPEAT_COUNT,
            @ApiParam("操作时间") @RequestParam("operational_date") String operational_date,
            @ApiParam("航班号") @RequestParam("FLIGHT_NO_IATA") String FLIGHT_NO_IATA,
                                         HttpServletRequest request, HttpServletResponse response) throws ParseException {


        return ServerResponse.createBySuccess(deicingService.update(deicingORnot,deicingType,deicingPart,deicingStart,deicingEnd,a_or_d,FLIGHT_REPEAT_COUNT,operational_date,FLIGHT_NO_IATA));

    }
}
