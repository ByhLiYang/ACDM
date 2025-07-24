package com.hq.acdm.controller.effectAnalysis;


import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.TFlightSupportRecord;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.RedisSentinelPool;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.effectAnalysis.AbnormalService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.util.excel.JxlsBuilder;
import com.hq.acdm.vo.dynamicFlight.TEnvelopeMsgVo;
import com.hq.acdm.vo.dynamicFlight.TLocalFlightInfoVo;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "异常分析")
@Slf4j
@RestController
@RequestMapping("/effectAnalysis/abnormal")
public class AbnormalController {

    @Resource
    private AbnormalService abnormalService;

    @Resource
    private SysCacheService sysCacheService;

    @ApiOperation(httpMethod = "POST", value = "异常分析列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getAbnormal.json", method = RequestMethod.POST)
    public ServerResponse getFltInfo(@ApiParam("异常分析控列表")
                                     @RequestParam("startDate") String startDate,
                                     @RequestParam("endDate") String endDate,
                                     @RequestParam("flno") String flno, @RequestParam("airlines") String airlines,
                                     @RequestParam("atype") String atype,@RequestParam("agent") String agent,
                                     HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("flno",flno);
        queryMap.put("airlines",airlines);
        queryMap.put("atype","NA");
        if (StringUtil.isNotEmpty(atype))
            queryMap.put("atype",atype);
        queryMap.put("agent",agent);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String now=sdf.format(new Date());
        try{
            now=DateTimeUtil.plusDay(-1,now,"yyyy-MM-dd");
        }catch (ParseException e){
        }
        queryMap.put("startDate",now);
        queryMap.put("endDate",now);
        if (StringUtil.isNotEmpty(startDate)&&StringUtil.isEmpty(endDate)){
            endDate=startDate;
        }
        if (StringUtil.isNotEmpty(endDate)&&StringUtil.isEmpty(startDate)){
            startDate=endDate;
        }
        if (StringUtil.isNotEmpty(startDate))
            queryMap.put("startDate",startDate);
        if (StringUtil.isNotEmpty(endDate))
            queryMap.put("endDate",endDate);
        List<TLocalFlightInfoVo> tLocalFlightInfoList= new ArrayList<TLocalFlightInfoVo>();

        tLocalFlightInfoList = abnormalService.findAbnormal(queryMap,true);

        return ServerResponse.createBySuccess(tLocalFlightInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "异常分析列表导出", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/export.json", method = RequestMethod.POST)
    public void export(@ApiParam("异常分析列表导出")
                                     @RequestParam("startDate") String startDate,
                                     @RequestParam("endDate") String endDate,
                                     @RequestParam("flno") String flno, @RequestParam("airlines") String airlines,
                                     @RequestParam("atype") String atype,@RequestParam("agent") String agent,
                                     HttpServletRequest request, HttpServletResponse response)  throws Exception{
        Map<String, Object> queryMap = new HashMap<>();
        OutputStream out = response.getOutputStream();
        queryMap.put("flno",flno);
        queryMap.put("airlines",airlines);
        queryMap.put("atype","NA");
        if (StringUtil.isNotEmpty(atype))
            queryMap.put("atype",atype);
        String title="晚关门";
        if ("DA".equals(atype))title="延误";
        if ("FA".equals(atype))title="放行延误";
        queryMap.put("agent",agent);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String now=sdf.format(new Date());
        try{
            now=DateTimeUtil.plusDay(-1,now,"yyyy-MM-dd");
        }catch (ParseException e){
        }
        queryMap.put("startDate",now);
        queryMap.put("endDate",now);
        if (StringUtil.isNotEmpty(startDate)&&StringUtil.isEmpty(endDate)){
            endDate=startDate;
        }
        if (StringUtil.isNotEmpty(endDate)&&StringUtil.isEmpty(startDate)){
            startDate=endDate;
        }
        if (StringUtil.isNotEmpty(startDate))
            queryMap.put("startDate",startDate);
        if (StringUtil.isNotEmpty(endDate))
            queryMap.put("endDate",endDate);
        List<TLocalFlightInfoVo> tLocalFlightInfoList= new ArrayList<TLocalFlightInfoVo>();

        tLocalFlightInfoList = abnormalService.findAbnormal(queryMap,false);

        JxlsBuilder jxlsBuilder = JxlsBuilder
                .getBuilder(ResourceUtils.getFile("classpath:template/abnormal.xlsx").getAbsolutePath())
                .out(out)
                .ignoreImageMiss(true)
                .putVar("title",title)
                .putVar("lnrList", tLocalFlightInfoList)
                .build();

        out.close();
    }


    @ApiOperation(httpMethod = "POST", value = "添加航班保障记录表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertFlightSupportRecord.json", method = RequestMethod.POST)
    public ServerResponse insertFlightSupportRecord(@ApiParam("添加航班保障记录表")
                                     @RequestParam("flightId") String flightId,
                                     @RequestParam("clean") String clean,
                                     @RequestParam("boarding") String boarding,
                                     @RequestParam("closeDoor") String closeDoor,
                                     @RequestParam("rollOut") String rollOut,
                                     @RequestParam("delayReason") String delayReason,
                                     @RequestParam("remarks") String remarks,
                                     HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("flightId",flightId);
        queryMap.put("clean",clean);
        queryMap.put("boarding",boarding);
        queryMap.put("closeDoor",closeDoor);
        queryMap.put("rollOut",rollOut);
        queryMap.put("delayReason",delayReason);
        queryMap.put("remarks",remarks);

        int i = 0;

        List<TFlightSupportRecord> list = abnormalService.findTFlightSupportRecord(queryMap);
        if(list != null && list.size() > 0){
            TFlightSupportRecord record = list.get(0);
            record.setFlightId(Integer.parseInt(flightId));
            record.setClean(clean);
            record.setBoarding(boarding);
            record.setCloseDoor(closeDoor);
            record.setRollOut(rollOut);
            record.setDelayReason(delayReason);
            record.setRemarks(remarks);
            i = abnormalService.updateTFlightSupportRecord(record);
        }else{
            TFlightSupportRecord record = new TFlightSupportRecord();
            record.setId(UUID.randomUUID().toString().replaceAll("-",""));
            record.setFlightId(Integer.parseInt(flightId));
            record.setClean(clean);
            record.setBoarding(boarding);
            record.setCloseDoor(closeDoor);
            record.setRollOut(rollOut);
            record.setDelayReason(delayReason);
            record.setRemarks(remarks);
            record.setCreateEmp("Admin");
            record.setCreateTime(new Date());
            i = abnormalService.insertTFlightSupportRecord(record);
        }

        return ServerResponse.createBySuccess(i);
    }


    @ApiOperation(httpMethod = "POST", value = "修改航班保障记录表延误原因", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updDelayReasonToSupportRecord.json", method = RequestMethod.POST)
    public ServerResponse updDelayReasonToSupportRecord(@ApiParam("修改航班保障记录表延误原因")
                                                    @RequestParam("flightId") String flightId,
                                                    @RequestParam("delayReason") String delayReason,
                                                    HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("flightId",flightId);
        queryMap.put("delayReason",delayReason);

        int i = 0;

        List<TFlightSupportRecord> list = abnormalService.findTFlightSupportRecord(queryMap);
        if(list != null && list.size() > 0){
            TFlightSupportRecord record = list.get(0);
            record.setFlightId(Integer.parseInt(flightId));
            record.setDelayReason(delayReason);
            i = abnormalService.updateTFlightSupportRecord(record);
        }else{
            TFlightSupportRecord record = new TFlightSupportRecord();
            record.setId(UUID.randomUUID().toString().replaceAll("-",""));
            record.setFlightId(Integer.parseInt(flightId));
            record.setDelayReason(delayReason);
            record.setCreateEmp("Admin");
            record.setCreateTime(new Date());
            i = abnormalService.insertTFlightSupportRecord(record);
        }

        return ServerResponse.createBySuccess(i);
    }


    @ApiOperation(httpMethod = "POST", value = "修改航班保障记录表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateToSupportRecord.json", method = RequestMethod.POST)
    public ServerResponse updateToSupportRecord(@ApiParam("修改航班保障记录表")
                                                        @RequestParam("flightId") String flightId,
                                                        @RequestParam("type") String type,
                                                        @RequestParam("reason") String reason,
                                                        @RequestParam("remarks") String remarks,
                                                        HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("flightId",flightId);
        queryMap.put("reason",reason);
        queryMap.put("remarks",remarks);

        int i = 0;

        List<TFlightSupportRecord> list = abnormalService.findTFlightSupportRecord(queryMap);
        if(list != null && list.size() > 0){
            TFlightSupportRecord record = list.get(0);
            record.setFlightId(Integer.parseInt(flightId));
            if("clean".equals(type)){
                record.setClean(reason);
            }
            if("boarding".equals(type)){
                record.setBoarding(reason);
            }
            if("closeDoor".equals(type)){
                record.setCloseDoor(reason);
            }
            if("rollOut".equals(type)){
                record.setRollOut(reason);
            }
            record.setRemarks(remarks);
            i = abnormalService.updateTFlightSupportRecord(record);
        }else{
            TFlightSupportRecord record = new TFlightSupportRecord();
            record.setId(UUID.randomUUID().toString().replaceAll("-",""));
            record.setFlightId(Integer.parseInt(flightId));
            if("clean".equals(type)){
                record.setClean(reason);
            }
            if("boarding".equals(type)){
                record.setBoarding(reason);
            }
            if("closeDoor".equals(type)){
                record.setCloseDoor(reason);
            }
            if("rollOut".equals(type)){
                record.setRollOut(reason);
            }
            record.setRemarks(remarks);
            record.setCreateEmp("Admin");
            record.setCreateTime(new Date());
            i = abnormalService.insertTFlightSupportRecord(record);
        }

        return ServerResponse.createBySuccess(i);
    }

    @ApiOperation(httpMethod = "POST", value = "查询信封消息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getEnvelopMsg.json", method = RequestMethod.POST)
    public ServerResponse getEnvelopMsg(@ApiParam("查询信封消息")
                                            @RequestBody String AddDataObject,
                                     HttpServletRequest request, HttpServletResponse response)  throws IOException, JSONException, ServletException {

        JSONObject j=new JSONObject(AddDataObject);
        String startDate=j.optString("startDate");
        String endDate=j.optString("endDate");
        String op=j.optString("op");
        String department="1";
        Map<String, Object> queryMap = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String now=sdf.format(new Date());
        Users sysUser =null;
        try{
            now=DateTimeUtil.plusDay(0,now,"yyyy-MM-dd");
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
        }catch (ParseException e){
        }
        List<TEnvelopeMsgVo> tLocalFlightInfoList= new ArrayList<TEnvelopeMsgVo>();
        if (null!=sysUser){
            department=sysUser.getDepartment();
        }else {
            return ServerResponse.createBySuccess(tLocalFlightInfoList);
        }
        queryMap.put("startDate",now);
        queryMap.put("endDate",now);
        queryMap.put("op",op);
        queryMap.put("department",department);
        if (StringUtil.isNotEmpty(startDate)&&StringUtil.isEmpty(endDate)){
            endDate=startDate;
        }
        if (StringUtil.isNotEmpty(endDate)&&StringUtil.isEmpty(startDate)){
            startDate=endDate;
        }
        if (StringUtil.isNotEmpty(startDate))
            queryMap.put("startDate",startDate);
        if (StringUtil.isNotEmpty(endDate))
            queryMap.put("endDate",endDate);


        tLocalFlightInfoList = abnormalService.getEnvelopMsg(queryMap);
        if (tLocalFlightInfoList!=null&&tLocalFlightInfoList.size()>0){
            for (int i = 0; i <tLocalFlightInfoList.size() ; i++) {
                TEnvelopeMsgVo vo=tLocalFlightInfoList.get(i);
                if ("4".equals(vo.getOp())){
                    vo.setStand(vo.getRmk());
                }
            }
        }


        return ServerResponse.createBySuccess(tLocalFlightInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "10小时内不弹消息确定接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/noMsgIn1Hour.json", method = RequestMethod.POST)
    public ServerResponse noMsgIn1Hour(@ApiParam("10小时内不弹消息确定接口")
                                        @RequestBody String AddDataObject,
                                        HttpServletRequest request, HttpServletResponse response)  throws IOException, JSONException, ServletException {

        JSONObject j=new JSONObject(AddDataObject);
        String flid=j.optString("flid");
        String op=j.optString("op");
        String key=""; int seconds=36000;
        if ("1".equals(op)&&StringUtil.isNotEmpty(flid)){
            key="popupevent1changeevent"+flid;
        }else if ("2".equals(op)&&StringUtil.isNotEmpty(flid)){
            key="popupeventMd52abnormalevent"+flid;
        }else if ("3".equals(op)&&StringUtil.isNotEmpty(flid)){
            key="popupevent3NoGrndTsfTm"+flid;
        }else if ("4".equals(op)&&StringUtil.isNotEmpty(flid)){
            key="popupevent4standRanking"+flid;
        }else if ("5".equals(op)&&StringUtil.isNotEmpty(flid)){
            key="popupevent5LJEvent"+flid;
        }else {
            return ServerResponse.createByParamError();
        }

        Jedis shardedJedis = null;
        Long result = null;
        RedisSentinelPool p=new RedisSentinelPool();
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
        }

        try {
            Map<String, Object> queryMap = new HashMap<>();
            queryMap.put("flid",flid);
            queryMap.put("username",createUsr);
            queryMap.put("op",op);
            int aa=abnormalService.updateMsgUser(queryMap);

            shardedJedis =  p.instance();
            shardedJedis.set(key, "key");
            result = shardedJedis.expire(key, seconds);
            long a=shardedJedis.ttl(key);
            log.info(key+":"+a);


            return ServerResponse.createBySuccess(aa);
        } catch (Exception e) {
            log.error("expire key:{} error",key,e);
            return ServerResponse.createBySystemError();
        } finally {
            p.safeClose(shardedJedis);

        }


    }
}
