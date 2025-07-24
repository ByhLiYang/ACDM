package com.hq.acdm.controller.Video;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.Video.Video;
import com.hq.acdm.model.statistics.averageCrossingTime.AverageCrossingTime;
import com.hq.acdm.service.Vedio.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 * @author wangshuhao
 * @date 2018/11/14 0014 16:53
 */
@Api(description = "视频信息")
@RestController
@RequestMapping("/video")
public class VideoController {
    @Resource
    private VideoService videoService;
    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("视频号")@RequestParam("params[videoCode]") String videoCode,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("videoCode",videoCode);

        return ServerResponse.createBySuccess(videoService.queryByCondition(queryMap));
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryVideoHistoiy.json", method = RequestMethod.POST)
    public ServerResponse queryHistoryAsAct(@ApiParam("视频号")@RequestParam("params[videoCode]") String videoCode,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("videoCode",videoCode);
        return ServerResponse.createBySuccess(videoService.queryVideoHistoiy(queryMap));
    }


    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryHistory.json", method = RequestMethod.POST)
    public ServerResponse queryHistory(@ApiParam("视频号")@RequestParam("params[videoCode]") String videoCode,
                                       @ApiParam("播放时间")@RequestParam("params[playtime]") String playtime,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("playtime",playtime);
        queryMap.put("videoCode",videoCode);

        return ServerResponse.createBySuccess(videoService.queryHistory(queryMap));
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryStand.json", method = RequestMethod.POST)
    public ServerResponse queryStand(@ApiParam("机位号")@RequestParam("params[stand]") String stand,
                                     @ApiParam("视频号")@RequestParam("params[playtime]") String playtime,
                                       HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("playtime",playtime);
        queryMap.put("STAND",stand);

        return ServerResponse.createBySuccess(videoService.queryByStand(queryMap));
    }
}
