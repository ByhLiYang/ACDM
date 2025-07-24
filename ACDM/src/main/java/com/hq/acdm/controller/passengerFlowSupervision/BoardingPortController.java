package com.hq.acdm.controller.passengerFlowSupervision;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.passengerFlowSupervision.HourlyPassengerCountT2;
import com.hq.acdm.service.passengerFlowSupervision.BoardingPortService;
import com.hq.acdm.model.passengerFlowSupervision.BoardingPort;
import com.hq.acdm.service.passengerFlowSupervision.HourlyPassengerCountT2Service;
import com.hq.acdm.vo.passengerFlowSupervision.BoardingPortVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2018/10/23 16:54
 * @Description
 */
@Api(description = "登机口旅客监管")
@RestController
@RequestMapping("/passengerFlowSupervision/BoardingPort")
public class BoardingPortController {
    @Resource
    private BoardingPortService boardingPortService;
    @Resource
    private HourlyPassengerCountT2Service hourlyPassengerCountT2Service;
    @ApiOperation(httpMethod = "GET", value = "登机口旅客监管T1——查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("findGatePassengerSumT1.json")
    public ServerResponse<List<BoardingPortVo>> findGatePassengerSumT1() {
        List<BoardingPort> list = boardingPortService.findGatePassengerSumT1();
        List<BoardingPortVo> voList = new ArrayList<>();
        for (BoardingPort model : list) {
            BoardingPortVo vo = new BoardingPortVo();
            int flag = -1;
            for (int i=0; i<voList.size(); i++){
                if(model.getGate().equals(voList.get(i).getGate())){
                    flag = i;
                }
            }
            if(flag == -1){
                vo.setGate(model.getGate());
                List<String> flightNum = new ArrayList<>();
                flightNum.add(model.getFlightNum()==null?"":model.getFlightNum());
                vo.setFlightNum(flightNum);
                List<String> paxSecurityareaSum = new ArrayList<>();
                paxSecurityareaSum.add(model.getPaxSecurityareaSum()==null?"":model.getPaxSecurityareaSum());
                vo.setPaxSecurityareaSum(paxSecurityareaSum);
                List<String> cOBT = new ArrayList<>();
                cOBT.add(model.getCOBT()==null?"":model.getCOBT());
                vo.setCOBT(cOBT);
                voList.add(vo);
            }else{
                voList.get(flag).getFlightNum().add(model.getFlightNum()==null?"":model.getFlightNum());
                voList.get(flag).getPaxSecurityareaSum().add(model.getPaxSecurityareaSum()==null?"":model.getPaxSecurityareaSum());
                voList.get(flag).getCOBT().add(model.getCOBT()==null?"":model.getCOBT());
            }
        }
        return ServerResponse.createBySuccess(voList);
    }
    @ApiOperation(httpMethod = "GET", value = "登机口旅客监管T2——查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("findGatePassengerSumT2.json")
    public ServerResponse<List<BoardingPortVo>> findGatePassengerSumT2() {
        List<BoardingPort> list = boardingPortService.findGatePassengerSumT2();
        List<BoardingPortVo> voList = new ArrayList<>();
        for (BoardingPort model : list) {
            BoardingPortVo vo = new BoardingPortVo();
            int flag = -1;
            for (int i=0; i<voList.size(); i++){
                if(model.getGate().equals(voList.get(i).getGate())){
                    flag = i;
                }
            }
            if(flag == -1){
                vo.setGate(model.getGate());
                List<String> flightNum = new ArrayList<>();
                flightNum.add(model.getFlightNum()==null?"":model.getFlightNum());
                vo.setFlightNum(flightNum);
                List<String> paxSecurityareaSum = new ArrayList<>();
                paxSecurityareaSum.add(model.getPaxSecurityareaSum()==null?"":model.getPaxSecurityareaSum());
                vo.setPaxSecurityareaSum(paxSecurityareaSum);
                List<String> cOBT = new ArrayList<>();
                cOBT.add(model.getCOBT()==null?"":model.getCOBT());
                vo.setCOBT(cOBT);
                voList.add(vo);
            }else{
                voList.get(flag).getFlightNum().add(model.getFlightNum()==null?"":model.getFlightNum());
                voList.get(flag).getPaxSecurityareaSum().add(model.getPaxSecurityareaSum()==null?"":model.getPaxSecurityareaSum());
                voList.get(flag).getCOBT().add(model.getCOBT()==null?"":model.getCOBT());
            }
        }
        return ServerResponse.createBySuccess(voList);
    }

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/pic.json", method = RequestMethod.GET)
    public ServerResponse queryPic() {
        List<HourlyPassengerCountT2> list = hourlyPassengerCountT2Service.queryTerminal2();
        Map<String,Object> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list1.add(list.get(i).getCount_checked_in());
            list2.add(list.get(i).getCount_insecurityzone());
            list3.add(list.get(i).getCount_onflights());
        }
        map.put("list1",list1);
        map.put("list2",list2);
        map.put("list3",list3);
        return ServerResponse.createBySuccess(map);
    }
}
