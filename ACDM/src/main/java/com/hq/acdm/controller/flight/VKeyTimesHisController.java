package com.hq.acdm.controller.flight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.flight.AbnormalAlert;
import com.hq.acdm.model.flight.VKeyTimesHis;
import com.hq.acdm.service.flight.VKeyTimesHisService;
import com.hq.acdm.service.flight.impl.VKeyTimesHisServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "关键时间节点历史查询")
@RestController
@RequestMapping("/statisticalReport/nodeQueryHis")
@Slf4j
public class VKeyTimesHisController {
    @Autowired
    VKeyTimesHisService vKeyTimesHisService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始日期(YYYY-MM-DD)")@RequestParam(value="startDate", required = true) String beginDate,
                                @ApiParam("结束日期(YYYY-MM-DD)")@RequestParam(value="endDate", required = true) String endDate,
                                @ApiParam("航空公司")@RequestParam(value="airCompany", required = false) String airline,
                                @ApiParam("航班号")@RequestParam(value="flight_no_iata", required = false) String flightNoIata,
                                @ApiParam("始发站/目的站")@RequestParam(value="destination", required = false) String dest,
                                @ApiParam("进出港")@RequestParam(value="aord", required = false) String aOrD,
                                @ApiParam("航站楼")@RequestParam(value="terminal", required = false) String terminal,
                                @ApiParam("登机区域")@RequestParam(value="areaid", required = false) String areaid,
                                @ApiParam("登机口")@RequestParam(value="gate", required = false) String gate,
                                @ApiParam("航班状态(0,1)")@RequestParam(value="flightstatus", required = false) String flightstatus,
                                @ApiParam("放行状态(0,1)")@RequestParam(value="passstatus", required = false) String passstatus,
                                @ApiParam("航班延误时间(分钟)>???(分钟)")@RequestParam(value="flightdelaytime", required = false) String inDelay,
                                @ApiParam("放行延误时间(分钟)>???(分钟)")@RequestParam(value="passdelaytime", required = false) String outDelay

    ) {
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put(VKeyTimesHisServiceImpl.BEGIN_DATE,beginDate);
        queryMap.put(VKeyTimesHisServiceImpl.END_DATE,endDate);
        queryMap.put(VKeyTimesHisServiceImpl.AIRLINE,airline);
        queryMap.put(VKeyTimesHisServiceImpl.FLIGHT_NO_IATA,flightNoIata);
        queryMap.put(VKeyTimesHisServiceImpl.DEST,dest);
        queryMap.put(VKeyTimesHisServiceImpl.A_OR_D,aOrD);
        queryMap.put(VKeyTimesHisServiceImpl.TERMINAL,terminal);
        queryMap.put(VKeyTimesHisServiceImpl.AREAID,areaid);
        queryMap.put(VKeyTimesHisServiceImpl.GATE,gate);
        queryMap.put(VKeyTimesHisServiceImpl.FLIGHT_STATUS,flightstatus);
        queryMap.put(VKeyTimesHisServiceImpl.PASS_STATUS,passstatus);
        queryMap.put(VKeyTimesHisServiceImpl.IN_DELAY,inDelay);
        queryMap.put(VKeyTimesHisServiceImpl.OUT_DELAY,outDelay);
        List<VKeyTimesHis> list = vKeyTimesHisService.query(queryMap);
        return ServerResponse.createBySuccess(list);
    }
}
