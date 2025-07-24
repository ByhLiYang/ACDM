package com.hq.acdm.controller.statistics.resourceSeatMonitoringManagement;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.statistics.resourceSeatMonitoringManagement.ResourceSeatMonitoringManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源席位监控管理Controller
 */
@Api(description = "资源席位监控管理")
@RestController
@RequestMapping("/supervision/postSupervision") //前台访问地址
@Slf4j
public class ResourceSeatMonitoringManagementController {
    @Resource
    private ResourceSeatMonitoringManagementService resourceSeatMonitoringManagementService;

    @ApiOperation(httpMethod = "GET", value = "资源席位监控管理", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/resourcesSeatsMonitoring.json", method = RequestMethod.GET)
    public ServerResponse query() {
        Map<String,Object> resultMap=new HashMap<>();

        //查询实时靠桥率
        List<Map> realTimeBridgeApproachList=resourceSeatMonitoringManagementService.queryRealTimeBridgeApproach();
        resultMap.put("tableData1",realTimeBridgeApproachList);

        //查询滞留航班延误排行
        List<Map> delayedFlightTopList=resourceSeatMonitoringManagementService.queryDelayedFlightTop();
        resultMap.put("tableData2",delayedFlightTopList);

        //查询滞留航线延误排行
        List<Map> delayedFlightLineTopList=resourceSeatMonitoringManagementService.queryDelayedFlightLineTop();
        resultMap.put("tableData3",delayedFlightLineTopList);

        //查询机位冲突预警
        List<Map> collisionWarningList=resourceSeatMonitoringManagementService.queryCollisionWarning();
        resultMap.put("tableData4",collisionWarningList);

        //另外得出机位冲突预警的总数量
        int positionConflict=collisionWarningList.size();
        resultMap.put("positionConflict",positionConflict);

//        //查询空闲停机位总数
//        int freeSpaceCount=resourceSeatMonitoringManagementService.queryFreeSpaceCount();
//        resultMap.put("freeSpace",freeSpaceCount);



        //机位空闲停机位类型、总数
        List<Map> freeStandGroup=resourceSeatMonitoringManagementService.queryFreeStandGroup();

        List<Map> freeStandList=new ArrayList<>();//空闲机位最终的结果

        if(freeStandGroup.size()==0){
            //计算空闲停机位总数
            resultMap.put("freeSpace","0");

            Map<String,Object> resMap=new HashMap<>();
            resMap.put("type","B");
            resMap.put("T1","0");
            resMap.put("T2","0");
            resMap.put("total","0");
            freeStandList.add(resMap);

            resMap=new HashMap<>();
            resMap.put("type","C");
            resMap.put("T1","0");
            resMap.put("T2","0");
            resMap.put("total","0");
            freeStandList.add(resMap);

            resMap=new HashMap<>();
            resMap.put("type","D");
            resMap.put("T1","0");
            resMap.put("T2","0");
            resMap.put("total","0");
            freeStandList.add(resMap);

            resMap=new HashMap<>();
            resMap.put("type","E");
            resMap.put("T1","0");
            resMap.put("T2","0");
            resMap.put("total","0");
            freeStandList.add(resMap);
        }else{
            //机位空闲停机位 航站楼、停机位类型、停机位数量
            List<Map> freeStandSum=resourceSeatMonitoringManagementService.queryFreeStandSum();
            //给结果赋初始值
            Map<String,Object> resMapOfb=new HashMap<>();
            resMapOfb.put("type","B");
            resMapOfb.put("T1","0");
            resMapOfb.put("T2","0");
            resMapOfb.put("total","0");
            Map<String,Object> resMapOfc=new HashMap<>();
            resMapOfc.put("type","C");
            resMapOfc.put("T1","0");
            resMapOfc.put("T2","0");
            resMapOfc.put("total","0");
            Map<String,Object> resMapOfd=new HashMap<>();
            resMapOfd.put("type","D");
            resMapOfd.put("T1","0");
            resMapOfd.put("T2","0");
            resMapOfd.put("total","0");
            Map<String,Object> resMapOfe=new HashMap<>();
            resMapOfe.put("type","E");
            resMapOfe.put("T1","0");
            resMapOfe.put("T2","0");
            resMapOfe.put("total","0");

            //计算空闲停机位总数
            int freeSpaceCount=0;
            for(Map map:freeStandGroup){
                String type=map.get("DESCRIPTION").toString();
                String total=map.get("STANDS").toString();

                freeSpaceCount+=Integer.parseInt(total);
                switch (type){
                    case "B":
                        resMapOfb.put("type","B");
                        resMapOfb.put("total",total);
                        break;
                    case "C":
                        resMapOfc.put("type","C");
                        resMapOfc.put("total",total);
                        break;
                    case "D":
                        resMapOfd.put("type","D");
                        resMapOfd.put("total",total);
                        break;
                    case "E":
                        resMapOfe.put("type","E");
                        resMapOfe.put("total",total);
                        break;

                        default:
                            break;

                }


            }
            resultMap.put("freeSpace",freeSpaceCount);


            //取出T1、T2 航站楼的停机位数量
            for(Map map:freeStandSum){
                String type=map.get("DESCRIPTION").toString();
                String terminal=map.get("TERMINAL").toString();
                String stands=map.get("STANDS").toString();
                switch (type){
                    case "B":
                        if("1".equals(terminal)){
                            resMapOfb.put("T1",stands);
                        }else if("2".equals(terminal)){
                            resMapOfb.put("T2",stands);
                        }
                        break;
                    case "C":
                        if("1".equals(terminal)){
                            resMapOfc.put("T1",stands);
                        }else if("2".equals(terminal)){
                            resMapOfc.put("T2",stands);
                        }
                        break;
                    case "D":
                        if("1".equals(terminal)){
                            resMapOfd.put("T1",stands);
                        }else if("2".equals(terminal)){
                            resMapOfd.put("T2",stands);
                        }
                        break;
                    case "E":
                        if("1".equals(terminal)){
                            resMapOfe.put("T1",stands);
                        }else if("2".equals(terminal)){
                            resMapOfe.put("T2",stands);
                        }
                        break;

                    default:
                        break;
                }
            }

            freeStandList.add(resMapOfb);
            freeStandList.add(resMapOfc);
            freeStandList.add(resMapOfd);
            freeStandList.add(resMapOfe);


        }



        resultMap.put("tableData5",freeStandList);


        return ServerResponse.createBySuccess(resultMap);
    }


}
