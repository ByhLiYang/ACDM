package com.hq.acdm.controller.flight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.flight.AbnormalAlert;
import com.hq.acdm.service.flight.AbnormalAlertService;
import com.hq.acdm.service.flight.impl.AbnormalAlertServiceImpl;
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

@Api(description = "登机异常监管")
@RestController
@RequestMapping("/flightSupervision/abnormalAlert")
@Slf4j
public class AbnormalAlertController {
    @Autowired
    AbnormalAlertService abnormalAlertService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("查询时间(YYYY-MM-DD)")@RequestParam(value="start_date", required = true) String date
    ) {
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put(AbnormalAlertServiceImpl.QUERY_DATE,date);
        List<AbnormalAlert> list = abnormalAlertService.query(queryMap);
        return ServerResponse.createBySuccess(list);
    }
}
