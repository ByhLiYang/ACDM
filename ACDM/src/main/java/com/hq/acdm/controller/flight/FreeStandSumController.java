package com.hq.acdm.controller.flight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.flight.FreeStandSum;
//import com.hq.acdm.model.flight.VCCTV;
import com.hq.acdm.service.flight.FreeStandSumService;
//import com.hq.acdm.service.flight.impl.Constants;
import com.hq.acdm.service.flight.impl.FreeStandSumServiceImpl;
//import com.hq.acdm.service.flight.impl.VCCTVServiceImpl;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "可使用机位")
@RestController
@RequestMapping("/resourceRegulation/freeposition")
@Slf4j
public class FreeStandSumController {

    @Autowired
    FreeStandSumService freeStandSumService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryFree.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间(YYYY-MM-DD HH24:MI:SS)")@RequestParam(value="beginDate", required = true) String beginDate,
                                @ApiParam("结束时间(YYYY-MM-DD HH24:MI:SS)")@RequestParam(value="endDate", required = true) String endDate,
                                @ApiParam("机型")@RequestParam(value="airporttype", required = false) String airporttype,
                                @ApiParam("航站楼(1,2)")@RequestParam(value="terminal", required = false) String terminal,
                                @ApiParam("是否远机位(Y,N)")@RequestParam(value="isRemote", required = false) String isRemote
    ) {
        Map<Object, Object> queryMap = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        beginDate=date +" "+beginDate;
        endDate=date +" "+endDate;
        queryMap.put(FreeStandSumServiceImpl.BEGIN_DATE,beginDate);
        queryMap.put(FreeStandSumServiceImpl.END_DATE,endDate);
        queryMap.put(FreeStandSumServiceImpl.AIRPORTTYPE,airporttype);
        queryMap.put(FreeStandSumServiceImpl.TERMINAL,terminal);
        queryMap.put(FreeStandSumServiceImpl.IS_REMOTE,isRemote);
        List<FreeStandSum> allFreeStandSum = freeStandSumService.query(queryMap);
        return ServerResponse.createBySuccess(allFreeStandSum);
    }
}
