package com.hq.acdm.controller.coordinatedOprt;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.coordinatedOprt.DelayedDisposalService;
import com.hq.acdm.service.coordinatedOprt.FlightCutsService;
import com.hq.acdm.service.sys.UsersService;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.util.excel.JxlsBuilder;
import com.hq.acdm.vo.coordinatedOprt.*;
import com.hq.acdm.vo.realtimeSituation.BackVo;
import com.hq.acdm.vo.realtimeSituation.FDelayVo;
import com.hq.acdm.vo.realtimeSituation.FlightDelayVo;
import com.hq.acdm.vo.realtimeSituation.SPassengersVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jxls.expression.JexlExpressionEvaluator;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/06/12 10:25
 * @Description
 */
@Api(description = "延误处置")
@RestController
@RequestMapping("/coordinatedOprt/delayedDisposal")
public class DelayedDisposalController {
    @Resource
    private DelayedDisposalService delayedDisposalService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private UsersService usersService;

    @ApiOperation(httpMethod = "POST", value = "取消航班查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findCnlInfo.json", method = RequestMethod.POST)
    public ServerResponse findCnlInfo(@ApiParam("起始时间") @RequestParam("startTime") String startTime,
                                      @ApiParam("结束时间") @RequestParam("endTime") String endTime,
                                      @ApiParam("结束时间") @RequestParam("status") String status,
                                      HttpServletRequest request, HttpServletResponse response) {

        Map<Object,Object> queryMap = new HashMap<>();
        queryMap.put("startTime",startTime);
        queryMap.put("endTime",endTime);
        queryMap.put("id","");
        queryMap.put("status",status);
        List<DelayedDisposalVo> list=delayedDisposalService.findCnlInfo(queryMap);
        Map<String, Integer> countDear = new HashMap<String, Integer>();
        Map<String, Integer> countHol = new HashMap<String, Integer>();
        for (int i = 0; i < list.size(); i++) {

            String currentStr = list.get(i).getDealId();
            if (StringUtil.isNotEmpty(currentStr)){
                int totalNum = 1;

                if (countDear.containsKey(currentStr)) {
                    totalNum = countDear.get(currentStr) + 1;
                }
                countDear.put(currentStr, totalNum);
            }


            String currentHol = list.get(i).getHotelId();
            if (StringUtil.isNotEmpty(currentHol)){
                int totalHol = 1;
                if (countHol.containsKey(currentHol)) {
                    totalHol = countHol.get(currentHol) + 1;
                }
                countHol.put(currentHol, totalHol);
            }

        }
        System.out.println("countDear"+countDear);
        System.out.println("countHol"+countHol);
        List<DelayedDisposalVo> relist=new ArrayList<DelayedDisposalVo>();
        for (int i = 0; i <list.size() ; i++) {
            DelayedDisposalVo vo=list.get(i);
            vo.setCountDear(0);
            vo.setCountHol(0);
            String currentStr = vo.getDealId();
            if (StringUtil.isNotEmpty(currentStr)&&countDear.containsKey(currentStr)){
                vo.setCountDear(countDear.get(currentStr));
                countDear.remove(currentStr);
            }
            if (StringUtil.isEmpty(currentStr)){
                vo.setCountDear(1);
            }
            String currentHol = vo.getHotelId();
            if (StringUtil.isNotEmpty(currentHol)&&countHol.containsKey(currentHol)){
                vo.setCountHol(countHol.get(currentHol));
                countHol.remove(currentHol);
            }
            if (StringUtil.isEmpty(currentHol)){
                vo.setCountHol(1);
            }
            relist.add(vo);
        }

        return ServerResponse.createBySuccess(relist);
    }
    @ApiOperation(httpMethod = "POST", value = "酒店查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findholInfo.json", method = RequestMethod.POST)
    public ServerResponse findholInfo(@ApiParam("航班主键id") @RequestParam("id") String id,

                                      HttpServletRequest request, HttpServletResponse response) {

        Map<Object,Object> queryMap = new HashMap<>();

        queryMap.put("id",id);

        return ServerResponse.createBySuccess(delayedDisposalService.findholInfo(queryMap));
    }
    @ApiOperation(httpMethod = "POST", value = "巴士查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findbusInfo.json", method = RequestMethod.POST)
    public ServerResponse findbusInfo(@ApiParam("航班主键id") @RequestParam("id") String id,

                                      HttpServletRequest request, HttpServletResponse response) {

        Map<Object,Object> queryMap = new HashMap<>();

        queryMap.put("id",id);
        queryMap.put("status","");
        queryMap.put("startTime","");
        queryMap.put("endTime","");
        return ServerResponse.createBySuccess(delayedDisposalService.findbusInfo(queryMap));
    }


