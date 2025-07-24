package com.hq.acdm.controller.statistics.averageCrossingTime;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.averageCrossingTime.AverageCrossingTime;
import com.hq.acdm.service.statistics.averageCrossingTime.AverageCrossingTimeService;
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
 * @author wangshuhao
 * @date 2018/9/20 0020 14:40
 */

@Api(description = "平均过站时间")
@RestController
@RequestMapping("/statisticalReport/averageCrossingTime")
@Slf4j
public class AverageCrossingTimeController {

    @Resource
    private AverageCrossingTimeService averageCrossingTimeService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                @ApiParam("机型") @RequestParam("planeModel") String plane_model,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        if("全部".equals(airline_code_iata)){
            queryMap.put("airCompany","");
        }else{
            queryMap.put("airCompany",airline_code_iata);
        }
        if("全部".equals(plane_model)){
            queryMap.put("planeModel","");
        }else{
            queryMap.put("planeModel",plane_model);
        }

        List<AverageCrossingTime> averageCrossingTimes = averageCrossingTimeService.queryAverageCrossingTime(queryMap);
        return ServerResponse.createBySuccess(averageCrossingTimes);
    }
}
