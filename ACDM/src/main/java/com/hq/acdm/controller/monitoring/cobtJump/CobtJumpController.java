package com.hq.acdm.controller.monitoring.cobtJump;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.monitoring.cobtJump.CobtJump;
import com.hq.acdm.service.monitoring.CobtJump.CobtJumpService;
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

@Api(description = "COBT跳变")
@RestController
@RequestMapping("/flightSupervision/cobtJump")
@Slf4j
public class CobtJumpController {

    @Resource
    private CobtJumpService cobtJumpService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航班号") @RequestParam("flight_no_iata") String flight_no_iata,
                                @ApiParam("a_or_d") @RequestParam("a_or_d") String a_or_d,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------CobtJumpController-----------------");
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("flight_no_iata",flight_no_iata);
        queryMap.put("a_or_d",a_or_d);

        List<CobtJump> cobtJump = cobtJumpService.queryList(queryMap);
        return ServerResponse.createBySuccess(cobtJump);
    }
}
