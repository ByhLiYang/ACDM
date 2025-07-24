package com.hq.acdm.controller.statistics.multiDataSourceManagement;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.enums.ReponseStatusEnum;
import com.hq.acdm.service.statistics.multiDataSourceManagement.MultiDataSourceManagementService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "多数据源管理")
@RestController
@RequestMapping("/statisticalReport/multiDataSourceManagement") //前台访问地址
@Slf4j
public class MultiDataSourceManagementController {
    @Resource
    private MultiDataSourceManagementService multiDataSourceManagementService;

    //取得机位列表
    @ApiOperation(httpMethod = "GET", value = "获取有效数据源", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/DSMDataSourceList.json", method = RequestMethod.GET)
    public ServerResponse queryDSMDataSourceList() {

        List<Map> resultMap=new ArrayList<Map>();
        try {
            List<Map> dataSourceList= multiDataSourceManagementService.getDSMDataSourceList();
            for(Map dsMap:dataSourceList){
                Map<String,Object> map=new HashMap<>();
                // 数据源代码
                map.put("DS_CODE", dsMap.get("DS_ID"));
                // 数据源名称
                map.put("DS_NAME", dsMap.get("DS_DESC"));
                resultMap.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
           return ServerResponse.createByOtherError("获取数据源异常:"+e.getMessage());
        }


        return ServerResponse.createBySuccess(resultMap);
    }


    //取得机位列表
    @ApiOperation(httpMethod = "GET", value = "获取有效里程碑数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/DSMMileStoneList.json", method = RequestMethod.GET)
    public ServerResponse querygetDSMMileStoneList() {

        List<Map> resultMap=new ArrayList<Map>();
        try {
            List<Map> dataSourceList= multiDataSourceManagementService.getDSMMileStoneList();
            for(Map dsMap:dataSourceList){
                Map<String,Object> map=new HashMap<>();
                // 里程碑时间节点编号
                map.put("MS_CODE", dsMap.get("MILESTONE_ID"));
                // 里程碑短名称
                map.put("MS_NAME", dsMap.get("MILESTONE_DESC"));
                resultMap.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByOtherError("获取里程碑数据异常:"+e.getMessage());
        }


        return ServerResponse.createBySuccess(resultMap);
    }

    //取得机位列表
    @ApiOperation(httpMethod = "GET", value = "获取所有数据源", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/DSMAllDataSource.json", method = RequestMethod.GET)
    public ServerResponse queryDSMAllDataSource() {

        List<Map> resultMap=new ArrayList<Map>();
        try {
            List<Map> dataSourceList= multiDataSourceManagementService.getDSMAllDataSource();
            for(Map dsMap:dataSourceList){
                Map<String,Object> map=new HashMap<>();
                // 数据源代码
                map.put("DS_CODE", dsMap.get("DS_ID"));
                // 数据源名称
                map.put("DS_NAME", dsMap.get("DS_DESC"));
                // 里程碑时间节点编号
                map.put("MS_CODE", dsMap.get("MILESTONE_ID"));
                // 里程碑短名称
                map.put("MS_NAME", dsMap.get("MILESTONE_DESC"));
                //优先级
                map.put("MS_DS_LEV", dsMap.get("PRIORITY"));
                resultMap.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByOtherError("获取所有数据源异常:"+e.getMessage());
        }


        return ServerResponse.createBySuccess(resultMap);
    }



    //更新数据源优先级
    @ApiOperation(httpMethod = "POST", value = "更新数据源优先级", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/UpdatePriority.json", method = RequestMethod.POST)
    public ServerResponse updatePriority(@ApiParam("数据源代码")@RequestParam("DS_CODE") String dsCode,
                                         @ApiParam("里程碑时间节点编号")@RequestParam("MS_CODE") String msCode,
                                         @ApiParam("优先级")@RequestParam("MS_DS_LEV") String msDsLev) {

        try{
            // 用户指定的指定记录的优先级
            int ipriority = Integer.parseInt(msDsLev);
            // 数据库中保存的指定记录的优先级
            int ioldpriority = 0;
            // 取得数据库中的指定记录的优先级
            Map<String,String> valueMap=new HashMap<String,String>();//存储查询条件的Map
            valueMap.put("msid",msCode);
            valueMap.put("dsid",dsCode);
            ioldpriority = Integer.parseInt(multiDataSourceManagementService.getDefinedPriority(valueMap));


            // 根据指定的优先级和保存的优先级，判断与指定记录相邻的记录要如何进行优先级变更
            if (ioldpriority < ipriority) {	// 指定记录优先级下移，相邻记录上移 updateLowerPriority
                Map<String,String> updateMap=new HashMap<String,String>();//存储更新条件的Map
                updateMap.put("msid",msCode);
                updateMap.put("dsid",dsCode);
                updateMap.put("pri",String.valueOf(ipriority));
                multiDataSourceManagementService.updateLowerPriority(updateMap);
            }
            else if (ioldpriority > ipriority) {	// 指定记录优先级上移，相邻记录下移 updateHigherPriority
                Map<String,String> updateMap=new HashMap<String,String>();//存储更新条件的Map
                updateMap.put("msid",msCode);
                updateMap.put("dsid",dsCode);
                updateMap.put("pri",String.valueOf(ipriority));
                multiDataSourceManagementService.updateHigherPriority(updateMap);
            }
            else {	// 指定记录的优先级无需变更
                System.out.println("指定记录的优先级无需变更");
            }


            // 最后完成指定记录的优先级变更 updateDefinedPriority
            Map<String,String> updateMap=new HashMap<String,String>();//存储更新条件的Map
            updateMap.put("msid",msCode);
            updateMap.put("dsid",dsCode);
            updateMap.put("pri",String.valueOf(ipriority));
            multiDataSourceManagementService.updateDefinedPriority(updateMap);
        }catch(Exception e){
            e.printStackTrace();
            return ServerResponse.createByOtherError("更新数据源优先级异常:"+e.getMessage());
        }



        return ServerResponse.createBySuccess();
    }


    //删除数据源（将要删除记录的生效状态置为不生效）
    @ApiOperation(httpMethod = "POST", value = "删除数据源优先级", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/DeleteRecord.json", method = RequestMethod.POST)
    public ServerResponse deleteRecord(@ApiParam("数据源代码")@RequestParam("DS_CODE") String dsCode,
                                         @ApiParam("里程碑时间节点编号")@RequestParam("MS_CODE") String msCode,
                                         @ApiParam("优先级")@RequestParam("MS_DS_LEV") String msDsLev) {

        try{
            // 删除前先将优先级小于待删除记录的优先级全部提升一级  updatePriorityBeforedel
            Map<String,String> updateMap=new HashMap<String,String>();//存储更新条件的Map
            updateMap.put("msid",msCode);
            updateMap.put("dsid",dsCode);
            updateMap.put("pri",msDsLev);
            multiDataSourceManagementService.updatePriorityBeforedel(updateMap);

            // 删除该记录 - 逻辑删除 deleteRecordLogic
            updateMap=new HashMap<String,String>();//存储更新条件的Map
            updateMap.put("msid",msCode);
            updateMap.put("dsid",dsCode);
            multiDataSourceManagementService.deleteRecordLogic(updateMap);
        }catch(Exception e){
            e.printStackTrace();
            return ServerResponse.createByOtherError("删除数据源异常:"+e.getMessage());
        }



        return ServerResponse.createBySuccess();


    }

    //新增数据源
    @ApiOperation(httpMethod = "POST", value = "新增数据源", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/InsertRecord.json", method = RequestMethod.POST)
    public ServerResponse insertRecord(@ApiParam("数据源代码")@RequestParam("DS_CODE") String dsCode,
                                       @ApiParam("里程碑时间节点编号")@RequestParam("MS_CODE") String msCode,
                                       @ApiParam("优先级")@RequestParam("MS_DS_LEV") String msDsLev) {


            try{
                int priority=Integer.parseInt(msDsLev);
                if (priority <= 0) {
                    return ServerResponse.createBySuccess().createByParamError();
                }

                // 插入该记录 - 先尝试逻辑插入 insertRecordLogic
                Map<String,String> updateMap=new HashMap<String,String>();//存储更新条件的Map
                updateMap.put("msid",msCode);
                updateMap.put("dsid",dsCode);
                updateMap.put("pri",msDsLev);
                int result=0;
                result =multiDataSourceManagementService.insertRecordLogic(updateMap);


                if (result > 0) {
                    //返回成功消息
                }else {	// 逻辑插入失败，尝试物理插入 insertRecordPhysical
                    Map<String,Object> insertRecordMap=new HashMap<String,Object>();//存储更新条件的Map
                    insertRecordMap.put("msid",msCode);
                    insertRecordMap.put("dsid",dsCode);
                    insertRecordMap.put("pri",priority);
                    result =multiDataSourceManagementService.insertRecordPhysical(insertRecordMap);

                    if (result > 0) {	// 物理插入成功，更新插入记录的里程碑名和数据源名  updateInsertRecord
                        Map<String,String> updateRecordMap=new HashMap<String,String>();//存储更新条件的Map
                        updateRecordMap.put("msid",msCode);
                        updateRecordMap.put("dsid",dsCode);
                        result =multiDataSourceManagementService.updateInsertRecord(updateRecordMap);

                        if (result > 0) {
                            //返回成功消息
                        }
                    }
                    else {	// 物理插入失败，插入操作失败
                        return ServerResponse.createByOtherError("新增数据源记录失败");
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
                return ServerResponse.createByOtherError("新增数据源异常:"+e.getMessage());
            }


            return ServerResponse.createBySuccess();

    }

}
