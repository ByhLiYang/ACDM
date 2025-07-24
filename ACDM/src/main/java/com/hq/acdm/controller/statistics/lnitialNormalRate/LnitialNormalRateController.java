package com.hq.acdm.controller.statistics.lnitialNormalRate;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate;
import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate1;
import com.hq.acdm.model.statistics.lnitialNormalRate.LnitialNormalRate2;
import com.hq.acdm.service.statistics.lnitialNormalRate.LnitialNormalRateService;
import com.hq.acdm.util.excel.JxlsBuilder;
import com.hq.acdm.vo.statistics.lnitialNormalRate.LnitialNormalRateVo;
import com.hq.acdm.vo.statistics.lnitialNormalRate.LnitialNormalRateVo2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "始发正常率排名")
@RestController
@RequestMapping("/statisticalReport/originatingNormalRate")
@Slf4j
public class LnitialNormalRateController {
    @Resource
    private LnitialNormalRateService lnitialNormalRateService;

    @ApiOperation(httpMethod = "POST", value = "查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query.json", method = RequestMethod.POST)
    public ServerResponse query(@ApiParam("开始时间") @RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate") String endDate,HttpServletRequest request, HttpServletResponse response) {
        return ServerResponse.createBySuccess(getLnitialNormalRateVo(startDate,endDate));
    }

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/export.json", method = RequestMethod.POST)
    public void export(@ApiParam("开始时间") @RequestParam("startDate") String startDate,
                                @ApiParam("结束时间") @RequestParam("endDate") String endDate,HttpServletRequest request, HttpServletResponse response) throws Exception {
        LnitialNormalRateVo lnrv = getLnitialNormalRateVo(startDate,endDate);
        OutputStream out = response.getOutputStream();
        List al = new ArrayList();
        List al1 = new ArrayList();
        List al2 = new ArrayList();
        List al3 = new ArrayList();
        List al4 = new ArrayList();
        List al5 = new ArrayList();
        for (int i = 0; i < 3; i++) {
            al.add(lnrv.getTableData().getAirline().get(i).get("name"));
            for (int j = 1; j < 8; j++) {
                al.add(lnrv.getTableData().getAirline().get(i).get(lnrv.getTableData().getAirCompany().get(j)));
            }
        }
        for (int i = 0; i < 3; i++) {
            al1.add(lnrv.getTableData1().getAirline().get(i).get("name"));
            for (int j = 1; j < 8; j++) {
                al1.add(lnrv.getTableData1().getAirline().get(i).get(lnrv.getTableData1().getAirCompany().get(j)));
            }
        }
        for (int i = 0; i < 3; i++) {
            al2.add(lnrv.getTableData2().getAirline().get(i).get("name"));
            for (int j = 1; j < 8; j++) {
                al2.add(lnrv.getTableData2().getAirline().get(i).get(lnrv.getTableData2().getAirCompany().get(j)));
            }
        }
        for (int i = 0; i < 3; i++) {
            al3.add(lnrv.getTableData3().getAirline().get(i).get("name"));
            for (int j = 1; j < 8; j++) {
                al3.add(lnrv.getTableData3().getAirline().get(i).get(lnrv.getTableData3().getAirCompany().get(j)));
            }
        }
        for (int i = 0; i < 3; i++) {
            al4.add(lnrv.getTableData4().getAirline().get(i).get("name"));
            for (int j = 1; j < 8; j++) {
                al4.add(lnrv.getTableData4().getAirline().get(i).get(lnrv.getTableData4().getAirCompany().get(j)));
            }
        }
        for (int i = 0; i < 3; i++) {
            al5.add(lnrv.getTableData5().getAirline().get(i).get("name"));
            for (int j = 1; j < 8; j++) {
                al5.add(lnrv.getTableData5().getAirline().get(i).get(lnrv.getTableData5().getAirCompany().get(j)));
            }
        }
        JxlsBuilder jxlsBuilder = JxlsBuilder
                .getBuilder(ResourceUtils.getFile("classpath:template/template.xlsx").getAbsolutePath())
                .out(out)
                .ignoreImageMiss(true)
                .putVar("ac", lnrv.getTableData().getAirCompany())
                .putVar("ac1", lnrv.getTableData1().getAirCompany())
                .putVar("ac2", lnrv.getTableData2().getAirCompany())
                .putVar("ac3", lnrv.getTableData3().getAirCompany())
                .putVar("ac4", lnrv.getTableData4().getAirCompany())
                .putVar("ac5", lnrv.getTableData5().getAirCompany())
                .putVar("al", al)
                .putVar("al1", al1)
                .putVar("al2", al2)
                .putVar("al3", al3)
                .putVar("al4", al4)
                .putVar("al5", al5)
                .putVar("lnrList", lnrv.getTableData6())
                .build();
        out.close();
    }

