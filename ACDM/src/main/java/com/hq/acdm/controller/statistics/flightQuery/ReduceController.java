package com.hq.acdm.controller.statistics.flightQuery;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.flightQuery.ReduceModel;
import com.hq.acdm.service.statistics.flightQuery.ReduceService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/26 0026 17:12
 */
@Api(description = "削减")
@RestController
@RequestMapping("/statisticalReport/reduce")
@Slf4j
public class ReduceController {
    @Resource
    private ReduceService reduceService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    public ServerResponse findDirection(@ApiParam("进出港") @RequestParam("a_or_d") String a_or_d,
                                        @ApiParam("航班号") @RequestParam("flight_no_iata") String flight_no_iata,
                                        @ApiParam("日期") @RequestParam("operational_date") String operational_date,
                                        @ApiParam("始发站") @RequestParam("oa") String oa,
                                        @ApiParam("目的地") @RequestParam("da") String da,
                                        @ApiParam("用户") @RequestParam("user") String user,
                                        HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<>();
        map.put("a_or_d",a_or_d);
        map.put("flight_no_iata",flight_no_iata);
        map.put("operational_date",operational_date);
        map.put("oa",oa);
        map.put("da",da);
        map.put("user",user);
        List<ReduceModel> list = reduceService.queryReduce(map);
        int result = 0;
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                Map<String,Object> map1 = new HashMap<>();
                map1.put("operational_date",list.get(i).getOPERATIONAL_DATE());
                map1.put("flight_no_iata",list.get(i).getFLIGHT_NO_IATA());
                map1.put("a_or_d",list.get(i).getA_OR_D());
                String temp = list.get(i).getOPERATIONAL_FLAG();
                if("1".equals(temp)){
                    map1.put("flag","0");
                }else{
                    map1.put("flag","1");
                }
                result = reduceService.updateReduce(map1)+result;
            }
        }else{
            result =  reduceService.insertIntoReduce(map) +result;
        }
        return ServerResponse.createBySuccess(result);
    }
}

