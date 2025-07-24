package com.hq.acdm.controller.realtimeSituation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.realtimeSituation.SpecialSituationService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.realtimeSituation.SpecialSituationVo;
import com.hq.acdm.model.realtimeSituation.TSpecialInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.UUID;

/**
 * @author LiFaQiang
 * @date 2019/03/25 11:23
 * @Description
 */
@Api(description = "今日特情")
@RestController
@RequestMapping("/realtimeSituation/specialSituation")
public class SpecialSituationController {

    @Resource
    private SpecialSituationService specialSituationService;
    @Resource
    private SysCacheService sysCacheService;

    @ApiOperation(httpMethod = "GET", value = "今日特情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findByTSpecialInfo.json", method = RequestMethod.GET)
    public ServerResponse findByTSpecialInfo(@ApiParam("今日特情")
                                                  HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> returnMap = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        List<SpecialSituationVo> tSpecialInfoList = specialSituationService.findByTSpecialInfo(queryMap);
        List<SpecialSituationVo> tNoticeOfConstructionList = specialSituationService.findByTNoticeOfConstructionInfo(queryMap);
        List<SpecialSituationVo> tNoticeOfGroundingList = specialSituationService.findByTNoticeOfGroundingInfo(queryMap);
        List<SpecialSituationVo> tMdrsList = specialSituationService.findByTMdrsInfo(queryMap);
        List<SpecialSituationVo> tControlInfoList = specialSituationService.findByTControlInfoInfo(queryMap);
        /*
        if(tNoticeOfConstructionList != null && tNoticeOfConstructionList.size()>0){
            for(int i=0;i<tNoticeOfConstructionList.size();i++)
            tSpecialInfoList.add(tNoticeOfConstructionList.get(i));
        }
        if(tNoticeOfGroundingList != null && tNoticeOfGroundingList.size()>0){
            for(int i=0;i<tNoticeOfGroundingList.size();i++)
                tSpecialInfoList.add(tNoticeOfGroundingList.get(i));
        }
        if(tMdrsList != null && tMdrsList.size()>0){
            for(int i=0;i<tMdrsList.size();i++)
                tSpecialInfoList.add(tMdrsList.get(i));
        }
        if(tControlInfoList != null && tControlInfoList.size()>0){
            for(int i=0;i<tControlInfoList.size();i++)
                tSpecialInfoList.add(tControlInfoList.get(i));
        }
        */
        if(tMdrsList != null && tMdrsList.size()>0){
            for(int i=0;i<tMdrsList.size();i++)
                tControlInfoList.add(tMdrsList.get(i));
        }
        returnMap.put("specialInfo",tSpecialInfoList);
        returnMap.put("noticeOfConstruction",tNoticeOfConstructionList);
        returnMap.put("noticeOfGrounding",tNoticeOfGroundingList);
        returnMap.put("controlInfo",tControlInfoList);

        return ServerResponse.createBySuccess(returnMap);
    }

    @ApiOperation(httpMethod = "POST", value = "今日特情新增", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public ServerResponse insert(@ApiParam("今日特情新增")
                                     @RequestParam("infoType") String infoType,
                                     @RequestParam("infoContent") String infoContent,
                                     @RequestParam("infoStarttm") String infoStarttm,
                                     @RequestParam("infoEndtm") String infoEndtm,
                                     /*@RequestParam("createUsr") String createUsr,*/
                                     HttpServletRequest request, HttpServletResponse response) {
        TSpecialInfo specialInfo = new TSpecialInfo();
        specialInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
        specialInfo.setInfoType(infoType);
        specialInfo.setInfoContent(infoContent);
        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String createUsr = "";
        if (null!=sysUser){
            createUsr=sysUser.getUserId();
        }
        if(infoStarttm.length()==16){
            infoStarttm = infoStarttm+":00";
        }
        if(infoEndtm.length()==16){
            infoEndtm = infoEndtm+":00";
        }
        specialInfo.setInfoStarttm(DateTimeUtil.strToDate(infoStarttm));
        specialInfo.setInfoEndtm(DateTimeUtil.strToDate(infoEndtm));
        specialInfo.setCreateUsr(createUsr);
        specialInfo.setCreateTm(new Date());
        return ServerResponse.createBySuccess(specialSituationService.insert(specialInfo));
    }

    @ApiOperation(httpMethod = "POST", value = "今日特情更新", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse updateByPrimaryKey(@ApiParam("今日特情更新")
                                             @RequestParam("id") String id,
                                             @RequestParam("infoType") String infoType,
                                             @RequestParam("infoContent") String infoContent,
                                             @RequestParam("infoStarttm") String infoStarttm,
                                             @RequestParam("infoEndtm") String infoEndtm,
                                             /*@RequestParam("createUsr") String createUsr,*/
                                             HttpServletRequest request, HttpServletResponse response) {
        TSpecialInfo specialInfo = new TSpecialInfo();
        specialInfo.setId(id);
        specialInfo.setInfoType(infoType);
        specialInfo.setInfoContent(infoContent);

        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String createUsr = "";
        if (null!=sysUser){
            createUsr=sysUser.getUserId();
        }
        if(infoStarttm.length()==16){
            infoStarttm = infoStarttm+":00";
        }
        if(infoEndtm.length()==16){
            infoEndtm = infoEndtm+":00";
        }
        specialInfo.setInfoStarttm(DateTimeUtil.strToDate(infoStarttm));
        specialInfo.setInfoEndtm(DateTimeUtil.strToDate(infoEndtm));
        specialInfo.setCreateUsr(createUsr);
        specialInfo.setCreateTm(new Date());
        specialInfo.setCreateTm(new Date());
        return ServerResponse.createBySuccess(specialSituationService.updateByPrimaryKey(specialInfo));
    }

    @ApiOperation(httpMethod = "GET", value = "今日特情删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByPrimaryKey.json", method = RequestMethod.GET)
    public ServerResponse deleteByPrimaryKey(@ApiParam("今日特情删除")
                                             @RequestParam("id") String id,
                                             HttpServletRequest request, HttpServletResponse response) {

        return ServerResponse.createBySuccess(specialSituationService.deleteByPrimaryKey(id));
    }

    @ApiOperation(httpMethod = "POST", value = "今日特情所有信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findAllTSpecialInfo.json", method = RequestMethod.POST)
    public ServerResponse findAllTSpecialInfo(@ApiParam("今日特情所有信息")
                                                     @RequestParam("tiaojian") String tiaojian,
                                                     @RequestParam("start_date") String start_date,
                                                     @RequestParam("end_date") String end_date,
                                                     HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("tiaojian",tiaojian);
        queryMap.put("start_date",start_date);
        queryMap.put("end_date",end_date);
        List<TSpecialInfo> tSpecialInfoList = specialSituationService.findAllTSpecialInfo(queryMap);
        return ServerResponse.createBySuccess(tSpecialInfoList);
    }

}