    private LnitialNormalRateVo getLnitialNormalRateVo(String startDate,String endDate){
        List<LnitialNormalRate> lnitialNormalRateList=lnitialNormalRateService.queryLnitialNormalRate(startDate, endDate);

        List<LnitialNormalRate1> lnitialNormalRateList1=lnitialNormalRateService.queryLnitialNormalRate1(startDate, endDate);

        List<LnitialNormalRate2> lnitialNormalRateList2=lnitialNormalRateService.queryLnitialNormalRate2(startDate, endDate);

        String IATA="";
        LnitialNormalRateVo lnitialNormalRateVo=new LnitialNormalRateVo();
        List<LnitialNormalRate> list=new ArrayList<>();
        LnitialNormalRate lnitialNormalRate=new LnitialNormalRate();

        for (int i=0;i<lnitialNormalRateList.size();i++){
            IATA+= lnitialNormalRateList.get(i).getAIRLINE_CODE_IATA();
            lnitialNormalRate.setAIRLINE_CODE_IATA(lnitialNormalRateList.get(i).getAIRLINE_CODE_IATA());
            lnitialNormalRate.setSFS(lnitialNormalRateList.get(i).getSFS());
            lnitialNormalRate.setSFYWS(lnitialNormalRateList.get(i).getSFYWS());
            lnitialNormalRate.setZCS(lnitialNormalRateList.get(i).getZCS());
            list.add(lnitialNormalRate);
            lnitialNormalRate=new LnitialNormalRate();
        }

        if(IATA.indexOf("9C")==-1){
            lnitialNormalRate.setAIRLINE_CODE_IATA("9C");
            lnitialNormalRate.setSFS("0");
            lnitialNormalRate.setSFYWS("0");
            lnitialNormalRate.setZCS("0.00%");
            list.add(lnitialNormalRate);
            lnitialNormalRate=new LnitialNormalRate();
        }
        if(IATA.indexOf("HO")==-1){//表示不包含
            lnitialNormalRate.setAIRLINE_CODE_IATA("HO");
            lnitialNormalRate.setSFS("0");
            lnitialNormalRate.setSFYWS("0");
            lnitialNormalRate.setZCS("0.00%");
            list.add(lnitialNormalRate);
            lnitialNormalRate=new LnitialNormalRate();
        }
        if(IATA.indexOf("CZ")==-1){//表示不包含
            lnitialNormalRate.setAIRLINE_CODE_IATA("CZ");
            lnitialNormalRate.setSFS("0");
            lnitialNormalRate.setSFYWS("0");
            lnitialNormalRate.setZCS("0.00%");
            list.add(lnitialNormalRate);
            lnitialNormalRate=new LnitialNormalRate();
        }
        if(IATA.indexOf("FM")==-1){//表示不包含
            lnitialNormalRate.setAIRLINE_CODE_IATA("FM");
            lnitialNormalRate.setSFS("0");
            lnitialNormalRate.setSFYWS("0");
            lnitialNormalRate.setZCS("0.00%");
            list.add(lnitialNormalRate);
            lnitialNormalRate=new LnitialNormalRate();
        }
        if(IATA.indexOf("MU")==-1){//表示不包含
            lnitialNormalRate.setAIRLINE_CODE_IATA("MU");
            lnitialNormalRate.setSFS("0");
            lnitialNormalRate.setSFYWS("0");
            lnitialNormalRate.setZCS("0.00%");
            list.add(lnitialNormalRate);
            lnitialNormalRate=new LnitialNormalRate();
        }
        if(IATA.indexOf("地服")==-1){//表示不包含
            lnitialNormalRate.setAIRLINE_CODE_IATA("地服");
            lnitialNormalRate.setSFS("0");
            lnitialNormalRate.setSFYWS("0");
            lnitialNormalRate.setZCS("0.00%");
            list.add(lnitialNormalRate);
            lnitialNormalRate=new LnitialNormalRate();
        }
        if(IATA.indexOf("CA")==-1){//表示不包含
            lnitialNormalRate.setAIRLINE_CODE_IATA("CA");
            lnitialNormalRate.setSFS("0");
            lnitialNormalRate.setSFYWS("0");
            lnitialNormalRate.setZCS("0.00%");
            list.add(lnitialNormalRate);
            lnitialNormalRate=new LnitialNormalRate();
        }

        String IATA6="";
        List<LnitialNormalRate1> list1=new ArrayList<>();
        List<LnitialNormalRate1> list2=new ArrayList<>();
        List<LnitialNormalRate1> list3=new ArrayList<>();
        List<LnitialNormalRate1> list4=new ArrayList<>();
        List<LnitialNormalRate1> list5=new ArrayList<>();

        LnitialNormalRate1 lnitialNormalRate1=new LnitialNormalRate1();

        for (int j=0;j<lnitialNormalRateList1.size();j++){
            IATA6+=lnitialNormalRateList1.get(j).getAIRLINE_CODE_IATA();
            if(lnitialNormalRateList1.get(j).getATOT().equals("06")){
                lnitialNormalRate1.setAIRLINE_CODE_IATA(lnitialNormalRateList1.get(j).getAIRLINE_CODE_IATA());
                lnitialNormalRate1.setSFS(lnitialNormalRateList1.get(j).getSFS());
                lnitialNormalRate1.setSFYWS(lnitialNormalRateList1.get(j).getSFYWS());
                lnitialNormalRate1.setZCS(lnitialNormalRateList1.get(j).getZCS());
                list1.add(lnitialNormalRate1);
                lnitialNormalRate1=new LnitialNormalRate1();
            }
            if(lnitialNormalRateList1.get(j).getATOT().equals("07")){
                lnitialNormalRate1.setAIRLINE_CODE_IATA(lnitialNormalRateList1.get(j).getAIRLINE_CODE_IATA());
                lnitialNormalRate1.setSFS(lnitialNormalRateList1.get(j).getSFS());
                lnitialNormalRate1.setSFYWS(lnitialNormalRateList1.get(j).getSFYWS());
                lnitialNormalRate1.setZCS(lnitialNormalRateList1.get(j).getZCS().toString());
                list2.add(lnitialNormalRate1);
                lnitialNormalRate1=new LnitialNormalRate1();
            }
            if(lnitialNormalRateList1.get(j).getATOT().equals("08")){
                lnitialNormalRate1.setAIRLINE_CODE_IATA(lnitialNormalRateList1.get(j).getAIRLINE_CODE_IATA());
                lnitialNormalRate1.setSFS(lnitialNormalRateList1.get(j).getSFS().toString());
                lnitialNormalRate1.setSFYWS(lnitialNormalRateList1.get(j).getSFYWS().toString());
                lnitialNormalRate1.setZCS(lnitialNormalRateList1.get(j).getZCS().toString());
                list3.add(lnitialNormalRate1);
                lnitialNormalRate1=new LnitialNormalRate1();
            }
            if(lnitialNormalRateList1.get(j).getATOT().equals("09")){
                lnitialNormalRate1.setAIRLINE_CODE_IATA(lnitialNormalRateList1.get(j).getAIRLINE_CODE_IATA());
                lnitialNormalRate1.setSFS(lnitialNormalRateList1.get(j).getSFS().toString());
                lnitialNormalRate1.setSFYWS(lnitialNormalRateList1.get(j).getSFYWS().toString());
                lnitialNormalRate1.setZCS(lnitialNormalRateList1.get(j).getZCS().toString());
                list4.add(lnitialNormalRate1);
                lnitialNormalRate1=new LnitialNormalRate1();
            }
            if(lnitialNormalRateList1.get(j).getATOT().equals("10")){
                lnitialNormalRate1.setAIRLINE_CODE_IATA(lnitialNormalRateList1.get(j).getAIRLINE_CODE_IATA());
                lnitialNormalRate1.setSFS(lnitialNormalRateList1.get(j).getSFS().toString());
                lnitialNormalRate1.setSFYWS(lnitialNormalRateList1.get(j).getSFYWS().toString());
                lnitialNormalRate1.setZCS(lnitialNormalRateList1.get(j).getZCS().toString());
                list5.add(lnitialNormalRate1);
                lnitialNormalRate1=new LnitialNormalRate1();
            }
        }


        if(IATA6.indexOf("9C")==-1){//表示不包含
            lnitialNormalRate1.setAIRLINE_CODE_IATA("9C");
            lnitialNormalRate1.setSFS("0");
            lnitialNormalRate1.setSFYWS("0");
            lnitialNormalRate1.setZCS("0.00%");

            list1.add(lnitialNormalRate1);
            list2.add(lnitialNormalRate1);
            list3.add(lnitialNormalRate1);
            list4.add(lnitialNormalRate1);
            list5.add(lnitialNormalRate1);
            lnitialNormalRate1=new LnitialNormalRate1();
        }
        if(IATA6.indexOf("HO")==-1){//表示不包含
            lnitialNormalRate1.setAIRLINE_CODE_IATA("HO");
            lnitialNormalRate1.setSFS("0");
            lnitialNormalRate1.setSFYWS("0");
            lnitialNormalRate1.setZCS("0.00%");

            list1.add(lnitialNormalRate1);
            list2.add(lnitialNormalRate1);
            list3.add(lnitialNormalRate1);
            list4.add(lnitialNormalRate1);
            list5.add(lnitialNormalRate1);

            lnitialNormalRate1=new LnitialNormalRate1();
        }
        if(IATA6.indexOf("CZ")==-1){//表示不包含
            lnitialNormalRate1.setAIRLINE_CODE_IATA("CZ");
            lnitialNormalRate1.setSFS("0");
            lnitialNormalRate1.setSFYWS("0");
            lnitialNormalRate1.setZCS("0.00%");

            list1.add(lnitialNormalRate1);
            list2.add(lnitialNormalRate1);
            list3.add(lnitialNormalRate1);
            list4.add(lnitialNormalRate1);
            list5.add(lnitialNormalRate1);

//            lnitialNormalRate1=new LnitialNormalRate1();
        }
        if(IATA6.indexOf("FM")==-1){//表示不包含
            lnitialNormalRate1.setAIRLINE_CODE_IATA("FM");
            lnitialNormalRate1.setSFS("0");
            lnitialNormalRate1.setSFYWS("0");
            lnitialNormalRate1.setZCS("0.00%");

            list1.add(lnitialNormalRate1);
            list2.add(lnitialNormalRate1);
            list3.add(lnitialNormalRate1);
            list4.add(lnitialNormalRate1);
            list5.add(lnitialNormalRate1);

//            lnitialNormalRate1=new LnitialNormalRate1();
        }
        if(IATA6.indexOf("MU")==-1){//表示不包含
            lnitialNormalRate1.setAIRLINE_CODE_IATA("MU");
            lnitialNormalRate1.setSFS("0");
            lnitialNormalRate1.setSFYWS("0");
            lnitialNormalRate1.setZCS("0.00%");

            list1.add(lnitialNormalRate1);
            list2.add(lnitialNormalRate1);
            list3.add(lnitialNormalRate1);
            list4.add(lnitialNormalRate1);
            list5.add(lnitialNormalRate1);

//            lnitialNormalRate1=new LnitialNormalRate1();
        }
        if(IATA6.indexOf("地服")==-1){//表示不包含
            lnitialNormalRate1.setAIRLINE_CODE_IATA("地服");
            lnitialNormalRate1.setSFS("0");
            lnitialNormalRate1.setSFYWS("0");
            lnitialNormalRate1.setZCS("0.00%");

            list1.add(lnitialNormalRate1);
            list2.add(lnitialNormalRate1);
            list3.add(lnitialNormalRate1);
            list4.add(lnitialNormalRate1);
            list5.add(lnitialNormalRate1);

//            lnitialNormalRate1=new LnitialNormalRate1();
        }
        if(IATA6.indexOf("CA")==-1){//表示不包含
            lnitialNormalRate1.setAIRLINE_CODE_IATA("CA");
            lnitialNormalRate1.setSFS("0");
            lnitialNormalRate1.setSFYWS("0");
            lnitialNormalRate1.setZCS("0.00%");
            list1.add(lnitialNormalRate1);
            list2.add(lnitialNormalRate1);
            list3.add(lnitialNormalRate1);
            list4.add(lnitialNormalRate1);
            list5.add(lnitialNormalRate1);

//            lnitialNormalRate1=new LnitialNormalRate1();
        }

        List<LnitialNormalRate2> list6=new ArrayList<>();
        LnitialNormalRate2 lnitialNormalRate22;

        for (int k=0;k<lnitialNormalRateList2.size();k++){
            lnitialNormalRate22=new LnitialNormalRate2();
            lnitialNormalRate22.setFLIGHT_NO_IATA(lnitialNormalRateList2.get(k).getFLIGHT_NO_IATA());
            lnitialNormalRate22.setDEST_AIRPORT_IATA(lnitialNormalRateList2.get(k).getDEST_AIRPORT_IATA());
            lnitialNormalRate22.setSOBT(lnitialNormalRateList2.get(k).getSOBT());
            lnitialNormalRate22.setZS(lnitialNormalRateList2.get(k).getZS());
            lnitialNormalRate22.setYWS(lnitialNormalRateList2.get(k).getYWS());
            lnitialNormalRate22.setZCS(lnitialNormalRateList2.get(k).getZCS());
            lnitialNormalRate22.setAVG(lnitialNormalRateList2.get(k).getAVG());
            list6.add(lnitialNormalRate22);
        }
        LnitialNormalRateVo2 lnrv = new LnitialNormalRateVo2();
        List<String> airCompany = new ArrayList<>();
        airCompany.add("航空公司");
        List<Map<String,String>> airline = new ArrayList<>();
        Map<String,String> tmp = new HashMap<>();
        Map<String,String> tmp1 = new HashMap<>();
        Map<String,String> tmp2 = new HashMap<>();
        tmp.put("name","始发架次");
        tmp1.put("name","延误架次");
        tmp2.put("name","始发正常率");
        for (LnitialNormalRate lnr : list) {
            airCompany.add(lnr.getAIRLINE_CODE_IATA());
            tmp.put(lnr.getAIRLINE_CODE_IATA(),lnr.getSFS());
            tmp1.put(lnr.getAIRLINE_CODE_IATA(),lnr.getSFYWS());
            tmp2.put(lnr.getAIRLINE_CODE_IATA(),lnr.getZCS());
        }
        airline.add(tmp);
        airline.add(tmp1);
        airline.add(tmp2);
        lnrv.setAirCompany(airCompany);
        lnrv.setAirline(airline);
        lnitialNormalRateVo.setTableData(lnrv);
        lnitialNormalRateVo.setTableData1(voHandle(list1));
        lnitialNormalRateVo.setTableData2(voHandle(list2));
        lnitialNormalRateVo.setTableData3(voHandle(list3));
        lnitialNormalRateVo.setTableData4(voHandle(list4));
        lnitialNormalRateVo.setTableData5(voHandle(list5));
        lnitialNormalRateVo.setTableData6(list6);
        return lnitialNormalRateVo;
    }

