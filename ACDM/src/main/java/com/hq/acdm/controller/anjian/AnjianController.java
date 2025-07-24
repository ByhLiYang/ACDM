package com.hq.acdm.controller.anjian;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.mysql.AreaPeopleNumber;
import com.hq.acdm.service.timer.Anjian.AnjianService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/13 0013 9:22
 */
@Api(description = "楼下安检数据库")
@RestController
@RequestMapping("/anjian")
public class AnjianController {
    @Resource
    private AnjianService anjianService;

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ServerResponse queryPic() {
        Map<String,String> list =  anjianService.queryPax_num();
        return ServerResponse.createBySuccess(list);
    }
}
