package com.hq.acdm.controller.realtimeSituation;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.TIgoHotelStandardFee;
import com.hq.acdm.model.realtimeSituation.TSkFareDetailed;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.realtimeSituation.TIgoHotelStandardFeeService;
import com.hq.acdm.service.realtimeSituation.TSkFareDetailedService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.vo.realtimeSituation.SKVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@Api(description = "省客费用明细")
@RestController
@RequestMapping("/realtimeSituation/skFareDetailed")
public class TSkFareDetailedController {

    @Resource
    private TSkFareDetailedService tSkFareDetailedService;
    @Resource
    private SysCacheService sysCacheService;

    @Resource
    private FltMonitorService fltMonitorService;

    @ApiOperation(httpMethod = "POST", value = "省客费用新增", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public ServerResponse insert(@ApiParam("省客费用新增")
                                     @RequestBody String AddDataObject,
                                     HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException{
        JSONObject j=new JSONObject(AddDataObject);

        TSkFareDetailed specialInfo = new TSkFareDetailed();
        specialInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
        specialInfo.setFareType(j.optString("fareType"));
        specialInfo.setAdep(j.optString("adep"));
        specialInfo.setAdes(j.optString("ades"));
        specialInfo.setFare(StringUtil.isNotEmpty2(j.optString("fare"))?j.optDouble("fare"):0.0);

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
        return ServerResponse.createBySuccess(tSkFareDetailedService.insert(specialInfo));
    }

    @ApiOperation(httpMethod = "POST", value = "省客费用更新", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse updateByPrimaryKey(@ApiParam("省客费用更新")
                                             @RequestBody String AddDataObject,
                                             HttpServletRequest request, HttpServletResponse response)throws IOException, JSONException, ServletException {
        JSONObject j=new JSONObject(AddDataObject);

        String id=j.optString("id");

        TSkFareDetailed specialInfo = new TSkFareDetailed();
        specialInfo.setId(id);
        specialInfo.setFareType(j.optString("fareType"));
        specialInfo.setAdep(j.optString("adep"));
        specialInfo.setAdes(j.optString("ades"));
        specialInfo.setFare(StringUtil.isNotEmpty2(j.optString("fare"))?j.optDouble("fare"):0.0);

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
        return ServerResponse.createBySuccess(tSkFareDetailedService.updateByPrimaryKey(specialInfo));
    }

    @ApiOperation(httpMethod = "POST", value = "省客费用删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse deleteByPrimaryKey(@ApiParam("省客费用删除")
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
            queryMap.put("value","省客费用删除");
            queryMap.put("source",id);
            queryMap.put("username",createUsr);
            queryMap.put("filed","RMK");
            fltMonitorService.insertTlocalForprivate(queryMap);
        }catch (Exception ex){}
        return ServerResponse.createBySuccess(tSkFareDetailedService.deleteByPrimaryKey(id));
    }

    @ApiOperation(httpMethod = "POST", value = "省客费用查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findSkFareDetailedInfo.json", method = RequestMethod.POST)
    public ServerResponse findSkFareDetailedInfo(@ApiParam("省客费用查询")
                                               @RequestBody String AddDataObject,
                                                     HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {
        Map<String, Object> queryMap = new HashMap<>();

        JSONObject j=new JSONObject(AddDataObject);
        SKVo vo=new SKVo();
         ArrayList<TSkFareDetailed> jzs=new ArrayList<TSkFareDetailed>();//机组
         ArrayList<TSkFareDetailed> lks=new ArrayList<TSkFareDetailed>();//旅客
        queryMap.put("tiaojian",j.optString("tiaojian"));
       // queryMap.put("fareType",j.optString("fareType"));
        List<TSkFareDetailed> tSpecialInfoList = tSkFareDetailedService.findAllTSpecialInfo(queryMap);
        if (tSpecialInfoList!=null&&tSpecialInfoList.size()>0){
            for (int i = 0; i <tSpecialInfoList.size() ; i++) {
                TSkFareDetailed v=tSpecialInfoList.get(i);
                if ("1".equals(v.getFareType())){
                    jzs.add(v);
                }
                if ("2".equals(v.getFareType())){
                    lks.add(v);
                }
            }
        }
        vo.setJzs(jzs);
        vo.setLks(lks);
        return ServerResponse.createBySuccess(vo);
    }

}