    private LnitialNormalRateVo2 voHandle(List<LnitialNormalRate1> list){
        LnitialNormalRateVo2 lnrv = new LnitialNormalRateVo2();
        List<String> airCompany = new ArrayList<>();
        airCompany.add("航空公司");
        List<Map<String,String>> airline = new ArrayList<>();
        Map<String,String> tmp = new HashMap<>();
        Map<String,String> tmp1 = new HashMap<>();
        Map<String,String> tmp2 = new HashMap<>();
        tmp.put("name","始发架次");
        tmp1.put("name","延误架次");
        tmp2.put("name","始发正常率");
        for (LnitialNormalRate1 lnr : list) {
            airCompany.add(lnr.getAIRLINE_CODE_IATA());
            tmp.put(lnr.getAIRLINE_CODE_IATA(),lnr.getSFS());
            tmp1.put(lnr.getAIRLINE_CODE_IATA(),lnr.getSFYWS());
            tmp2.put(lnr.getAIRLINE_CODE_IATA(),lnr.getZCS());
        }
        if(airCompany.indexOf("9C")==-1){
            airCompany.add("9C");
            tmp.put("9C","0");
            tmp1.put("9C","0");
            tmp2.put("9C","0%");
        }
        if(airCompany.indexOf("HO")==-1){
            airCompany.add("HO");
            tmp.put("HO","0");
            tmp1.put("HO","0");
            tmp2.put("HO","0%");
        }
        if(airCompany.indexOf("CZ")==-1){
            airCompany.add("CZ");
            tmp.put("CZ","0");
            tmp1.put("CZ","0");
            tmp2.put("CZ","0%");
        }
        if(airCompany.indexOf("FM")==-1){
            airCompany.add("FM");
            tmp.put("FM","0");
            tmp1.put("FM","0");
            tmp2.put("FM","0%");
        }
        if(airCompany.indexOf("MU")==-1){
            airCompany.add("MU");
            tmp.put("MU","0");
            tmp1.put("MU","0");
            tmp2.put("MU","0%");
        }
        if(airCompany.indexOf("地服")==-1){
            airCompany.add("地服");
            tmp.put("地服","0");
            tmp1.put("地服","0");
            tmp2.put("地服","0%");
        }
        if(airCompany.indexOf("CA")==-1){
            airCompany.add("CA");
            tmp.put("CA","0");
            tmp1.put("CA","0");
            tmp2.put("CA","0%");
        }
        airline.add(tmp);
        airline.add(tmp1);
        airline.add(tmp2);
        lnrv.setAirCompany(airCompany);
        lnrv.setAirline(airline);
        return lnrv;
    }

}
