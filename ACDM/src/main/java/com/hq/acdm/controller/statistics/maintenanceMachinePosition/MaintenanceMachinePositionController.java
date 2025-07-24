package com.hq.acdm.controller.statistics.maintenanceMachinePosition;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.maintenanceMachinePosition.CameraStand;
import com.hq.acdm.model.statistics.maintenanceMachinePosition.StandAdd;
import com.hq.acdm.service.statistics.maintenanceMachinePosition.MaintenanceMachinePositionService;
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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 机位状态维护 控制类
 */

@Api(description = "机位状态维护")
@RestController
@RequestMapping("/statisticalReport/maintenanceMachinePosition") //前台访问地址
@Slf4j
public class MaintenanceMachinePositionController {

    @Resource
    private MaintenanceMachinePositionService maintenanceMachinePositionService;

    //取得机位列表
    @ApiOperation(httpMethod = "GET", value = "取得机位列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/SMMStandList.json", method = RequestMethod.GET)
    public ServerResponse querySMMStandList() {

        List<Map> resultMap=new ArrayList<Map>();
        try {
            List<String> maintenanceMachinePositionList= maintenanceMachinePositionService.getSMMStandList();
            for(String str:maintenanceMachinePositionList){
                Map<String,Object> map=new HashMap<>();
                map.put("RS_STAND",str);//机位号
                resultMap.add(map);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByOtherError("取得机位列表异常:"+e.getMessage());
        }

        return ServerResponse.createBySuccess(resultMap);
    }

    //取得机位所有记录
    @ApiOperation(httpMethod = "POST", value = "取得机位所有记录", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/SMMAllRecord.json", method = RequestMethod.POST)
    public ServerResponse querySMMAllRecord(@ApiParam("机位号")@RequestParam(value="standno",required = false) String standno,
                                            @ApiParam("航站楼") @RequestParam(value="terminal",required = false)String terminal) {

        List<Map> resultMap=new ArrayList<Map>();//查询返回的结果集
        try {
            Map<String, String> queryMap = new HashMap<>();//查询条件
            queryMap.put("standno",standno);
            queryMap.put("terminal",terminal);
            List<CameraStand> cameraStandList= maintenanceMachinePositionService.getSMMAllRecord(queryMap);
            String m_tmp;
            for(CameraStand cameraStand:cameraStandList){
                Map<String,Object> map=new HashMap<>();
                map.put("RS_STAND",cameraStand.getSTAND());//机位号
                map.put("RS_TERMINAL",cameraStand.getTERMINAL()); // 航站楼
                // 机位类型
                switch (Integer.parseInt(cameraStand.getTYPE())) {
                    case 0: map.put("RS_TYPE", "基础机位"); break;
                    case 1: map.put("RS_TYPE", "临时机位"); break;
                    case 2: map.put("RS_TYPE", "除冰机位"); break;
                    case 3: map.put("RS_TYPE", "反恐机位"); break;
                    case 4: map.put("RS_TYPE", "试车机位"); break;
                    default:
                }
                // 维护开始时间
                m_tmp = cameraStand.getSTATUS_START();
                if(m_tmp == null || "".equals(m_tmp)) {
                    m_tmp = "无";
                }
                map.put("RS_BEGTIME", m_tmp.substring(0,19));


                // 维护结束时间
                m_tmp = cameraStand.getSTATUS_END();
                if(m_tmp == null || "".equals(m_tmp)) {
                    m_tmp = "无";
                }
                map.put("RS_ENDTIME", m_tmp.substring(0,19));


                // 维护原因
                m_tmp = cameraStand.getSTATUS_REASON();
                if(m_tmp == null || "".equals(m_tmp)) {
                    m_tmp = "无";
                }
                map.put("RS_REASON", m_tmp);


                resultMap.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByOtherError("取得机位所有记录异常:"+e.getMessage());
        }

        return ServerResponse.createBySuccess(resultMap);
    }


    @ApiOperation(httpMethod = "POST", value = "新增机位", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addStand.json", method = RequestMethod.POST)
    public ServerResponse addStand(StandAdd standAdd) {
        try{
            maintenanceMachinePositionService.addStand(standAdd);
        }catch(Exception e){
            return ServerResponse.createByOtherError("新增机位异常:"+e.getMessage());
        }

        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "GET", value = "删除机位", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delStand.json", method = RequestMethod.GET)
    public ServerResponse delStand(@RequestParam("standno") String standno) {
        try{
            maintenanceMachinePositionService.delStand(standno);
        }catch(Exception e){
            e.printStackTrace();
            return ServerResponse.createByOtherError("删除机位异常:"+e.getMessage());
        }
        return ServerResponse.createBySuccess();
    }


    //更新机位
    @ApiOperation(httpMethod = "POST", value = "更新机位", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateStandMaint.json", method = RequestMethod.POST)
    public ServerResponse updateStandMaint(@ApiParam("机位号")@RequestParam("Stand") String stand,
                                           // @ApiParam("有无开始结束时间") @RequestParam(value="Delflg",required = false,defaultValue = "")String delflg,
                                            @ApiParam("维护机位原因") @RequestParam(value="Reason",required = false,defaultValue = "")String reason,
                                           //@ApiParam("开始日期") @RequestParam(value="starttime1",required = false,defaultValue = "")String starttime1,
                                           @ApiParam("开始时间") @RequestParam(value="starttime",required = false,defaultValue = "")String starttime,
                                          // @ApiParam("结束日期") @RequestParam(value="endtime1",required = false,defaultValue = "")String endtime1,
                                            @ApiParam("结束时间") @RequestParam(value="endtime",required = false,defaultValue = "")String endtime,
                                            @ApiParam("航站楼")@RequestParam("Terminal") String terminal,
                                           @ApiParam("机位类型")@RequestParam("Type") String type ) {

        try{
//            if("off".equals(delflg)) {
//                maintainReason = reason;
//
//                begTime = starttime1 + starttime;
//                endTime = endtime1 + endtime;
//
//                // 对前台传入的日期时间格式进行处理：
//                // "2014-05-05T15:00:00" -> "2014-05-05 15:00:00"
//                begTime = begTime.replace("T", " ");
//                endTime = endTime.replace("T", " ");
//            } else {
//                maintainReason = "";
//                begTime = "";
//                endTime = "";
//            }

            Map<Object, Object> updateMap = new HashMap<>();//更新条件与更新的值
            if("0".equals(type)) {	//基础机位更新
                System.out.println("基础机位更新");
                updateMap.put("standno",stand);
                if("".equals(starttime)) {
                    updateMap.put("begtime",null);
                } else {
                    //str时间格式转成timestamp
                    Timestamp ts = new Timestamp(System.currentTimeMillis());
                    try {
                        ts = Timestamp.valueOf(starttime);
                        updateMap.put("begtime",ts);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ServerResponse.createByParamError("开始时间格式不正确:"+starttime);
                    }
                }
                if("".equals(endtime)) {
                    updateMap.put("endtime",null);
                } else {
                    //str时间格式转成timestamp
                    Timestamp ts = new Timestamp(System.currentTimeMillis());
                    try {
                        ts = Timestamp.valueOf(endtime);
                        updateMap.put("endtime",ts);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ServerResponse.createByParamError("结束时间格式不正确:"+endtime);
                    }
                }
                if("".equals(reason)) {
                    updateMap.put("reason",null);
                } else {
                    updateMap.put("reason",reason);
                }
                maintenanceMachinePositionService.updateStand(updateMap);

            } else {//非基础机位更新
                System.out.println("非基础机位更新");
                updateMap.put("standno",stand);
                updateMap.put("terminal",terminal);
                updateMap.put("type",Integer.parseInt(type));

                if("".equals(starttime)) {
                    updateMap.put("begtime",null);
                } else {
                    //str时间格式转成timestamp
                    Timestamp ts = new Timestamp(System.currentTimeMillis());
                    try {
                        ts = Timestamp.valueOf(starttime);
                        updateMap.put("begtime",ts);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ServerResponse.createByParamError("开始时间格式不正确:"+starttime);
                    }
                }
                if("".equals(endtime)) {
                    updateMap.put("endtime",null);
                } else {
                    //str时间格式转成timestamp
                    Timestamp ts = new Timestamp(System.currentTimeMillis());
                    try {
                        ts = Timestamp.valueOf(endtime);
                        updateMap.put("endtime",ts);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ServerResponse.createByParamError("结束时间格式不正确:"+endtime);
                    }
                }

                if("".equals(reason)) {
                    updateMap.put("reason",null);
                } else {
                    updateMap.put("reason",reason);
                }
                maintenanceMachinePositionService.updateStandAdd(updateMap);
            }
        }catch(Exception e){
            e.printStackTrace();
            return ServerResponse.createByOtherError("更新机位异常:"+e.getMessage());
        }

        return ServerResponse.createBySuccess();
    }

}
