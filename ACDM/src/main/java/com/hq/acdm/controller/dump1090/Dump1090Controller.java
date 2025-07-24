package com.hq.acdm.controller.dump1090;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "dump1090", tags = {"dump1090接口"})
@RestController
@RequestMapping("/dump1090")
@Slf4j
public class Dump1090Controller {
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/dataReception.json", method = RequestMethod.POST)
    public void queryDetail(@RequestBody List<Aircraft> aircraftDataList, HttpServletRequest request, HttpServletResponse response) {
        log.info("------------Dump1090Controller dataReception.json Start-----------------");

        // 打印接收到的数据条数
        log.info("Received {} aircraft data entries", aircraftDataList.size());

        // 示例：遍历并打印关键字段
        log.info("aircraftDataList: {}", JSON.toJSONString(aircraftDataList));
        log.info("------------Dump1090Controller dataReception.json End---------------");
    }



    @Data
    public static class Aircraft {
        private String hex;
        private String flight;
        private double lat;
        private double lon;
        private int altitude;
        private int track;
        private int speed;
    }
}
