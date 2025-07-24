package com.hq.acdm.controller.flight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.flight.DailyFlightMasterService;
import com.hq.acdm.service.flight.VStartFlightLvService;
import com.hq.acdm.vo.flight.VStartFlightLvVo;
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
 * @Auther: pengzhanghua
 * @Date: 2018/9/18 10:38
 * @Description: parkerW修改
 */
@Api(description = "自身始发航班正常率")
@RestController
@RequestMapping("/statisticalReport/itselfOriginatingNormalRate")
@Slf4j
public class FlightStartController {

    @Resource
    private DailyFlightMasterService dailyFlightMasterService;

    @Resource
    private VStartFlightLvService vsStartFlightLvService;
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/airCompany.json", method = RequestMethod.GET)
    public ServerResponse findAllCompany() {
        List<String> allCompany = dailyFlightMasterService.getAllCompany();
        return ServerResponse.createBySuccess(allCompany);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airCompany,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        if("全部".equals(airCompany)){
            queryMap.put("airCompany","");
        }else{
            queryMap.put("airCompany",airCompany);
        }
        List<VStartFlightLvVo> vStartFlightLvVos = vsStartFlightLvService.checkFightRegularity(queryMap);
        return ServerResponse.createBySuccess(vStartFlightLvVos);
    }
}
