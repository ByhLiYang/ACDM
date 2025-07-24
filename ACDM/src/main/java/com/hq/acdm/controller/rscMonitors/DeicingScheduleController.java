package com.hq.acdm.controller.rscMonitors;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.rscMonitors.TEarlyDeicing;
import com.hq.acdm.service.rscMonitors.DeicingScheduleService;
import com.hq.acdm.util.excel.JxlsBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2020/12/17 10:16
 * @Description
 */
@Api(description = "除冰计划")
@RestController
    @RequestMapping("/rscMonitors/deicingSchedule")
public class DeicingScheduleController {
    @Resource
    private DeicingScheduleService deicingScheduleService;
    @ApiOperation(httpMethod = "POST", value = "除冰整体计划", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeicingSchedule.json", method = RequestMethod.POST)
    public ServerResponse<List<TEarlyDeicing>> findDeicingSchedule(@RequestBody String AddDataObject,
                                                                   HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject j=new JSONObject(AddDataObject);
        String execDate = j.getString("execDate");
        String type = j.getString("type");
        return ServerResponse.createBySuccess(deicingScheduleService.selectByDate(execDate,type));
    }

    @ApiOperation(httpMethod = "POST", value = "除冰区域计划", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDeicingArea.json", method = RequestMethod.POST)
    public ServerResponse<Map<String,List<TEarlyDeicing>>> findDeicingArea(@RequestBody String AddDataObject,
                                                                           HttpServletRequest request, HttpServletResponse response) throws JSONException  {
        JSONObject j=new JSONObject(AddDataObject);
        String execDate = j.getString("execDate");
        String type = j.getString("type");
        List<TEarlyDeicing> list = deicingScheduleService.selectByDate(execDate,type);
        Map<String,List<TEarlyDeicing>> map = new HashMap<>();
        List<TEarlyDeicing> e1 = new ArrayList<>();
        List<TEarlyDeicing> e2 = new ArrayList<>();
        List<TEarlyDeicing> w1 = new ArrayList<>();
        List<TEarlyDeicing> w2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ("东一".equals(list.get(i).getArea())){
                e1.add(list.get(i));
            }else if ("东二".equals(list.get(i).getArea())){
                e2.add(list.get(i));
            }else if ("西一".equals(list.get(i).getArea())){
                w1.add(list.get(i));
            }else if ("西二".equals(list.get(i).getArea())){
                w2.add(list.get(i));
            }
        }
        map.put("ALL",list);
        map.put("E1",e1);
        map.put("E2",e2);
        map.put("W1",w1);
        map.put("W2",w2);
        return ServerResponse.createBySuccess(map);
    }

    @ApiOperation(httpMethod = "POST", value = "修改预计除冰时间或区域", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateDeicingSchedule.json", method = RequestMethod.POST)
    public ServerResponse updateDeicingSchedule(@RequestBody String AddDataObject,
                                                HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject j=new JSONObject(AddDataObject);
        TEarlyDeicing ted = new TEarlyDeicing();
        ted.setFlno(j.getString("flno"));
        ted.setExecDate(j.getString("execDate"));
        ted.setEcdt(j.getString("ecdt"));
        ted.setArea(j.getString("area"));
        return ServerResponse.createBySuccess(deicingScheduleService.updateByFlno(ted));
    }

    @ApiOperation(httpMethod = "POST", value = "更新或交换机位", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateStand.json", method = RequestMethod.POST)
    public ServerResponse updateStand(@RequestBody String AddDataObject,
                                                HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject j=new JSONObject(AddDataObject);
        TEarlyDeicing ted = new TEarlyDeicing();
        ted.setFlno(j.getString("flno"));
        ted.setExecDate(j.getString("execDate"));
        ted.setStand(j.getString("stand"));
        return ServerResponse.createBySuccess(deicingScheduleService.updateStand(ted));
    }

    @ApiOperation(httpMethod = "POST", value = "查询可分配机位", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectStand.json", method = RequestMethod.POST)
    public ServerResponse selectStand(@RequestBody String AddDataObject,
                                      HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject j=new JSONObject(AddDataObject);
        TEarlyDeicing ted = new TEarlyDeicing();
        ted.setExecDate(j.getString("execDate"));
        ted.setArea(j.getString("area"));
        return ServerResponse.createBySuccess(deicingScheduleService.selectStand(ted));
    }

    @ApiOperation(httpMethod = "POST", value = "查询航班分配的机位位置", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectFltLocation.json", method = RequestMethod.POST)
    public ServerResponse selectFltLocation(@RequestBody String AddDataObject,
                                      HttpServletRequest request, HttpServletResponse response) throws JSONException {
        JSONObject j=new JSONObject(AddDataObject);
        String execDate = j.getString("execDate");
        return ServerResponse.createBySuccess(deicingScheduleService.selectFltLocation(execDate));
    }

    @ApiOperation(httpMethod = "POST", value = "除冰区域计划导出", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/export.json", method = RequestMethod.POST)
    public void export(@RequestBody String AddDataObject,
                                                                           HttpServletRequest request, HttpServletResponse response) throws Exception  {
        JSONObject j=new JSONObject(AddDataObject);
        String execDate = j.getString("execDate");
        String type = j.getString("type");
        OutputStream out = response.getOutputStream();
        List<TEarlyDeicing> list = deicingScheduleService.selectByDate(execDate,type);
        Map<String,List<TEarlyDeicing>> map = new HashMap<>();
        List<TEarlyDeicing> e1 = new ArrayList<>();
        List<TEarlyDeicing> e2 = new ArrayList<>();
        List<TEarlyDeicing> w1 = new ArrayList<>();
        List<TEarlyDeicing> w2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ("东一".equals(list.get(i).getArea())){
                e1.add(list.get(i));
            }else if ("东二".equals(list.get(i).getArea())){
                e2.add(list.get(i));
            }else if ("西一".equals(list.get(i).getArea())){
                w1.add(list.get(i));
            }else if ("西二".equals(list.get(i).getArea())){
                w2.add(list.get(i));
            }
        }

        JxlsBuilder jxlsBuilder = JxlsBuilder
                .getBuilder(ResourceUtils.getFile("classpath:template/deicingSchedule.xlsx").getAbsolutePath())
                .out(out)
                .ignoreImageMiss(true)
                .putVar("e1",e1)
                .putVar("e2", e2)
                .putVar("w1",w1)
                .putVar("w2", w2)
                .build();

        out.close();
    }

}
