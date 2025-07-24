package com.hq.acdm.controller.sysManager;

import com.alibaba.fastjson.JSON;
import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.TAreaStandToAtc;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.coordinatedOprt.FlightWightInfoUpdService;
import com.hq.acdm.service.sysManager.StandManageService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.sysManager.AltStandVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "机位基础信息维护")
@RestController
@RequestMapping("/sysManager/standManage")
public class StandManageController {

    @Resource
    private StandManageService standManageService;

    @Resource
    private SysCacheService sysCacheService;

    @RequestMapping(value = "/findStandBaseInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "获取机位基础信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse findStandBaseInfo(@ApiParam("获取机位基础信息") @RequestBody String AddDataObject,
                                              HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

        JSONArray jsonArray = null;
        JSONObject j=new JSONObject(AddDataObject);
        String stand = j.optString("stand");
        String status = j.optString("status");
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("stand",stand);
        queryMap.put("status",status);
        queryMap.put("isdelete","0");
        List<TAreaStandToAtc> voList = standManageService.findStandBaseInfo(queryMap);
        return ServerResponse.createBySuccess(voList);

    }

    @RequestMapping(value = "/updStandBaseInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "修改机位基础信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse updStandBaseInfo(@ApiParam("修改机位基础信息") @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

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
            //return ServerResponse.createByLoginExpire();
        }
        JSONObject j=new JSONObject(AddDataObject);

        TAreaStandToAtc tasta=new TAreaStandToAtc();
        tasta= JSON.parseObject(j.toString(),TAreaStandToAtc.class);
        tasta.setIsdelete("0");
//        int i = flightWightInfoUpdService.updAirLineInfo(tasta);
        return ServerResponse.createBySuccess(standManageService.updStandBaseInfo(tasta));
    }

    @RequestMapping(value = "/insStandBaseInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "新增机位基础信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse insStandBaseInfo(@ApiParam("新增机位基础信息") @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

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
            //return ServerResponse.createByLoginExpire();
        }
        JSONObject j=new JSONObject(AddDataObject);

        TAreaStandToAtc tasta=new TAreaStandToAtc();
        tasta= JSON.parseObject(j.toString(),TAreaStandToAtc.class);
        tasta.setIsdelete("0");
        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("stand",tasta.getStand());
        queryMap.put("isdelete","0");
        List<TAreaStandToAtc> voList = standManageService.findStandBaseInfo(queryMap);
        boolean istwo0=false;
        int aa=0;
        if (voList!=null&&voList.size()>0){
            for (int i = 0; i <voList.size() ; i++) {
                if ("0".equals(voList.get(i).getIsdelete())){
                    istwo0=true;
                }
            }
            if (istwo0){
                return ServerResponse.createByParamError("机位编号已存在！");
            }else {
                aa= standManageService.updStandBaseInfo(tasta);
            }

        }else {
            aa=standManageService.insStandBaseInfo(tasta);
        }

        return ServerResponse.createBySuccess(aa);

    }

    @RequestMapping(value = "/delStandBaseInfo.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "删除机位基础信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse delStandBaseInfo(@ApiParam("删除机位基础信息") @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
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
            //return ServerResponse.createByLoginExpire();
        }
        JSONObject j=new JSONObject(AddDataObject);
        TAreaStandToAtc tasta=new TAreaStandToAtc();
        tasta= JSON.parseObject(j.toString(),TAreaStandToAtc.class);
        tasta.setIsdelete("1");
        int i = standManageService.updStandBaseInfo(tasta);
        return ServerResponse.createBySuccess(i);

    }

    @RequestMapping(value = "/findRTNStand.json", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(httpMethod = "GET", value = "查询备降机位数量", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse findRTNStand(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        return ServerResponse.createBySuccess(standManageService.selectRTNStand());
    }

    @RequestMapping(value = "/updRTNStand.json", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(httpMethod = "POST", value = "修改备降机位信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse updRTNStand(@ApiParam("修改备降机位信息") @RequestBody String AddDataObject,
                                           HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

        Users sysUser =null;
        try {
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
        }catch (Exception ex){}

        String updUsr = "";
        if (null!=sysUser){
            updUsr=sysUser.getUserId();
        }else {
            //return ServerResponse.createByLoginExpire();
        }
        JSONObject j=new JSONObject(AddDataObject);
        AltStandVo asv=new AltStandVo();
        asv= JSON.parseObject(j.toString(),AltStandVo.class);
        asv.setUpdateUser(updUsr);
        asv.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        int i = flightWightInfoUpdService.updAirLineInfo(tasta);
        return ServerResponse.createBySuccess(standManageService.updRTNStand(asv));
    }

    }
