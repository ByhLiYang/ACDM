package com.hq.acdm.controller.coordinatedOprt;

import com.alibaba.fastjson.JSON;
import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.service.coordinatedOprt.DelayPrejudgeService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.vo.coordinatedOprt.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "协同运行航班延误预判")
@RestController
@RequestMapping("/coordinatedOprt/delayPrejudge")
public class DelayPrejudgeController {

    @Resource
    private DelayPrejudgeService delayPrejudgeService;


    @ApiOperation(httpMethod = "GET", value = "航延预判航班执行情况", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFligthExecInfo.json", method = RequestMethod.GET)
    public ServerResponse findFligthExecInfo() {
        List<DelayPrejudgeHBZXQKVo> voList = delayPrejudgeService.findFligthExecInfo();
        return ServerResponse.createBySuccess(voList.get(0));
    }

    @ApiOperation(httpMethod = "GET", value = "航延预判机场运行效率", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAirRunEfficiency.json", method = RequestMethod.GET)
    public ServerResponse findAirRunEfficiency() {
        List<DelayPrejudgeJCYXXLVo> voList = delayPrejudgeService.findAirRunEfficiency();
        return ServerResponse.createBySuccess(voList.get(0));
    }


    @ApiOperation(httpMethod = "GET", value = "航延预判执行率", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findExeRate.json", method = RequestMethod.GET)
    public ServerResponse findExeRate() {
        List<DelayPrejudgeExeVarVo> voList = delayPrejudgeService.findExeRate();
        return ServerResponse.createBySuccess(voList);
    }

    @ApiOperation(httpMethod = "GET", value = "航延预判出港延误一小时以上未起飞航班数", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDelayNotTakingOff.json", method = RequestMethod.GET)
    public ServerResponse findDelayNotTakingOff() {
        List<DelayPrejudgeExeVarVo> voList = delayPrejudgeService.findDelayNotTakingOff();
        return ServerResponse.createBySuccess(voList);
    }


    @ApiOperation(httpMethod = "GET", value = "航延预判数据信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findDelayPrejudgeInfo.json", method = RequestMethod.GET)
    public ServerResponse findDelayPrejudgeInfo() {
        Map<String,Object> map = delayPrejudgeService.findDelayPrejudgeInfo();
        return ServerResponse.createBySuccess(map);
    }

    @ApiOperation(httpMethod = "GET", value = "未来2小时延误航班", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFtDelays.json", method = RequestMethod.GET)
    public ServerResponse<List<FutureDelayVo>> findFtDelays() {
        return ServerResponse.createBySuccess(delayPrejudgeService.findFtDelays());
    }

    @ApiOperation(httpMethod = "GET", value = "延误预测", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findFtDelaysX.json", method = RequestMethod.GET)
    public ServerResponse findFtDelaysX() {
        return ServerResponse.createBySuccess(delayPrejudgeService.findFtDelaysX());
    }

    @ApiOperation(httpMethod = "GET", value = "查询当前启动的预警ID", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findWarningId.json", method = RequestMethod.GET)
    public ServerResponse<TEmergencyDisposalVo> findWarningId() {
        TEmergencyDisposal ted = delayPrejudgeService.findWarningId();
        TEmergencyDisposalVo tedv = new TEmergencyDisposalVo();
        if (null!=ted){
            tedv.setId(ted.getId());
            tedv.setLevel(ted.getLevel());
            tedv.setReason(ted.getReason());
        }
        return ServerResponse.createBySuccess(tedv);
    }

    @ApiOperation(httpMethod = "POST", value = "启动航延预警查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findWarningChat.json", method = RequestMethod.POST)
    public ServerResponse<TEmergencyDisposalVo> findWarningChat(@RequestBody String data) {
        JSONObject jsonObject = null;
        String level = "";
        String edId = "";
        try {
            jsonObject = new JSONObject(data);
            level = jsonObject.getString("level").equals("null") ? null : jsonObject.getString("level");
            edId = jsonObject.getString("edId").equals("null") ? null : jsonObject.getString("edId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TEmergencyDisposal ted = delayPrejudgeService.findWarningChat(level,edId);
        TEmergencyDisposalVo tedv = new TEmergencyDisposalVo();
        tedv.setEndTime(null==ted.getEndTime()?null:DateTimeUtil.dateToStr(ted.getEndTime(),"yyyy-MM-dd HH:mm"));
        tedv.setId(ted.getId());
        tedv.setLevel(ted.getLevel());
        tedv.setReason(ted.getReason());
        tedv.setRemark(ted.getRemark());
        tedv.setStartTime(null==ted.getStartTime()?null:DateTimeUtil.dateToStr(ted.getStartTime(),"yyyy-MM-dd HH:mm"));
        return ServerResponse.createBySuccess(tedv);
    }

    @ApiOperation(httpMethod = "POST", value = "根据处置ID查询处置任务清单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findTaskList.json", method = RequestMethod.POST)
    public ServerResponse<List<TEdDynTaskVo>> findTaskList(@RequestBody String data) {
        JSONObject jsonObject = null;
        String edId = "";
        try {
            jsonObject = new JSONObject(data);
            edId = jsonObject.getString("edId").equals("null") ? null : jsonObject.getString("edId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<TEdDynTask> tEdDynTasks = delayPrejudgeService.findTaskList(edId);
        List<TEdDynTaskVo> tEdDynTaskVos = new ArrayList<>();
        for (int i = 0; i < tEdDynTasks.size(); i++) {
            TEdDynTaskVo tedtv = new TEdDynTaskVo();
            tedtv.setCreateTime(null==tEdDynTasks.get(i).getCreateTime()?null:DateTimeUtil.dateToStr(tEdDynTasks.get(i).getCreateTime(),"yyyy-MM-dd HH:mm"));
            tedtv.setEdId(tEdDynTasks.get(i).getEdId());
            tedtv.setEndTime(null==tEdDynTasks.get(i).getEndTime()?null:DateTimeUtil.dateToStr(tEdDynTasks.get(i).getEndTime(),"yyyy-MM-dd HH:mm"));
            tedtv.setId(tEdDynTasks.get(i).getId());
            tedtv.setIsfinished(tEdDynTasks.get(i).getIsfinished());
            tedtv.setRemark(tEdDynTasks.get(i).getRemark());
            tedtv.setStartTime(null==tEdDynTasks.get(i).getStartTime()?null:DateTimeUtil.dateToStr(tEdDynTasks.get(i).getStartTime(),"yyyy-MM-dd HH:mm"));
            tedtv.setTaskName(tEdDynTasks.get(i).getTaskName());
            tedtv.setUpdateTime(null==tEdDynTasks.get(i).getUpdateTime()?null:DateTimeUtil.dateToStr(tEdDynTasks.get(i).getUpdateTime(),"yyyy-MM-dd HH:mm"));
            tEdDynTaskVos.add(tedtv);
        }
        return ServerResponse.createBySuccess(tEdDynTaskVos);
    }

    @ApiOperation(httpMethod = "POST", value = "根据处置ID查询响应表录入数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findResponseEt.json", method = RequestMethod.POST)
    public ServerResponse<TEdResponseVo> findResponseEt(@RequestBody String data) {
        JSONObject jsonObject = null;
        String edId = "";
        try {
            jsonObject = new JSONObject(data);
            edId = jsonObject.getString("edId").equals("null") ? null : jsonObject.getString("edId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TEdResponse ter = delayPrejudgeService.findResponseEt(edId);
        TEdResponseVo terv = new TEdResponseVo();
        terv.setCanceledA(ter.getCanceledA());
        terv.setCanceledD(ter.getCanceledD());
        terv.setCreateTime(null==ter.getCreateTime()?null:DateTimeUtil.dateToStr(ter.getCreateTime(),"yyyy-MM-dd HH:mm"));
        terv.setCurdateApmng(ter.getCurdateApmng());
        terv.setCurdateApmngPhone(ter.getCurdateManagerPhone());
        terv.setCurdateManager(ter.getCurdateManager());
        terv.setCurdateManagerPhone(ter.getCurdateManagerPhone());
        terv.setCurdatePlana(ter.getCurdatePlana());
        terv.setCurdatePland(ter.getCurdatePland());
        terv.setCurtimePlana(ter.getCurtimePlana());
        terv.setCurtimePland(ter.getCurtimePland());
        terv.setCutoffTime((null==ter.getCutoffTime()?null:DateTimeUtil.dateToStr(ter.getCutoffTime(),"yyyy-MM-dd HH:mm")));
        terv.setDclsFlno(ter.getDclsFlno());
        terv.setDelayFlno(ter.getDelayFlno());
        terv.setDelayRatio(ter.getDelayRatio());
        terv.setDescendCapacity(ter.getDescendCapacity());
        terv.setEdId(ter.getEdId());
        terv.setExecutedA(ter.getExecutedA());
        terv.setExecutedD(ter.getExecutedD());
        terv.setExecutiveCdtn(ter.getExecutiveCdtn());
        terv.setFactorsPeriod(ter.getFactorsPeriod());
        terv.setFillingTime(null==ter.getFillingTime()?null:DateTimeUtil.dateToStr(ter.getFillingTime(),"yyyy-MM-dd HH:mm"));
        terv.setFreeStand(ter.getFreeStand());
        terv.setHourActuala(ter.getHourActuala());
        terv.setHourActuald(ter.getHourActuald());
        terv.setHourPlana(ter.getHourPlana());
        terv.setHourPland(ter.getHourPland());
        terv.setId(ter.getId());
        terv.setLevel(ter.getLevel());
        terv.setMattersCoordinated(ter.getMattersCoordinated());
        terv.setOtherSpecial(ter.getOtherSpecial());
        terv.setPreparer(ter.getPreparer());
        terv.setRemark(ter.getRemark());
        terv.setReturnAlternate(ter.getReturnAlternate());
        terv.setSpecialPlane(ter.getSpecialPlane());
        terv.setTerminalOrder(ter.getTerminalOrder());
        terv.setUpdateTime(null==ter.getUpdateTime()?null:DateTimeUtil.dateToStr(ter.getUpdateTime(),"yyyy-MM-dd HH:mm"));
        return ServerResponse.createBySuccess(terv);
    }

    @ApiOperation(httpMethod = "POST", value = "根据处置ID查询响应表实时计算数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findResponseCalc.json", method = RequestMethod.POST)
    public ServerResponse<TEdResponseVo> findResponseCalc(@RequestBody String data) {
        JSONObject jsonObject = null;
        String edId = "";
        try {
            jsonObject = new JSONObject(data);
            edId = jsonObject.getString("edId").equals("null") ? null : jsonObject.getString("edId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TEdResponse ter = delayPrejudgeService.findResponseCalc(edId);
        TEdResponseVo terv = new TEdResponseVo();

        terv.setCanceledA(ter.getCanceledA());
        terv.setCanceledD(ter.getCanceledD());
        terv.setCreateTime(null==ter.getCreateTime()?null:DateTimeUtil.dateToStr(ter.getCreateTime(),"yyyy-MM-dd HH:mm"));
        terv.setCurdateApmng(ter.getCurdateApmng());
        terv.setCurdateApmngPhone(ter.getCurdateManagerPhone());
        terv.setCurdateManager(ter.getCurdateManager());
        terv.setCurdateManagerPhone(ter.getCurdateManagerPhone());
        terv.setCurdatePlana(ter.getCurdatePlana());
        terv.setCurdatePland(ter.getCurdatePland());
        terv.setCurtimePlana(ter.getCurtimePlana());
        terv.setCurtimePland(ter.getCurtimePland());
        terv.setCutoffTime((null==ter.getCutoffTime()?null:DateTimeUtil.dateToStr(ter.getCutoffTime(),"yyyy-MM-dd HH:mm")));
        terv.setDclsFlno(ter.getDclsFlno());
        terv.setDelayFlno(ter.getDelayFlno());
        terv.setDelayRatio(ter.getDelayRatio());
        terv.setDescendCapacity(ter.getDescendCapacity());
        terv.setEdId(ter.getEdId());
        terv.setExecutedA(ter.getExecutedA());
        terv.setExecutedD(ter.getExecutedD());
        terv.setExecutiveCdtn(ter.getExecutiveCdtn());
        terv.setFactorsPeriod(ter.getFactorsPeriod());
        terv.setFillingTime(null==ter.getFillingTime()?null:DateTimeUtil.dateToStr(ter.getFillingTime(),"yyyy-MM-dd HH:mm"));
        terv.setFreeStand(ter.getFreeStand());
        terv.setHourActuala(ter.getHourActuala());
        terv.setHourActuald(ter.getHourActuald());
        terv.setHourPlana(ter.getHourPlana());
        terv.setHourPland(ter.getHourPland());
        terv.setId(ter.getId());
        terv.setLevel(ter.getLevel());
        terv.setMattersCoordinated(ter.getMattersCoordinated());
        terv.setOtherSpecial(ter.getOtherSpecial());
        terv.setPreparer(ter.getPreparer());
        terv.setRemark(ter.getRemark());
        terv.setReturnAlternate(ter.getReturnAlternate());
        terv.setSpecialPlane(ter.getSpecialPlane());
        terv.setTerminalOrder(ter.getTerminalOrder());
        terv.setUpdateTime(null==ter.getUpdateTime()?null:DateTimeUtil.dateToStr(ter.getUpdateTime(),"yyyy-MM-dd HH:mm"));
        return ServerResponse.createBySuccess(terv);
    }

    @ApiOperation(httpMethod = "POST", value = "根据处置ID查询预警信息表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findWarningInfo.json", method = RequestMethod.POST)
    public ServerResponse<TEdWarningVo> findWarningInfo(@RequestBody String data) {
        JSONObject jsonObject = null;
        String edId = "";
        try {
            jsonObject = new JSONObject(data);
            edId = jsonObject.getString("edId").equals("null") ? null : jsonObject.getString("edId");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TEdWarningVo tewv = new TEdWarningVo();
        TEdWarning tew = delayPrejudgeService.findWarningInfo(edId);
        tewv.setAdjustedBk(tew.getAdjustedBk());
        tewv.setAdjustedCa(tew.getAdjustedCa());
        tewv.setAdjustedCz(tew.getAdjustedCz());
        tewv.setAdjustedGs(tew.getAdjustedGs());
        tewv.setAdjustedHj(tew.getAdjustedHj());
        tewv.setAdjustedMu(tew.getAdjustedMu());
        tewv.setAdjustedPlanaSum(tew.getAdjustedPlanaSum());
        tewv.setAdjustedPlandSum(tew.getAdjustedPlandSum());
        tewv.setAdjustedPlanSum(tew.getAdjustedPlanSum());
        tewv.setAdjustPeriod(tew.getAdjustPeriod());
        tewv.setAdjustPlanBk(tew.getAdjustPlanBk());
        tewv.setAdjustPlanCa(tew.getAdjustPlanCa());
        tewv.setAdjustPlanCz(tew.getAdjustPlanCz());
        tewv.setAdjustPlanGs(tew.getAdjustPlanGs());
        tewv.setAdjustPlanHj(tew.getAdjustPlanHj());
        tewv.setAdjustPlanMu(tew.getAdjustPlanMu());
        tewv.setAdjustRatio(tew.getAdjustRatio());
        tewv.setCreateTime(null==tew.getCreateTime()?null:DateTimeUtil.dateToStr(tew.getCreateTime(),"yyyy-MM-dd HH:mm"));
        tewv.setCutoffTime(null==tew.getCutoffTime()?null:DateTimeUtil.dateToStr(tew.getCutoffTime(),"yyyy-MM-dd HH:mm"));
        tewv.setDescendCapacity(tew.getDescendCapacity());
        tewv.setEdId(tew.getEdId());
        tewv.setFactorsPeriod(tew.getFactorsPeriod());
        tewv.setFillingTime(null==tew.getFillingTime()?null:DateTimeUtil.dateToStr(tew.getCutoffTime(),"yyyy-MM-dd HH:mm"));
        tewv.setId(tew.getId());
        tewv.setIsCoordinated(tew.getIsCoordinated());
        tewv.setIsScheduleAdjustmnet(tew.getIsScheduleAdjustmnet());
        tewv.setLevel(tew.getLevel());
        tewv.setMattersCoordinated(tew.getMattersCoordinated());
        tewv.setNdApmng(tew.getNdApmng());
        tewv.setNdApmngPhone(tew.getNdApmngPhone());
        tewv.setNdManager(tew.getNdManager());
        tewv.setNdManagerPhone(tew.getNdManagerPhone());
        tewv.setOriginalPlanBk(tew.getOriginalPlanBk());
        tewv.setOriginalPlanCa(tew.getOriginalPlanCa());
        tewv.setOriginalPlanCz(tew.getOriginalPlanCz());
        tewv.setOriginalPlanGs(tew.getOriginalPlanGs());
        tewv.setOriginalPlanHj(tew.getOriginalPlanHj());
        tewv.setOriginalPlanMu(tew.getOriginalPlanMu());
        tewv.setOtherSpecial(tew.getOtherSpecial());
        tewv.setPreparer(tew.getPreparer());
        tewv.setRemark(tew.getRemark());
        tewv.setSpecialPlane(tew.getSpecialPlane());
        tewv.setUpdateTime(null==tew.getUpdateTime()?null:DateTimeUtil.dateToStr(tew.getUpdateTime(),"yyyy-MM-dd HH:mm"));
        return ServerResponse.createBySuccess(tewv);
    }

    @ApiOperation(httpMethod = "POST", value = "根据处置任务ID更新任务状态和备注", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateEmgcDsps.json", method = RequestMethod.POST)
    public ServerResponse updateEmgcDsps(@RequestBody String data) {
        JSONObject jsonObject = null;
        TEdDynTask tedt = new TEdDynTask();
        try {
            jsonObject = new JSONObject(data);
            tedt.setId(jsonObject.getString("id").equals("null") ? null : jsonObject.getString("id"));
            tedt.setTaskName(jsonObject.getString("taskName").equals("null") ? null : jsonObject.getString("taskName"));
            tedt.setIsfinished(jsonObject.getString("isfinished").equals("null") ? null : jsonObject.getBoolean("isfinished"));
            tedt.setRemark(jsonObject.getString("remark").equals("null") ? null : jsonObject.getString("remark"));
            tedt.setUpdateTime(new Date());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess(delayPrejudgeService.updateEmgcDsps(tedt));
    }

    @ApiOperation(httpMethod = "POST", value = "根据处置ID更新响应表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateEdResponse.json", method = RequestMethod.POST)
    public ServerResponse updateEdResponse(@RequestBody String data) {
        JSONObject jsonObject = null;
        TEdResponse ter = new TEdResponse();
        try {
            jsonObject = new JSONObject(data);
            ter.setId(jsonObject.getString("id").equals("null") ? null : jsonObject.getString("id"));
            ter.setEdId(jsonObject.getString("edId").equals("null") ? null : jsonObject.getString("edId"));
            ter.setLevel(jsonObject.getString("level").equals("null") ? null : jsonObject.getString("level"));
            ter.setFactorsPeriod(jsonObject.getString("factorsPeriod").equals("null") ? null : jsonObject.getString("factorsPeriod"));
            ter.setDescendCapacity(jsonObject.getString("descendCapacity").equals("null") ? null : jsonObject.getString("descendCapacity"));
            ter.setCurdatePlana(jsonObject.getString("curdatePlana").equals("null") ? null : jsonObject.getString("curdatePlana"));
            ter.setCurdatePland(jsonObject.getString("curdatePland").equals("null") ? null : jsonObject.getString("curdatePland"));
            ter.setCurtimePlana(jsonObject.getString("curtimePlana").equals("null") ? null : jsonObject.getString("curtimePlana"));
            ter.setCurtimePland(jsonObject.getString("curtimePland").equals("null") ? null : jsonObject.getString("curtimePland"));
            ter.setExecutedA(jsonObject.getString("executedA").equals("null") ? null : jsonObject.getString("executedA"));
            ter.setExecutedD(jsonObject.getString("executedD").equals("null") ? null : jsonObject.getString("executedD"));
            ter.setCanceledA(jsonObject.getString("canceledA").equals("null") ? null : jsonObject.getString("canceledA"));
            ter.setCanceledD(jsonObject.getString("canceledD").equals("null") ? null : jsonObject.getString("canceledD"));
            ter.setReturnAlternate(jsonObject.getString("returnAlternate").equals("null") ? null : jsonObject.getString("returnAlternate"));
            ter.setHourPlana(jsonObject.getString("hourPlana").equals("null") ? null : jsonObject.getString("hourPlana"));
            ter.setHourActuala(jsonObject.getString("hourActuala").equals("null") ? null : jsonObject.getString("hourActuala"));
            ter.setHourPland(jsonObject.getString("hourPland").equals("null") ? null : jsonObject.getString("hourPland"));
            ter.setHourActuald(jsonObject.getString("hourActuald").equals("null") ? null : jsonObject.getString("hourActuald"));
            ter.setFreeStand(jsonObject.getString("freeStand").equals("null") ? null : jsonObject.getString("freeStand"));
            ter.setDelayRatio(jsonObject.getString("delayRatio").equals("null") ? null : jsonObject.getString("delayRatio"));
            ter.setDelayFlno(jsonObject.getString("delayFlno").equals("null") ? null : jsonObject.getString("delayFlno"));
            ter.setDclsRatio(jsonObject.getString("dclsRatio").equals("null") ? null : jsonObject.getString("dclsRatio"));
            ter.setDclsFlno(jsonObject.getString("dclsFlno").equals("null") ? null : jsonObject.getString("dclsFlno"));
            ter.setExecutiveCdtn(jsonObject.getString("executiveCdtn").equals("null") ? null : jsonObject.getString("executiveCdtn"));
            ter.setSpecialPlane(jsonObject.getString("specialPlane").equals("null") ? null : jsonObject.getString("specialPlane"));
            ter.setTerminalOrder(jsonObject.getString("terminalOrder").equals("null") ? null : jsonObject.getString("terminalOrder"));
            ter.setMattersCoordinated(jsonObject.getString("mattersCoordinated").equals("null") ? null : jsonObject.getString("mattersCoordinated"));
            ter.setOtherSpecial(jsonObject.getString("otherSpecial").equals("null") ? null : jsonObject.getString("otherSpecial"));
            ter.setCurdateManager(jsonObject.getString("curdateManager").equals("null") ? null : jsonObject.getString("curdateManager"));
            ter.setCurdateManagerPhone(jsonObject.getString("curdateManagerPhone").equals("null") ? null : jsonObject.getString("curdateManagerPhone"));
            ter.setCurdateApmng(jsonObject.getString("curdateApmng").equals("null") ? null : jsonObject.getString("curdateApmng"));
            ter.setCurdateApmngPhone(jsonObject.getString("curdateApmngPhone").equals("null") ? null : jsonObject.getString("curdateApmngPhone"));
            ter.setPreparer(jsonObject.getString("preparer").equals("null") ? null : jsonObject.getString("preparer"));
            ter.setFillingTime(jsonObject.getString("fillingTime").equals("null") ? null : DateTimeUtil.strToDate(jsonObject.getString("fillingTime"),"YYYY-MM-DD HH:mm:ss"));
            ter.setCutoffTime(jsonObject.getString("cutoffTime").equals("null") ? null : DateTimeUtil.strToDate(jsonObject.getString("cutoffTime"),"YYYY-MM-DD HH:mm:ss"));
            ter.setRemark(jsonObject.getString("remark").equals("null") ? null : jsonObject.getString("remark"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess(delayPrejudgeService.updateEdResponse(ter));
    }

    @ApiOperation(httpMethod = "POST", value = "根据处置ID更新响应表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateEdWarning.json", method = RequestMethod.POST)
    public ServerResponse updateEdWarning(@RequestBody String data) {
        JSONObject jsonObject = null;
        TEdWarning tew = new TEdWarning();
        try {
            jsonObject = new JSONObject(data);
            tew = JSON.parseObject(jsonObject.toString(),TEdWarning.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess(delayPrejudgeService.updateEdWarning(tew));
    }
}
