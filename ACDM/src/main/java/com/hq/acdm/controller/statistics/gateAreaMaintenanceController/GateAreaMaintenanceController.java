package com.hq.acdm.controller.statistics.gateAreaMaintenanceController;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.averageCrossingTime.AverageCrossingTime;
import com.hq.acdm.model.statistics.gateAreaMaintenance.GateAreaMaintenance;
import com.hq.acdm.service.statistics.GateAreaMaintenance.GateAreaMaintenanceService;
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
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/9/27 0027 9:09
 */
@Api(description = "登机区域维护")
@RestController
@RequestMapping("/statisticalReport/gateAreaMaintenance")
@Slf4j
public class GateAreaMaintenanceController {
    @Resource
    private GateAreaMaintenanceService gateAreaMaintenanceService;
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("航站楼")@RequestParam("terminal") String terminal,
                                @ApiParam("登机口") @RequestParam("gate")String gate,
                                @ApiParam("描述") @RequestParam("description") String description,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("terminal",terminal);
        queryMap.put("gate",gate);
        queryMap.put("description",description);
        return ServerResponse.createBySuccess(gateAreaMaintenanceService.queryGateAreaMaintenance(queryMap));
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public ServerResponse insert(@ApiParam("航站楼")@RequestParam("terminal") String terminal,
                                @ApiParam("登机口") @RequestParam("gate")String gate,
                                @ApiParam("描述") @RequestParam("description") String description,
                                 @ApiParam("阈值") @RequestParam("passengerMax") String passengerMax,
                                 @ApiParam("登机区域") @RequestParam("gateArea") String gateArea,
                                HttpServletRequest request, HttpServletResponse response) {


            return ServerResponse.createBySuccess(gateAreaMaintenanceService.insert(terminal,gate,description,passengerMax,gateArea));
        }


    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete.json", method = RequestMethod.POST)
    public ServerResponse delete(@ApiParam("航站楼")@RequestParam("terminal") String terminal,
                                 @ApiParam("登机口") @RequestParam("gate")String gate,
                                 @ApiParam("描述") @RequestParam("description") String description,
                                 @ApiParam("阈值") @RequestParam("passengerMax") String passengerMax,
                                 @ApiParam("登机区域") @RequestParam("gateArea") String gateArea,
                                 @ApiParam("旧航站楼") @RequestParam("oldTerminal") String oldTerminal,
                                 HttpServletRequest request, HttpServletResponse response) {


            return ServerResponse.createBySuccess(gateAreaMaintenanceService.delete(terminal,gate,description,passengerMax,gateArea,oldTerminal));
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/modify.json", method = RequestMethod.POST)
    public ServerResponse modfiy(@ApiParam("航站楼")@RequestParam("terminal") String terminal,
                                 @ApiParam("登机口") @RequestParam("gate")String gate,
                                 @ApiParam("描述") @RequestParam("description") String description,
                                 @ApiParam("阈值") @RequestParam("passengerMax") String passengerMax,
                                 @ApiParam("登机区域") @RequestParam("gateArea") String gateArea,
                                 @ApiParam("旧航站楼") @RequestParam("oldTerminal") String oldTerminal,
                                 HttpServletRequest request, HttpServletResponse response) {


        return ServerResponse.createBySuccess(gateAreaMaintenanceService.modify(terminal,gate,description,passengerMax,gateArea,oldTerminal));
    }
}
