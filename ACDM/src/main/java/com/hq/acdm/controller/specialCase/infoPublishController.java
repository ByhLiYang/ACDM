package com.hq.acdm.controller.specialCase;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.specialCase.infoPublish.infoPublish;
import com.hq.acdm.model.specialCase.infoPublish.infoPublishResult;
import com.hq.acdm.service.specialCase.infoPublish.InfoPublishService;
import com.hq.acdm.vo.flight.VStartFlightLvVo;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/23 0023 13:40
 */
@Api(description = "重要信息发布")
@RestController
@RequestMapping("/specialCase/infoPublish")
@Slf4j
public class infoPublishController {
    @Resource
    private InfoPublishService infoPublishService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("关键字")@RequestParam("keyword") String keyword,
                                @ApiParam("有效日期")@RequestParam("effective_date") String effective_date,
                                @ApiParam("截止日期")@RequestParam("expire_date") String expire_date,
                                HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("keyword",keyword);
        queryMap.put("effective_date",effective_date);
        queryMap.put("expire_date",expire_date);
        List<infoPublishResult> list = infoPublishService.queryInfoPublish(queryMap);
        return ServerResponse.createBySuccess(list);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    public ServerResponse add(
                              @ApiParam("创建者")@RequestParam("create_person") String create_person,
                              @ApiParam("有效日期")@RequestParam("effective_date") String effective_date,
                              @ApiParam("截止日期")@RequestParam("expire_date") String expire_date,
                              @ApiParam("内容")@RequestParam("content") String content,
                                HttpServletRequest request, HttpServletResponse response) {
        infoPublish infoPublish = new infoPublish();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date effectiveDate = new Date();
        Date expireDate = new Date();
        try {
            effectiveDate = simpleDateFormat.parse(effective_date);
            expireDate = simpleDateFormat.parse(expire_date);
        }catch (Exception e){
            System.out.println("转换日期格式出错");
        }
        infoPublish.setCONTENT(content);
        infoPublish.setCREATE_PERSON(create_person);
        infoPublish.setEFFECTIVE_DATE(effectiveDate);
        infoPublish.setEXPIRE_DATE(expireDate);
        int number = 0;
        try {
            number  = infoPublishService.addInfoPublish(infoPublish);
        }catch (Exception e){
            System.out.println("插入语句报错");
        }

        return ServerResponse.createBySuccess(number);
    }
}
