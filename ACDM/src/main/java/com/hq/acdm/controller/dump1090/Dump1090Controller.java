package com.hq.acdm.controller.dump1090;

import com.hq.acdm.controller.req.AircraftSaveReq;
import com.hq.acdm.service.dump1090.Dump1090Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "dump1090", tags = {"dump1090接口"})
@RestController
@RequestMapping("/dump1090")
@Slf4j
public class Dump1090Controller {
    @Resource
    private Dump1090Service dump1090Service;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/dataReception.json", method = RequestMethod.POST)
    public void dataReception(@RequestBody List<AircraftSaveReq> aircraftDataList, HttpServletRequest request, HttpServletResponse response) {
        dump1090Service.dataReception(aircraftDataList);
    }
}
