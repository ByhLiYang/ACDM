package com.hq.acdm.controller.statistics.cdmTobt;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.cdmTobt.CdmTobt;
import com.hq.acdm.service.statistics.cdmTobt.CdmTobtService;
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

@Api(description = "CDM TOBT遵从度")
@RestController
@RequestMapping("/statisticalReport/cdmTobt")
@Slf4j
public class CdmTobtController {

    @Resource
    private CdmTobtService cdmTobtService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------CdmTobtController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);

        List<CdmTobt> baggageFlights = cdmTobtService.queryCdmTobt(queryMap);
        return ServerResponse.createBySuccess(baggageFlights);
    }
}
