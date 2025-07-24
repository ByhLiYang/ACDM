package com.hq.acdm.controller.flight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.flight.VCCTV;
import com.hq.acdm.model.flight.VCCTVPopup;
import com.hq.acdm.service.flight.VCCTVPopupService;
import com.hq.acdm.service.flight.VCCTVService;
//import com.hq.acdm.service.flight.impl.Constants;
import com.hq.acdm.service.flight.impl.VCCTVPopupServiceImpl;
import com.hq.acdm.service.flight.impl.VCCTVServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "航班到港离港监管")
@RestController
@RequestMapping("/flightSupervision/vcctv")
@Slf4j
public class VCCTVController {

    @Autowired
    VCCTVService vcctvService;

    @Autowired
    VCCTVPopupService vcctvPopupService;
//    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(value = "/vcctv.json", method = RequestMethod.GET)
//    public ServerResponse findAllVCCTV() {
//        List<VCCTV> allCCTV = vcctvService.query(new HashMap());
//        return ServerResponse.createBySuccess(allCCTV);
//    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/vcctv.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("航班号")@RequestParam(value="matchedFno", required = false) String matchedFno,
                                @ApiParam("机位号")@RequestParam(value="stand", required = false) String stand,
                                @ApiParam("机位类型")@RequestParam(value="isRemote", required = false) String isRemote,
                                @ApiParam("AGS")@RequestParam(value="ags", required = false) String ags,
                                @ApiParam("操作类型")@RequestParam(value="milestoneId", required = false) String milestoneId,
                                @ApiParam("是否需要手工确认")@RequestParam(value="matchedYn", required = false) String matchedYn,
                                @ApiParam("是否已手工确认")@RequestParam(value="confirmYn", required = false) String confirmYn,
                                @ApiParam("日期")@RequestParam(value="mileDate", required = false) String mileDate,
                                @ApiParam("开始时间")@RequestParam(value="mileDateTimeStart", required = false) String mileDateTimeStart,
                                @ApiParam("结束时间")@RequestParam(value="mileDateTimeEnd", required = false) String mileDateTimeEnd
                                ) {
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("matchedFno",matchedFno);
        queryMap.put("stand",stand);
        queryMap.put("isRemote",isRemote);
        queryMap.put("ags",ags);
        queryMap.put("milestoneId",milestoneId);
        queryMap.put("matchedYn",matchedYn);
        queryMap.put("confirmYn",confirmYn);
        queryMap.put("mileDate",mileDate);
        queryMap.put("mileDateTimeStart",mileDateTimeStart);
        queryMap.put("mileDateTimeEnd",mileDateTimeEnd);

        List<VCCTV> allCCTV = vcctvService.queryList(queryMap);
        return ServerResponse.createBySuccess(allCCTV);
    }


    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/vcctvPopup.json", method = RequestMethod.POST)
    public ServerResponse queryPopup(
                                @ApiParam("机位号")@RequestParam(value="stand", required = true) String stand,
                                @ApiParam("操作类型")@RequestParam(value="milestoneId", required = true) String milestoneId,
                                @ApiParam("时间")@RequestParam(value="operationalDate", required = true) String operationalDate

    ) {
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put(VCCTVPopupServiceImpl.STAND,stand);
        queryMap.put(VCCTVPopupServiceImpl.A_OR_D,milestoneId);
        queryMap.put(VCCTVPopupServiceImpl.OPERATIONAL_DATE,operationalDate);

        List<VCCTVPopup> allCCTV = vcctvPopupService.query(queryMap);
        return ServerResponse.createBySuccess(allCCTV);
    }
}
