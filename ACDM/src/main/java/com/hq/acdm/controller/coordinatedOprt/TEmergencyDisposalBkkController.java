package com.hq.acdm.controller.coordinatedOprt;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.coordinatedOprt.TEmergencyDisposalBkkService;
import com.hq.acdm.vo.coordinatedOprt.FlowControlInfoTMdrsVo;
import com.hq.acdm.vo.coordinatedOprt.TEmergencyDisposalBkkVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "延误处置复查查询")
@RestController
@RequestMapping("/coordinatedOprt/tEmergencyDisposalBkk")
public class TEmergencyDisposalBkkController {

    @Resource
    private TEmergencyDisposalBkkService tEmergencyDisposalBkkService;


    @ApiOperation(httpMethod = "POST", value = "查询TEmergencyDisposalBkk表数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findTEmergencyDisposalBkk.json", method = RequestMethod.POST)
    public ServerResponse findTEmergencyDisposalBkk(@RequestParam("startDate") String startDate,
                                         @RequestParam("endDate") String endDate) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        List<TEmergencyDisposalBkkVo> list = tEmergencyDisposalBkkService.findTEmergencyDisposalBkk(queryMap);
        return ServerResponse.createBySuccess(list);
    }




}
