package com.hq.acdm.controller.coordinatedOprt;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.coordinatedOprt.FlowControlInformationService;
import com.hq.acdm.vo.coordinatedOprt.FlowControlInfoTControlInfoVo;
import com.hq.acdm.vo.coordinatedOprt.FlowControlInfoTMdrsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "流控信息查询")
@RestController
@RequestMapping("/coordinatedOprt/flowControlInformation")
public class FlowControlInformationController {

    @Resource
    private FlowControlInformationService flowControlInformationService;


    @ApiOperation(httpMethod = "POST", value = "流控信息查询TMdrs表数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFlowControlInfoTMdrs.json", method = RequestMethod.POST)
    public ServerResponse findFlowControlInfoTMdrs(@RequestParam("startDate") String startDate,
                                         @RequestParam("endDate") String endDate) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        List<FlowControlInfoTMdrsVo> list = flowControlInformationService.findFlowControlInfoTMdrs(queryMap);
        return ServerResponse.createBySuccess(list);
    }


    @ApiOperation(httpMethod = "POST", value = "流控信息查询TControlInfo表数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFlowControlInfoTControlInfo.json", method = RequestMethod.POST)
    public ServerResponse findFlowControlInfoTControlInfo(@RequestParam("startDate") String startDate,
                                                   @RequestParam("endDate") String endDate,
                                                    @RequestParam("isava") String isava) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("isava",isava);
        if(!"1".equals(isava)&&!"0".equals(isava)){
            queryMap.put("isava",null);
        }

        List<FlowControlInfoTControlInfoVo> list = flowControlInformationService.findFlowControlInfoTControlInfo(queryMap);
        return ServerResponse.createBySuccess(list);
    }

}
