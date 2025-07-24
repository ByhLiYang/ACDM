package com.hq.acdm.controller.effectAnalysis;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.effectAnalysis.InsufficientTTTService;
import com.hq.acdm.service.realtimeSituation.FlightIndexService;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.util.*;
import com.hq.acdm.vo.dynamicFlight.*;
import com.hq.acdm.vo.effectAnalysis.DelayedAnlssVo;
import com.hq.acdm.vo.effectAnalysis.EffectiveneVo;
import com.hq.acdm.vo.effectAnalysis.FltDelayVo;
import com.hq.acdm.vo.effectAnalysis.InsufficientTTTVo;
import com.hq.acdm.vo.realtimeSituation.FltDetailIdxVo;
import com.hq.acdm.vo.realtimeSituation.FltRlsIdxVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "效能分析")
@RestController
@Slf4j
@RequestMapping("/effectAnalysis/insufficientTTT")
public class InsufficientTTTController {

    @Resource
    private FlightIndexService flightIndexService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;
    @Resource
    private InsufficientTTTService insufficientService;

    @ApiOperation(httpMethod = "POST", value = "过站不足列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectGZBZ.json", method = RequestMethod.POST)
    public ServerResponse selectGZBZ(@ApiParam("过站不足列表")
                                         @RequestParam("execDate") String execDate,
                                     @RequestParam("agent") String agent,
                         HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        String execDateS=execDate.replace("-","");
        queryMap.put("execDate",execDateS);
        queryMap.put("agent",agent);
        List<InsufficientTTTVo> insufficientTTTVoList=null;
        if(StringUtil.isNotEmpty(execDate)){
            if(!execDate.contains("-")){
                execDate=execDate.substring(0,4)+"-"+execDate.substring(4,6)+"-"+execDate.substring(6);
            }

            String returnTime= DateTimeUtil.reDayFormatByStr(execDate+" 00:00:00");
            System.out.println("时间"+returnTime);
            if(returnTime.contains("-")&&Long.parseLong(returnTime.substring(returnTime.indexOf("-")+1))>7){

                insufficientTTTVoList = insufficientService.selectGZBZHis(queryMap);
            }
            else {
                insufficientTTTVoList = insufficientService.selectGZBZ(queryMap);
            }
        }


        return ServerResponse.createBySuccess(insufficientTTTVoList);
    }


