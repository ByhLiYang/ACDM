package com.hq.acdm.controller.statistics.estimatedTaxiTimeAccuracy;


import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.estimatedTaxiTimeAccuracy.EstimatedTaxiTimeAccuracy;
import com.hq.acdm.service.statistics.estimatedTaxiTimeAccuracy.EstimatedTaxiTimeAccuracyService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Auther: wangshuhao
 * @Date: 2018/9/19 10:38
 * @Description:
 */
@Api(description = "滑行时间预测准确性统计")
@RestController
@RequestMapping("/statisticalReport/taxiTimeAccuracy")
@Slf4j
public class EstimatedTaxiTimeController {
    @Resource
    private EstimatedTaxiTimeAccuracyService estimatedTaxiTimeAccuracyService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                @ApiParam("机型") @RequestParam("planeModel") String plane_model,
                                @ApiParam("滑行类型") @RequestParam("taxiType") String taxi_type,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        if(airline_code_iata.equals("全部")){
            queryMap.put("airCompany","");
        }else{
            queryMap.put("airCompany",airline_code_iata);
        }
        queryMap.put("planeModel",plane_model);
        queryMap.put("taxiType",taxi_type);
        return ServerResponse.createBySuccess(estimatedTaxiTimeAccuracyService.queryEstimatedTaxiTimeAccuracyInfo(queryMap));
    }



}
