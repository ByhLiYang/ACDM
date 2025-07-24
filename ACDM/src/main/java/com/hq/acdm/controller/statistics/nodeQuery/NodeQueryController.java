package com.hq.acdm.controller.statistics.nodeQuery;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.aosssysdic.Aosssysdic;
import com.hq.acdm.model.statistics.nodeQuery.NodeQuery;
import com.hq.acdm.model.statistics.nodeQuery.NodeDetail;
import com.hq.acdm.service.statistics.aosssysdic.AosssysdicService;
import com.hq.acdm.service.statistics.nodeQuery.NodeQueryService;
import com.hq.acdm.model.statistics.gateAreaMaintenance.GateAreaMaintenance;
import com.hq.acdm.service.statistics.GateAreaMaintenance.GateAreaMaintenanceService;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author tonychen
 * @date 2018/10/22 0020 14:40
 */

@Api(description = "关键节点查询")
@RestController
@RequestMapping("/statisticalReport/nodeQuery")
@Slf4j
public class NodeQueryController {

    @Resource
    private NodeQueryService nodeQueryService;
    @Resource
    private AosssysdicService aosssysdicService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("未执行") @RequestParam("execution")String execution,
                                @ApiParam("航空公司") @RequestParam("airCompany") String airline_code_iata,
                                @ApiParam("始发站/目的站") @RequestParam("destination") String destination,
                               @ApiParam("航班号") @RequestParam("flight_no_iata") String flight_no_iata,
                                @ApiParam("航站楼") @RequestParam("terminal") String terminal,
                                @ApiParam("登机区域") @RequestParam("areaid") String areaid,
                                @ApiParam("登机口") @RequestParam("gate") String gate,
                                @ApiParam("航班状态") @RequestParam("flightstatus") String flightstatus,
                                @ApiParam("放行状态") @RequestParam("passstatus") String passstatus,
                                @ApiParam("放行延误时间") @RequestParam("passdelaytime") String passdelaytime,
                                @ApiParam("航班延误时间") @RequestParam("flightdelaytime") String flightdelaytime,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------NodeQueryController-----------------");
        Map<String, Object> queryMap = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 1);
        String date2 = dateFormat.format( c.getTime());//临界22点后需要加1天

        //  String str[]=request.getParameterValues("flight_no_iata");
        String flight_no_iata2="";

        if(flight_no_iata.length()>0)flight_no_iata=flight_no_iata.substring(0,flight_no_iata.length()-1);

        List<Aosssysdic> aosssysdiclist = aosssysdicService.selectDefinedParawvalue("EW","","","");
        Map <String,String>map=new LinkedHashMap<>();
        Iterator it = aosssysdiclist.iterator();
        while(it.hasNext()){
            Aosssysdic dict=(Aosssysdic)it.next();
            map.put(dict.getPARAMCODE(),dict.getPARAMVALUE());
        }
        System.out.println("----------aosssysdiclist----------:"+map);
        String startHour=startDate.substring(0,startDate.indexOf(":"));
        String endHour=endDate.substring(0,endDate.indexOf(":"));
        if (startHour.length()==1)startHour="0"+startHour;
        if (endHour.length()==1)endHour="0"+startHour;
        startDate=date +" "+startDate+":00";

        if(Integer.parseInt(startHour)>Integer.parseInt(endHour))//+1天
            endDate=date2 +" "+endDate+":00";
        else
            endDate=date +" "+endDate+":00";

        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("airCompany",airline_code_iata);
        java.util.List<String> col =new ArrayList();
        if(flight_no_iata!=null&&flight_no_iata.indexOf(",")==-1) {
            queryMap.put("flight_no_iata", flight_no_iata);
            queryMap.put("flight_no_iata2", "");
        }else{//多选
            queryMap.put("flight_no_iata", "");
            queryMap.put("flight_no_iata2", flight_no_iata);
            String str[]=flight_no_iata.split(",");
            for(int i=0;i<str.length;i++){
                 col.add(str[i]);
            }
            queryMap.put("list", col);
        }
        queryMap.put("terminal",terminal);
        queryMap.put("areaid",areaid);
        queryMap.put("gate",gate);
        queryMap.put("destination",destination);
        queryMap.put("flightstatus",flightstatus);
        queryMap.put("execution",execution);
        queryMap.put("passstatus",passstatus);
        queryMap.put("passdelaytime",passdelaytime);
        queryMap.put("flightdelaytime",flightdelaytime);
        System.out.println("condition-------------:"+queryMap);

        List<NodeQuery> baggageFlights = nodeQueryService.queryList(queryMap);
        return ServerResponse.createBySuccess(baggageFlights);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryDetailA.json", method = RequestMethod.POST)
    public ServerResponse queryDetailA(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                @ApiParam("航空公司") @RequestParam("flight_no_iata") String flight_no_iata,
                                 @ApiParam("日期") @RequestParam("OPERATIONAL_DATE") String OPERATIONAL_DATE,
                                HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------NodeQueryController queryDetailA-----------------:"+flight_no_iata+"-"+OPERATIONAL_DATE);
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("flight_no_iata",flight_no_iata);
        queryMap.put("OPERATIONAL_DATE",OPERATIONAL_DATE);
        System.out.println("conditionA-------------:"+queryMap);
        NodeDetail nodeDetail = nodeQueryService.queryDetailA(queryMap);
        System.out.println(nodeDetail);
        return ServerResponse.createBySuccess(nodeDetail);
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryDetailD.json", method = RequestMethod.POST)
    public ServerResponse queryDetailD(@ApiParam("开始时间")@RequestParam("startDate") String startDate,
                                       @ApiParam("结束时间") @RequestParam("endDate")String endDate,
                                       @ApiParam("航空公司") @RequestParam("flight_no_iata") String flight_no_iata,
                                       @ApiParam("日期") @RequestParam("OPERATIONAL_DATE") String OPERATIONAL_DATE,
                                       HttpServletRequest request, HttpServletResponse response) {
        System.out.println("------------NodeQueryController queryDetailD-----------------:"+flight_no_iata+"-"+OPERATIONAL_DATE);
        Map<Object, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("flight_no_iata",flight_no_iata);
        queryMap.put("OPERATIONAL_DATE",OPERATIONAL_DATE);
        System.out.println("conditionD-------------:"+queryMap);

        NodeDetail nodeDetail = nodeQueryService.queryDetailD(queryMap);
        System.out.println(nodeDetail);
        return ServerResponse.createBySuccess(nodeDetail);
    }

    @Resource
    private GateAreaMaintenanceService gateAreaMaintenanceService;
    @ApiOperation(httpMethod = "GET", value = "查询登机区域", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryArea.json", method = RequestMethod.GET)
    public ServerResponse findAllCompany() {
        List<GateAreaMaintenance> allCompany = gateAreaMaintenanceService.queryArea();
        return ServerResponse.createBySuccess(allCompany);
    }

    @Resource
    private GateAreaMaintenanceService gateAreaMaintenanceService2;
    @ApiOperation(httpMethod = "GET", value = "查询登机口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryGate.json", method = RequestMethod.GET)
    public ServerResponse findGate(//@ApiParam("航站楼")@RequestParam("terminal") String terminal
    ) {
        List<GateAreaMaintenance>    gateList = gateAreaMaintenanceService2.queryGate("");
        return ServerResponse.createBySuccess(gateList);
    }

}
