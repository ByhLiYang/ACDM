package com.hq.acdm.controller.index;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.index.CompanyDuty;
import com.hq.acdm.service.index.CompanyDutyService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.index.CompanyDutyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiFaQiang
 * @date 2018/10/22 15:37
 * @Description
 */
@Api(description = "公司值班录入")
@RestController
@RequestMapping("/index/CompanyDuty")
public class CompanyDutyController {
    @Resource
    private CompanyDutyService companyDutyService;

    @ApiOperation(httpMethod = "POST", value = "公司值班录入——新增", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "insert.json", method = RequestMethod.POST)
    public ServerResponse insert(CompanyDutyVo record){
        CompanyDuty model = new CompanyDuty();
        model.setDutyDate(DateTimeUtil.strToDate(record.getDutyDate(),"yyyy-MM-dd"));
        model.setHqCompanyDuty(record.getHqCompanyDuty());
        model.setAocManager(record.getAocManager());
        model.setAocExternalManager(record.getAocExternalManager());
        model.setAocInternalManager(record.getAocInternalManager());
        model.setFlightAreaDuty(record.getFlightAreaDuty());
        model.setOperator(record.getOperator());
        model.setOperateIp(record.getOperateIp());
        model.setRemarks(record.getRemarks());
        companyDutyService.insert(model);
        return ServerResponse.createBySuccess();
    }
    @ApiOperation(httpMethod = "POST", value = "公司值班录入——更新", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "update.json", method = RequestMethod.POST)
    public ServerResponse update(CompanyDutyVo record){
        CompanyDuty model = new CompanyDuty();
        model.setId(new BigDecimal(record.getId()));
        model.setDutyDate(DateTimeUtil.strToDate(record.getDutyDate(),"yyyy-MM-dd"));
        model.setHqCompanyDuty(record.getHqCompanyDuty());
        model.setAocManager(record.getAocManager());
        model.setAocExternalManager(record.getAocExternalManager());
        model.setAocInternalManager(record.getAocInternalManager());
        model.setFlightAreaDuty(record.getFlightAreaDuty());
        model.setOperator(record.getOperator());
        model.setOperateIp(record.getOperateIp());
        model.setRemarks(record.getRemarks());
        companyDutyService.updateByPrimaryKeySelective(model);
        return ServerResponse.createBySuccess();
    }
    @ApiOperation(httpMethod = "POST", value = "公司值班录入——删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "delete.json", method = RequestMethod.POST)
    public ServerResponse delete(@RequestParam("id")BigDecimal id) {
        companyDutyService.deleteByPrimaryKey(id);
        return ServerResponse.createBySuccess();
    }
    @ApiOperation(httpMethod = "POST", value = "公司值班录入——查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "getRecords.json", method = RequestMethod.POST)
    public ServerResponse<List<CompanyDutyVo>> getRecordByDate(@ApiParam("值班日期")@RequestParam("dutyDate") String dutyDate) {
        List<CompanyDuty> list = null;
        if(StringUtil.isNotEmpty(dutyDate)){
            list = companyDutyService.getRecordByDate(dutyDate);
        }else{
            list = companyDutyService.getAllRecord();
        }
        List<CompanyDutyVo> listVo = new ArrayList<>();
        if (null!=list){
            for (CompanyDuty model: list) {
                CompanyDutyVo record = new CompanyDutyVo();
                record.setId(model.getId().toString());
                record.setDutyDate(DateTimeUtil.dateToStr(model.getDutyDate(),"yyyy-MM-dd"));
                record.setHqCompanyDuty(model.getHqCompanyDuty());
                record.setAocManager(model.getAocManager());
                record.setAocExternalManager(model.getAocExternalManager());
                record.setAocInternalManager(model.getAocInternalManager());
                record.setFlightAreaDuty(model.getFlightAreaDuty());
                record.setOperator(model.getOperator());
                record.setOperateTime(DateTimeUtil.dateToStr(model.getOperateTime()));
                record.setOperateIp(model.getOperateIp());
                record.setRemarks(model.getRemarks());
                listVo.add(record);
            }
        }
        return ServerResponse.createBySuccess(listVo);
    }
}