    @ApiOperation(httpMethod = "GET", value = "效能分析主页查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/effectivene.json", method = RequestMethod.GET)
    public ServerResponse effectivene(@ApiParam("效能分析主页查询")
                                         HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> queryMap = new HashMap<>();
        EffectiveneVo effectiveneVo=new EffectiveneVo();
        try {
            /*JSONObject j=new JSONObject(AddDataObject);
            String dora=j.optString("dora");//页面名
            if (StringUtil.isEmpty(dora))dora="D";*/
            String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
            String cacheValue = sysCacheService.getFromCache(loginToken);
            Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
            });
            String condition = "";
            String dept = "";
            if(sysUser != null){
                dept = UsersService.findDepartment(sysUser.getEmployeeId());
                //用户为地服用户时，设置查询条件
                if ("IGO".equals(dept)){
                    condition= ConstantUtil.IGO;
                }
                //用户为国航用户时，设置查询条件
                if ("CCA".equals(dept)){
                    condition= ConstantUtil.CCA;
                }
                //用户为南航用户时，设置查询条件
                if ("CSN".equals(dept)){
                    condition= ConstantUtil.CSN;
                }
                //用户为东航用户时，设置查询条件
                if ("CES".equals(dept)){
                    condition= ConstantUtil.CES;
                }
            }
            queryMap.put("dept",dept);
            queryMap.put("agent",condition);
            FltRlsIdxVo vo = flightIndexService.findFltRlsIdx(queryMap);
            if (vo!=null){
                //机场正常性=起飞正常率*0.3+放行正常率*0.7
                BigDecimal ariNom = new BigDecimal(vo.getZCL()).multiply(new BigDecimal("0.3"))
                        .add(new BigDecimal(vo.getFXL()).multiply(new BigDecimal("0.7")))
                        .setScale(2, BigDecimal.ROUND_HALF_UP);
                effectiveneVo.setFxl(vo.getFXL());//起飞正常率
                effectiveneVo.setZcl(vo.getZCL());//放行放行率
                effectiveneVo.setAriNom(ariNom.doubleValue());
            }
            //始发正常性
            effectiveneVo.setAfxl(new BigDecimal(insufficientService.getFltNormIdxByD(queryMap)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            //进港正常性
            effectiveneVo.setDzcl(new BigDecimal(insufficientService.getFltNormIdxByA(queryMap)*100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

             //离港概况
            List<FltDetailIdxVo> listD=flightIndexService.findDFltDetailIdx(queryMap);
            for (int i = 0; i <listD.size() ; i++) {
                FltDetailIdxVo dgj=listD.get(i);
                if ("国内".equals(dgj.getAttribute())){
                    effectiveneVo.setPlanHomeD(dgj.getPlan());
                    effectiveneVo.setActualHomeD(dgj.getActual());
                }else  if ("国际".equals(dgj.getAttribute())){
                    effectiveneVo.setPlanInlD(dgj.getPlan());
                    effectiveneVo.setActualInlD(dgj.getActual());
                }else  if ("合计".equals(dgj.getAttribute())){
                    effectiveneVo.setPlanD(dgj.getPlan());
                    effectiveneVo.setActualD(dgj.getActual());
                    effectiveneVo.setDelayD(dgj.getDelay());
                }
            }
            //进港概况
            List<FltDetailIdxVo> listA=flightIndexService.findAFltDetailIdx(queryMap);
            for (int i = 0; i <listA.size() ; i++) {
                FltDetailIdxVo agj=listA.get(i);
                if ("国内".equals(agj.getAttribute())){
                    effectiveneVo.setPlanHomeA(agj.getPlan());
                    effectiveneVo.setActualHomeA(agj.getActual());
                }else  if ("国际".equals(agj.getAttribute())){
                    effectiveneVo.setPlanInlA(agj.getPlan());
                    effectiveneVo.setActualInlA(agj.getActual());
                }else  if ("合计".equals(agj.getAttribute())){
                    effectiveneVo.setPlanA(agj.getPlan());
                    effectiveneVo.setActualA(agj.getActual());
                    effectiveneVo.setDelayA(agj.getDelay());
                }
            }
            //流量概况
            effectiveneVo.setLlgkD(insufficientService.getAllFlightD(queryMap));
            effectiveneVo.setLlgkA(insufficientService.getAllFlightA(queryMap));

            //延误时长
            FltDelayVo fvo=insufficientService.selectFltDelay();
            effectiveneVo.setYwywsc(fvo.getYwywsc());
            effectiveneVo.setYw015(fvo.getYw015());
            effectiveneVo.setYw1530(fvo.getYw1530());
            effectiveneVo.setYw3060(fvo.getYw3060());
            effectiveneVo.setYw60120(fvo.getYw60120());
            effectiveneVo.setYw120(fvo.getYw120());
            effectiveneVo.setYwywsl(fvo.getYwywsl());

            //延误原因
            effectiveneVo.setYwyy(insufficientService.selectYWType());

            //过站不足
            queryMap.put("execDate",DateTimeUtil.dateToStr2(new Date()).replace("-",""));
            queryMap.put("agent",null);
            List<InsufficientTTTVo> insufficientTTTVoList=insufficientService.selectGZBZ(queryMap);
            effectiveneVo.setGzbu(insufficientTTTVoList);
        }catch (Exception ex){
            log.debug("effectivene错误日志:"+ex.getMessage());
        }


        return ServerResponse.createBySuccess(effectiveneVo);
    }

}
