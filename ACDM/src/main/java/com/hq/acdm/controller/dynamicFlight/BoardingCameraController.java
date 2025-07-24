package com.hq.acdm.controller.dynamicFlight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.dynamicFlight.BoardingCameraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
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
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "登机口摄像机查询")
@RestController
@RequestMapping("/dynamicFlight/boardingCamera")
public class BoardingCameraController {

    @Resource
    private BoardingCameraService boardingCameraService;

    @ApiOperation(httpMethod = "POST", value = "获取摄像机ID号", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeviceNameInfo.json", method = RequestMethod.POST)
    public ServerResponse findDeviceNameInfo(@ApiParam(" 登机口")
                         @RequestParam("boardingPost") String boardingPost,
                         HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("boardingPost",boardingPost);
        List<String> flightInfoList = boardingCameraService.findDeviceNameInfo(queryMap);
        return ServerResponse.createBySuccess(flightInfoList);
    }



}
