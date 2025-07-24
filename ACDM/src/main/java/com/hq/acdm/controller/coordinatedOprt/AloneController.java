package com.hq.acdm.controller.coordinatedOprt;

import com.alibaba.fastjson.JSON;
import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.coordinatedOprt.AloneService;
import com.hq.acdm.service.coordinatedOprt.FlightCutsService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.excel.JxlsBuilder;
import com.hq.acdm.vo.coordinatedOprt.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/06/12 10:25
 * @Description
 */
@Api(description = "航班削减")
@RestController
@RequestMapping("/coordinatedOprt/alone")
public class AloneController {
    @Resource
    private AloneService aloneService;

    @ApiOperation(httpMethod = "GET", value = "航班单独查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAloneFlights.json", method = RequestMethod.GET)
    public ServerResponse findAloneFlights(
                                         HttpServletRequest request, HttpServletResponse response) throws ParseException {

//        查询航班
        List<AloneVo> list = aloneService.findAloneFlights(null);

        return ServerResponse.createBySuccess(list);
    }

}
