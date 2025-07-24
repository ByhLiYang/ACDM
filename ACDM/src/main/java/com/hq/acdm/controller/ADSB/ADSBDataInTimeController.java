package com.hq.acdm.controller.ADSB;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.ADSB.ADSBModel;
import com.hq.acdm.service.ADSB.ADSBService;
import com.hq.acdm.service.flight.DailyFlightMasterService;
import com.hq.acdm.service.flight.VStartFlightLvService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author wangshuhao
 * @date 2018/11/20 0020 12:52
 */
@Api(description = "ADSB及时数据")
@RestController
@RequestMapping("/adsb")
@Slf4j
public class ADSBDataInTimeController {
    @Resource
    private ADSBService adsbService;

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.GET)
    public ServerResponse findAllADSB() {
        List<ADSBModel> list = adsbService.query5minutesData();
        Set<String> set = new TreeSet<>();
        String id = "";
        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> resultList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<List<Double>> listList = new ArrayList<>();
            if("".equals(list.get(i).getRE())||  list.get(i).getRE()==null ){
             continue;
            }
            if("".equals(list.get(i).getFN())||  list.get(i).getFN()==null ){
                continue;
            }
            if("".equals(list.get(i).getOA())||  list.get(i).getOA()==null ){
                continue;
            }
            if("".equals(list.get(i).getDA())||  list.get(i).getDA()==null ){
                continue;
            }
            if("----".equals(list.get(i).getFN())){
                id = list.get(i).getRE().trim()+"|"+list.get(i).getOA().trim()+"|"+list.get(i).getDA().trim()+"|"+list.get(i).getCO();
            }else{
                id = list.get(i).getFN().trim()+"|"+list.get(i).getOA().trim()+"|"+list.get(i).getDA().trim()+"|"+list.get(i).getCO();
            }
            try{
                if(set.contains(id)){
                    List<Double> oneList = new ArrayList<>();
                    oneList.add(Double.parseDouble(list.get(i).getLO().trim()));
                    oneList.add(Double.parseDouble(list.get(i).getLA().trim()));
                    listList = (List<List<Double>>) map.get(id);
                    listList.add(oneList);
                    map.put(id,listList);
                }else{
                    set.add(id);
                    List<Double> oneList = new ArrayList<>();
                    oneList.add(Double.parseDouble(list.get(i).getLO().trim()));
                    oneList.add(Double.parseDouble(list.get(i).getLA().trim()));
                    listList.add(oneList);
                    map.put(id,listList);
                }
            }catch (Exception e){
                System.out.println(i);
                System.out.println(list.get(i).getLA());
                System.out.println(list.get(i).getLO());
                System.out.println(list.get(i).getFN());
                System.out.println(e.toString());
            }
        }
        for(Map.Entry<String,Object> entry:map.entrySet()){
            String[] strings = entry.getKey().split("\\|");
            Map<String,Object> map1 = new HashMap<>();
            map1.put("FlightNumber",strings[0].trim());
            map1.put("start",strings[1].trim());
            map1.put("end",strings[2].trim());
            map1.put("co",strings[3].trim());
            map1.put("dian",entry.getValue());
            resultList.add(map1);
        }
        System.out.println(resultList);
        return ServerResponse.createBySuccess(resultList);
    }

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/search.json", method = RequestMethod.GET)
    public ServerResponse findDirection(@ApiParam("航班号") @RequestParam("fn") String fn,
                                        HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<>();
        map.put("fn",fn);
        return ServerResponse.createBySuccess(adsbService.queryOneAdsb(map));
    }
}