    @ApiOperation(httpMethod = "POST", value = "运控部门操作酒店", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/preservationHolInfo.json", method = RequestMethod.POST)
    public ServerResponse preservationHolInfo(@ApiParam("运控部门操作酒店")
                                                        @RequestBody String AddDataObject) {

        JSONArray jsonArray = null;
       // Date today=new Date();
       // SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
       // String now=format.format(today);


        String isAdd="";

        try {
            JSONObject j=new JSONObject(AddDataObject);
            String remk=j.getString("remk");
            String ID=j.getString("id");
            TCnlDeal vo = new TCnlDeal();
            vo.setId(ID);
            vo.setRemk(remk);
            vo.setUpdateTm(new Date());
            delayedDisposalService.updateDealByPrimaryKeySelective(vo);
            jsonArray = j.getJSONArray("data");
            for(int i=0 ; i < jsonArray.length() ;i++) {
                JSONObject jb = jsonArray.getJSONObject(i);
                TCnlDealHotel record=new TCnlDealHotel();
                isAdd=jb.getString("isAdd");
                if ("I".equals(isAdd)){
                    record.setId(UUID.randomUUID().toString().replace("-",""));
                    record.setEsNumber(jb.getString("esNumber"));
                    record.setDealId(jb.getString("id"));
                    record.setHotelType(jb.getString("hotelType"));
                    record.setEsBusnum(jb.getString("esBusnum"));
                    record.setHotelsName(jb.getString("hotelsName"));
                    record.setBreakfasts(jb.getString("breakfasts"));
                    record.setLunch(jb.getString("lunch"));
                    record.setDinner(jb.getString("dinner"));
                    record.setSnack(jb.getString("snack"));

                    record.setDrinks(jb.getString("drinks"));
                    record.setBreakfastsnum(jb.getString("breakfastsnum"));
                    record.setLunchnum(jb.getString("lunchnum"));
                    record.setDinnernum(jb.getString("dinnernum"));
                    record.setSnacknum(jb.getString("snacknum"));
                    record.setDrinksnum(jb.getString("drinksnum"));
                    record.setCreateTm(new Date());

                    delayedDisposalService.insertHolSelective(record);
                    int busnum=Integer.parseInt(jb.getString("esBusnum"));
                    for (int k = 0; k <busnum ; k++) {
                        TCnlDealBus bus=new TCnlDealBus();
                        bus.setId(UUID.randomUUID().toString().replace("-",""));

                        bus.setHotelId(record.getId());
                        bus.setBusType(jb.getString("hotelType"));
                        bus.setCreateTm(new Date());
                        delayedDisposalService.insertBusSelective(bus);
                    }
                }else if ("U".equals(isAdd)){
                    String id=jb.getString("hid");
                    record.setId(id);
                    record.setEsNumber(jb.getString("esNumber"));
                    record.setHotelType(jb.getString("hotelType"));
                    record.setHotelsName(jb.getString("hotelsName"));

                    record.setBreakfasts(jb.getString("breakfasts"));
                    record.setLunch(jb.getString("lunch"));
                    record.setDinner(jb.getString("dinner"));
                    record.setSnack(jb.getString("snack"));
                    record.setDrinks(jb.getString("drinks"));
                    record.setBreakfastsnum(jb.getString("breakfastsnum"));
                    record.setLunchnum(jb.getString("lunchnum"));
                    record.setDinnernum(jb.getString("dinnernum"));
                    record.setSnacknum(jb.getString("snacknum"));
                    record.setDrinksnum(jb.getString("drinksnum"));
                    record.setUpdateTm(new Date());

                    delayedDisposalService.updateHolByPrimaryKeySelective(record);

                }else if ("D".equals(isAdd)){
                    String id=jb.getString("hid");

                    delayedDisposalService.deleteHolByPrimaryKey(id);

                    delayedDisposalService.deleteBusByHotelIdKey(id);

                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "省客集团修改巴士", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/preservationHolBusInfo.json", method = RequestMethod.POST)
    public ServerResponse preservationHolBusInfo(@ApiParam("省客集团修改巴士")
                                         @RequestBody String AddDataObject) {

        JSONArray jsonArray = null;
        // Date today=new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        // String now=format.format(today);


        String isAdd="";

        try {
            JSONObject j=new JSONObject(AddDataObject);
            String remk=j.getString("remk");
            String ID=j.getString("id");
            TCnlDeal vo = new TCnlDeal();
            vo.setId(ID);
            vo.setRemk(remk);
            vo.setUpdateTm(new Date());
            delayedDisposalService.updateDealByPrimaryKeySelective(vo);
            jsonArray = j.getJSONArray("data");
            for(int i=0 ; i < jsonArray.length() ;i++) {
                JSONObject jb = jsonArray.getJSONObject(i);
                TCnlDealBus bus=new TCnlDealBus();
                isAdd=jb.getString("isAdd");
                if ("U".equals(isAdd)){
                    bus.setId(jb.getString("bid"));
                    bus.setDriver(jb.getString("driver"));
                    bus.setPhone(jb.getString("phone"));
                    bus.setCarReg(jb.getString("carReg"));


                    bus.setUpdateTm(new Date());

                    delayedDisposalService.updateBusByPrimaryKeySelective(bus);


                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "客运部修改巴士", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/preservationBusInfo.json", method = RequestMethod.POST)
    public ServerResponse preservationBusInfo(@ApiParam("省客集团操作酒店")
                                                 @RequestBody String AddDataObject) {

        JSONArray jsonArray = null;
        // Date today=new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        // String now=format.format(today);


        String isAdd="";

        try {
            JSONObject j=new JSONObject(AddDataObject);

            String remk=j.getString("remk");
            String ID=j.getString("id");
            TCnlDeal vo = new TCnlDeal();
            vo.setId(ID);
            vo.setRemk(remk);
            vo.setUpdateTm(new Date());
            delayedDisposalService.updateDealByPrimaryKeySelective(vo);
            jsonArray = j.getJSONArray("data");
            for(int i=0 ; i < jsonArray.length() ;i++) {
                JSONObject jb = jsonArray.getJSONObject(i);
                TCnlDealBus bus=new TCnlDealBus();
                isAdd=jb.getString("isAdd");
                if ("U".equals(isAdd)){
                    bus.setId(jb.getString("bid"));
                    bus.setAcNumber(jb.getString("acNumber"));
                    bus.setStartTime(jb.getString("startTime"));
                    bus.setStaff(jb.getString("staff"));
                    bus.setBstatus(jb.getString("bstatus"));
                    bus.setUpdateTm(new Date());

                    delayedDisposalService.updateBusByPrimaryKeySelective(bus);


                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "延误航班添加", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertTCnlDeal.json", method = RequestMethod.POST)
    public ServerResponse insertTCnlDeal(@RequestParam("cflightId") String cflightId,
                                         @RequestParam("cflno") String cflno,
                                         @RequestParam("cexecdate") String cexecdate,
                                         @RequestParam("csobt") String csobt,
                                         @RequestParam("tstatus") String tstatus,
                                         @RequestParam("ttype") String ttype,
                                         @RequestParam("route") String route,
                                      HttpServletRequest request, HttpServletResponse response) {

        Map<Object,Object> queryMap = new HashMap<>();
        queryMap.put("cflightId",cflightId);
        queryMap.put("ttype",ttype);
        queryMap.put("tstatus",tstatus);
        TCnlDeal tcd = delayedDisposalService.findTCnlDealInfo(queryMap);
        if(tcd != null){
            return ServerResponse.createBySuccess("已存在相关处置！！");
        }else{
            if(csobt != null && !"".equals(csobt)){
                if(csobt.indexOf("(") == -1){
                    csobt = cexecdate + " " + csobt;
                }else{
                    csobt = cexecdate.substring(0,8) + csobt.substring(6,8) + " " + csobt.substring(0,5);
                }
            }
            TCnlDeal vo = new TCnlDeal();
            vo.setId(UUID.randomUUID().toString().replaceAll("-",""));
            vo.setCFlightId(cflightId);
            vo.setCFlno(cflno);
            vo.setCExecDate(cexecdate);
            vo.setCSobt(csobt);
            vo.setCCnlTime(null);
            vo.setPassangerCount("");
            vo.setBaggageCount("");
            vo.setRoute(route);
            vo.setTtype(ttype);
            vo.setTstatus(tstatus);
            vo.setStatus("0");
            vo.setCreateTm(new Date());

            return ServerResponse.createBySuccess(delayedDisposalService.insertDealSelective(vo));

        }


    }

    @ApiOperation(httpMethod = "POST", value = "补班", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/preservationdeaInfo.json", method = RequestMethod.POST)
    public ServerResponse preservationdeaInfo(@ApiParam("补班")
                                              @RequestBody String AddDataObject) {

        JSONArray jsonArray = null;
        // Date today=new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        // String now=format.format(today);


        String isAdd="";

        try {
            JSONObject j=new JSONObject(AddDataObject);
            String fid=j.getString("id");
            Map<Object,Object> queryMap = new HashMap<>();
            //jsonArray = j.getJSONArray("data");
            queryMap.put("fid",fid);
            String tstatus=j.getString("tstatus");
//            if (!"0".equals(tstatus)&&!"1".equals(tstatus)){
//                return ServerResponse.createBySuccess("只有取消,延误才能进行补班！！");
//            }
            TCnlDeal tcd = delayedDisposalService.findFCnlDealInfo(queryMap);

            if(tcd != null){
                return ServerResponse.createBySuccess("已存在相关处置！！");
            }else {
                String cexecdate="";

                String ttype=j.getString("ttype");
                String cSobt=j.getString("cSobt");
                String cFlno=j.getString("cFlno");
                String route=j.getString("route");
                String remk=j.getString("remk");
                if(cSobt != null && !"".equals(cSobt)){
                    cexecdate=cSobt+":00";
                }
                TCnlDeal vo = new TCnlDeal();
                String ID=UUID.randomUUID().toString().replaceAll("-","");
                vo.setId(ID);
                //vo.setCFlightId(cflightId);
                vo.setFid(fid);
                vo.setCFlno(cFlno);
                vo.setCExecDate(cexecdate);
                vo.setCSobt(cSobt);
                vo.setCCnlTime(null);
                vo.setPassangerCount("");
                vo.setBaggageCount("");
                vo.setRoute(route);
                vo.setRemk(remk);
                vo.setTtype(ttype);
                vo.setTstatus(tstatus);
                vo.setStatus("0");
                vo.setCreateTm(new Date());
                delayedDisposalService.insertDealSelective(vo);
                jsonArray = j.getJSONArray("data");

                for(int i=0 ; i < jsonArray.length() ;i++) {
                    JSONObject jb = jsonArray.getJSONObject(i);
                    TCnlDealHotel record=new TCnlDealHotel();
                    //isAdd=jb.getString("isAdd");

                        record.setId(UUID.randomUUID().toString().replace("-",""));
                        record.setEsNumber(jb.getString("esNumber"));
                        record.setDealId(ID);
                        record.setHotelType(jb.getString("hotelType"));
                        record.setEsBusnum(jb.getString("esBusnum"));
                        record.setHotelsName(jb.getString("hotelsName"));
                        record.setCreateTm(new Date());

                        delayedDisposalService.insertHolSelective(record);
                        int busnum=Integer.parseInt(jb.getString("esBusnum"));
                        for (int k = 0; k <busnum ; k++) {
                            TCnlDealBus bus=new TCnlDealBus();
                            bus.setId(UUID.randomUUID().toString().replace("-",""));

                            bus.setHotelId(record.getId());
                            bus.setBusType(jb.getString("hotelType"));
                            bus.setCreateTm(new Date());
                            delayedDisposalService.insertBusSelective(bus);
                        }


                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "修改航班状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateCnlInfo.json", method = RequestMethod.POST)
    public ServerResponse updateCnlInfo(@ApiParam("省客集团操作酒店")
                                              @RequestBody String AddDataObject) {

        JSONArray jsonArray = null;
        // Date today=new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        // String now=format.format(today);


        String isAdd="";

        try {
            JSONObject j=new JSONObject(AddDataObject);

            String status=j.getString("status");
            String ID=j.getString("id");
            TCnlDeal vo = new TCnlDeal();
            vo.setId(ID);
            vo.setStatus(status);
            vo.setUpdateTm(new Date());
            delayedDisposalService.updateDealByPrimaryKeySelective(vo);



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "取消航班查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/export.json", method = RequestMethod.POST)
    public void export(@ApiParam("起始时间") @RequestParam("startTime") String startTime,
                                      @ApiParam("结束时间") @RequestParam("endTime") String endTime,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<Object,Object> queryMap = new HashMap<>();
        queryMap.put("startTime",startTime);
        queryMap.put("endTime",endTime);
        queryMap.put("id","");
        List<DelayedDisposalVo> list=delayedDisposalService.findCnlInfo(queryMap);
        Map<String, Integer> countDear = new HashMap<String, Integer>();
        Map<String, Integer> countHol = new HashMap<String, Integer>();
        for (int i = 0; i < list.size(); i++) {

            String currentStr = list.get(i).getDealId();
            if (StringUtil.isNotEmpty(currentStr)){
                int totalNum = 1;

                if (countDear.containsKey(currentStr)) {
                    totalNum = countDear.get(currentStr) + 1;
                }
                countDear.put(currentStr, totalNum);
            }


            String currentHol = list.get(i).getHotelId();
            if (StringUtil.isNotEmpty(currentHol)){
                int totalHol = 1;
                if (countHol.containsKey(currentHol)) {
                    totalHol = countHol.get(currentHol) + 1;
                }
                countHol.put(currentHol, totalHol);
            }

        }
        System.out.println("countDear"+countDear);
        System.out.println("countHol"+countHol);
        List<DelayedDisposalVo> relist=new ArrayList<DelayedDisposalVo>();
        for (int i = 0; i <list.size() ; i++) {
            DelayedDisposalVo vo=list.get(i);
            vo.setCountDear(0);
            vo.setCountHol(0);
            String currentStr = vo.getDealId();
            if (StringUtil.isNotEmpty(currentStr)&&countDear.containsKey(currentStr)){
                vo.setCountDear(countDear.get(currentStr));
                countDear.remove(currentStr);
            }
            if (StringUtil.isEmpty(currentStr)){
                vo.setCountDear(1);
            }
            String currentHol = vo.getHotelId();
            if (StringUtil.isNotEmpty(currentHol)&&countHol.containsKey(currentHol)){
                vo.setCountHol(countHol.get(currentHol));
                countHol.remove(currentHol);
            }
            if (StringUtil.isEmpty(currentHol)){
                vo.setCountHol(1);
            }
            relist.add(vo);
        }
        if (relist!=null&&relist.size()>0){
            OutputStream out = response.getOutputStream();
            JxlsBuilder jxlsBuilder = JxlsBuilder
                    .getBuilder(ResourceUtils.getFile("classpath:template/delary.xlsx").getAbsolutePath())
                    .out(out)
                    .ignoreImageMiss(true)
                    .putVar("relist", relist)
                    .build();

            out.close();
        }

    }

    @ApiOperation(httpMethod = "POST", value = "返回任务数量", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findCount.json", method = RequestMethod.POST)
    public ServerResponse findCount( @ApiParam("账号") @RequestParam("account") String account,
                                      HttpServletRequest request, HttpServletResponse response) {

        Map<Object,Object> queryMap = new HashMap<>();
        queryMap.put("startTime","2019-01-01 00:00:00");
        queryMap.put("endTime","2069-01-01 00:00:00");
        queryMap.put("id","");
        queryMap.put("status","0");
        List<DelayedDisposalVo> list=delayedDisposalService.findCnlInfoNo(queryMap);
        Users sysUser = usersService.findByUsername(account);
        System.out.println("sysUser:"+sysUser);
        Map<Object,Object> returnMap = new HashMap<>();
        List<DelayedDisposalVo> relist=new ArrayList<DelayedDisposalVo>();
        for (int i = 0; i <list.size() ; i++) {
            DelayedDisposalVo vo=list.get(i);
            vo.setCountDear(0);
            vo.setCountHol(0);

            if(vo.getBid()!=null&&sysUser != null&&
                    (("KY".equals(sysUser.getDept())&&StringUtil.isEmpty(vo.getStartTime()))||
                     ("SK".equals(sysUser.getDept())&&StringUtil.isEmpty(vo.getCarReg()))
                    )){

                relist.add(vo);
            }
        }
        returnMap.put("count",0);
        if(sysUser != null&&relist!=null){
            if ("KY".equals(sysUser.getDept())||"SK".equals(sysUser.getDept())){
                returnMap.put("count",relist.size());
            }
        }

        return ServerResponse.createBySuccess(returnMap);
    }

    @ApiOperation(httpMethod = "POST", value = "取消航班查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findCnlInfoNo.json", method = RequestMethod.POST)
    public ServerResponse findCnlInfoNo(@ApiParam("车牌号") @RequestParam("plateNo") String plateNo,
                                        @ApiParam("账号") @RequestParam("account") String account,
                                      HttpServletRequest request, HttpServletResponse response) {

        Map<Object,Object> queryMap = new HashMap<>();
        queryMap.put("startTime","2019-01-01 00:00:00");
        queryMap.put("endTime","2069-01-01 00:00:00");
        queryMap.put("id","");
        queryMap.put("status","0");

            queryMap.put("flightNo",plateNo);
            queryMap.put("plateNo",plateNo);
        Users sysUser = usersService.findByUsername(account);
        String ac="";
        if(sysUser != null){
            ac=sysUser.getDept();
            queryMap.put("acount",sysUser.getDept());
        }

        List<DelayedDisposalVo> list=delayedDisposalService.findCnlInfoNo(queryMap);
        Map<String, Integer> countDear = new HashMap<String, Integer>();
        Map<String, Integer> countHol = new HashMap<String, Integer>();
        for (int i = 0; i < list.size(); i++) {

            String currentStr = list.get(i).getDealId();
            if (StringUtil.isNotEmpty(currentStr)){
                int totalNum = 1;

                if (countDear.containsKey(currentStr)) {
                    totalNum = countDear.get(currentStr) + 1;
                }
                countDear.put(currentStr, totalNum);
            }


            String currentHol = list.get(i).getHotelId();
            if (StringUtil.isNotEmpty(currentHol)){
                int totalHol = 1;
                if (countHol.containsKey(currentHol)) {
                    totalHol = countHol.get(currentHol) + 1;
                }
                countHol.put(currentHol, totalHol);
            }

        }
        System.out.println("countDear"+countDear);
        System.out.println("countHol"+countHol);
        List<DelayedDisposalVo> relist=new ArrayList<DelayedDisposalVo>();
        for (int i = 0; i <list.size() ; i++) {
            DelayedDisposalVo vo=list.get(i);
            vo.setCountDear(0);
            vo.setCountHol(0);
            String currentStr = vo.getDealId();
            if (StringUtil.isNotEmpty(currentStr)&&countDear.containsKey(currentStr)){
                vo.setCountDear(countDear.get(currentStr));
                countDear.remove(currentStr);
            }
            if (StringUtil.isEmpty(currentStr)){
                vo.setCountDear(1);
            }
            String currentHol = vo.getHotelId();
            if (StringUtil.isNotEmpty(currentHol)&&countHol.containsKey(currentHol)){
                vo.setCountHol(countHol.get(currentHol));
                countHol.remove(currentHol);
            }
            if (StringUtil.isEmpty(currentHol)){
                vo.setCountHol(1);
            }
            vo.setStatus("0");
            if (StringUtil.isNotEmpty(vo.getCarReg())&&"SK".equals(ac)){
                vo.setStatus("1");
            }
            if (StringUtil.isNotEmpty(vo.getStartTime())&&"KY".equals(ac)){
                vo.setStatus("1");
            }
            if(vo.getBid()!=null) relist.add(vo);

        }

        return ServerResponse.createBySuccess(relist);
    }

    @ApiOperation(httpMethod = "POST", value = "APP客运部修改巴士", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/appUpBusInfo.json", method = RequestMethod.POST)
    public ServerResponse appUpBusInfo(@ApiParam("巴士id") @RequestParam("bid") String bid,
                                       @ApiParam("发车时间") @RequestParam("startTime") String startTime,
                                       @ApiParam("实际人数") @RequestParam("acNumber") String acNumber,
                                       @ApiParam("跟车信息") @RequestParam("staff") String staff,
                                       HttpServletRequest request, HttpServletResponse response) {

        JSONArray jsonArray = null;
        // Date today=new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        // String now=format.format(today);

                TCnlDealBus bus=new TCnlDealBus();


                bus.setId(bid);
                bus.setAcNumber(acNumber);
                bus.setStartTime(startTime);
                bus.setStaff(staff);

                bus.setUpdateTm(new Date());

                delayedDisposalService.updateBusByPrimaryKeySelective(bus);


        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "APP省客部修改巴士", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/appUpskBusInfo.json", method = RequestMethod.POST)
    public ServerResponse appUpskBusInfo(@ApiParam("巴士id") @RequestParam("bid") String bid,
                                       @ApiParam("司机") @RequestParam("driver") String driver,
                                       @ApiParam("电话") @RequestParam("phone") String phone,
                                       @ApiParam("车牌") @RequestParam("carReg") String carReg,
                                       HttpServletRequest request, HttpServletResponse response) {

        JSONArray jsonArray = null;
        // Date today=new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        // String now=format.format(today);

        TCnlDealBus bus=new TCnlDealBus();


        bus.setId(bid);
        bus.setDriver(driver);
        bus.setPhone(phone);
        bus.setCarReg(carReg);

        bus.setUpdateTm(new Date());

        delayedDisposalService.updateBusByPrimaryKeySelective(bus);


        return ServerResponse.createBySuccess();
    }

    @ApiOperation(httpMethod = "POST", value = "APP查询巴士", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/appSelectBusInfo.json", method = RequestMethod.POST)
    public ServerResponse appSelectBusInfo(@ApiParam("巴士id") @RequestParam("bid") String bid,
                                         HttpServletRequest request, HttpServletResponse response) {

        return ServerResponse.createBySuccess(delayedDisposalService.selectByPrimaryKey(bid));
    }

    @ApiOperation(httpMethod = "GET", value = "延误处置权限查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/findauth.json", method = RequestMethod.GET)
    public ServerResponse findauth(@ApiParam("用户名") @RequestParam("username") String username) {
        Users sysUser = usersService.findByUsername(username);
        Map<String,String> map = new HashMap<>();
        map.put("auth",sysUser.getDept());
        return ServerResponse.createBySuccess(map);
    }

    @ApiOperation(httpMethod = "POST", value = "智航查询取消航班", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/flightDelayInfo.json", method = RequestMethod.POST)
    public ServerResponse flightDelayInfo(@ApiParam("日期") @RequestParam("flop") String flop,

                                        HttpServletRequest request, HttpServletResponse response) {

        Map<Object,Object> queryMap = new HashMap<>();
        if (StringUtil.isEmpty(flop))flop= DateTimeUtil.dateToStr2(new Date());
        queryMap.put("startTime",flop);

        List<DelayedDisposalVo> list=delayedDisposalService.findCnlInfoByZH(queryMap);

        List<ZHDelayedDisposalVo> relist=new ArrayList<ZHDelayedDisposalVo>();
        for (int i = 0; i < list.size(); i++) {
            DelayedDisposalVo dvo=list.get(i);
            String type="1".equals(dvo.getHotelType())?"机组":"旅客";
            String tstatus="1".equals(dvo.getTstatus())?"延误":"补班";
            if ("0".equals(dvo.getTstatus()))tstatus="取消";
            tstatus=dvo.getRemk()+" "+tstatus;
            String regn=dvo.getStaff();
            String attribute=dvo.getBstatus();
            if ("1".equals(dvo.getHotelType())){
                ZHDelayedDisposalVo zvo=new ZHDelayedDisposalVo();
                zvo.setFlno(dvo.getCFlno());
                zvo.setFlop(flop);
                zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                zvo.setVial(dvo.getRoute());
                zvo.setType(type);
                zvo.setDlreason(tstatus);
                zvo.setRegnumber(regn);
                zvo.setAttribute(attribute);
                zvo.setProjectType("住宿");
                zvo.setProject("机组住宿");
                zvo.setNumber(dvo.getEsNumber());
                zvo.setSupplier(dvo.getHotelsName());
                relist.add(zvo);
                zvo=new ZHDelayedDisposalVo();
                zvo.setFlno(dvo.getCFlno());
                zvo.setFlop(flop);
                zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                zvo.setVial(dvo.getRoute());
                zvo.setType(type);
                zvo.setDlreason(tstatus);
                zvo.setRegnumber(regn);
                zvo.setAttribute(attribute);
                zvo.setProjectType("用车");
                zvo.setProject("机组用车");
                zvo.setNumber(dvo.getEsBusnum());
                zvo.setSupplier("省客");
                relist.add(zvo);
                if ("1".equals(dvo.getBreakfasts())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("早餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getBreakfasts())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("早餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
                if ("1".equals(dvo.getLunch())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("中餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getLunch())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("中餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
                if ("1".equals(dvo.getDinner())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("晚餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getDinner())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("晚餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
                if ("1".equals(dvo.getSnack())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("夜宵");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getSnack())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("夜宵");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
                if ("1".equals(dvo.getDrinks())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("饮料");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getDrinks())){
                     zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("饮料");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
            }

            if ("2".equals(dvo.getHotelType())){
                ZHDelayedDisposalVo zvo=new ZHDelayedDisposalVo();
                zvo.setFlno(dvo.getCFlno());
                zvo.setFlop(flop);
                zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                zvo.setVial(dvo.getRoute());
                zvo.setType(type);
                zvo.setDlreason(tstatus);
                zvo.setRegnumber(regn);
                zvo.setAttribute(attribute);
                zvo.setProjectType("住宿");
                zvo.setProject("旅客住宿");
                zvo.setNumber(dvo.getEsNumber());
                zvo.setSupplier(dvo.getHotelsName());
                relist.add(zvo);
                zvo=new ZHDelayedDisposalVo();
                zvo.setFlno(dvo.getCFlno());
                zvo.setFlop(flop);
                zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                zvo.setVial(dvo.getRoute());
                zvo.setType(type);
                zvo.setDlreason(tstatus);
                zvo.setRegnumber(regn);
                zvo.setAttribute(attribute);
                zvo.setProjectType("用车");
                zvo.setProject("旅客用车");
                zvo.setNumber(dvo.getEsBusnum());
                zvo.setSupplier("省客");
                relist.add(zvo);
                if ("1".equals(dvo.getBreakfasts())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("早餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getBreakfasts())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("早餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
                if ("1".equals(dvo.getLunch())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("中餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getLunch())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("中餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
                if ("1".equals(dvo.getDinner())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("晚餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getDinner())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("晚餐");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
                if ("1".equals(dvo.getSnack())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("夜宵");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getSnack())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("夜宵");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
                if ("1".equals(dvo.getDrinks())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("饮料");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier(dvo.getHotelsName());
                    relist.add(zvo);
                }else  if ("2".equals(dvo.getDrinks())){
                    zvo=new ZHDelayedDisposalVo();
                    zvo.setFlno(dvo.getCFlno());
                    zvo.setFlop(flop);
                    zvo.setAirlineCode(dvo.getCFlno().substring(0,2));
                    zvo.setVial(dvo.getRoute());
                    zvo.setType(type);
                    zvo.setDlreason(tstatus);
                    zvo.setRegnumber(regn);
                    zvo.setAttribute(attribute);
                    zvo.setProjectType("餐饮");
                    zvo.setProject("饮料");
                    zvo.setNumber(dvo.getEsNumber());
                    zvo.setSupplier("机场提供");
                    relist.add(zvo);
                }
            }


        }



        return ServerResponse.createBySuccess(relist);
    }
}
