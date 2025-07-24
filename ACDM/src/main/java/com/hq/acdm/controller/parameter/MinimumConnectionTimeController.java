package com.hq.acdm.controller.parameter;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.parameter.VMinimumConnectionTime;
import com.hq.acdm.param.sys.AclModuleParam;
import com.hq.acdm.service.parameter.MinimumConnectionTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/19 10:13
 * @Description
 */
@Api(description = "最小过站时间管理")
@RestController
@RequestMapping("/parameter/minimumConnectionTime")
public class MinimumConnectionTimeController {
    @Resource
    private MinimumConnectionTimeService minimumConnectionTimeService;

    @ApiOperation(httpMethod = "POST", value = "最小过站时间管理——查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "findMinimumConnectionTime.json", method = RequestMethod.POST)
    public ServerResponse<List<VMinimumConnectionTime>> findMinimumConnectionTime(VMinimumConnectionTime model) {
        return ServerResponse.createBySuccess(minimumConnectionTimeService.findMinimumConnectionTime());
    }
    @ApiOperation(httpMethod = "POST", value = "最小过站时间管理——新增", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "insertMinimumConnectionTime.json", method = RequestMethod.POST)
    public ServerResponse insertMinimumConnectionTime(VMinimumConnectionTime model) {
        if(null != model.getAirline() && "全部".equals(model.getAirline())){
            model.setAirline("ALL");
        }
        if(null != model.getAircrafttype() && "全部".equals(model.getAircrafttype())){
            model.setAircrafttype("ALL");
        }
        minimumConnectionTimeService.insertMinimumConnectionTime(model);
        return ServerResponse.createBySuccess();
    }
    @ApiOperation(httpMethod = "POST", value = "最小过站时间管理——更新", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "updateMinimumConnectionTime.json", method = RequestMethod.POST)
    public ServerResponse updateMinimumConnectionTime(VMinimumConnectionTime model) {
        if(null != model.getAirline() && "全部".equals(model.getAirline())){
            model.setAirline("ALL");
        }
        if(null != model.getAircrafttype() && "全部".equals(model.getAircrafttype())){
            model.setAircrafttype("ALL");
        }
        minimumConnectionTimeService.updateMinimumConnectionTime(model);
        return ServerResponse.createBySuccess();
    }
    @ApiOperation(httpMethod = "POST", value = "最小过站时间管理——删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "updateForDelete.json", method = RequestMethod.POST)
    public ServerResponse updateForDelete(VMinimumConnectionTime model) {
        if(null != model.getAirline() && "全部".equals(model.getAirline())){
            model.setAirline("ALL");
        }
        if(null != model.getAircrafttype() && "全部".equals(model.getAircrafttype())){
            model.setAircrafttype("ALL");
        }
        minimumConnectionTimeService.updateForDelete(model);
        return ServerResponse.createBySuccess();
    }
}
