package com.hq.acdm.controller.sysManager;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.TOndutyInfo;
import com.hq.acdm.model.realtimeSituation.TOndutyOrg;
import com.hq.acdm.model.realtimeSituation.TOndutyOrgRoot;
import com.hq.acdm.model.realtimeSituation.TSpecialInfo;
import com.hq.acdm.service.realtimeSituation.SpecialSituationService;
import com.hq.acdm.service.sysManager.OnDutyManageService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.vo.sysManager.OnDutyInfoVo;
import com.hq.acdm.vo.sysManager.OnDutyOrgInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/25 11:23
 * @Description
 */
@Api(description = "值班管理")
@RestController
@RequestMapping("/sysManager/onDutyManage")
public class OnDutyManageController {

    @Resource
    private OnDutyManageService onDutyManageService;
    @Resource
    private SpecialSituationService specialSituationService;

    @ApiOperation(httpMethod = "POST", value = "查询值班机构信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findOnDutyOrgAllInfo.json", method = RequestMethod.POST)
    public ServerResponse findOnDutyOrgAllInfo(
                                             HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> queryMap = new HashMap<>();
        List<OnDutyOrgInfoVo> onDutyOrgInfoList = onDutyManageService.findOnDutyOrgAllInfo(queryMap);
        return ServerResponse.createBySuccess(onDutyOrgInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "查询值班信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findOnDutyAllInfo.json", method = RequestMethod.POST)
    public ServerResponse findOnDutyAllInfo(@RequestParam("startDate") String startDate,
                                            @RequestParam("endDate") String endDate,
                                            @RequestParam("userInfo") String userInfo,
                                            @RequestParam("orgId") String orgId,
                                            @RequestParam("orgType") String orgType,
                                            HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startDate",startDate);
        queryMap.put("endDate",endDate);
        queryMap.put("userInfo",userInfo);
        queryMap.put("orgId",orgId);
        queryMap.put("orgType",orgType);
        List<OnDutyInfoVo> onDutyOrgInfoList = onDutyManageService.findOnDutyAllInfo(queryMap);
        return ServerResponse.createBySuccess(onDutyOrgInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "值班机构新增", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertOrg.json", method = RequestMethod.POST)
    public ServerResponse insertOrg(@RequestParam("orgType") String orgType,
                                 @RequestParam("orgName") String orgName,
                                 @RequestParam("orgRootId") String orgRootId,
                                     HttpServletRequest request, HttpServletResponse response) {
        int count = 0;
        if(orgType != null && orgType.equals("1")){
            TOndutyOrgRoot toor = new TOndutyOrgRoot();
            toor.setId(UUID.randomUUID().toString().replaceAll("-",""));
            toor.setOrgName(orgName);
            toor.setSort(0);
            toor.setIsValid("1");
            toor.setCreateEmp("Admin");
            toor.setCreateTm(new Date());
            count = onDutyManageService.insertOndutyRootOrg(toor);
        }
        if(orgType != null && orgType.equals("2")){
            TOndutyOrg too = new TOndutyOrg();
            too.setId(UUID.randomUUID().toString().replaceAll("-",""));
            too.setOrgRootId(orgRootId);
            too.setOrgName(orgName);
            too.setSort(0);
            too.setIsValid("1");
            too.setCreateEmp("Admin");
            too.setCreateTm(new Date());
            count = onDutyManageService.insertOndutyOrg(too);
        }
        return ServerResponse.createBySuccess(count);
    }

    @ApiOperation(httpMethod = "POST", value = "值班机构更新", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateOrg.json", method = RequestMethod.POST)
    public ServerResponse updateOrg(@RequestParam("id") String id,
                                    @RequestParam("orgType") String orgType,
                                     @RequestParam("orgName") String orgName,
                                     @RequestParam("orgRootId") String orgRootId,
                                     HttpServletRequest request, HttpServletResponse response) {
        int count = 0;
        if(orgType != null && orgType.equals("1")){
            TOndutyOrgRoot toor = new TOndutyOrgRoot();
            toor.setId(id);
            toor.setOrgName(orgName);
            toor.setUpdateEmp("Admin");
            toor.setUpdateTm(new Date());
            count = onDutyManageService.updateOndutyRootOrg(toor);
        }
        if(orgType != null && orgType.equals("2")){
            TOndutyOrg too = new TOndutyOrg();
            too.setId(id);
            too.setOrgRootId(orgRootId);
            too.setOrgName(orgName);
            too.setUpdateEmp("Admin");
            too.setUpdateTm(new Date());
            count = onDutyManageService.updateOndutyOrg(too);
        }
        return ServerResponse.createBySuccess(count);
    }

    @ApiOperation(httpMethod = "POST", value = "值班机构新增或修改", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/saveOrUpdateOrg.json", method = RequestMethod.POST)
    public ServerResponse saveOrUpdateOrg(@RequestParam("id") String id,
                                    @RequestParam("orgType") String orgType,
                                    @RequestParam("orgName") String orgName,
                                    @RequestParam("orgRootId") String orgRootId,
                                    HttpServletRequest request, HttpServletResponse response) {
        int count = 0;
        if(orgType != null && orgType.equals("1")){
            if(id == null || "".equals(id)){
                TOndutyOrgRoot toor = new TOndutyOrgRoot();
                toor.setId(UUID.randomUUID().toString().replaceAll("-",""));
                toor.setOrgName(orgName);
                toor.setSort(0);
                toor.setIsValid("1");
                toor.setCreateEmp("Admin");
                toor.setCreateTm(new Date());
                count = onDutyManageService.insertOndutyRootOrg(toor);
            }else{
                TOndutyOrgRoot toor = new TOndutyOrgRoot();
                toor.setId(id);
                toor.setOrgName(orgName);
                toor.setUpdateEmp("Admin");
                toor.setUpdateTm(new Date());
                count = onDutyManageService.updateOndutyRootOrg(toor);
            }

        }
        if(orgType != null && orgType.equals("2")){
            //TOndutyOrg orgVo = onDutyManageService.selectOrgByPrimaryKey(id);
            if(id != null && !"".equals(id)){
                TOndutyOrg too = new TOndutyOrg();
                too.setId(id);
                too.setOrgRootId(orgRootId);
                too.setOrgName(orgName);
                too.setUpdateEmp("Admin");
                too.setUpdateTm(new Date());
                count = onDutyManageService.updateOndutyOrg(too);
            }else{
                TOndutyOrg too = new TOndutyOrg();
                too.setId(UUID.randomUUID().toString().replaceAll("-",""));
                too.setOrgRootId(orgRootId);
                too.setOrgName(orgName);
                too.setSort(0);
                too.setIsValid("1");
                too.setCreateEmp("Admin");
                too.setCreateTm(new Date());
                count = onDutyManageService.insertOndutyOrg(too);
            }

        }
        return ServerResponse.createBySuccess(count);
    }

    @ApiOperation(httpMethod = "POST", value = "值班机构删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteOrg.json", method = RequestMethod.POST)
    public ServerResponse deleteOrg(@RequestParam("orgType") String orgType,
                                     @RequestParam("id") String id,
                                     HttpServletRequest request, HttpServletResponse response) {
        int count = 0;
        if(orgType != null && orgType.equals("1")){
            count = onDutyManageService.deleteOndutyRootOrg(id);
        }
        if(orgType != null && orgType.equals("2")){
            count = onDutyManageService.deleteOndutyOrg(id);
        }
        return ServerResponse.createBySuccess(count);
    }


    @ApiOperation(httpMethod = "POST", value = "值班信息新增或修改", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/saveOrUpdateOndutyInfo.json", method = RequestMethod.POST)
    public ServerResponse saveOrUpdateOndutyInfo(@RequestParam("orgId") String orgId,
                                    @RequestParam("orgName") String orgName,
                                    @RequestParam("emp") String emp,
                                    @RequestParam("tel") String tel,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("ondutyDate") String ondutyDate,
                                    HttpServletRequest request, HttpServletResponse response) {
        int count = 0;
        Map<String,Object> queryMap = new HashMap<String,Object>();
        queryMap.put("orgId",orgId);
        queryMap.put("ondutyDate",ondutyDate);
        queryMap.put("emp",emp);
        queryMap.put("phone",phone);
        queryMap.put("tel",tel);
        TOndutyInfo tOndutyInfo = onDutyManageService.findTOndutyInfo(queryMap);
        if(tOndutyInfo == null){
            TOndutyInfo vo = new TOndutyInfo();
            vo.setId(UUID.randomUUID().toString().replaceAll("-",""));
            vo.setOrgId(orgId);
            vo.setOrgName(orgName);
            vo.setOndutyEmpId("");
            vo.setOndutyEmp(emp);
            vo.setTel(tel);
            vo.setMobilePhone(phone);
            vo.setOndutyTime(DateTimeUtil.strToDate(ondutyDate,"yyyy-MM-dd"));
            count = onDutyManageService.insertOndutyInfo(vo);
        }else{
            count = onDutyManageService.updateByOrgIdAndOndutyDate(queryMap);
        }

        return ServerResponse.createBySuccess(count);
    }


    @ApiOperation(httpMethod = "POST", value = "值班人员信息下拉框", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findOnDutyUser.json", method = RequestMethod.POST)
    public ServerResponse findOnDutyUser(@RequestParam("orgName") String orgName,
                                    HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> queryMap = new HashMap<String,Object>();
        //orgName = new String(orgName.getBytes("ISO-8859-1"), "UTF-8");
        if("中心值班".equals(orgName)){
            orgName = "运行指挥中心";
        }
        if("运控值班".equals(orgName)){
            orgName = "机场运控中心";
        }
        queryMap.put("orgName",orgName);
        return ServerResponse.createBySuccess(onDutyManageService.findOnDutyUser(queryMap));
    }

}
