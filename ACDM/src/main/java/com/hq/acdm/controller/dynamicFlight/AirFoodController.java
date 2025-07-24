package com.hq.acdm.controller.dynamicFlight;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.THotelInfo;
import com.hq.acdm.model.realtimeSituation.TMultiDatasourceRecord;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.dynamicFlight.AirFoodService;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.dynamicFlight.FltSearchService;
import com.hq.acdm.util.*;
import com.hq.acdm.vo.dynamicFlight.*;
import com.hq.acdm.vo.sysManager.HotelInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;
import org.codehaus.jackson.type.TypeReference;
import org.jfree.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 09:10
 * @Description
 */
@Api(description = "东航航食")
@RestController
@RequestMapping("/dynamicFlight/AirFood")
public class AirFoodController {

    @Resource
    private AirFoodService airFoodService;


    @ApiOperation(httpMethod = "POST", value = "东航航班航食列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getAirFoodFltInfo.json", method = RequestMethod.POST)
    public ServerResponse getAirFoodFltInfo(@ApiParam("东航航班航食列表")
                                         @RequestBody String AddDataObject,
                         HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException, ServletException {

       /* String loginToken = CookieUtil.readLoginToken(request, CookieUtil.COOKIE_SESSION_NAME);
        String cacheValue = sysCacheService.getFromCache(loginToken);
        Users sysUser = JsonMapper.string2Obj(cacheValue, new TypeReference<Users>() {
        });*/

        JSONObject j=new JSONObject(AddDataObject);
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("startTime",j.optString("startTime"));
        String sortad=j.optString("sortad");
        if (StringUtil.isEmpty(sortad)){
            sortad="AT";
        }
        queryMap.put("sortad",sortad);
        queryMap.put("flno",j.optString("flno"));
        queryMap.put("airlines",j.optString("airlines"));
        String agent=j.optString("agent");
        if (StringUtil.isNotEmpty(agent)){
            java.util.List<String> col =new ArrayList();
            String condition = "";
            //用户为地服用户时，设置查询条件

            if (agent.contains("DF")){
                condition= ConstantUtil.IGO+",";
            }
            //用户为国航用户时，设置查询条件
            if (agent.contains("GH")){
                if (agent.contains("DF")){
                    condition=condition.replace(ConstantUtil.CCA+",","");
                }else
                    condition+= ConstantUtil.CCA+",";
            }
            //用户为南航用户时，设置查询条件
            if (agent.contains("NH")){
                if (agent.contains("DF")){
                    condition=condition.replace(ConstantUtil.CSN+",","");
                }else
                    condition+= ConstantUtil.CSN+",";
            }
            //用户为东航用户时，设置查询条件
            if (agent.contains("DH")){
                if (agent.contains("DF")){
                    condition=condition.replace(ConstantUtil.CES+",","");
                }else
                    condition+= ConstantUtil.CES+",";
            }
            //用户为货运用户时，设置查询条件
            if (agent.contains("HY")){
                if (agent.contains("DF")){
                    condition=condition.replace(ConstantUtil.AIRLINES_HUO_YUN+",","");
                }else
                    condition+= ConstantUtil.AIRLINES_HUO_YUN+",";
            }
            if (agent.contains("DF")&&agent.contains("GH")&&agent.contains("NH")&&agent.contains("DH")){
                agent= "";
            }
            if (agent.contains("DF")){
                agent= "IGO";
            }
            if (!"".equals(condition)){
                condition=condition.substring(0,condition.length()-1);
            }

            queryMap.put("agent",agent);
            queryMap.put("dept",agent);
            queryMap.put("agentSys",condition);
                /*queryMap.put("flight_no_iata2", agent);
                String str[]=agent.split(",");
                for(int i=0;i<str.length;i++){
                    col.add(str[i]);
                }
                queryMap.put("list", col);
                <if test="params.flight_no_iata2 != null and params.flight_no_iata2 != ''"><!--多选-->
      and  (T.AIRLINES in
      <foreach collection="params.list" item="item" index="index" open="(" close=")" separator=",">
        #{item}
      </foreach>

      )
    </if>
                */

        }

        List<AirFoodFlightInfoVo> tLocalFlightInfoList = airFoodService.findAirFoodFltInfo(queryMap);
        return ServerResponse.createBySuccess(tLocalFlightInfoList);
    }



    @ApiOperation(httpMethod = "POST", value = "餐食计划信息导入", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/importHotelInfo.json", method = RequestMethod.POST)
    public ServerResponse importHotelInfo(@ApiParam("餐食计划信息导入")
                                          @RequestParam(value="file", required=false) MultipartFile file,
                                          @RequestParam(value="username", required=false) String username,
                                          @RequestParam(value="year") String year,
                                          @RequestParam(value="quarter") String quarter,
                                          HttpServletRequest request, HttpServletResponse response) {
        String msg = "";
        //String templateFile = request.getSession().getServletContext().getRealPath("/src/main/resources/template");

        try {
            //String templateFile =ResourceUtils.getFile("classpath:template").getAbsolutePath();
            if (null == file&&false) {
                msg = "导入文件为空!!";
                return ServerResponse.createByOtherError(msg);
            } else {
                /*String fileName = file.getOriginalFilename();
                if (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx") && !fileName.endsWith(".xlsm")) {
                    msg = "文件类型错误，导入文件仅允许excel文件类型!!";
                    return ServerResponse.createByOtherError(msg);
                }else*/
                    if(StringUtil.isEmpty(username)||StringUtil.isEmpty(year)||StringUtil.isEmpty(quarter)||!"1,2,3,4".contains(quarter)){
                    msg = "用户名或年或季度参数异常!!";
                    Log.info("用户名或年或季度参数异常!!"+username+"-"+year+"-"+quarter);
                    return ServerResponse.createByOtherError(msg);
                }else{

                    InputStream is = new FileInputStream(ResourceUtils.getFile("classpath:template").getAbsolutePath() + "/csConfig.xml");

                    InputStream inputXML = new BufferedInputStream(is);

                    XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
                        InputStream  inputXLS=null;
                    if (file!=null){
                         inputXLS = new BufferedInputStream(file.getInputStream());
                    }else {
                         inputXLS = new BufferedInputStream(request.getInputStream());
                    }

                    List<AirPlanFoodVo> airPlanFoodList = new ArrayList<>();
                    Map<String, Object> beans = new HashMap();
                    beans.put("airPlanFoodList", airPlanFoodList);
                    XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
                    Date today=new Date();
                    String [] ss=new String[3];
                    String yearQ=year.trim()+"-"+quarter.trim();
                    int s=0;
                    List<AirPlanFoodVo> airPlanFoodListADD = new ArrayList<>();
                    if(airPlanFoodList != null && airPlanFoodList.size()>0){

                        airFoodService.deleteByPrimaryKey(yearQ,username);
                        StringBuilder flnos=new StringBuilder("");

                        for(int i=0;i<airPlanFoodList.size();i++){
                            AirPlanFoodVo vo = airPlanFoodList.get(i);
                            if (!flnos.toString().contains(vo.getFlno().trim())){
                                AirPlanFoodVo airPlanFoodInfo = new AirPlanFoodVo();
                                //airPlanFoodInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
                                airPlanFoodInfo.setFlno(vo.getFlno().trim());
                                airPlanFoodInfo.setCreateTm(today);
                                airPlanFoodInfo.setCreateUsr(username);
                                airPlanFoodInfo.setQuarter(yearQ);
                                airPlanFoodListADD.add(airPlanFoodInfo);
                                //airFoodService.insert(airPlanFoodInfo);
                            }
                            flnos.append(vo.getFlno().trim()+",");


                        }

                        airFoodService.addTaxiTimeVarBatch(airPlanFoodListADD);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "系统读写文件错误，请稍后再试!!";
            return ServerResponse.createByOtherError(msg);
        }
        return ServerResponse.createBySuccess();
    }

}
