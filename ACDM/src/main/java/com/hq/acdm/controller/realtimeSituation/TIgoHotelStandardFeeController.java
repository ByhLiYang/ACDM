package com.hq.acdm.controller.realtimeSituation;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.TIgoHotelStandardFee;
import com.hq.acdm.model.realtimeSituation.TSpecialInfo;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.realtimeSituation.SpecialSituationService;
import com.hq.acdm.service.realtimeSituation.TIgoHotelStandardFeeService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.realtimeSituation.SpecialSituationVo;
import com.hq.acdm.vo.realtimeSituation.TIgoHotelStandardFeeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/25 11:23
 * @Description
 */
@Api(description = "地服酒店费用明细")
@RestController
@RequestMapping("/realtimeSituation/igoHotelStandardFee")
public class TIgoHotelStandardFeeController {

    @Resource
    private TIgoHotelStandardFeeService tIgoHotelStandardFeeService;
    @Resource
    private SysCacheService sysCacheService;

    @Resource
    private FltMonitorService fltMonitorService;

    @ApiOperation(httpMethod = "POST", value = "地服酒店新增", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public ServerResponse insert(@ApiParam("地服酒店新增")
                                     @RequestBody String AddDataObject,
                                     HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException{
        JSONObject j=new JSONObject(AddDataObject);

        TIgoHotelStandardFee specialInfo = new TIgoHotelStandardFee();
        specialInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
        specialInfo.setHotelName(j.optString("hotelName"));
        specialInfo.setHotelAddres(j.optString("hotelAddres"));
        specialInfo.setHotelTel(j.optString("hotelTel"));
        specialInfo.setHotelManagerTel(j.optString("hotelManagerTel"));
        specialInfo.setNameOfPartyB(j.optString("nameOfPartyB"));
        specialInfo.setAgreementStartDate(DateTimeUtil.strToDate2(j.optString("agreementStartDate")));
        specialInfo.setAgreementEndDate(DateTimeUtil.strToDate2(j.optString("agreementEndDate")));
        specialInfo.setBed(StringUtil.isNotEmpty2(j.optString("bed"))?j.optDouble("bed"):0.0);
        specialInfo.setHomeBreakfast(StringUtil.isNotEmpty2(j.optString("homeBreakfast"))?j.optDouble("homeBreakfast"):0.0);
        specialInfo.setHomeLunch(StringUtil.isNotEmpty2(j.optString("homeLunch"))?j.optDouble("homeLunch"):0.0);

        specialInfo.setHomeDinner(StringUtil.isNotEmpty2(j.optString("homeDinner"))?j.optDouble("homeDinner"):0.0);
        specialInfo.setInternationalBreakfast(StringUtil.isNotEmpty2(j.optString("internationalBreakfast"))?j.optDouble("internationalBreakfast"):0.0);
        specialInfo.setInternationalLunch(StringUtil.isNotEmpty2(j.optString("internationalLunch"))?j.optDouble("internationalLunch"):0.0);
        specialInfo.setInternationalDinner(StringUtil.isNotEmpty2(j.optString("internationalDinner"))?j.optDouble("internationalDinner"):0.0);
        specialInfo.setNightSnack(StringUtil.isNotEmpty2(j.optString("nightSnack"))?j.optDouble("nightSnack"):0.0);

        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String createUsr = "";
        if (null!=sysUser){
            createUsr=sysUser.getUserId();
        }

        specialInfo.setCreateEmp(createUsr);
        specialInfo.setCreateTm(new Date());
        System.out.println(specialInfo);
        return ServerResponse.createBySuccess(tIgoHotelStandardFeeService.insert(specialInfo));
    }

    @ApiOperation(httpMethod = "POST", value = "地服酒店更新", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse updateByPrimaryKey(@ApiParam("地服酒店更新")
                                             @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response)throws IOException, JSONException, ServletException {
        JSONObject j=new JSONObject(AddDataObject);

        String id=j.optString("id");

        TIgoHotelStandardFee specialInfo = new TIgoHotelStandardFee();
        specialInfo.setId(id);
        specialInfo.setHotelName(j.optString("hotelName"));
        specialInfo.setHotelAddres(j.optString("hotelAddres"));
        specialInfo.setHotelTel(j.optString("hotelTel"));
        specialInfo.setHotelManagerTel(j.optString("hotelManagerTel"));
        specialInfo.setNameOfPartyB(j.optString("nameOfPartyB"));
        specialInfo.setAgreementStartDate(DateTimeUtil.strToDate2(j.optString("agreementStartDate")));
        specialInfo.setAgreementEndDate(DateTimeUtil.strToDate2(j.optString("agreementEndDate")));
       // System.out.println("bed:"+j.optString("bed"));
        specialInfo.setBed(StringUtil.isNotEmpty2(j.optString("bed"))?j.optDouble("bed"):0.0);
        specialInfo.setHomeBreakfast(StringUtil.isNotEmpty2(j.optString("homeBreakfast"))?j.optDouble("homeBreakfast"):0.0);
        specialInfo.setHomeLunch(StringUtil.isNotEmpty2(j.optString("homeLunch"))?j.optDouble("homeLunch"):0.0);

        specialInfo.setHomeDinner(StringUtil.isNotEmpty2(j.optString("homeDinner"))?j.optDouble("homeDinner"):0.0);
        specialInfo.setInternationalBreakfast(StringUtil.isNotEmpty2(j.optString("internationalBreakfast"))?j.optDouble("internationalBreakfast"):0.0);
        specialInfo.setInternationalLunch(StringUtil.isNotEmpty2(j.optString("internationalLunch"))?j.optDouble("internationalLunch"):0.0);
        specialInfo.setInternationalDinner(StringUtil.isNotEmpty2(j.optString("internationalDinner"))?j.optDouble("internationalDinner"):0.0);
        specialInfo.setNightSnack(StringUtil.isNotEmpty2(j.optString("nightSnack"))?j.optDouble("nightSnack"):0.0);

        String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });
        String createUsr = "";
        if (null!=sysUser){
            createUsr=sysUser.getUserId();
        }
        specialInfo.setUpdateEmp(createUsr);
        specialInfo.setUpdateTm(new Date());
        System.out.println(specialInfo);
        return ServerResponse.createBySuccess(tIgoHotelStandardFeeService.updateByPrimaryKey(specialInfo));
    }

    @ApiOperation(httpMethod = "POST", value = "地服酒店删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse deleteByPrimaryKey(@ApiParam("地服酒店删除")
                                                 @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response)throws IOException, JSONException, ServletException {
        JSONObject j=new JSONObject(AddDataObject);

        String id=j.optString("id");
        Users sysUser =null;
        try {
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
            String createUsr = "";
            if (null!=sysUser){
                createUsr=sysUser.getUserId();
            }
            Map<String, Object> queryMap = new HashMap<>();
            queryMap.put("flightId",1);
            queryMap.put("nodeColumn","RMK");
            queryMap.put("value","地服酒店删除");
            queryMap.put("source",id);
            queryMap.put("username",createUsr);
            queryMap.put("filed","RMK");
            fltMonitorService.insertTlocalForprivate(queryMap);
        }catch (Exception ex){}
        return ServerResponse.createBySuccess(tIgoHotelStandardFeeService.deleteByPrimaryKey(id));
    }

    @ApiOperation(httpMethod = "POST", value = "地服酒店查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findIgoHotelInfo.json", method = RequestMethod.POST)
    public ServerResponse findIgoHotelInfo(@ApiParam("地服酒店查询")
                                               @RequestBody String AddDataObject,
                                                     HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        Map<String, Object> queryMap = new HashMap<>();

        JSONObject j=new JSONObject(AddDataObject);

        queryMap.put("tiaojian",j.optString("tiaojian"));

        List<TIgoHotelStandardFeeVO> tSpecialInfoList = tIgoHotelStandardFeeService.findAllTSpecialInfo(queryMap);
        return ServerResponse.createBySuccess(tSpecialInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "鉴权", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/authentication.json", method = RequestMethod.POST)
    public ServerResponse authentication(@ApiParam("鉴权")
                                           @RequestBody String AddDataObject,
                                           HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        Map<String, Object> queryMap = new HashMap<>();

        JSONObject j=new JSONObject(AddDataObject);
        String page=j.optString("page");//页面名
        if (StringUtil.isNotEmpty(page)){
            Users sysUser =null;
            try {
                String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
                String cacheValue = sysCacheService.getFromCache(loginToken);
                 sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
                });
            }catch (Exception ex){}

            String createUsr = "";
            if (null!=sysUser){
                createUsr=sysUser.getUserId();
            }else {
                return ServerResponse.createByLoginExpire();//登录过期
            }
            if ("BKA0032".equals(createUsr)&&"igoHotelStandardFee".equals(page)){
                return ServerResponse.createBySuccess();//地服酒店费用明细页面
            }else if ("BKA0032".equals(createUsr)&&"skFareDetailed".equals(page)){
                return ServerResponse.createBySuccess();//省客费用明细页面
            }else {
                return ServerResponse.createByNotPermission();//无权限操作
            }
        }else {
            return ServerResponse.createByOtherError("无参");
        }


    }

}
