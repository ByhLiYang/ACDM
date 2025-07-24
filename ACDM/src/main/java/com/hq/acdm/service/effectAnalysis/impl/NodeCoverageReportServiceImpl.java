package com.hq.acdm.service.effectAnalysis.impl;


import com.hq.acdm.dao.effectAnalysis.NodeCoverageReportMapper;
import com.hq.acdm.service.effectAnalysis.NodeCoverageReportService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.vo.effectAnalysis.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;


/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class NodeCoverageReportServiceImpl implements NodeCoverageReportService {

    @Resource
    private NodeCoverageReportMapper nodeCoverageReportMapper;


    @Override
    public List<NodeCoverageReportVo> findNodeCoverageA(Map params) {
        return nodeCoverageReportMapper.findNodeCoverageA(params);
    }

    @Override
    public List<NodeCoverageReportVo> findNodeCoverageD(Map params) {
        return nodeCoverageReportMapper.findNodeCoverageD(params);
    }

    @Override
    public List<NodeCoverageReportVo> findNodeCoverageDandA(Map params) {
        return nodeCoverageReportMapper.findNodeCoverageDandA(params);
    }

    @Override
    public List<NodeCoverageReportVo> findAllNodeCoverageA(Map params) {
        List<NodeCoverageReportVo> list = new ArrayList<NodeCoverageReportVo>();
        //国航
        params.put("dept","GH");
        params.put("agent", ConstantUtil.CCA);
        List<NodeCoverageReportVo> listGH = nodeCoverageReportMapper.findNodeCoverageA(params);

        //南航
        params.remove("dept");
        params.remove("agent");
        params.put("dept","NH");
        params.put("agent",ConstantUtil.CSN);
        List<NodeCoverageReportVo> listNH = nodeCoverageReportMapper.findNodeCoverageA(params);

        //东航
        params.remove("dept");
        params.remove("agent");
        params.put("dept","DH");
        params.put("agent",ConstantUtil.CES);
        List<NodeCoverageReportVo> listDH = nodeCoverageReportMapper.findNodeCoverageA(params);

        //地服
        params.remove("dept");
        params.remove("agent");
        params.put("dept","DF");
        params.put("agent",ConstantUtil.IGO);
        List<NodeCoverageReportVo> listDF = nodeCoverageReportMapper.findNodeCoverageA(params);

        list.add(listDH.get(0));//东航
        list.add(listNH.get(0));//南航
        list.add(listGH.get(0));//国航
        list.add(listDF.get(0));//地服

        return list;
    }

    @Override
    public List<NodeCoverageReportVo> findAllNodeCoverageD(Map params) {
        List<NodeCoverageReportVo> list = new ArrayList<NodeCoverageReportVo>();
        //国航
        params.put("dept","GH");
        params.put("agent",ConstantUtil.CCA);
        List<NodeCoverageReportVo> listGH = nodeCoverageReportMapper.findNodeCoverageD(params);

        //南航
        params.remove("dept");
        params.remove("agent");
        params.put("dept","NH");
        params.put("agent",ConstantUtil.CSN);
        List<NodeCoverageReportVo> listNH = nodeCoverageReportMapper.findNodeCoverageD(params);

        //东航
        params.remove("dept");
        params.remove("agent");
        params.put("dept","DH");
        params.put("agent",ConstantUtil.CES);
        List<NodeCoverageReportVo> listDH = nodeCoverageReportMapper.findNodeCoverageD(params);

        //地服
        params.remove("dept");
        params.remove("agent");
        params.put("dept","DF");
        params.put("agent",ConstantUtil.IGO);
        List<NodeCoverageReportVo> listDF = nodeCoverageReportMapper.findNodeCoverageD(params);

        list.add(listDH.get(0));//东航
        list.add(listNH.get(0));//南航
        list.add(listGH.get(0));//国航
        list.add(listDF.get(0));//地服

        return list;
    }

    @Override
    public List<NodeCoverageReportVo> findAllNodeCoverageDandA(Map params) {
        List<NodeCoverageReportVo> list = new ArrayList<NodeCoverageReportVo>();
        //国航
        params.put("dept","GH");
        params.put("agent",ConstantUtil.CCA);
        List<NodeCoverageReportVo> listGH = nodeCoverageReportMapper.findNodeCoverageDandA(params);

        //南航
        params.remove("dept");
        params.remove("agent");
        params.put("dept","NH");
        params.put("agent",ConstantUtil.CSN);
        List<NodeCoverageReportVo> listNH = nodeCoverageReportMapper.findNodeCoverageDandA(params);

        //东航
        params.remove("dept");
        params.remove("agent");
        params.put("dept","DH");
        params.put("agent",ConstantUtil.CES);
        List<NodeCoverageReportVo> listDH = nodeCoverageReportMapper.findNodeCoverageDandA(params);

        //地服
        params.remove("dept");
        params.remove("agent");
        params.put("dept","DF");
        params.put("agent",ConstantUtil.IGO);
        List<NodeCoverageReportVo> listDF = nodeCoverageReportMapper.findNodeCoverageDandA(params);

        list.add(listDH.get(0));//东航
        list.add(listNH.get(0));//南航
        list.add(listGH.get(0));//国航
        list.add(listDF.get(0));//地服

        return list;
    }

    @Override
    public NodeCoveragePieVo findPieData(Map params) {

        String []legendData = new String[]{"东航","南航","国航","地服"};
        List<NodeCoverageReportVo> listA = this.findAllNodeCoverageA(params);
        List<NodeCoverageReportVo> listD = this.findAllNodeCoverageD(params);
        List<NodeCoverageReportVo> listDandA = this.findAllNodeCoverageDandA(params);

        //东航数
        BigDecimal totalDH = new BigDecimal(listA.get(0).getTotal())
                            .add(new BigDecimal(listD.get(0).getTotal()))
                            .add(new BigDecimal(listDandA.get(0).getTotal()));

        //南航数
        BigDecimal totalNH = new BigDecimal(listA.get(1).getTotal())
                .add(new BigDecimal(listD.get(1).getTotal()))
                .add(new BigDecimal(listDandA.get(1).getTotal()));

        //国航数
        BigDecimal totalGH = new BigDecimal(listA.get(2).getTotal())
                .add(new BigDecimal(listD.get(2).getTotal()))
                .add(new BigDecimal(listDandA.get(2).getTotal()));

        //地服数
        BigDecimal totalDF = new BigDecimal(listA.get(3).getTotal())
                .add(new BigDecimal(listD.get(3).getTotal()))
                .add(new BigDecimal(listDandA.get(3).getTotal()));

        //总航数
        BigDecimal sumHB = totalDH.add(totalNH).add(totalGH).add(totalDF);

        BigDecimal dhRate = totalDH.divide(sumHB,2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));

        BigDecimal nhRate = totalNH.divide(sumHB,2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));

        BigDecimal ghRate = totalGH.divide(sumHB,2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));

        BigDecimal dfRate = totalDF.divide(sumHB,2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));

        NodeCoveragePieStaticVo dhVo = new NodeCoveragePieStaticVo();
        dhVo.setName("东航");
        dhVo.setCname("中国东方航空公司");
        dhVo.setValue(totalDH+"");

        NodeCoveragePieStaticVo nhVo = new NodeCoveragePieStaticVo();
        nhVo.setName("南航");
        nhVo.setCname("中国南方航空公司");
        nhVo.setValue(totalNH+"");

        NodeCoveragePieStaticVo ghVo = new NodeCoveragePieStaticVo();
        ghVo.setName("国航");
        ghVo.setCname("中国国际航空公司");
        ghVo.setValue(totalGH+"");

        NodeCoveragePieStaticVo dfVo = new NodeCoveragePieStaticVo();
        dfVo.setName("地服");
        dfVo.setCname("地面服务公司");
        dfVo.setValue(totalDF+"");

        List<NodeCoveragePieStaticVo> list = new ArrayList<NodeCoveragePieStaticVo>();
        list.add(dhVo);
        list.add(nhVo);
        list.add(ghVo);
        list.add(dfVo);

        NodeCoveragePieVo ncPieVo = new NodeCoveragePieVo();
        ncPieVo.setLegendData(legendData);
        ncPieVo.setStaticData(list);

        return ncPieVo;
    }

    @Override
    public NodeCoverageBarVo findBarData(Map params) {
        String []legendData = new String[]{"前站起飞","落地","进港航班地面移交","挡轮挡","靠桥/客梯车对接"
                ,"开客舱门","开货舱门","开始保洁","完成保洁","开始加油","完成加油","开始配餐","完成配餐","开始登机"
                ,"完成登机","关客舱门","关货舱门","机务放行","离桥/客梯车撤离","撤轮挡","离港航班地面移交","起飞",
                "进港货物重量","进港邮件重量","进港行李重量","进港订座人数","出港货物重量","出港邮件重量","出港行李重量",
                "出港订座人数"};

        List<NodeCoverageReportVo> listA = this.findAllNodeCoverageA(params);
        List<NodeCoverageReportVo> listD = this.findAllNodeCoverageD(params);
        List<NodeCoverageReportVo> listDandA = this.findAllNodeCoverageDandA(params);

        //东航--------------------------------东航-----------------------------------
        //前站起飞率
        BigDecimal atotRateADH = (new BigDecimal(listA.get(0).getAtotA())
                .add(new BigDecimal(listDandA.get(0).getAtotA())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //落地率
        BigDecimal aldtRateDH = (new BigDecimal(listA.get(0).getAldt())
                .add(new BigDecimal(listDandA.get(0).getAldt())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港航班地面移交率
        BigDecimal agrndTsfTmRateDH = (new BigDecimal(listA.get(0).getAgrndTsfTm())
                .add(new BigDecimal(listDandA.get(0).getAgrndTsfTm())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //挡轮挡率
        BigDecimal aibtRateDH = (new BigDecimal(listA.get(0).getAibt())
                .add(new BigDecimal(listDandA.get(0).getAibt())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //靠桥/客梯车对接率
        BigDecimal arslRateDH = (new BigDecimal(listA.get(0).getArsl())
                .add(new BigDecimal(listDandA.get(0).getArsl())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开客舱门率
        BigDecimal atdoRateDH = (new BigDecimal(listA.get(0).getAtdo())
                .add(new BigDecimal(listDandA.get(0).getAtdo())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开货舱门率
        BigDecimal atfoRateDH = (new BigDecimal(listA.get(0).getAtfo())
                .add(new BigDecimal(listDandA.get(0).getAtfo())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始保洁率
        BigDecimal asctRateDH = (new BigDecimal(listA.get(0).getAsct())
                .add(new BigDecimal(listDandA.get(0).getAsct())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成保洁率
        BigDecimal afctRateDH = (new BigDecimal(listA.get(0).getAfct())
                .add(new BigDecimal(listDandA.get(0).getAfct())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //开始加油率
        BigDecimal asrRateDH = (new BigDecimal(listD.get(0).getAsr())
                .add(new BigDecimal(listDandA.get(0).getAsr())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成加油率
        BigDecimal aerRateDH = (new BigDecimal(listD.get(0).getAer())
                .add(new BigDecimal(listDandA.get(0).getAer())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始配餐率
        BigDecimal ascRateDH = (new BigDecimal(listD.get(0).getAsc())
                .add(new BigDecimal(listDandA.get(0).getAsc())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成配餐率
        BigDecimal aecRateDH = (new BigDecimal(listD.get(0).getAec())
                .add(new BigDecimal(listDandA.get(0).getAec())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始登机率
        BigDecimal asbtRateDH = (new BigDecimal(listD.get(0).getAsbt())
                .add(new BigDecimal(listDandA.get(0).getAsbt())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成登机率
        BigDecimal aebtRateDH = (new BigDecimal(listD.get(0).getAebt())
                .add(new BigDecimal(listDandA.get(0).getAebt())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //关客舱门率
        BigDecimal atdcRateDH = (new BigDecimal(listD.get(0).getAtdc())
                .add(new BigDecimal(listDandA.get(0).getAtdc())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //关货舱门率
        BigDecimal atfcRateDH = (new BigDecimal(listD.get(0).getAtfc())
                .add(new BigDecimal(listDandA.get(0).getAtfc())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //机务放行率
        BigDecimal aactRateDH = (new BigDecimal(listD.get(0).getAact())
                .add(new BigDecimal(listDandA.get(0).getAact())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //离桥/客梯车撤离率
        BigDecimal alswRateDH = (new BigDecimal(listD.get(0).getAlsw())
                .add(new BigDecimal(listDandA.get(0).getAlsw())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //撤轮挡率
        BigDecimal aobtRateDH = (new BigDecimal(listD.get(0).getAobt())
                .add(new BigDecimal(listDandA.get(0).getAobt())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //离港航班地面移交率
        BigDecimal dgrndTsfTmRateDH = (new BigDecimal(listD.get(0).getDgrndTsfTm())
                .add(new BigDecimal(listDandA.get(0).getDgrndTsfTm())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //起飞率
        BigDecimal atotRateDDH = (new BigDecimal(listD.get(0).getAtotD())
                .add(new BigDecimal(listDandA.get(0).getAtotD())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港货重率
        BigDecimal cargoWeightARateDH = (new BigDecimal(listA.get(0).getCargoWeightA())
                .add(new BigDecimal(listDandA.get(0).getCargoWeightA())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港邮重率
        BigDecimal mailWeightARateDH = (new BigDecimal(listA.get(0).getMailWeightA())
                .add(new BigDecimal(listDandA.get(0).getMailWeightA())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港行李率
        BigDecimal bagWeightARateDH = (new BigDecimal(listA.get(0).getBagWeightA())
                .add(new BigDecimal(listDandA.get(0).getBagWeightA())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港订坐率
        BigDecimal reservationsARateDH = (new BigDecimal(listA.get(0).getReservationsA())
                .add(new BigDecimal(listDandA.get(0).getReservationsA())))
                .divide((new BigDecimal(listA.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //出港货重率
        BigDecimal cargoWeightDRateDH = (new BigDecimal(listD.get(0).getCargoWeightD())
                .add(new BigDecimal(listDandA.get(0).getCargoWeightD())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港邮重率
        BigDecimal mailWeightDRateDH = (new BigDecimal(listD.get(0).getMailWeightD())
                .add(new BigDecimal(listDandA.get(0).getMailWeightD())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港行李率
        BigDecimal bagWeightDRateDH = (new BigDecimal(listD.get(0).getBagWeightD())
                .add(new BigDecimal(listDandA.get(0).getBagWeightD())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港订坐率
        BigDecimal reservationsDRateDH = (new BigDecimal(listD.get(0).getReservationsD())
                .add(new BigDecimal(listDandA.get(0).getReservationsD())))
                .divide((new BigDecimal(listD.get(0).getTotal())
                        .add(new BigDecimal(listDandA.get(0).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));




        //南航--------------------------------南航-----------------------------------
        //前站起飞率
        BigDecimal atotRateANH = (new BigDecimal(listA.get(1).getAtotA())
                .add(new BigDecimal(listDandA.get(1).getAtotA())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //落地率
        BigDecimal aldtRateNH = (new BigDecimal(listA.get(1).getAldt())
                .add(new BigDecimal(listDandA.get(1).getAldt())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港航班地面移交率
        BigDecimal agrndTsfTmRateNH = (new BigDecimal(listA.get(1).getAgrndTsfTm())
                .add(new BigDecimal(listDandA.get(1).getAgrndTsfTm())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //挡轮挡率
        BigDecimal aibtRateNH = (new BigDecimal(listA.get(1).getAibt())
                .add(new BigDecimal(listDandA.get(1).getAibt())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //靠桥/客梯车对接率
        BigDecimal arslRateNH = (new BigDecimal(listA.get(1).getArsl())
                .add(new BigDecimal(listDandA.get(1).getArsl())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开客舱门率
        BigDecimal atdoRateNH = (new BigDecimal(listA.get(1).getAtdo())
                .add(new BigDecimal(listDandA.get(1).getAtdo())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开货舱门率
        BigDecimal atfoRateNH = (new BigDecimal(listA.get(1).getAtfo())
                .add(new BigDecimal(listDandA.get(1).getAtfo())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始保洁率
        BigDecimal asctRateNH = (new BigDecimal(listA.get(1).getAsct())
                .add(new BigDecimal(listDandA.get(1).getAsct())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成保洁率
        BigDecimal afctRateNH = (new BigDecimal(listA.get(1).getAfct())
                .add(new BigDecimal(listDandA.get(1).getAfct())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //开始加油率
        BigDecimal asrRateNH = (new BigDecimal(listD.get(1).getAsr())
                .add(new BigDecimal(listDandA.get(1).getAsr())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成加油率
        BigDecimal aerRateNH = (new BigDecimal(listD.get(1).getAer())
                .add(new BigDecimal(listDandA.get(1).getAer())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始配餐率
        BigDecimal ascRateNH = (new BigDecimal(listD.get(1).getAsc())
                .add(new BigDecimal(listDandA.get(1).getAsc())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成配餐率
        BigDecimal aecRateNH = (new BigDecimal(listD.get(1).getAec())
                .add(new BigDecimal(listDandA.get(1).getAec())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始登机率
        BigDecimal asbtRateNH = (new BigDecimal(listD.get(1).getAsbt())
                .add(new BigDecimal(listDandA.get(1).getAsbt())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成登机率
        BigDecimal aebtRateNH = (new BigDecimal(listD.get(1).getAebt())
                .add(new BigDecimal(listDandA.get(1).getAebt())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //关客舱门率
        BigDecimal atdcRateNH = (new BigDecimal(listD.get(1).getAtdc())
                .add(new BigDecimal(listDandA.get(1).getAtdc())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //关货舱门率
        BigDecimal atfcRateNH = (new BigDecimal(listD.get(1).getAtfc())
                .add(new BigDecimal(listDandA.get(1).getAtfc())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //机务放行率
        BigDecimal aactRateNH = (new BigDecimal(listD.get(1).getAact())
                .add(new BigDecimal(listDandA.get(1).getAact())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //离桥/客梯车撤离率
        BigDecimal alswRateNH = (new BigDecimal(listD.get(1).getAlsw())
                .add(new BigDecimal(listDandA.get(1).getAlsw())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //撤轮挡率
        BigDecimal aobtRateNH = (new BigDecimal(listD.get(1).getAobt())
                .add(new BigDecimal(listDandA.get(1).getAobt())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //离港航班地面移交率
        BigDecimal dgrndTsfTmRateNH = (new BigDecimal(listD.get(1).getDgrndTsfTm())
                .add(new BigDecimal(listDandA.get(1).getDgrndTsfTm())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //起飞率
        BigDecimal atotRateDNH = (new BigDecimal(listD.get(1).getAtotD())
                .add(new BigDecimal(listDandA.get(1).getAtotD())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港货重率
        BigDecimal cargoWeightARateNH = (new BigDecimal(listA.get(1).getCargoWeightA())
                .add(new BigDecimal(listDandA.get(1).getCargoWeightA())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港邮重率
        BigDecimal mailWeightARateNH = (new BigDecimal(listA.get(1).getMailWeightA())
                .add(new BigDecimal(listDandA.get(1).getMailWeightA())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港行李率
        BigDecimal bagWeightARateNH = (new BigDecimal(listA.get(1).getBagWeightA())
                .add(new BigDecimal(listDandA.get(1).getBagWeightA())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港订坐率
        BigDecimal reservationsARateNH = (new BigDecimal(listA.get(1).getReservationsA())
                .add(new BigDecimal(listDandA.get(1).getReservationsA())))
                .divide((new BigDecimal(listA.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //出港货重率
        BigDecimal cargoWeightDRateNH = (new BigDecimal(listD.get(1).getCargoWeightD())
                .add(new BigDecimal(listDandA.get(1).getCargoWeightD())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港邮重率
        BigDecimal mailWeightDRateNH = (new BigDecimal(listD.get(1).getMailWeightD())
                .add(new BigDecimal(listDandA.get(1).getMailWeightD())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港行李率
        BigDecimal bagWeightDRateNH = (new BigDecimal(listD.get(1).getBagWeightD())
                .add(new BigDecimal(listDandA.get(1).getBagWeightD())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港订坐率
        BigDecimal reservationsDRateNH = (new BigDecimal(listD.get(1).getReservationsD())
                .add(new BigDecimal(listDandA.get(1).getReservationsD())))
                .divide((new BigDecimal(listD.get(1).getTotal())
                        .add(new BigDecimal(listDandA.get(1).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));



        //国航--------------------------------国航-----------------------------------
        //前站起飞率
        BigDecimal atotRateAGH = (new BigDecimal(listA.get(2).getAtotA())
                .add(new BigDecimal(listDandA.get(2).getAtotA())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //落地率
        BigDecimal aldtRateGH = (new BigDecimal(listA.get(2).getAldt())
                .add(new BigDecimal(listDandA.get(2).getAldt())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港航班地面移交率
        BigDecimal agrndTsfTmRateGH = (new BigDecimal(listA.get(2).getAgrndTsfTm())
                .add(new BigDecimal(listDandA.get(2).getAgrndTsfTm())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //挡轮挡率
        BigDecimal aibtRateGH = (new BigDecimal(listA.get(2).getAibt())
                .add(new BigDecimal(listDandA.get(2).getAibt())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //靠桥/客梯车对接率
        BigDecimal arslRateGH = (new BigDecimal(listA.get(2).getArsl())
                .add(new BigDecimal(listDandA.get(2).getArsl())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开客舱门率
        BigDecimal atdoRateGH = (new BigDecimal(listA.get(2).getAtdo())
                .add(new BigDecimal(listDandA.get(2).getAtdo())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开货舱门率
        BigDecimal atfoRateGH = (new BigDecimal(listA.get(2).getAtfo())
                .add(new BigDecimal(listDandA.get(2).getAtfo())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始保洁率
        BigDecimal asctRateGH = (new BigDecimal(listA.get(2).getAsct())
                .add(new BigDecimal(listDandA.get(2).getAsct())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成保洁率
        BigDecimal afctRateGH = (new BigDecimal(listA.get(2).getAfct())
                .add(new BigDecimal(listDandA.get(2).getAfct())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //开始加油率
        BigDecimal asrRateGH = (new BigDecimal(listD.get(2).getAsr())
                .add(new BigDecimal(listDandA.get(2).getAsr())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成加油率
        BigDecimal aerRateGH = (new BigDecimal(listD.get(2).getAer())
                .add(new BigDecimal(listDandA.get(2).getAer())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始配餐率
        BigDecimal ascRateGH = (new BigDecimal(listD.get(2).getAsc())
                .add(new BigDecimal(listDandA.get(2).getAsc())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成配餐率
        BigDecimal aecRateGH = (new BigDecimal(listD.get(2).getAec())
                .add(new BigDecimal(listDandA.get(2).getAec())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始登机率
        BigDecimal asbtRateGH = (new BigDecimal(listD.get(2).getAsbt())
                .add(new BigDecimal(listDandA.get(2).getAsbt())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成登机率
        BigDecimal aebtRateGH = (new BigDecimal(listD.get(2).getAebt())
                .add(new BigDecimal(listDandA.get(2).getAebt())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //关客舱门率
        BigDecimal atdcRateGH = (new BigDecimal(listD.get(2).getAtdc())
                .add(new BigDecimal(listDandA.get(2).getAtdc())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //关货舱门率
        BigDecimal atfcRateGH = (new BigDecimal(listD.get(2).getAtfc())
                .add(new BigDecimal(listDandA.get(2).getAtfc())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //机务放行率
        BigDecimal aactRateGH = (new BigDecimal(listD.get(2).getAact())
                .add(new BigDecimal(listDandA.get(2).getAact())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //离桥/客梯车撤离率
        BigDecimal alswRateGH = (new BigDecimal(listD.get(2).getAlsw())
                .add(new BigDecimal(listDandA.get(2).getAlsw())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //撤轮挡率
        BigDecimal aobtRateGH = (new BigDecimal(listD.get(2).getAobt())
                .add(new BigDecimal(listDandA.get(2).getAobt())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //离港航班地面移交率
        BigDecimal dgrndTsfTmRateGH = (new BigDecimal(listD.get(2).getDgrndTsfTm())
                .add(new BigDecimal(listDandA.get(2).getDgrndTsfTm())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //起飞率
        BigDecimal atotRateDGH = (new BigDecimal(listD.get(2).getAtotD())
                .add(new BigDecimal(listDandA.get(2).getAtotD())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港货重率
        BigDecimal cargoWeightARateGH = (new BigDecimal(listA.get(2).getCargoWeightA())
                .add(new BigDecimal(listDandA.get(2).getCargoWeightA())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港邮重率
        BigDecimal mailWeightARateGH = (new BigDecimal(listA.get(2).getMailWeightA())
                .add(new BigDecimal(listDandA.get(2).getMailWeightA())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港行李率
        BigDecimal bagWeightARateGH = (new BigDecimal(listA.get(2).getBagWeightA())
                .add(new BigDecimal(listDandA.get(2).getBagWeightA())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港订坐率
        BigDecimal reservationsARateGH = (new BigDecimal(listA.get(2).getReservationsA())
                .add(new BigDecimal(listDandA.get(2).getReservationsA())))
                .divide((new BigDecimal(listA.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //出港货重率
        BigDecimal cargoWeightDRateGH = (new BigDecimal(listD.get(2).getCargoWeightD())
                .add(new BigDecimal(listDandA.get(2).getCargoWeightD())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港邮重率
        BigDecimal mailWeightDRateGH = (new BigDecimal(listD.get(2).getMailWeightD())
                .add(new BigDecimal(listDandA.get(2).getMailWeightD())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港行李率
        BigDecimal bagWeightDRateGH = (new BigDecimal(listD.get(2).getBagWeightD())
                .add(new BigDecimal(listDandA.get(2).getBagWeightD())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港订坐率
        BigDecimal reservationsDRateGH = (new BigDecimal(listD.get(2).getReservationsD())
                .add(new BigDecimal(listDandA.get(2).getReservationsD())))
                .divide((new BigDecimal(listD.get(2).getTotal())
                        .add(new BigDecimal(listDandA.get(2).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //地服--------------------------------地服-----------------------------------
        //前站起飞率
        BigDecimal atotRateADF = (new BigDecimal(listA.get(3).getAtotA())
                .add(new BigDecimal(listDandA.get(3).getAtotA())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //落地率
        BigDecimal aldtRateDF = (new BigDecimal(listA.get(3).getAldt())
                .add(new BigDecimal(listDandA.get(3).getAldt())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港航班地面移交率
        BigDecimal agrndTsfTmRateDF = (new BigDecimal(listA.get(3).getAgrndTsfTm())
                .add(new BigDecimal(listDandA.get(3).getAgrndTsfTm())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //挡轮挡率
        BigDecimal aibtRateDF = (new BigDecimal(listA.get(3).getAibt())
                .add(new BigDecimal(listDandA.get(3).getAibt())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //靠桥/客梯车对接率
        BigDecimal arslRateDF = (new BigDecimal(listA.get(3).getArsl())
                .add(new BigDecimal(listDandA.get(3).getArsl())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开客舱门率
        BigDecimal atdoRateDF = (new BigDecimal(listA.get(3).getAtdo())
                .add(new BigDecimal(listDandA.get(3).getAtdo())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开货舱门率
        BigDecimal atfoRateDF = (new BigDecimal(listA.get(3).getAtfo())
                .add(new BigDecimal(listDandA.get(3).getAtfo())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始保洁率
        BigDecimal asctRateDF = (new BigDecimal(listA.get(3).getAsct())
                .add(new BigDecimal(listDandA.get(3).getAsct())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成保洁率
        BigDecimal afctRateDF = (new BigDecimal(listA.get(3).getAfct())
                .add(new BigDecimal(listDandA.get(3).getAfct())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //开始加油率
        BigDecimal asrRateDF = (new BigDecimal(listD.get(3).getAsr())
                .add(new BigDecimal(listDandA.get(3).getAsr())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成加油率
        BigDecimal aerRateDF = (new BigDecimal(listD.get(3).getAer())
                .add(new BigDecimal(listDandA.get(3).getAer())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始配餐率
        BigDecimal ascRateDF = (new BigDecimal(listD.get(3).getAsc())
                .add(new BigDecimal(listDandA.get(3).getAsc())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成配餐率
        BigDecimal aecRateDF = (new BigDecimal(listD.get(3).getAec())
                .add(new BigDecimal(listDandA.get(3).getAec())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //开始登机率
        BigDecimal asbtRateDF = (new BigDecimal(listD.get(3).getAsbt())
                .add(new BigDecimal(listDandA.get(3).getAsbt())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //完成登机率
        BigDecimal aebtRateDF = (new BigDecimal(listD.get(3).getAebt())
                .add(new BigDecimal(listDandA.get(3).getAebt())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //关客舱门率
        BigDecimal atdcRateDF = (new BigDecimal(listD.get(3).getAtdc())
                .add(new BigDecimal(listDandA.get(3).getAtdc())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //关货舱门率
        BigDecimal atfcRateDF = (new BigDecimal(listD.get(3).getAtfc())
                .add(new BigDecimal(listDandA.get(3).getAtfc())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //机务放行率
        BigDecimal aactRateDF = (new BigDecimal(listD.get(3).getAact())
                .add(new BigDecimal(listDandA.get(3).getAact())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //离桥/客梯车撤离率
        BigDecimal alswRateDF = (new BigDecimal(listD.get(3).getAlsw())
                .add(new BigDecimal(listDandA.get(3).getAlsw())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //撤轮挡率
        BigDecimal aobtRateDF = (new BigDecimal(listD.get(3).getAobt())
                .add(new BigDecimal(listDandA.get(3).getAobt())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //离港航班地面移交率
        BigDecimal dgrndTsfTmRateDF = (new BigDecimal(listD.get(3).getDgrndTsfTm())
                .add(new BigDecimal(listDandA.get(3).getDgrndTsfTm())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //起飞率
        BigDecimal atotRateDDF = (new BigDecimal(listD.get(3).getAtotD())
                .add(new BigDecimal(listDandA.get(3).getAtotD())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港货重率
        BigDecimal cargoWeightARateDF = (new BigDecimal(listA.get(3).getCargoWeightA())
                .add(new BigDecimal(listDandA.get(3).getCargoWeightA())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港邮重率
        BigDecimal mailWeightARateDF = (new BigDecimal(listA.get(3).getMailWeightA())
                .add(new BigDecimal(listDandA.get(3).getMailWeightA())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港行李率
        BigDecimal bagWeightARateDF = (new BigDecimal(listA.get(3).getBagWeightA())
                .add(new BigDecimal(listDandA.get(3).getBagWeightA())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //进港订坐率
        BigDecimal reservationsARateDF = (new BigDecimal(listA.get(3).getReservationsA())
                .add(new BigDecimal(listDandA.get(3).getReservationsA())))
                .divide((new BigDecimal(listA.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //出港货重率
        BigDecimal cargoWeightDRateDF = (new BigDecimal(listD.get(3).getCargoWeightD())
                .add(new BigDecimal(listDandA.get(3).getCargoWeightD())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港邮重率
        BigDecimal mailWeightDRateDF = (new BigDecimal(listD.get(3).getMailWeightD())
                .add(new BigDecimal(listDandA.get(3).getMailWeightD())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港行李率
        BigDecimal bagWeightDRateDF = (new BigDecimal(listD.get(3).getBagWeightD())
                .add(new BigDecimal(listDandA.get(3).getBagWeightD())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));

        //出港订坐率
        BigDecimal reservationsDRateDF = (new BigDecimal(listD.get(3).getReservationsD())
                .add(new BigDecimal(listDandA.get(3).getReservationsD())))
                .divide((new BigDecimal(listD.get(3).getTotal())
                        .add(new BigDecimal(listDandA.get(3).getTotal()))),2,BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal("100"));


        //平均------------------------------------平均---------------------------------------------
        //前站起飞率
        BigDecimal atotRateAAVG = (atotRateADH.add(atotRateANH).add(atotRateAGH).add(atotRateADF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //落地率
        BigDecimal aldtRateAVG = (aldtRateDH.add(aldtRateNH).add(aldtRateGH).add(aldtRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //进港航班地面移交率
        BigDecimal agrndTsfTmRateAVG = (agrndTsfTmRateDH.add(agrndTsfTmRateNH).add(agrndTsfTmRateGH).add(agrndTsfTmRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //挡轮挡率
        BigDecimal aibtRateAVG = (aibtRateDH.add(aibtRateNH).add(aibtRateGH).add(aibtRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //靠桥/客梯车对接率
        BigDecimal arslRateAVG = (arslRateDH.add(arslRateNH).add(arslRateGH).add(arslRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //开客舱门率
        BigDecimal atdoRateAVG = (atdoRateDH.add(atdoRateNH).add(atdoRateGH).add(atdoRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //开货舱门率
        BigDecimal atfoRateAVG = (atfoRateDH.add(atfoRateNH).add(atfoRateGH).add(atfoRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //开始保洁率
        BigDecimal asctRateAVG = (asctRateDH.add(asctRateNH).add(asctRateGH).add(asctRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //完成保洁率
        BigDecimal afctRateAVG = (afctRateDH.add(afctRateNH).add(afctRateGH).add(afctRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);


        //开始加油率
        BigDecimal asrRateAVG = (asrRateDH.add(asrRateNH).add(asrRateGH).add(asrRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //完成加油率
        BigDecimal aerRateAVG = (aerRateDH.add(aerRateNH).add(aerRateGH).add(aerRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //开始配餐率
        BigDecimal ascRateAVG = (ascRateDH.add(ascRateNH).add(ascRateGH).add(ascRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //完成配餐率
        BigDecimal aecRateAVG = (aecRateDH.add(aecRateNH).add(aecRateGH).add(aecRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //开始登机率
        BigDecimal asbtRateAVG = (asbtRateDH.add(asbtRateNH).add(asbtRateGH).add(asbtRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //完成登机率
        BigDecimal aebtRateAVG = (aebtRateDH.add(aebtRateNH).add(aebtRateGH).add(aebtRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //关客舱门率
        BigDecimal atdcRateAVG = (atdcRateDH.add(atdcRateNH).add(atdcRateGH).add(atdcRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //关货舱门率
        BigDecimal atfcRateAVG = (atfcRateDH.add(atfcRateNH).add(atfcRateGH).add(atfcRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //机务放行率
        BigDecimal aactRateAVG = (aactRateDH.add(aactRateNH).add(aactRateGH).add(aactRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //离桥/客梯车撤离率
        BigDecimal alswRateAVG = (alswRateDH.add(alswRateNH).add(alswRateGH).add(alswRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //撤轮挡率
        BigDecimal aobtRateAVG = (aobtRateDH.add(aobtRateNH).add(aobtRateGH).add(aobtRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //离港航班地面移交率
        BigDecimal dgrndTsfTmRateAVG = (dgrndTsfTmRateDH.add(dgrndTsfTmRateNH).add(dgrndTsfTmRateGH).add(dgrndTsfTmRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //起飞率
        BigDecimal atotRateDAVG = (atotRateDDH.add(atotRateDNH).add(atotRateDGH).add(atotRateDDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //进港货重率
        BigDecimal cargoWeightARateAVG = (cargoWeightARateDH.add(cargoWeightARateNH).add(cargoWeightARateGH).add(cargoWeightARateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //进港邮重率
        BigDecimal mailWeightARateAVG = (mailWeightARateDH.add(mailWeightARateNH).add(mailWeightARateGH).add(mailWeightARateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //进港行李率
        BigDecimal bagWeightARateAVG = (bagWeightARateDH.add(bagWeightARateNH).add(bagWeightARateGH).add(bagWeightARateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //进港订坐率
        BigDecimal reservationsARateAVG = (reservationsARateDH.add(reservationsARateNH).add(reservationsARateGH).add(reservationsARateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);


        //出港货重率
        BigDecimal cargoWeightDRateAVG = (cargoWeightDRateDH.add(cargoWeightDRateNH).add(cargoWeightDRateGH).add(cargoWeightDRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //出港邮重率
        BigDecimal mailWeightDRateAVG = (mailWeightDRateDH.add(mailWeightDRateNH).add(mailWeightDRateGH).add(mailWeightDRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //出港行李率
        BigDecimal bagWeightDRateAVG = (bagWeightDRateDH.add(bagWeightDRateNH).add(bagWeightDRateGH).add(bagWeightDRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);

        //出港订坐率
        BigDecimal reservationsDRateAVG = (reservationsDRateDH.add(reservationsDRateNH).add(reservationsDRateGH).add(reservationsDRateDF))
                .divide(new BigDecimal(4),2,BigDecimal.ROUND_HALF_UP);


        //东航数组
        BigDecimal []dhVal = new BigDecimal[30];
        dhVal[0] = atotRateADH;
        dhVal[1] = aldtRateDH;
        dhVal[2] = agrndTsfTmRateDH;
        dhVal[3] = aibtRateDH;
        dhVal[4] = arslRateDH;
        dhVal[5] = atdoRateDH;
        dhVal[6] = atfoRateDH;
        dhVal[7] = asctRateDH;
        dhVal[8] = afctRateDH;
        dhVal[9] = asrRateDH;
        dhVal[10] = aerRateDH;
        dhVal[11] = ascRateDH;
        dhVal[12] = aecRateDH;
        dhVal[13] = asbtRateDH;
        dhVal[14] = aebtRateDH;
        dhVal[15] = atdcRateDH;
        dhVal[16] = atfcRateDH;
        dhVal[17] = aactRateDH;
        dhVal[18] = alswRateDH;
        dhVal[19] = aobtRateDH;
        dhVal[20] = dgrndTsfTmRateDH;
        dhVal[21] = atotRateDDH;
        dhVal[22] = cargoWeightARateDH;
        dhVal[23] = mailWeightARateDH;
        dhVal[24] = bagWeightARateDH;
        dhVal[25] = reservationsARateDH;
        dhVal[26] = cargoWeightDRateDH;
        dhVal[27] = mailWeightDRateDH;
        dhVal[28] = bagWeightDRateDH;
        dhVal[29] = reservationsDRateDH;

        //南航数组
        BigDecimal []nhVal = new BigDecimal[30];
        nhVal[0] = atotRateANH;
        nhVal[1] = aldtRateNH;
        nhVal[2] = agrndTsfTmRateNH;
        nhVal[3] = aibtRateNH;
        nhVal[4] = arslRateNH;
        nhVal[5] = atdoRateNH;
        nhVal[6] = atfoRateNH;
        nhVal[7] = asctRateNH;
        nhVal[8] = afctRateNH;
        nhVal[9] = asrRateNH;
        nhVal[10] = aerRateNH;
        nhVal[11] = ascRateNH;
        nhVal[12] = aecRateNH;
        nhVal[13] = asbtRateNH;
        nhVal[14] = aebtRateNH;
        nhVal[15] = atdcRateNH;
        nhVal[16] = atfcRateNH;
        nhVal[17] = aactRateNH;
        nhVal[18] = alswRateNH;
        nhVal[19] = aobtRateNH;
        nhVal[20] = dgrndTsfTmRateNH;
        nhVal[21] = atotRateDNH;
        nhVal[22] = cargoWeightARateNH;
        nhVal[23] = mailWeightARateNH;
        nhVal[24] = bagWeightARateNH;
        nhVal[25] = reservationsARateNH;
        nhVal[26] = cargoWeightDRateNH;
        nhVal[27] = mailWeightDRateNH;
        nhVal[28] = bagWeightDRateNH;
        nhVal[29] = reservationsDRateNH;


        //国航数组
        BigDecimal []ghVal = new BigDecimal[30];
        ghVal[0] = atotRateAGH;
        ghVal[1] = aldtRateGH;
        ghVal[2] = agrndTsfTmRateGH;
        ghVal[3] = aibtRateGH;
        ghVal[4] = arslRateGH;
        ghVal[5] = atdoRateGH;
        ghVal[6] = atfoRateGH;
        ghVal[7] = asctRateGH;
        ghVal[8] = afctRateGH;
        ghVal[9] = asrRateGH;
        ghVal[10] = aerRateGH;
        ghVal[11] = ascRateGH;
        ghVal[12] = aecRateGH;
        ghVal[13] = asbtRateGH;
        ghVal[14] = aebtRateGH;
        ghVal[15] = atdcRateGH;
        ghVal[16] = atfcRateGH;
        ghVal[17] = aactRateGH;
        ghVal[18] = alswRateGH;
        ghVal[19] = aobtRateGH;
        ghVal[20] = dgrndTsfTmRateGH;
        ghVal[21] = atotRateDGH;
        ghVal[22] = cargoWeightARateGH;
        ghVal[23] = mailWeightARateGH;
        ghVal[24] = bagWeightARateGH;
        ghVal[25] = reservationsARateGH;
        ghVal[26] = cargoWeightDRateGH;
        ghVal[27] = mailWeightDRateGH;
        ghVal[28] = bagWeightDRateGH;
        ghVal[29] = reservationsDRateGH;


        //地服数组
        BigDecimal []dfVal = new BigDecimal[30];
        dfVal[0] = atotRateADF;
        dfVal[1] = aldtRateDF;
        dfVal[2] = agrndTsfTmRateDF;
        dfVal[3] = aibtRateDF;
        dfVal[4] = arslRateDF;
        dfVal[5] = atdoRateDF;
        dfVal[6] = atfoRateDF;
        dfVal[7] = asctRateDF;
        dfVal[8] = afctRateDF;
        dfVal[9] = asrRateDF;
        dfVal[10] = aerRateDF;
        dfVal[11] = ascRateDF;
        dfVal[12] = aecRateDF;
        dfVal[13] = asbtRateDF;
        dfVal[14] = aebtRateDF;
        dfVal[15] = atdcRateDF;
        dfVal[16] = atfcRateDF;
        dfVal[17] = aactRateDF;
        dfVal[18] = alswRateDF;
        dfVal[19] = aobtRateDF;
        dfVal[20] = dgrndTsfTmRateDF;
        dfVal[21] = atotRateDDF;
        dfVal[22] = cargoWeightARateDF;
        dfVal[23] = mailWeightARateDF;
        dfVal[24] = bagWeightARateDF;
        dfVal[25] = reservationsARateDF;
        dfVal[26] = cargoWeightDRateDF;
        dfVal[27] = mailWeightDRateDF;
        dfVal[28] = bagWeightDRateDF;
        dfVal[29] = reservationsDRateDF;


        //平均值数组
        BigDecimal []avgVal = new BigDecimal[30];
        avgVal[0] = atotRateAAVG;
        avgVal[1] = aldtRateAVG;
        avgVal[2] = agrndTsfTmRateAVG;
        avgVal[3] = aibtRateAVG;
        avgVal[4] = arslRateAVG;
        avgVal[5] = atdoRateAVG;
        avgVal[6] = atfoRateAVG;
        avgVal[7] = asctRateAVG;
        avgVal[8] = afctRateAVG;
        avgVal[9] = asrRateAVG;
        avgVal[10] = aerRateAVG;
        avgVal[11] = ascRateAVG;
        avgVal[12] = aecRateAVG;
        avgVal[13] = asbtRateAVG;
        avgVal[14] = aebtRateAVG;
        avgVal[15] = atdcRateAVG;
        avgVal[16] = atfcRateAVG;
        avgVal[17] = aactRateAVG;
        avgVal[18] = alswRateAVG;
        avgVal[19] = aobtRateAVG;
        avgVal[20] = dgrndTsfTmRateAVG;
        avgVal[21] = atotRateDAVG;
        avgVal[20] = dgrndTsfTmRateAVG;
        avgVal[21] = atotRateDAVG;
        avgVal[22] = cargoWeightARateAVG;
        avgVal[23] = mailWeightARateAVG;
        avgVal[24] = bagWeightARateAVG;
        avgVal[25] = reservationsARateAVG;
        avgVal[26] = cargoWeightDRateAVG;
        avgVal[27] = mailWeightDRateAVG;
        avgVal[28] = bagWeightDRateAVG;
        avgVal[29] = reservationsDRateAVG;

        List<BigDecimal[]> staticData = new ArrayList<BigDecimal[]>();
        staticData.add(dhVal);
        staticData.add(nhVal);
        staticData.add(ghVal);
        staticData.add(dfVal);
        staticData.add(avgVal);

        NodeCoverageBarVo vo = new NodeCoverageBarVo();
        vo.setLegendData(legendData);
        vo.setStaticData(staticData);

        return vo;
    }

    @Override
    public List<NodeCoverageTableVo> findTableData(Map params) {

        List<NodeCoverageTableVo> returnList = new ArrayList<NodeCoverageTableVo>();

        List<NodeCoverageReportVo> listA = this.findAllNodeCoverageA(params);
        List<NodeCoverageReportVo> listD = this.findAllNodeCoverageD(params);
        List<NodeCoverageReportVo> listDandA = this.findAllNodeCoverageDandA(params);

        /**
         * 过站航班统计-----------------------过站航班统计------------------------------
         */

        //过站东航----------------------------过站东航-------------------------
        NodeCoverageTableVo voGZDH = new NodeCoverageTableVo();
        voGZDH.setType("过站");
        voGZDH.setName("东航");
        voGZDH.setNumber(listDandA.get(0).getTotal());

        //过站东航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeGZDHList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeVoDH1 = new NodeCoverageTableNodeVo();
        nodeVoDH1.setFrequency(listDandA.get(0).getAtotA());
        nodeVoDH1.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH1);

        NodeCoverageTableNodeVo nodeVoDH2 = new NodeCoverageTableNodeVo();
        nodeVoDH2.setFrequency(listDandA.get(0).getAldt());
        nodeVoDH2.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH2);

        NodeCoverageTableNodeVo nodeVoDH3 = new NodeCoverageTableNodeVo();
        nodeVoDH3.setFrequency(listDandA.get(0).getAgrndTsfTm());
        nodeVoDH3.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH3);

        NodeCoverageTableNodeVo nodeVoDH4 = new NodeCoverageTableNodeVo();
        nodeVoDH4.setFrequency(listDandA.get(0).getAibt());
        nodeVoDH4.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH4);

        NodeCoverageTableNodeVo nodeVoDH5 = new NodeCoverageTableNodeVo();
        nodeVoDH5.setFrequency(listDandA.get(0).getArsl());
        nodeVoDH5.setFrequencyPercent(new BigDecimal(listDandA.get(0).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH5);

        NodeCoverageTableNodeVo nodeVoDH6 = new NodeCoverageTableNodeVo();
        nodeVoDH6.setFrequency(listDandA.get(0).getAtdo());
        nodeVoDH6.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH6);

        NodeCoverageTableNodeVo nodeVoDH7 = new NodeCoverageTableNodeVo();
        nodeVoDH7.setFrequency(listDandA.get(0).getAtfo());
        nodeVoDH7.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH7);

        NodeCoverageTableNodeVo nodeVoDH8 = new NodeCoverageTableNodeVo();
        nodeVoDH8.setFrequency(listDandA.get(0).getAsct());
        nodeVoDH8.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH8);

        NodeCoverageTableNodeVo nodeVoDH9 = new NodeCoverageTableNodeVo();
        nodeVoDH9.setFrequency(listDandA.get(0).getAfct());
        nodeVoDH9.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH9);

        NodeCoverageTableNodeVo nodeVoDH10 = new NodeCoverageTableNodeVo();
        nodeVoDH10.setFrequency(listDandA.get(0).getAsr());
        nodeVoDH10.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH10);

        NodeCoverageTableNodeVo nodeVoDH11 = new NodeCoverageTableNodeVo();
        nodeVoDH11.setFrequency(listDandA.get(0).getAer());
        nodeVoDH11.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH11);

        NodeCoverageTableNodeVo nodeVoDH12 = new NodeCoverageTableNodeVo();
        nodeVoDH12.setFrequency(listDandA.get(0).getAsc());
        nodeVoDH12.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH12);

        NodeCoverageTableNodeVo nodeVoDH13 = new NodeCoverageTableNodeVo();
        nodeVoDH13.setFrequency(listDandA.get(0).getAec());
        nodeVoDH13.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH13);

        NodeCoverageTableNodeVo nodeVoDH14 = new NodeCoverageTableNodeVo();
        nodeVoDH14.setFrequency(listDandA.get(0).getAsbt());
        nodeVoDH14.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH14);

        NodeCoverageTableNodeVo nodeVoDH15 = new NodeCoverageTableNodeVo();
        nodeVoDH15.setFrequency(listDandA.get(0).getAebt());
        nodeVoDH15.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH15);

        NodeCoverageTableNodeVo nodeVoDH16 = new NodeCoverageTableNodeVo();
        nodeVoDH16.setFrequency(listDandA.get(0).getAtdc());
        nodeVoDH16.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH16);

        NodeCoverageTableNodeVo nodeVoDH17 = new NodeCoverageTableNodeVo();
        nodeVoDH17.setFrequency(listDandA.get(0).getAtfc());
        nodeVoDH17.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH17);

        NodeCoverageTableNodeVo nodeVoDH18 = new NodeCoverageTableNodeVo();
        nodeVoDH18.setFrequency(listDandA.get(0).getAact());
        nodeVoDH18.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH18);

        NodeCoverageTableNodeVo nodeVoDH19 = new NodeCoverageTableNodeVo();
        nodeVoDH19.setFrequency(listDandA.get(0).getAlsw());
        nodeVoDH19.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH19);

        NodeCoverageTableNodeVo nodeVoDH20 = new NodeCoverageTableNodeVo();
        nodeVoDH20.setFrequency(listDandA.get(0).getAobt());
        nodeVoDH20.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH20);

        NodeCoverageTableNodeVo nodeVoDH21 = new NodeCoverageTableNodeVo();
        nodeVoDH21.setFrequency(listDandA.get(0).getDgrndTsfTm());
        nodeVoDH21.setFrequencyPercent(new BigDecimal(listDandA.get(0).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH21);

        NodeCoverageTableNodeVo nodeVoDH22 = new NodeCoverageTableNodeVo();
        nodeVoDH22.setFrequency(listDandA.get(0).getAtotD());
        nodeVoDH22.setFrequencyPercent(new BigDecimal(listDandA.get(0).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH22);

        NodeCoverageTableNodeVo nodeVoDH23 = new NodeCoverageTableNodeVo();
        nodeVoDH23.setFrequency(listDandA.get(0).getCargoWeightA());
        nodeVoDH23.setFrequencyPercent(new BigDecimal(listDandA.get(0).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH23);

        NodeCoverageTableNodeVo nodeVoDH24 = new NodeCoverageTableNodeVo();
        nodeVoDH24.setFrequency(listDandA.get(0).getMailWeightA());
        nodeVoDH24.setFrequencyPercent(new BigDecimal(listDandA.get(0).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH24);

        NodeCoverageTableNodeVo nodeVoDH25 = new NodeCoverageTableNodeVo();
        nodeVoDH25.setFrequency(listDandA.get(0).getBagWeightA());
        nodeVoDH25.setFrequencyPercent(new BigDecimal(listDandA.get(0).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH25);

        NodeCoverageTableNodeVo nodeVoDH26 = new NodeCoverageTableNodeVo();
        nodeVoDH26.setFrequency(listDandA.get(0).getReservationsA());
        nodeVoDH26.setFrequencyPercent(new BigDecimal(listDandA.get(0).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH26);

        NodeCoverageTableNodeVo nodeVoDH27 = new NodeCoverageTableNodeVo();
        nodeVoDH27.setFrequency(listDandA.get(0).getCargoWeightD());
        nodeVoDH27.setFrequencyPercent(new BigDecimal(listDandA.get(0).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH27);

        NodeCoverageTableNodeVo nodeVoDH28 = new NodeCoverageTableNodeVo();
        nodeVoDH28.setFrequency(listDandA.get(0).getMailWeightD());
        nodeVoDH28.setFrequencyPercent(new BigDecimal(listDandA.get(0).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH28);

        NodeCoverageTableNodeVo nodeVoDH29 = new NodeCoverageTableNodeVo();
        nodeVoDH29.setFrequency(listDandA.get(0).getBagWeightD());
        nodeVoDH29.setFrequencyPercent(new BigDecimal(listDandA.get(0).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH29);

        NodeCoverageTableNodeVo nodeVoDH30 = new NodeCoverageTableNodeVo();
        nodeVoDH30.setFrequency(listDandA.get(0).getReservationsD());
        nodeVoDH30.setFrequencyPercent(new BigDecimal(listDandA.get(0).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDHList.add(nodeVoDH30);

        //添加过站东航保障节点
        voGZDH.setMechanism(nodeGZDHList);
        //添加过站东航
        returnList.add(voGZDH);



        //过站南航----------------------------过站南航-------------------------
        NodeCoverageTableVo voGZNH = new NodeCoverageTableVo();
        voGZNH.setType("");
        voGZNH.setName("南航");
        voGZNH.setNumber(listDandA.get(1).getTotal());

        //过站南航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeGZNHList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeVoNH1 = new NodeCoverageTableNodeVo();
        nodeVoNH1.setFrequency(listDandA.get(1).getAtotA());
        nodeVoNH1.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH1);

        NodeCoverageTableNodeVo nodeVoNH2 = new NodeCoverageTableNodeVo();
        nodeVoNH2.setFrequency(listDandA.get(1).getAldt());
        nodeVoNH2.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH2);

        NodeCoverageTableNodeVo nodeVoNH3 = new NodeCoverageTableNodeVo();
        nodeVoNH3.setFrequency(listDandA.get(1).getAgrndTsfTm());
        nodeVoNH3.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH3);

        NodeCoverageTableNodeVo nodeVoNH4 = new NodeCoverageTableNodeVo();
        nodeVoNH4.setFrequency(listDandA.get(1).getAibt());
        nodeVoNH4.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH4);

        NodeCoverageTableNodeVo nodeVoNH5 = new NodeCoverageTableNodeVo();
        nodeVoNH5.setFrequency(listDandA.get(1).getArsl());
        nodeVoNH5.setFrequencyPercent(new BigDecimal(listDandA.get(1).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH5);

        NodeCoverageTableNodeVo nodeVoNH6 = new NodeCoverageTableNodeVo();
        nodeVoNH6.setFrequency(listDandA.get(1).getAtdo());
        nodeVoNH6.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH6);

        NodeCoverageTableNodeVo nodeVoNH7 = new NodeCoverageTableNodeVo();
        nodeVoNH7.setFrequency(listDandA.get(1).getAtfo());
        nodeVoNH7.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH7);

        NodeCoverageTableNodeVo nodeVoNH8 = new NodeCoverageTableNodeVo();
        nodeVoNH8.setFrequency(listDandA.get(1).getAsct());
        nodeVoNH8.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH8);

        NodeCoverageTableNodeVo nodeVoNH9 = new NodeCoverageTableNodeVo();
        nodeVoNH9.setFrequency(listDandA.get(1).getAfct());
        nodeVoNH9.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH9);

        NodeCoverageTableNodeVo nodeVoNH10 = new NodeCoverageTableNodeVo();
        nodeVoNH10.setFrequency(listDandA.get(1).getAsr());
        nodeVoNH10.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH10);

        NodeCoverageTableNodeVo nodeVoNH11 = new NodeCoverageTableNodeVo();
        nodeVoNH11.setFrequency(listDandA.get(1).getAer());
        nodeVoNH11.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH11);

        NodeCoverageTableNodeVo nodeVoNH12 = new NodeCoverageTableNodeVo();
        nodeVoNH12.setFrequency(listDandA.get(1).getAsc());
        nodeVoNH12.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH12);

        NodeCoverageTableNodeVo nodeVoNH13 = new NodeCoverageTableNodeVo();
        nodeVoNH13.setFrequency(listDandA.get(1).getAec());
        nodeVoNH13.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH13);

        NodeCoverageTableNodeVo nodeVoNH14 = new NodeCoverageTableNodeVo();
        nodeVoNH14.setFrequency(listDandA.get(1).getAsbt());
        nodeVoNH14.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH14);

        NodeCoverageTableNodeVo nodeVoNH15 = new NodeCoverageTableNodeVo();
        nodeVoNH15.setFrequency(listDandA.get(1).getAebt());
        nodeVoNH15.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH15);

        NodeCoverageTableNodeVo nodeVoNH16 = new NodeCoverageTableNodeVo();
        nodeVoNH16.setFrequency(listDandA.get(1).getAtdc());
        nodeVoNH16.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH16);

        NodeCoverageTableNodeVo nodeVoNH17 = new NodeCoverageTableNodeVo();
        nodeVoNH17.setFrequency(listDandA.get(1).getAtfc());
        nodeVoNH17.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH17);

        NodeCoverageTableNodeVo nodeVoNH18 = new NodeCoverageTableNodeVo();
        nodeVoNH18.setFrequency(listDandA.get(1).getAact());
        nodeVoNH18.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH18);

        NodeCoverageTableNodeVo nodeVoNH19 = new NodeCoverageTableNodeVo();
        nodeVoNH19.setFrequency(listDandA.get(1).getAlsw());
        nodeVoNH19.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH19);

        NodeCoverageTableNodeVo nodeVoNH20 = new NodeCoverageTableNodeVo();
        nodeVoNH20.setFrequency(listDandA.get(1).getAobt());
        nodeVoNH20.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH20);

        NodeCoverageTableNodeVo nodeVoNH21 = new NodeCoverageTableNodeVo();
        nodeVoNH21.setFrequency(listDandA.get(1).getDgrndTsfTm());
        nodeVoNH21.setFrequencyPercent(new BigDecimal(listDandA.get(1).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH21);

        NodeCoverageTableNodeVo nodeVoNH22 = new NodeCoverageTableNodeVo();
        nodeVoNH22.setFrequency(listDandA.get(1).getAtotD());
        nodeVoNH22.setFrequencyPercent(new BigDecimal(listDandA.get(1).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH22);

        NodeCoverageTableNodeVo nodeVoNH23 = new NodeCoverageTableNodeVo();
        nodeVoNH23.setFrequency(listDandA.get(1).getCargoWeightA());
        nodeVoNH23.setFrequencyPercent(new BigDecimal(listDandA.get(1).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH23);

        NodeCoverageTableNodeVo nodeVoNH24 = new NodeCoverageTableNodeVo();
        nodeVoNH24.setFrequency(listDandA.get(1).getMailWeightA());
        nodeVoNH24.setFrequencyPercent(new BigDecimal(listDandA.get(1).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH24);

        NodeCoverageTableNodeVo nodeVoNH25 = new NodeCoverageTableNodeVo();
        nodeVoNH25.setFrequency(listDandA.get(1).getBagWeightA());
        nodeVoNH25.setFrequencyPercent(new BigDecimal(listDandA.get(1).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH25);

        NodeCoverageTableNodeVo nodeVoNH26 = new NodeCoverageTableNodeVo();
        nodeVoNH26.setFrequency(listDandA.get(1).getReservationsA());
        nodeVoNH26.setFrequencyPercent(new BigDecimal(listDandA.get(1).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH26);

        NodeCoverageTableNodeVo nodeVoNH27 = new NodeCoverageTableNodeVo();
        nodeVoNH27.setFrequency(listDandA.get(1).getCargoWeightD());
        nodeVoNH27.setFrequencyPercent(new BigDecimal(listDandA.get(1).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH27);

        NodeCoverageTableNodeVo nodeVoNH28 = new NodeCoverageTableNodeVo();
        nodeVoNH28.setFrequency(listDandA.get(1).getMailWeightD());
        nodeVoNH28.setFrequencyPercent(new BigDecimal(listDandA.get(1).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH28);

        NodeCoverageTableNodeVo nodeVoNH29 = new NodeCoverageTableNodeVo();
        nodeVoNH29.setFrequency(listDandA.get(1).getBagWeightD());
        nodeVoNH29.setFrequencyPercent(new BigDecimal(listDandA.get(1).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH29);

        NodeCoverageTableNodeVo nodeVoNH30 = new NodeCoverageTableNodeVo();
        nodeVoNH30.setFrequency(listDandA.get(1).getReservationsD());
        nodeVoNH30.setFrequencyPercent(new BigDecimal(listDandA.get(1).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZNHList.add(nodeVoNH30);

        //添加过站南航保障节点
        voGZNH.setMechanism(nodeGZNHList);
        //添加过站南航
        returnList.add(voGZNH);




        //过站国航----------------------------过站国航-------------------------
        NodeCoverageTableVo voGZGH = new NodeCoverageTableVo();
        voGZGH.setType("");
        voGZGH.setName("国航");
        voGZGH.setNumber(listDandA.get(2).getTotal());

        //过站国航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeGZGHList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeVoGH1 = new NodeCoverageTableNodeVo();
        nodeVoGH1.setFrequency(listDandA.get(2).getAtotA());
        nodeVoGH1.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH1);

        NodeCoverageTableNodeVo nodeVoGH2 = new NodeCoverageTableNodeVo();
        nodeVoGH2.setFrequency(listDandA.get(2).getAldt());
        nodeVoGH2.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH2);

        NodeCoverageTableNodeVo nodeVoGH3 = new NodeCoverageTableNodeVo();
        nodeVoGH3.setFrequency(listDandA.get(2).getAgrndTsfTm());
        nodeVoGH3.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH3);

        NodeCoverageTableNodeVo nodeVoGH4 = new NodeCoverageTableNodeVo();
        nodeVoGH4.setFrequency(listDandA.get(2).getAibt());
        nodeVoGH4.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH4);

        NodeCoverageTableNodeVo nodeVoGH5 = new NodeCoverageTableNodeVo();
        nodeVoGH5.setFrequency(listDandA.get(2).getArsl());
        nodeVoGH5.setFrequencyPercent(new BigDecimal(listDandA.get(2).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH5);

        NodeCoverageTableNodeVo nodeVoGH6 = new NodeCoverageTableNodeVo();
        nodeVoGH6.setFrequency(listDandA.get(2).getAtdo());
        nodeVoGH6.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH6);

        NodeCoverageTableNodeVo nodeVoGH7 = new NodeCoverageTableNodeVo();
        nodeVoGH7.setFrequency(listDandA.get(2).getAtfo());
        nodeVoGH7.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH7);

        NodeCoverageTableNodeVo nodeVoGH8 = new NodeCoverageTableNodeVo();
        nodeVoGH8.setFrequency(listDandA.get(2).getAsct());
        nodeVoGH8.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH8);

        NodeCoverageTableNodeVo nodeVoGH9 = new NodeCoverageTableNodeVo();
        nodeVoGH9.setFrequency(listDandA.get(2).getAfct());
        nodeVoGH9.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH9);

        NodeCoverageTableNodeVo nodeVoGH10 = new NodeCoverageTableNodeVo();
        nodeVoGH10.setFrequency(listDandA.get(2).getAsr());
        nodeVoGH10.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH10);

        NodeCoverageTableNodeVo nodeVoGH11 = new NodeCoverageTableNodeVo();
        nodeVoGH11.setFrequency(listDandA.get(2).getAer());
        nodeVoGH11.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH11);

        NodeCoverageTableNodeVo nodeVoGH12 = new NodeCoverageTableNodeVo();
        nodeVoGH12.setFrequency(listDandA.get(2).getAsc());
        nodeVoGH12.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH12);

        NodeCoverageTableNodeVo nodeVoGH13 = new NodeCoverageTableNodeVo();
        nodeVoGH13.setFrequency(listDandA.get(2).getAec());
        nodeVoGH13.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH13);

        NodeCoverageTableNodeVo nodeVoGH14 = new NodeCoverageTableNodeVo();
        nodeVoGH14.setFrequency(listDandA.get(2).getAsbt());
        nodeVoGH14.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH14);

        NodeCoverageTableNodeVo nodeVoGH15 = new NodeCoverageTableNodeVo();
        nodeVoGH15.setFrequency(listDandA.get(2).getAebt());
        nodeVoGH15.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH15);

        NodeCoverageTableNodeVo nodeVoGH16 = new NodeCoverageTableNodeVo();
        nodeVoGH16.setFrequency(listDandA.get(2).getAtdc());
        nodeVoGH16.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH16);

        NodeCoverageTableNodeVo nodeVoGH17 = new NodeCoverageTableNodeVo();
        nodeVoGH17.setFrequency(listDandA.get(2).getAtfc());
        nodeVoGH17.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH17);

        NodeCoverageTableNodeVo nodeVoGH18 = new NodeCoverageTableNodeVo();
        nodeVoGH18.setFrequency(listDandA.get(2).getAact());
        nodeVoGH18.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH18);

        NodeCoverageTableNodeVo nodeVoGH19 = new NodeCoverageTableNodeVo();
        nodeVoGH19.setFrequency(listDandA.get(2).getAlsw());
        nodeVoGH19.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH19);

        NodeCoverageTableNodeVo nodeVoGH20 = new NodeCoverageTableNodeVo();
        nodeVoGH20.setFrequency(listDandA.get(2).getAobt());
        nodeVoGH20.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH20);

        NodeCoverageTableNodeVo nodeVoGH21 = new NodeCoverageTableNodeVo();
        nodeVoGH21.setFrequency(listDandA.get(2).getDgrndTsfTm());
        nodeVoGH21.setFrequencyPercent(new BigDecimal(listDandA.get(2).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH21);

        NodeCoverageTableNodeVo nodeVoGH22 = new NodeCoverageTableNodeVo();
        nodeVoGH22.setFrequency(listDandA.get(2).getAtotD());
        nodeVoGH22.setFrequencyPercent(new BigDecimal(listDandA.get(2).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH22);


        NodeCoverageTableNodeVo nodeVoGH23 = new NodeCoverageTableNodeVo();
        nodeVoGH23.setFrequency(listDandA.get(2).getCargoWeightA());
        nodeVoGH23.setFrequencyPercent(new BigDecimal(listDandA.get(2).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH23);

        NodeCoverageTableNodeVo nodeVoGH24 = new NodeCoverageTableNodeVo();
        nodeVoGH24.setFrequency(listDandA.get(2).getMailWeightA());
        nodeVoGH24.setFrequencyPercent(new BigDecimal(listDandA.get(2).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH24);

        NodeCoverageTableNodeVo nodeVoGH25 = new NodeCoverageTableNodeVo();
        nodeVoGH25.setFrequency(listDandA.get(2).getBagWeightA());
        nodeVoGH25.setFrequencyPercent(new BigDecimal(listDandA.get(2).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH25);

        NodeCoverageTableNodeVo nodeVoGH26 = new NodeCoverageTableNodeVo();
        nodeVoGH26.setFrequency(listDandA.get(2).getReservationsA());
        nodeVoGH26.setFrequencyPercent(new BigDecimal(listDandA.get(2).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH26);

        NodeCoverageTableNodeVo nodeVoGH27 = new NodeCoverageTableNodeVo();
        nodeVoGH27.setFrequency(listDandA.get(2).getCargoWeightD());
        nodeVoGH27.setFrequencyPercent(new BigDecimal(listDandA.get(2).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH27);

        NodeCoverageTableNodeVo nodeVoGH28 = new NodeCoverageTableNodeVo();
        nodeVoGH28.setFrequency(listDandA.get(2).getMailWeightD());
        nodeVoGH28.setFrequencyPercent(new BigDecimal(listDandA.get(2).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH28);

        NodeCoverageTableNodeVo nodeVoGH29 = new NodeCoverageTableNodeVo();
        nodeVoGH29.setFrequency(listDandA.get(2).getBagWeightD());
        nodeVoGH29.setFrequencyPercent(new BigDecimal(listDandA.get(2).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH29);

        NodeCoverageTableNodeVo nodeVoGH30 = new NodeCoverageTableNodeVo();
        nodeVoGH30.setFrequency(listDandA.get(2).getReservationsD());
        nodeVoGH30.setFrequencyPercent(new BigDecimal(listDandA.get(2).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZGHList.add(nodeVoGH30);

        //添加过站国航保障节点
        voGZGH.setMechanism(nodeGZGHList);
        //添加过站国航
        returnList.add(voGZGH);



        //过站地服----------------------------过站地服-------------------------
        NodeCoverageTableVo voGZDF = new NodeCoverageTableVo();
        voGZDF.setType("");
        voGZDF.setName("地服");
        voGZDF.setNumber(listDandA.get(3).getTotal());

        //过站国航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeGZDFList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeVoDF1 = new NodeCoverageTableNodeVo();
        nodeVoDF1.setFrequency(listDandA.get(3).getAtotA());
        nodeVoDF1.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF1);

        NodeCoverageTableNodeVo nodeVoDF2 = new NodeCoverageTableNodeVo();
        nodeVoDF2.setFrequency(listDandA.get(3).getAldt());
        nodeVoDF2.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF2);

        NodeCoverageTableNodeVo nodeVoDF3 = new NodeCoverageTableNodeVo();
        nodeVoDF3.setFrequency(listDandA.get(3).getAgrndTsfTm());
        nodeVoDF3.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF3);

        NodeCoverageTableNodeVo nodeVoDF4 = new NodeCoverageTableNodeVo();
        nodeVoDF4.setFrequency(listDandA.get(3).getAibt());
        nodeVoDF4.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF4);

        NodeCoverageTableNodeVo nodeVoDF5 = new NodeCoverageTableNodeVo();
        nodeVoDF5.setFrequency(listDandA.get(3).getArsl());
        nodeVoDF5.setFrequencyPercent(new BigDecimal(listDandA.get(3).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF5);

        NodeCoverageTableNodeVo nodeVoDF6 = new NodeCoverageTableNodeVo();
        nodeVoDF6.setFrequency(listDandA.get(3).getAtdo());
        nodeVoDF6.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF6);

        NodeCoverageTableNodeVo nodeVoDF7 = new NodeCoverageTableNodeVo();
        nodeVoDF7.setFrequency(listDandA.get(3).getAtfo());
        nodeVoDF7.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF7);

        NodeCoverageTableNodeVo nodeVoDF8 = new NodeCoverageTableNodeVo();
        nodeVoDF8.setFrequency(listDandA.get(3).getAsct());
        nodeVoDF8.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF8);

        NodeCoverageTableNodeVo nodeVoDF9 = new NodeCoverageTableNodeVo();
        nodeVoDF9.setFrequency(listDandA.get(3).getAfct());
        nodeVoDF9.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF9);

        NodeCoverageTableNodeVo nodeVoDF10 = new NodeCoverageTableNodeVo();
        nodeVoDF10.setFrequency(listDandA.get(3).getAsr());
        nodeVoDF10.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF10);

        NodeCoverageTableNodeVo nodeVoDF11 = new NodeCoverageTableNodeVo();
        nodeVoDF11.setFrequency(listDandA.get(3).getAer());
        nodeVoDF11.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF11);

        NodeCoverageTableNodeVo nodeVoDF12 = new NodeCoverageTableNodeVo();
        nodeVoDF12.setFrequency(listDandA.get(3).getAsc());
        nodeVoDF12.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF12);

        NodeCoverageTableNodeVo nodeVoDF13 = new NodeCoverageTableNodeVo();
        nodeVoDF13.setFrequency(listDandA.get(3).getAec());
        nodeVoDF13.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF13);

        NodeCoverageTableNodeVo nodeVoDF14 = new NodeCoverageTableNodeVo();
        nodeVoDF14.setFrequency(listDandA.get(3).getAsbt());
        nodeVoDF14.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF14);

        NodeCoverageTableNodeVo nodeVoDF15 = new NodeCoverageTableNodeVo();
        nodeVoDF15.setFrequency(listDandA.get(3).getAebt());
        nodeVoDF15.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF15);

        NodeCoverageTableNodeVo nodeVoDF16 = new NodeCoverageTableNodeVo();
        nodeVoDF16.setFrequency(listDandA.get(3).getAtdc());
        nodeVoDF16.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF16);

        NodeCoverageTableNodeVo nodeVoDF17 = new NodeCoverageTableNodeVo();
        nodeVoDF17.setFrequency(listDandA.get(3).getAtfc());
        nodeVoDF17.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF17);

        NodeCoverageTableNodeVo nodeVoDF18 = new NodeCoverageTableNodeVo();
        nodeVoDF18.setFrequency(listDandA.get(3).getAact());
        nodeVoDF18.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF18);

        NodeCoverageTableNodeVo nodeVoDF19 = new NodeCoverageTableNodeVo();
        nodeVoDF19.setFrequency(listDandA.get(3).getAlsw());
        nodeVoDF19.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF19);

        NodeCoverageTableNodeVo nodeVoDF20 = new NodeCoverageTableNodeVo();
        nodeVoDF20.setFrequency(listDandA.get(3).getAobt());
        nodeVoDF20.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF20);

        NodeCoverageTableNodeVo nodeVoDF21 = new NodeCoverageTableNodeVo();
        nodeVoDF21.setFrequency(listDandA.get(3).getDgrndTsfTm());
        nodeVoDF21.setFrequencyPercent(new BigDecimal(listDandA.get(3).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF21);

        NodeCoverageTableNodeVo nodeVoDF22 = new NodeCoverageTableNodeVo();
        nodeVoDF22.setFrequency(listDandA.get(3).getAtotD());
        nodeVoDF22.setFrequencyPercent(new BigDecimal(listDandA.get(3).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF22);

        NodeCoverageTableNodeVo nodeVoDF23 = new NodeCoverageTableNodeVo();
        nodeVoDF23.setFrequency(listDandA.get(3).getCargoWeightA());
        nodeVoDF23.setFrequencyPercent(new BigDecimal(listDandA.get(3).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF23);

        NodeCoverageTableNodeVo nodeVoDF24 = new NodeCoverageTableNodeVo();
        nodeVoDF24.setFrequency(listDandA.get(3).getMailWeightA());
        nodeVoDF24.setFrequencyPercent(new BigDecimal(listDandA.get(3).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF24);

        NodeCoverageTableNodeVo nodeVoDF25 = new NodeCoverageTableNodeVo();
        nodeVoDF25.setFrequency(listDandA.get(3).getBagWeightA());
        nodeVoDF25.setFrequencyPercent(new BigDecimal(listDandA.get(3).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF25);

        NodeCoverageTableNodeVo nodeVoDF26 = new NodeCoverageTableNodeVo();
        nodeVoDF26.setFrequency(listDandA.get(3).getReservationsA());
        nodeVoDF26.setFrequencyPercent(new BigDecimal(listDandA.get(3).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF26);

        NodeCoverageTableNodeVo nodeVoDF27 = new NodeCoverageTableNodeVo();
        nodeVoDF27.setFrequency(listDandA.get(3).getCargoWeightD());
        nodeVoDF27.setFrequencyPercent(new BigDecimal(listDandA.get(3).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF27);

        NodeCoverageTableNodeVo nodeVoDF28 = new NodeCoverageTableNodeVo();
        nodeVoDF28.setFrequency(listDandA.get(3).getMailWeightD());
        nodeVoDF28.setFrequencyPercent(new BigDecimal(listDandA.get(3).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF28);

        NodeCoverageTableNodeVo nodeVoDF29 = new NodeCoverageTableNodeVo();
        nodeVoDF29.setFrequency(listDandA.get(3).getBagWeightD());
        nodeVoDF29.setFrequencyPercent(new BigDecimal(listDandA.get(3).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF29);

        NodeCoverageTableNodeVo nodeVoDF30 = new NodeCoverageTableNodeVo();
        nodeVoDF30.setFrequency(listDandA.get(3).getReservationsD());
        nodeVoDF30.setFrequencyPercent(new BigDecimal(listDandA.get(3).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeGZDFList.add(nodeVoDF30);

        //添加过站地服保障节点
        voGZDF.setMechanism(nodeGZDFList);
        //添加过站地服
        returnList.add(voGZDF);


        /**
         * 单进航班统计-----------------------单进航班统计------------------------------
         */

        //单进东航----------------------------单进东航-------------------------
        NodeCoverageTableVo voADH = new NodeCoverageTableVo();
        voADH.setType("单进");
        voADH.setName("东航");
        voADH.setNumber(listA.get(0).getTotal());

        //单进东航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeADHList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeAVoDH1 = new NodeCoverageTableNodeVo();
        nodeAVoDH1.setFrequency(listA.get(0).getAtotA());
        nodeAVoDH1.setFrequencyPercent(new BigDecimal(listA.get(0).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH1);

        NodeCoverageTableNodeVo nodeAVoDH2 = new NodeCoverageTableNodeVo();
        nodeAVoDH2.setFrequency(listA.get(0).getAldt());
        nodeAVoDH2.setFrequencyPercent(new BigDecimal(listA.get(0).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH2);

        NodeCoverageTableNodeVo nodeAVoDH3 = new NodeCoverageTableNodeVo();
        nodeAVoDH3.setFrequency(listA.get(0).getAgrndTsfTm());
        nodeAVoDH3.setFrequencyPercent(new BigDecimal(listA.get(0).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH3);

        NodeCoverageTableNodeVo nodeAVoDH4 = new NodeCoverageTableNodeVo();
        nodeAVoDH4.setFrequency(listA.get(0).getAibt());
        nodeAVoDH4.setFrequencyPercent(new BigDecimal(listA.get(0).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH4);

        NodeCoverageTableNodeVo nodeAVoDH5 = new NodeCoverageTableNodeVo();
        nodeAVoDH5.setFrequency(listA.get(0).getArsl());
        nodeAVoDH5.setFrequencyPercent(new BigDecimal(listA.get(0).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH5);

        NodeCoverageTableNodeVo nodeAVoDH6 = new NodeCoverageTableNodeVo();
        nodeAVoDH6.setFrequency(listA.get(0).getAtdo());
        nodeAVoDH6.setFrequencyPercent(new BigDecimal(listA.get(0).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH6);

        NodeCoverageTableNodeVo nodeAVoDH7 = new NodeCoverageTableNodeVo();
        nodeAVoDH7.setFrequency(listA.get(0).getAtfo());
        nodeAVoDH7.setFrequencyPercent(new BigDecimal(listA.get(0).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH7);

        NodeCoverageTableNodeVo nodeAVoDH8 = new NodeCoverageTableNodeVo();
        nodeAVoDH8.setFrequency(listA.get(0).getAsct());
        nodeAVoDH8.setFrequencyPercent(new BigDecimal(listA.get(0).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH8);

        NodeCoverageTableNodeVo nodeAVoDH9 = new NodeCoverageTableNodeVo();
        nodeAVoDH9.setFrequency(listA.get(0).getAfct());
        nodeAVoDH9.setFrequencyPercent(new BigDecimal(listA.get(0).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH9);

        NodeCoverageTableNodeVo nodeAVoDH10 = new NodeCoverageTableNodeVo();
        nodeAVoDH10.setFrequency(listA.get(0).getAsr());
        nodeAVoDH10.setFrequencyPercent(new BigDecimal(listA.get(0).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH10);

        NodeCoverageTableNodeVo nodeAVoDH11 = new NodeCoverageTableNodeVo();
        nodeAVoDH11.setFrequency(listA.get(0).getAer());
        nodeAVoDH11.setFrequencyPercent(new BigDecimal(listA.get(0).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH11);

        NodeCoverageTableNodeVo nodeAVoDH12 = new NodeCoverageTableNodeVo();
        nodeAVoDH12.setFrequency(listA.get(0).getAsc());
        nodeAVoDH12.setFrequencyPercent(new BigDecimal(listA.get(0).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH12);

        NodeCoverageTableNodeVo nodeAVoDH13 = new NodeCoverageTableNodeVo();
        nodeAVoDH13.setFrequency(listA.get(0).getAec());
        nodeAVoDH13.setFrequencyPercent(new BigDecimal(listA.get(0).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH13);

        NodeCoverageTableNodeVo nodeAVoDH14 = new NodeCoverageTableNodeVo();
        nodeAVoDH14.setFrequency(listA.get(0).getAsbt());
        nodeAVoDH14.setFrequencyPercent(new BigDecimal(listA.get(0).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH14);

        NodeCoverageTableNodeVo nodeAVoDH15 = new NodeCoverageTableNodeVo();
        nodeAVoDH15.setFrequency(listA.get(0).getAebt());
        nodeAVoDH15.setFrequencyPercent(new BigDecimal(listA.get(0).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH15);

        NodeCoverageTableNodeVo nodeAVoDH16 = new NodeCoverageTableNodeVo();
        nodeAVoDH16.setFrequency(listA.get(0).getAtdc());
        nodeAVoDH16.setFrequencyPercent(new BigDecimal(listA.get(0).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH16);

        NodeCoverageTableNodeVo nodeAVoDH17 = new NodeCoverageTableNodeVo();
        nodeAVoDH17.setFrequency(listA.get(0).getAtfc());
        nodeAVoDH17.setFrequencyPercent(new BigDecimal(listA.get(0).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH17);

        NodeCoverageTableNodeVo nodeAVoDH18 = new NodeCoverageTableNodeVo();
        nodeAVoDH18.setFrequency(listA.get(0).getAact());
        nodeAVoDH18.setFrequencyPercent(new BigDecimal(listA.get(0).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH18);

        NodeCoverageTableNodeVo nodeAVoDH19 = new NodeCoverageTableNodeVo();
        nodeAVoDH19.setFrequency(listA.get(0).getAlsw());
        nodeAVoDH19.setFrequencyPercent(new BigDecimal(listA.get(0).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH19);

        NodeCoverageTableNodeVo nodeAVoDH20 = new NodeCoverageTableNodeVo();
        nodeAVoDH20.setFrequency(listA.get(0).getAobt());
        nodeAVoDH20.setFrequencyPercent(new BigDecimal(listA.get(0).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH20);

        NodeCoverageTableNodeVo nodeAVoDH21 = new NodeCoverageTableNodeVo();
        nodeAVoDH21.setFrequency(listA.get(0).getDgrndTsfTm());
        nodeAVoDH21.setFrequencyPercent(new BigDecimal(listA.get(0).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH21);

        NodeCoverageTableNodeVo nodeAVoDH22 = new NodeCoverageTableNodeVo();
        nodeAVoDH22.setFrequency(listA.get(0).getAtotD());
        nodeAVoDH22.setFrequencyPercent(new BigDecimal(listA.get(0).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH22);

        NodeCoverageTableNodeVo nodeAVoDH23 = new NodeCoverageTableNodeVo();
        nodeAVoDH23.setFrequency(listA.get(0).getCargoWeightA());
        nodeAVoDH23.setFrequencyPercent(new BigDecimal(listA.get(0).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH23);

        NodeCoverageTableNodeVo nodeAVoDH24 = new NodeCoverageTableNodeVo();
        nodeAVoDH24.setFrequency(listA.get(0).getMailWeightA());
        nodeAVoDH24.setFrequencyPercent(new BigDecimal(listA.get(0).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH24);

        NodeCoverageTableNodeVo nodeAVoDH25 = new NodeCoverageTableNodeVo();
        nodeAVoDH25.setFrequency(listA.get(0).getBagWeightA());
        nodeAVoDH25.setFrequencyPercent(new BigDecimal(listA.get(0).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH25);

        NodeCoverageTableNodeVo nodeAVoDH26 = new NodeCoverageTableNodeVo();
        nodeAVoDH26.setFrequency(listA.get(0).getReservationsA());
        nodeAVoDH26.setFrequencyPercent(new BigDecimal(listA.get(0).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH26);

        NodeCoverageTableNodeVo nodeAVoDH27 = new NodeCoverageTableNodeVo();
        nodeAVoDH27.setFrequency(listA.get(0).getCargoWeightD());
        nodeAVoDH27.setFrequencyPercent(new BigDecimal(listA.get(0).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH27);

        NodeCoverageTableNodeVo nodeAVoDH28 = new NodeCoverageTableNodeVo();
        nodeAVoDH28.setFrequency(listA.get(0).getMailWeightD());
        nodeAVoDH28.setFrequencyPercent(new BigDecimal(listA.get(0).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH28);

        NodeCoverageTableNodeVo nodeAVoDH29 = new NodeCoverageTableNodeVo();
        nodeAVoDH29.setFrequency(listA.get(0).getBagWeightD());
        nodeAVoDH29.setFrequencyPercent(new BigDecimal(listA.get(0).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH29);

        NodeCoverageTableNodeVo nodeAVoDH30 = new NodeCoverageTableNodeVo();
        nodeAVoDH30.setFrequency(listA.get(0).getReservationsD());
        nodeAVoDH30.setFrequencyPercent(new BigDecimal(listA.get(0).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADHList.add(nodeAVoDH30);

        //添加单进东航保障节点
        voADH.setMechanism(nodeADHList);
        //添加单进东航
        returnList.add(voADH);



        //单进南航----------------------------单进南航-------------------------
        NodeCoverageTableVo voANH = new NodeCoverageTableVo();
        voANH.setType("");
        voANH.setName("南航");
        voANH.setNumber(listA.get(1).getTotal());

        //单进南航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeANHList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeAVoNH1 = new NodeCoverageTableNodeVo();
        nodeAVoNH1.setFrequency(listA.get(1).getAtotA());
        nodeAVoNH1.setFrequencyPercent(new BigDecimal(listA.get(1).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH1);

        NodeCoverageTableNodeVo nodeAVoNH2 = new NodeCoverageTableNodeVo();
        nodeAVoNH2.setFrequency(listA.get(1).getAldt());
        nodeAVoNH2.setFrequencyPercent(new BigDecimal(listA.get(1).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH2);

        NodeCoverageTableNodeVo nodeAVoNH3 = new NodeCoverageTableNodeVo();
        nodeAVoNH3.setFrequency(listA.get(1).getAgrndTsfTm());
        nodeAVoNH3.setFrequencyPercent(new BigDecimal(listA.get(1).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH3);

        NodeCoverageTableNodeVo nodeAVoNH4 = new NodeCoverageTableNodeVo();
        nodeAVoNH4.setFrequency(listA.get(1).getAibt());
        nodeAVoNH4.setFrequencyPercent(new BigDecimal(listA.get(1).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH4);

        NodeCoverageTableNodeVo nodeAVoNH5 = new NodeCoverageTableNodeVo();
        nodeAVoNH5.setFrequency(listA.get(1).getArsl());
        nodeAVoNH5.setFrequencyPercent(new BigDecimal(listA.get(1).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH5);

        NodeCoverageTableNodeVo nodeAVoNH6 = new NodeCoverageTableNodeVo();
        nodeAVoNH6.setFrequency(listA.get(1).getAtdo());
        nodeAVoNH6.setFrequencyPercent(new BigDecimal(listA.get(1).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH6);

        NodeCoverageTableNodeVo nodeAVoNH7 = new NodeCoverageTableNodeVo();
        nodeAVoNH7.setFrequency(listA.get(1).getAtfo());
        nodeAVoNH7.setFrequencyPercent(new BigDecimal(listA.get(1).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH7);

        NodeCoverageTableNodeVo nodeAVoNH8 = new NodeCoverageTableNodeVo();
        nodeAVoNH8.setFrequency(listA.get(1).getAsct());
        nodeAVoNH8.setFrequencyPercent(new BigDecimal(listA.get(1).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH8);

        NodeCoverageTableNodeVo nodeAVoNH9 = new NodeCoverageTableNodeVo();
        nodeAVoNH9.setFrequency(listA.get(1).getAfct());
        nodeAVoNH9.setFrequencyPercent(new BigDecimal(listA.get(1).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH9);

        NodeCoverageTableNodeVo nodeAVoNH10 = new NodeCoverageTableNodeVo();
        nodeAVoNH10.setFrequency(listA.get(1).getAsr());
        nodeAVoNH10.setFrequencyPercent(new BigDecimal(listA.get(1).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH10);

        NodeCoverageTableNodeVo nodeAVoNH11 = new NodeCoverageTableNodeVo();
        nodeAVoNH11.setFrequency(listA.get(1).getAer());
        nodeAVoNH11.setFrequencyPercent(new BigDecimal(listA.get(1).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH11);

        NodeCoverageTableNodeVo nodeAVoNH12 = new NodeCoverageTableNodeVo();
        nodeAVoNH12.setFrequency(listA.get(1).getAsc());
        nodeAVoNH12.setFrequencyPercent(new BigDecimal(listA.get(1).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH12);

        NodeCoverageTableNodeVo nodeAVoNH13 = new NodeCoverageTableNodeVo();
        nodeAVoNH13.setFrequency(listA.get(1).getAec());
        nodeAVoNH13.setFrequencyPercent(new BigDecimal(listA.get(1).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH13);

        NodeCoverageTableNodeVo nodeAVoNH14 = new NodeCoverageTableNodeVo();
        nodeAVoNH14.setFrequency(listA.get(1).getAsbt());
        nodeAVoNH14.setFrequencyPercent(new BigDecimal(listA.get(1).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH14);

        NodeCoverageTableNodeVo nodeAVoNH15 = new NodeCoverageTableNodeVo();
        nodeAVoNH15.setFrequency(listA.get(1).getAebt());
        nodeAVoNH15.setFrequencyPercent(new BigDecimal(listA.get(1).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH15);

        NodeCoverageTableNodeVo nodeAVoNH16 = new NodeCoverageTableNodeVo();
        nodeAVoNH16.setFrequency(listA.get(1).getAtdc());
        nodeAVoNH16.setFrequencyPercent(new BigDecimal(listA.get(1).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH16);

        NodeCoverageTableNodeVo nodeAVoNH17 = new NodeCoverageTableNodeVo();
        nodeAVoNH17.setFrequency(listA.get(1).getAtfc());
        nodeAVoNH17.setFrequencyPercent(new BigDecimal(listA.get(1).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH17);

        NodeCoverageTableNodeVo nodeAVoNH18 = new NodeCoverageTableNodeVo();
        nodeAVoNH18.setFrequency(listA.get(1).getAact());
        nodeAVoNH18.setFrequencyPercent(new BigDecimal(listA.get(1).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH18);

        NodeCoverageTableNodeVo nodeAVoNH19 = new NodeCoverageTableNodeVo();
        nodeAVoNH19.setFrequency(listA.get(1).getAlsw());
        nodeAVoNH19.setFrequencyPercent(new BigDecimal(listA.get(1).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH19);

        NodeCoverageTableNodeVo nodeAVoNH20 = new NodeCoverageTableNodeVo();
        nodeAVoNH20.setFrequency(listA.get(1).getAobt());
        nodeAVoNH20.setFrequencyPercent(new BigDecimal(listA.get(1).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH20);

        NodeCoverageTableNodeVo nodeAVoNH21 = new NodeCoverageTableNodeVo();
        nodeAVoNH21.setFrequency(listA.get(1).getDgrndTsfTm());
        nodeAVoNH21.setFrequencyPercent(new BigDecimal(listA.get(1).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH21);

        NodeCoverageTableNodeVo nodeAVoNH22 = new NodeCoverageTableNodeVo();
        nodeAVoNH22.setFrequency(listA.get(1).getAtotD());
        nodeAVoNH22.setFrequencyPercent(new BigDecimal(listA.get(1).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH22);


        NodeCoverageTableNodeVo nodeAVoNH23 = new NodeCoverageTableNodeVo();
        nodeAVoNH23.setFrequency(listA.get(1).getCargoWeightA());
        nodeAVoNH23.setFrequencyPercent(new BigDecimal(listA.get(1).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH23);

        NodeCoverageTableNodeVo nodeAVoNH24 = new NodeCoverageTableNodeVo();
        nodeAVoNH24.setFrequency(listA.get(1).getMailWeightA());
        nodeAVoNH24.setFrequencyPercent(new BigDecimal(listA.get(1).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH24);

        NodeCoverageTableNodeVo nodeAVoNH25 = new NodeCoverageTableNodeVo();
        nodeAVoNH25.setFrequency(listA.get(1).getBagWeightA());
        nodeAVoNH25.setFrequencyPercent(new BigDecimal(listA.get(1).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH25);

        NodeCoverageTableNodeVo nodeAVoNH26 = new NodeCoverageTableNodeVo();
        nodeAVoNH26.setFrequency(listA.get(1).getReservationsA());
        nodeAVoNH26.setFrequencyPercent(new BigDecimal(listA.get(1).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH26);

        NodeCoverageTableNodeVo nodeAVoNH27 = new NodeCoverageTableNodeVo();
        nodeAVoNH27.setFrequency(listA.get(1).getCargoWeightD());
        nodeAVoNH27.setFrequencyPercent(new BigDecimal(listA.get(1).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH27);

        NodeCoverageTableNodeVo nodeAVoNH28 = new NodeCoverageTableNodeVo();
        nodeAVoNH28.setFrequency(listA.get(1).getMailWeightD());
        nodeAVoNH28.setFrequencyPercent(new BigDecimal(listA.get(1).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH28);

        NodeCoverageTableNodeVo nodeAVoNH29 = new NodeCoverageTableNodeVo();
        nodeAVoNH29.setFrequency(listA.get(1).getBagWeightD());
        nodeAVoNH29.setFrequencyPercent(new BigDecimal(listA.get(1).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH29);

        NodeCoverageTableNodeVo nodeAVoNH30 = new NodeCoverageTableNodeVo();
        nodeAVoNH30.setFrequency(listA.get(1).getReservationsD());
        nodeAVoNH30.setFrequencyPercent(new BigDecimal(listA.get(1).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeANHList.add(nodeAVoNH30);

        //添加单进南航保障节点
        voANH.setMechanism(nodeANHList);
        //添加单进南航
        returnList.add(voANH);




        //单进国航----------------------------单进国航-------------------------
        NodeCoverageTableVo voAGH = new NodeCoverageTableVo();
        voAGH.setType("");
        voAGH.setName("国航");
        voAGH.setNumber(listA.get(2).getTotal());

        //单进国航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeAGHList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeAVoGH1 = new NodeCoverageTableNodeVo();
        nodeAVoGH1.setFrequency(listA.get(2).getAtotA());
        nodeAVoGH1.setFrequencyPercent(new BigDecimal(listA.get(2).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH1);

        NodeCoverageTableNodeVo nodeAVoGH2 = new NodeCoverageTableNodeVo();
        nodeAVoGH2.setFrequency(listA.get(2).getAldt());
        nodeAVoGH2.setFrequencyPercent(new BigDecimal(listA.get(2).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH2);

        NodeCoverageTableNodeVo nodeAVoGH3 = new NodeCoverageTableNodeVo();
        nodeAVoGH3.setFrequency(listA.get(2).getAgrndTsfTm());
        nodeAVoGH3.setFrequencyPercent(new BigDecimal(listA.get(2).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH3);

        NodeCoverageTableNodeVo nodeAVoGH4 = new NodeCoverageTableNodeVo();
        nodeAVoGH4.setFrequency(listA.get(2).getAibt());
        nodeAVoGH4.setFrequencyPercent(new BigDecimal(listA.get(2).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH4);

        NodeCoverageTableNodeVo nodeAVoGH5 = new NodeCoverageTableNodeVo();
        nodeAVoGH5.setFrequency(listA.get(2).getArsl());
        nodeAVoGH5.setFrequencyPercent(new BigDecimal(listA.get(2).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH5);

        NodeCoverageTableNodeVo nodeAVoGH6 = new NodeCoverageTableNodeVo();
        nodeAVoGH6.setFrequency(listA.get(2).getAtdo());
        nodeAVoGH6.setFrequencyPercent(new BigDecimal(listA.get(2).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH6);

        NodeCoverageTableNodeVo nodeAVoGH7 = new NodeCoverageTableNodeVo();
        nodeAVoGH7.setFrequency(listA.get(2).getAtfo());
        nodeAVoGH7.setFrequencyPercent(new BigDecimal(listA.get(2).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH7);

        NodeCoverageTableNodeVo nodeAVoGH8 = new NodeCoverageTableNodeVo();
        nodeAVoGH8.setFrequency(listA.get(2).getAsct());
        nodeAVoGH8.setFrequencyPercent(new BigDecimal(listA.get(2).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH8);

        NodeCoverageTableNodeVo nodeAVoGH9 = new NodeCoverageTableNodeVo();
        nodeAVoGH9.setFrequency(listA.get(2).getAfct());
        nodeAVoGH9.setFrequencyPercent(new BigDecimal(listA.get(2).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH9);

        NodeCoverageTableNodeVo nodeAVoGH10 = new NodeCoverageTableNodeVo();
        nodeAVoGH10.setFrequency(listA.get(2).getAsr());
        nodeAVoGH10.setFrequencyPercent(new BigDecimal(listA.get(2).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH10);

        NodeCoverageTableNodeVo nodeAVoGH11 = new NodeCoverageTableNodeVo();
        nodeAVoGH11.setFrequency(listA.get(2).getAer());
        nodeAVoGH11.setFrequencyPercent(new BigDecimal(listA.get(2).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH11);

        NodeCoverageTableNodeVo nodeAVoGH12 = new NodeCoverageTableNodeVo();
        nodeAVoGH12.setFrequency(listA.get(2).getAsc());
        nodeAVoGH12.setFrequencyPercent(new BigDecimal(listA.get(2).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH12);

        NodeCoverageTableNodeVo nodeAVoGH13 = new NodeCoverageTableNodeVo();
        nodeAVoGH13.setFrequency(listA.get(2).getAec());
        nodeAVoGH13.setFrequencyPercent(new BigDecimal(listA.get(2).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH13);

        NodeCoverageTableNodeVo nodeAVoGH14 = new NodeCoverageTableNodeVo();
        nodeAVoGH14.setFrequency(listA.get(2).getAsbt());
        nodeAVoGH14.setFrequencyPercent(new BigDecimal(listA.get(2).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH14);

        NodeCoverageTableNodeVo nodeAVoGH15 = new NodeCoverageTableNodeVo();
        nodeAVoGH15.setFrequency(listA.get(2).getAebt());
        nodeAVoGH15.setFrequencyPercent(new BigDecimal(listA.get(2).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH15);

        NodeCoverageTableNodeVo nodeAVoGH16 = new NodeCoverageTableNodeVo();
        nodeAVoGH16.setFrequency(listA.get(2).getAtdc());
        nodeAVoGH16.setFrequencyPercent(new BigDecimal(listA.get(2).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH16);

        NodeCoverageTableNodeVo nodeAVoGH17 = new NodeCoverageTableNodeVo();
        nodeAVoGH17.setFrequency(listA.get(2).getAtfc());
        nodeAVoGH17.setFrequencyPercent(new BigDecimal(listA.get(2).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH17);

        NodeCoverageTableNodeVo nodeAVoGH18 = new NodeCoverageTableNodeVo();
        nodeAVoGH18.setFrequency(listA.get(2).getAact());
        nodeAVoGH18.setFrequencyPercent(new BigDecimal(listA.get(2).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH18);

        NodeCoverageTableNodeVo nodeAVoGH19 = new NodeCoverageTableNodeVo();
        nodeAVoGH19.setFrequency(listA.get(2).getAlsw());
        nodeAVoGH19.setFrequencyPercent(new BigDecimal(listA.get(2).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH19);

        NodeCoverageTableNodeVo nodeAVoGH20 = new NodeCoverageTableNodeVo();
        nodeAVoGH20.setFrequency(listA.get(2).getAobt());
        nodeAVoGH20.setFrequencyPercent(new BigDecimal(listA.get(2).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH20);

        NodeCoverageTableNodeVo nodeAVoGH21 = new NodeCoverageTableNodeVo();
        nodeAVoGH21.setFrequency(listA.get(2).getDgrndTsfTm());
        nodeAVoGH21.setFrequencyPercent(new BigDecimal(listA.get(2).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH21);

        NodeCoverageTableNodeVo nodeAVoGH22 = new NodeCoverageTableNodeVo();
        nodeAVoGH22.setFrequency(listA.get(2).getAtotD());
        nodeAVoGH22.setFrequencyPercent(new BigDecimal(listA.get(2).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH22);

        NodeCoverageTableNodeVo nodeAVoGH23 = new NodeCoverageTableNodeVo();
        nodeAVoGH23.setFrequency(listA.get(2).getCargoWeightA());
        nodeAVoGH23.setFrequencyPercent(new BigDecimal(listA.get(2).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH23);

        NodeCoverageTableNodeVo nodeAVoGH24 = new NodeCoverageTableNodeVo();
        nodeAVoGH24.setFrequency(listA.get(2).getMailWeightA());
        nodeAVoGH24.setFrequencyPercent(new BigDecimal(listA.get(2).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH24);

        NodeCoverageTableNodeVo nodeAVoGH25 = new NodeCoverageTableNodeVo();
        nodeAVoGH25.setFrequency(listA.get(2).getBagWeightA());
        nodeAVoGH25.setFrequencyPercent(new BigDecimal(listA.get(2).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH25);

        NodeCoverageTableNodeVo nodeAVoGH26 = new NodeCoverageTableNodeVo();
        nodeAVoGH26.setFrequency(listA.get(2).getReservationsA());
        nodeAVoGH26.setFrequencyPercent(new BigDecimal(listA.get(2).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH26);

        NodeCoverageTableNodeVo nodeAVoGH27 = new NodeCoverageTableNodeVo();
        nodeAVoGH27.setFrequency(listA.get(2).getCargoWeightD());
        nodeAVoGH27.setFrequencyPercent(new BigDecimal(listA.get(2).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH27);

        NodeCoverageTableNodeVo nodeAVoGH28 = new NodeCoverageTableNodeVo();
        nodeAVoGH28.setFrequency(listA.get(2).getMailWeightD());
        nodeAVoGH28.setFrequencyPercent(new BigDecimal(listA.get(2).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH28);

        NodeCoverageTableNodeVo nodeAVoGH29 = new NodeCoverageTableNodeVo();
        nodeAVoGH29.setFrequency(listA.get(2).getBagWeightD());
        nodeAVoGH29.setFrequencyPercent(new BigDecimal(listA.get(2).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH29);

        NodeCoverageTableNodeVo nodeAVoGH30 = new NodeCoverageTableNodeVo();
        nodeAVoGH30.setFrequency(listA.get(2).getReservationsD());
        nodeAVoGH30.setFrequencyPercent(new BigDecimal(listA.get(2).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeAGHList.add(nodeAVoGH30);

        //添加单进国航保障节点
        voAGH.setMechanism(nodeAGHList);
        //添加单进国航
        returnList.add(voAGH);



        //单进地服----------------------------单进地服-------------------------
        NodeCoverageTableVo voADF = new NodeCoverageTableVo();
        voADF.setType("");
        voADF.setName("地服");
        voADF.setNumber(listA.get(3).getTotal());

        //单进地服保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeADFList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeAVoDF1 = new NodeCoverageTableNodeVo();
        nodeAVoDF1.setFrequency(listA.get(3).getAtotA());
        nodeAVoDF1.setFrequencyPercent(new BigDecimal(listA.get(3).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF1);

        NodeCoverageTableNodeVo nodeAVoDF2 = new NodeCoverageTableNodeVo();
        nodeAVoDF2.setFrequency(listA.get(3).getAldt());
        nodeAVoDF2.setFrequencyPercent(new BigDecimal(listA.get(3).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF2);

        NodeCoverageTableNodeVo nodeAVoDF3 = new NodeCoverageTableNodeVo();
        nodeAVoDF3.setFrequency(listA.get(3).getAgrndTsfTm());
        nodeAVoDF3.setFrequencyPercent(new BigDecimal(listA.get(3).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF3);

        NodeCoverageTableNodeVo nodeAVoDF4 = new NodeCoverageTableNodeVo();
        nodeAVoDF4.setFrequency(listA.get(3).getAibt());
        nodeAVoDF4.setFrequencyPercent(new BigDecimal(listA.get(3).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF4);

        NodeCoverageTableNodeVo nodeAVoDF5 = new NodeCoverageTableNodeVo();
        nodeAVoDF5.setFrequency(listA.get(3).getArsl());
        nodeAVoDF5.setFrequencyPercent(new BigDecimal(listA.get(3).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF5);

        NodeCoverageTableNodeVo nodeAVoDF6 = new NodeCoverageTableNodeVo();
        nodeAVoDF6.setFrequency(listA.get(3).getAtdo());
        nodeAVoDF6.setFrequencyPercent(new BigDecimal(listA.get(3).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF6);

        NodeCoverageTableNodeVo nodeAVoDF7 = new NodeCoverageTableNodeVo();
        nodeAVoDF7.setFrequency(listA.get(3).getAtfo());
        nodeAVoDF7.setFrequencyPercent(new BigDecimal(listA.get(3).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF7);

        NodeCoverageTableNodeVo nodeAVoDF8 = new NodeCoverageTableNodeVo();
        nodeAVoDF8.setFrequency(listA.get(3).getAsct());
        nodeAVoDF8.setFrequencyPercent(new BigDecimal(listA.get(3).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF8);

        NodeCoverageTableNodeVo nodeAVoDF9 = new NodeCoverageTableNodeVo();
        nodeAVoDF9.setFrequency(listA.get(3).getAfct());
        nodeAVoDF9.setFrequencyPercent(new BigDecimal(listA.get(3).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF9);

        NodeCoverageTableNodeVo nodeAVoDF10 = new NodeCoverageTableNodeVo();
        nodeAVoDF10.setFrequency(listA.get(3).getAsr());
        nodeAVoDF10.setFrequencyPercent(new BigDecimal(listA.get(3).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF10);

        NodeCoverageTableNodeVo nodeAVoDF11 = new NodeCoverageTableNodeVo();
        nodeAVoDF11.setFrequency(listA.get(3).getAer());
        nodeAVoDF11.setFrequencyPercent(new BigDecimal(listA.get(3).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF11);

        NodeCoverageTableNodeVo nodeAVoDF12 = new NodeCoverageTableNodeVo();
        nodeAVoDF12.setFrequency(listA.get(3).getAsc());
        nodeAVoDF12.setFrequencyPercent(new BigDecimal(listA.get(3).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF12);

        NodeCoverageTableNodeVo nodeAVoDF13 = new NodeCoverageTableNodeVo();
        nodeAVoDF13.setFrequency(listA.get(3).getAec());
        nodeAVoDF13.setFrequencyPercent(new BigDecimal(listA.get(3).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF13);

        NodeCoverageTableNodeVo nodeAVoDF14 = new NodeCoverageTableNodeVo();
        nodeAVoDF14.setFrequency(listA.get(3).getAsbt());
        nodeAVoDF14.setFrequencyPercent(new BigDecimal(listA.get(3).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF14);

        NodeCoverageTableNodeVo nodeAVoDF15 = new NodeCoverageTableNodeVo();
        nodeAVoDF15.setFrequency(listA.get(3).getAebt());
        nodeAVoDF15.setFrequencyPercent(new BigDecimal(listA.get(3).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF15);

        NodeCoverageTableNodeVo nodeAVoDF16 = new NodeCoverageTableNodeVo();
        nodeAVoDF16.setFrequency(listA.get(3).getAtdc());
        nodeAVoDF16.setFrequencyPercent(new BigDecimal(listA.get(3).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF16);

        NodeCoverageTableNodeVo nodeAVoDF17 = new NodeCoverageTableNodeVo();
        nodeAVoDF17.setFrequency(listA.get(3).getAtfc());
        nodeAVoDF17.setFrequencyPercent(new BigDecimal(listA.get(3).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF17);

        NodeCoverageTableNodeVo nodeAVoDF18 = new NodeCoverageTableNodeVo();
        nodeAVoDF18.setFrequency(listA.get(3).getAact());
        nodeAVoDF18.setFrequencyPercent(new BigDecimal(listA.get(3).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF18);

        NodeCoverageTableNodeVo nodeAVoDF19 = new NodeCoverageTableNodeVo();
        nodeAVoDF19.setFrequency(listA.get(3).getAlsw());
        nodeAVoDF19.setFrequencyPercent(new BigDecimal(listA.get(3).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF19);

        NodeCoverageTableNodeVo nodeAVoDF20 = new NodeCoverageTableNodeVo();
        nodeAVoDF20.setFrequency(listA.get(3).getAobt());
        nodeAVoDF20.setFrequencyPercent(new BigDecimal(listA.get(3).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF20);

        NodeCoverageTableNodeVo nodeAVoDF21 = new NodeCoverageTableNodeVo();
        nodeAVoDF21.setFrequency(listA.get(3).getDgrndTsfTm());
        nodeAVoDF21.setFrequencyPercent(new BigDecimal(listA.get(3).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF21);

        NodeCoverageTableNodeVo nodeAVoDF22 = new NodeCoverageTableNodeVo();
        nodeAVoDF22.setFrequency(listA.get(3).getAtotD());
        nodeAVoDF22.setFrequencyPercent(new BigDecimal(listA.get(3).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF22);


        NodeCoverageTableNodeVo nodeAVoDF23 = new NodeCoverageTableNodeVo();
        nodeAVoDF23.setFrequency(listA.get(3).getCargoWeightA());
        nodeAVoDF23.setFrequencyPercent(new BigDecimal(listA.get(3).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF23);

        NodeCoverageTableNodeVo nodeAVoDF24 = new NodeCoverageTableNodeVo();
        nodeAVoDF24.setFrequency(listA.get(3).getMailWeightA());
        nodeAVoDF24.setFrequencyPercent(new BigDecimal(listA.get(3).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF24);

        NodeCoverageTableNodeVo nodeAVoDF25 = new NodeCoverageTableNodeVo();
        nodeAVoDF25.setFrequency(listA.get(3).getBagWeightA());
        nodeAVoDF25.setFrequencyPercent(new BigDecimal(listA.get(3).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF25);

        NodeCoverageTableNodeVo nodeAVoDF26 = new NodeCoverageTableNodeVo();
        nodeAVoDF26.setFrequency(listA.get(3).getReservationsA());
        nodeAVoDF26.setFrequencyPercent(new BigDecimal(listA.get(3).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF26);

        NodeCoverageTableNodeVo nodeAVoDF27 = new NodeCoverageTableNodeVo();
        nodeAVoDF27.setFrequency(listA.get(3).getCargoWeightD());
        nodeAVoDF27.setFrequencyPercent(new BigDecimal(listA.get(3).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF27);

        NodeCoverageTableNodeVo nodeAVoDF28 = new NodeCoverageTableNodeVo();
        nodeAVoDF28.setFrequency(listA.get(3).getMailWeightD());
        nodeAVoDF28.setFrequencyPercent(new BigDecimal(listA.get(3).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF28);

        NodeCoverageTableNodeVo nodeAVoDF29 = new NodeCoverageTableNodeVo();
        nodeAVoDF29.setFrequency(listA.get(3).getBagWeightD());
        nodeAVoDF29.setFrequencyPercent(new BigDecimal(listA.get(3).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF29);

        NodeCoverageTableNodeVo nodeAVoDF30 = new NodeCoverageTableNodeVo();
        nodeAVoDF30.setFrequency(listA.get(3).getReservationsD());
        nodeAVoDF30.setFrequencyPercent(new BigDecimal(listA.get(3).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeADFList.add(nodeAVoDF30);

        //添加单进地服保障节点
        voADF.setMechanism(nodeADFList);
        //添加单进地服
        returnList.add(voADF);



        /**
         * 单出航班统计-----------------------单出航班统计------------------------------
         */

        //单出东航----------------------------单出东航-------------------------
        NodeCoverageTableVo voDDH = new NodeCoverageTableVo();
        voDDH.setType("单出");
        voDDH.setName("东航");
        voDDH.setNumber(listD.get(0).getTotal());

        //单出东航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeDDHList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeDVoDH1 = new NodeCoverageTableNodeVo();
        nodeDVoDH1.setFrequency(listD.get(0).getAtotA());
        nodeDVoDH1.setFrequencyPercent(new BigDecimal(listD.get(0).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH1);

        NodeCoverageTableNodeVo nodeDVoDH2 = new NodeCoverageTableNodeVo();
        nodeDVoDH2.setFrequency(listD.get(0).getAldt());
        nodeDVoDH2.setFrequencyPercent(new BigDecimal(listD.get(0).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH2);

        NodeCoverageTableNodeVo nodeDVoDH3 = new NodeCoverageTableNodeVo();
        nodeDVoDH3.setFrequency(listD.get(0).getAgrndTsfTm());
        nodeDVoDH3.setFrequencyPercent(new BigDecimal(listD.get(0).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH3);

        NodeCoverageTableNodeVo nodeDVoDH4 = new NodeCoverageTableNodeVo();
        nodeDVoDH4.setFrequency(listD.get(0).getAibt());
        nodeDVoDH4.setFrequencyPercent(new BigDecimal(listD.get(0).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH4);

        NodeCoverageTableNodeVo nodeDVoDH5 = new NodeCoverageTableNodeVo();
        nodeDVoDH5.setFrequency(listD.get(0).getArsl());
        nodeDVoDH5.setFrequencyPercent(new BigDecimal(listD.get(0).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH5);

        NodeCoverageTableNodeVo nodeDVoDH6 = new NodeCoverageTableNodeVo();
        nodeDVoDH6.setFrequency(listD.get(0).getAtdo());
        nodeDVoDH6.setFrequencyPercent(new BigDecimal(listD.get(0).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH6);

        NodeCoverageTableNodeVo nodeDVoDH7 = new NodeCoverageTableNodeVo();
        nodeDVoDH7.setFrequency(listD.get(0).getAtfo());
        nodeDVoDH7.setFrequencyPercent(new BigDecimal(listD.get(0).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH7);

        NodeCoverageTableNodeVo nodeDVoDH8 = new NodeCoverageTableNodeVo();
        nodeDVoDH8.setFrequency(listD.get(0).getAsct());
        nodeDVoDH8.setFrequencyPercent(new BigDecimal(listD.get(0).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH8);

        NodeCoverageTableNodeVo nodeDVoDH9 = new NodeCoverageTableNodeVo();
        nodeDVoDH9.setFrequency(listD.get(0).getAfct());
        nodeDVoDH9.setFrequencyPercent(new BigDecimal(listD.get(0).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH9);

        NodeCoverageTableNodeVo nodeDVoDH10 = new NodeCoverageTableNodeVo();
        nodeDVoDH10.setFrequency(listD.get(0).getAsr());
        nodeDVoDH10.setFrequencyPercent(new BigDecimal(listD.get(0).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH10);

        NodeCoverageTableNodeVo nodeDVoDH11 = new NodeCoverageTableNodeVo();
        nodeDVoDH11.setFrequency(listD.get(0).getAer());
        nodeDVoDH11.setFrequencyPercent(new BigDecimal(listD.get(0).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH11);

        NodeCoverageTableNodeVo nodeDVoDH12 = new NodeCoverageTableNodeVo();
        nodeDVoDH12.setFrequency(listD.get(0).getAsc());
        nodeDVoDH12.setFrequencyPercent(new BigDecimal(listD.get(0).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH12);

        NodeCoverageTableNodeVo nodeDVoDH13 = new NodeCoverageTableNodeVo();
        nodeDVoDH13.setFrequency(listD.get(0).getAec());
        nodeDVoDH13.setFrequencyPercent(new BigDecimal(listD.get(0).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH13);

        NodeCoverageTableNodeVo nodeDVoDH14 = new NodeCoverageTableNodeVo();
        nodeDVoDH14.setFrequency(listD.get(0).getAsbt());
        nodeDVoDH14.setFrequencyPercent(new BigDecimal(listD.get(0).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH14);

        NodeCoverageTableNodeVo nodeDVoDH15 = new NodeCoverageTableNodeVo();
        nodeDVoDH15.setFrequency(listD.get(0).getAebt());
        nodeDVoDH15.setFrequencyPercent(new BigDecimal(listD.get(0).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH15);

        NodeCoverageTableNodeVo nodeDVoDH16 = new NodeCoverageTableNodeVo();
        nodeDVoDH16.setFrequency(listD.get(0).getAtdc());
        nodeDVoDH16.setFrequencyPercent(new BigDecimal(listD.get(0).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH16);

        NodeCoverageTableNodeVo nodeDVoDH17 = new NodeCoverageTableNodeVo();
        nodeDVoDH17.setFrequency(listD.get(0).getAtfc());
        nodeDVoDH17.setFrequencyPercent(new BigDecimal(listD.get(0).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH17);

        NodeCoverageTableNodeVo nodeDVoDH18 = new NodeCoverageTableNodeVo();
        nodeDVoDH18.setFrequency(listD.get(0).getAact());
        nodeDVoDH18.setFrequencyPercent(new BigDecimal(listD.get(0).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH18);

        NodeCoverageTableNodeVo nodeDVoDH19 = new NodeCoverageTableNodeVo();
        nodeDVoDH19.setFrequency(listD.get(0).getAlsw());
        nodeDVoDH19.setFrequencyPercent(new BigDecimal(listD.get(0).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH19);

        NodeCoverageTableNodeVo nodeDVoDH20 = new NodeCoverageTableNodeVo();
        nodeDVoDH20.setFrequency(listD.get(0).getAobt());
        nodeDVoDH20.setFrequencyPercent(new BigDecimal(listD.get(0).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH20);

        NodeCoverageTableNodeVo nodeDVoDH21 = new NodeCoverageTableNodeVo();
        nodeDVoDH21.setFrequency(listD.get(0).getDgrndTsfTm());
        nodeDVoDH21.setFrequencyPercent(new BigDecimal(listD.get(0).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH21);

        NodeCoverageTableNodeVo nodeDVoDH22 = new NodeCoverageTableNodeVo();
        nodeDVoDH22.setFrequency(listD.get(0).getAtotD());
        nodeDVoDH22.setFrequencyPercent(new BigDecimal(listD.get(0).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH22);


        NodeCoverageTableNodeVo nodeDVoDH23 = new NodeCoverageTableNodeVo();
        nodeDVoDH23.setFrequency(listD.get(0).getCargoWeightA());
        nodeDVoDH23.setFrequencyPercent(new BigDecimal(listD.get(0).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH23);

        NodeCoverageTableNodeVo nodeDVoDH24 = new NodeCoverageTableNodeVo();
        nodeDVoDH24.setFrequency(listD.get(0).getMailWeightA());
        nodeDVoDH24.setFrequencyPercent(new BigDecimal(listD.get(0).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH24);

        NodeCoverageTableNodeVo nodeDVoDH25 = new NodeCoverageTableNodeVo();
        nodeDVoDH25.setFrequency(listD.get(0).getBagWeightA());
        nodeDVoDH25.setFrequencyPercent(new BigDecimal(listD.get(0).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH25);

        NodeCoverageTableNodeVo nodeDVoDH26 = new NodeCoverageTableNodeVo();
        nodeDVoDH26.setFrequency(listD.get(0).getReservationsA());
        nodeDVoDH26.setFrequencyPercent(new BigDecimal(listD.get(0).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH26);

        NodeCoverageTableNodeVo nodeDVoDH27 = new NodeCoverageTableNodeVo();
        nodeDVoDH27.setFrequency(listD.get(0).getCargoWeightD());
        nodeDVoDH27.setFrequencyPercent(new BigDecimal(listD.get(0).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH27);

        NodeCoverageTableNodeVo nodeDVoDH28 = new NodeCoverageTableNodeVo();
        nodeDVoDH28.setFrequency(listD.get(0).getMailWeightD());
        nodeDVoDH28.setFrequencyPercent(new BigDecimal(listD.get(0).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH28);

        NodeCoverageTableNodeVo nodeDVoDH29 = new NodeCoverageTableNodeVo();
        nodeDVoDH29.setFrequency(listD.get(0).getBagWeightD());
        nodeDVoDH29.setFrequencyPercent(new BigDecimal(listD.get(0).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH29);

        NodeCoverageTableNodeVo nodeDVoDH30 = new NodeCoverageTableNodeVo();
        nodeDVoDH30.setFrequency(listD.get(0).getReservationsD());
        nodeDVoDH30.setFrequencyPercent(new BigDecimal(listD.get(0).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDHList.add(nodeDVoDH30);

        //添加单出东航保障节点
        voDDH.setMechanism(nodeDDHList);
        //添加单出东航
        returnList.add(voDDH);



        //单出南航----------------------------单出南航-------------------------
        NodeCoverageTableVo voDNH = new NodeCoverageTableVo();
        voDNH.setType("");
        voDNH.setName("南航");
        voDNH.setNumber(listD.get(1).getTotal());

        //单出南航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeDNHList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeDVoNH1 = new NodeCoverageTableNodeVo();
        nodeDVoNH1.setFrequency(listD.get(1).getAtotA());
        nodeDVoNH1.setFrequencyPercent(new BigDecimal(listD.get(1).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH1);

        NodeCoverageTableNodeVo nodeDVoNH2 = new NodeCoverageTableNodeVo();
        nodeDVoNH2.setFrequency(listD.get(1).getAldt());
        nodeDVoNH2.setFrequencyPercent(new BigDecimal(listD.get(1).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH2);

        NodeCoverageTableNodeVo nodeDVoNH3 = new NodeCoverageTableNodeVo();
        nodeDVoNH3.setFrequency(listD.get(1).getAgrndTsfTm());
        nodeDVoNH3.setFrequencyPercent(new BigDecimal(listD.get(1).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH3);

        NodeCoverageTableNodeVo nodeDVoNH4 = new NodeCoverageTableNodeVo();
        nodeDVoNH4.setFrequency(listD.get(1).getAibt());
        nodeDVoNH4.setFrequencyPercent(new BigDecimal(listD.get(1).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH4);

        NodeCoverageTableNodeVo nodeDVoNH5 = new NodeCoverageTableNodeVo();
        nodeDVoNH5.setFrequency(listD.get(1).getArsl());
        nodeDVoNH5.setFrequencyPercent(new BigDecimal(listD.get(1).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH5);

        NodeCoverageTableNodeVo nodeDVoNH6 = new NodeCoverageTableNodeVo();
        nodeDVoNH6.setFrequency(listD.get(1).getAtdo());
        nodeDVoNH6.setFrequencyPercent(new BigDecimal(listD.get(1).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH6);

        NodeCoverageTableNodeVo nodeDVoNH7 = new NodeCoverageTableNodeVo();
        nodeDVoNH7.setFrequency(listD.get(1).getAtfo());
        nodeDVoNH7.setFrequencyPercent(new BigDecimal(listD.get(1).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH7);

        NodeCoverageTableNodeVo nodeDVoNH8 = new NodeCoverageTableNodeVo();
        nodeDVoNH8.setFrequency(listD.get(1).getAsct());
        nodeDVoNH8.setFrequencyPercent(new BigDecimal(listD.get(1).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH8);

        NodeCoverageTableNodeVo nodeDVoNH9 = new NodeCoverageTableNodeVo();
        nodeDVoNH9.setFrequency(listD.get(1).getAfct());
        nodeDVoNH9.setFrequencyPercent(new BigDecimal(listD.get(1).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH9);

        NodeCoverageTableNodeVo nodeDVoNH10 = new NodeCoverageTableNodeVo();
        nodeDVoNH10.setFrequency(listD.get(1).getAsr());
        nodeDVoNH10.setFrequencyPercent(new BigDecimal(listD.get(1).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH10);

        NodeCoverageTableNodeVo nodeDVoNH11 = new NodeCoverageTableNodeVo();
        nodeDVoNH11.setFrequency(listD.get(1).getAer());
        nodeDVoNH11.setFrequencyPercent(new BigDecimal(listD.get(1).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH11);

        NodeCoverageTableNodeVo nodeDVoNH12 = new NodeCoverageTableNodeVo();
        nodeDVoNH12.setFrequency(listD.get(1).getAsc());
        nodeDVoNH12.setFrequencyPercent(new BigDecimal(listD.get(1).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH12);

        NodeCoverageTableNodeVo nodeDVoNH13 = new NodeCoverageTableNodeVo();
        nodeDVoNH13.setFrequency(listD.get(1).getAec());
        nodeDVoNH13.setFrequencyPercent(new BigDecimal(listD.get(1).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH13);

        NodeCoverageTableNodeVo nodeDVoNH14 = new NodeCoverageTableNodeVo();
        nodeDVoNH14.setFrequency(listD.get(1).getAsbt());
        nodeDVoNH14.setFrequencyPercent(new BigDecimal(listD.get(1).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH14);

        NodeCoverageTableNodeVo nodeDVoNH15 = new NodeCoverageTableNodeVo();
        nodeDVoNH15.setFrequency(listD.get(1).getAebt());
        nodeDVoNH15.setFrequencyPercent(new BigDecimal(listD.get(1).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH15);

        NodeCoverageTableNodeVo nodeDVoNH16 = new NodeCoverageTableNodeVo();
        nodeDVoNH16.setFrequency(listD.get(1).getAtdc());
        nodeDVoNH16.setFrequencyPercent(new BigDecimal(listD.get(1).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH16);

        NodeCoverageTableNodeVo nodeDVoNH17 = new NodeCoverageTableNodeVo();
        nodeDVoNH17.setFrequency(listD.get(1).getAtfc());
        nodeDVoNH17.setFrequencyPercent(new BigDecimal(listD.get(1).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH17);

        NodeCoverageTableNodeVo nodeDVoNH18 = new NodeCoverageTableNodeVo();
        nodeDVoNH18.setFrequency(listD.get(1).getAact());
        nodeDVoNH18.setFrequencyPercent(new BigDecimal(listD.get(1).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH18);

        NodeCoverageTableNodeVo nodeDVoNH19 = new NodeCoverageTableNodeVo();
        nodeDVoNH19.setFrequency(listD.get(1).getAlsw());
        nodeDVoNH19.setFrequencyPercent(new BigDecimal(listD.get(1).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH19);

        NodeCoverageTableNodeVo nodeDVoNH20 = new NodeCoverageTableNodeVo();
        nodeDVoNH20.setFrequency(listD.get(1).getAobt());
        nodeDVoNH20.setFrequencyPercent(new BigDecimal(listD.get(1).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH20);

        NodeCoverageTableNodeVo nodeDVoNH21 = new NodeCoverageTableNodeVo();
        nodeDVoNH21.setFrequency(listD.get(1).getDgrndTsfTm());
        nodeDVoNH21.setFrequencyPercent(new BigDecimal(listD.get(1).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH21);

        NodeCoverageTableNodeVo nodeDVoNH22 = new NodeCoverageTableNodeVo();
        nodeDVoNH22.setFrequency(listD.get(1).getAtotD());
        nodeDVoNH22.setFrequencyPercent(new BigDecimal(listD.get(1).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH22);


        NodeCoverageTableNodeVo nodeDVoNH23 = new NodeCoverageTableNodeVo();
        nodeDVoNH23.setFrequency(listD.get(1).getCargoWeightA());
        nodeDVoNH23.setFrequencyPercent(new BigDecimal(listD.get(1).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH23);

        NodeCoverageTableNodeVo nodeDVoNH24 = new NodeCoverageTableNodeVo();
        nodeDVoNH24.setFrequency(listD.get(1).getMailWeightA());
        nodeDVoNH24.setFrequencyPercent(new BigDecimal(listD.get(1).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH24);

        NodeCoverageTableNodeVo nodeDVoNH25 = new NodeCoverageTableNodeVo();
        nodeDVoNH25.setFrequency(listD.get(1).getBagWeightA());
        nodeDVoNH25.setFrequencyPercent(new BigDecimal(listD.get(1).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH25);

        NodeCoverageTableNodeVo nodeDVoNH26 = new NodeCoverageTableNodeVo();
        nodeDVoNH26.setFrequency(listD.get(1).getReservationsA());
        nodeDVoNH26.setFrequencyPercent(new BigDecimal(listD.get(1).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH26);

        NodeCoverageTableNodeVo nodeDVoNH27 = new NodeCoverageTableNodeVo();
        nodeDVoNH27.setFrequency(listD.get(1).getCargoWeightD());
        nodeDVoNH27.setFrequencyPercent(new BigDecimal(listD.get(1).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH27);

        NodeCoverageTableNodeVo nodeDVoNH28 = new NodeCoverageTableNodeVo();
        nodeDVoNH28.setFrequency(listD.get(1).getMailWeightD());
        nodeDVoNH28.setFrequencyPercent(new BigDecimal(listD.get(1).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH28);

        NodeCoverageTableNodeVo nodeDVoNH29 = new NodeCoverageTableNodeVo();
        nodeDVoNH29.setFrequency(listD.get(1).getBagWeightD());
        nodeDVoNH29.setFrequencyPercent(new BigDecimal(listD.get(1).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH29);

        NodeCoverageTableNodeVo nodeDVoNH30 = new NodeCoverageTableNodeVo();
        nodeDVoNH30.setFrequency(listD.get(1).getReservationsD());
        nodeDVoNH30.setFrequencyPercent(new BigDecimal(listD.get(1).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDNHList.add(nodeDVoNH30);

        //添加单出南航保障节点
        voDNH.setMechanism(nodeDNHList);
        //添加单出南航
        returnList.add(voDNH);




        //单出国航----------------------------单出国航-------------------------
        NodeCoverageTableVo voDGH = new NodeCoverageTableVo();
        voDGH.setType("");
        voDGH.setName("国航");
        voDGH.setNumber(listD.get(2).getTotal());

        //单出国航保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeDGHList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeDVoGH1 = new NodeCoverageTableNodeVo();
        nodeDVoGH1.setFrequency(listD.get(2).getAtotA());
        nodeDVoGH1.setFrequencyPercent(new BigDecimal(listD.get(2).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH1);

        NodeCoverageTableNodeVo nodeDVoGH2 = new NodeCoverageTableNodeVo();
        nodeDVoGH2.setFrequency(listD.get(2).getAldt());
        nodeDVoGH2.setFrequencyPercent(new BigDecimal(listD.get(2).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH2);

        NodeCoverageTableNodeVo nodeDVoGH3 = new NodeCoverageTableNodeVo();
        nodeDVoGH3.setFrequency(listD.get(2).getAgrndTsfTm());
        nodeDVoGH3.setFrequencyPercent(new BigDecimal(listD.get(2).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH3);

        NodeCoverageTableNodeVo nodeDVoGH4 = new NodeCoverageTableNodeVo();
        nodeDVoGH4.setFrequency(listD.get(2).getAibt());
        nodeDVoGH4.setFrequencyPercent(new BigDecimal(listD.get(2).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH4);

        NodeCoverageTableNodeVo nodeDVoGH5 = new NodeCoverageTableNodeVo();
        nodeDVoGH5.setFrequency(listD.get(2).getArsl());
        nodeDVoGH5.setFrequencyPercent(new BigDecimal(listD.get(2).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH5);

        NodeCoverageTableNodeVo nodeDVoGH6 = new NodeCoverageTableNodeVo();
        nodeDVoGH6.setFrequency(listD.get(2).getAtdo());
        nodeDVoGH6.setFrequencyPercent(new BigDecimal(listD.get(2).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH6);

        NodeCoverageTableNodeVo nodeDVoGH7 = new NodeCoverageTableNodeVo();
        nodeDVoGH7.setFrequency(listD.get(2).getAtfo());
        nodeDVoGH7.setFrequencyPercent(new BigDecimal(listD.get(2).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH7);

        NodeCoverageTableNodeVo nodeDVoGH8 = new NodeCoverageTableNodeVo();
        nodeDVoGH8.setFrequency(listD.get(2).getAsct());
        nodeDVoGH8.setFrequencyPercent(new BigDecimal(listD.get(2).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH8);

        NodeCoverageTableNodeVo nodeDVoGH9 = new NodeCoverageTableNodeVo();
        nodeDVoGH9.setFrequency(listD.get(2).getAfct());
        nodeDVoGH9.setFrequencyPercent(new BigDecimal(listD.get(2).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH9);

        NodeCoverageTableNodeVo nodeDVoGH10 = new NodeCoverageTableNodeVo();
        nodeDVoGH10.setFrequency(listD.get(2).getAsr());
        nodeDVoGH10.setFrequencyPercent(new BigDecimal(listD.get(2).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH10);

        NodeCoverageTableNodeVo nodeDVoGH11 = new NodeCoverageTableNodeVo();
        nodeDVoGH11.setFrequency(listD.get(2).getAer());
        nodeDVoGH11.setFrequencyPercent(new BigDecimal(listD.get(2).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH11);

        NodeCoverageTableNodeVo nodeDVoGH12 = new NodeCoverageTableNodeVo();
        nodeDVoGH12.setFrequency(listD.get(2).getAsc());
        nodeDVoGH12.setFrequencyPercent(new BigDecimal(listD.get(2).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH12);

        NodeCoverageTableNodeVo nodeDVoGH13 = new NodeCoverageTableNodeVo();
        nodeDVoGH13.setFrequency(listD.get(2).getAec());
        nodeDVoGH13.setFrequencyPercent(new BigDecimal(listD.get(2).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH13);

        NodeCoverageTableNodeVo nodeDVoGH14 = new NodeCoverageTableNodeVo();
        nodeDVoGH14.setFrequency(listD.get(2).getAsbt());
        nodeDVoGH14.setFrequencyPercent(new BigDecimal(listD.get(2).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH14);

        NodeCoverageTableNodeVo nodeDVoGH15 = new NodeCoverageTableNodeVo();
        nodeDVoGH15.setFrequency(listD.get(2).getAebt());
        nodeDVoGH15.setFrequencyPercent(new BigDecimal(listD.get(2).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH15);

        NodeCoverageTableNodeVo nodeDVoGH16 = new NodeCoverageTableNodeVo();
        nodeDVoGH16.setFrequency(listD.get(2).getAtdc());
        nodeDVoGH16.setFrequencyPercent(new BigDecimal(listD.get(2).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH16);

        NodeCoverageTableNodeVo nodeDVoGH17 = new NodeCoverageTableNodeVo();
        nodeDVoGH17.setFrequency(listD.get(2).getAtfc());
        nodeDVoGH17.setFrequencyPercent(new BigDecimal(listD.get(2).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH17);

        NodeCoverageTableNodeVo nodeDVoGH18 = new NodeCoverageTableNodeVo();
        nodeDVoGH18.setFrequency(listD.get(2).getAact());
        nodeDVoGH18.setFrequencyPercent(new BigDecimal(listD.get(2).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH18);

        NodeCoverageTableNodeVo nodeDVoGH19 = new NodeCoverageTableNodeVo();
        nodeDVoGH19.setFrequency(listD.get(2).getAlsw());
        nodeDVoGH19.setFrequencyPercent(new BigDecimal(listD.get(2).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH19);

        NodeCoverageTableNodeVo nodeDVoGH20 = new NodeCoverageTableNodeVo();
        nodeDVoGH20.setFrequency(listD.get(2).getAobt());
        nodeDVoGH20.setFrequencyPercent(new BigDecimal(listD.get(2).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH20);

        NodeCoverageTableNodeVo nodeDVoGH21 = new NodeCoverageTableNodeVo();
        nodeDVoGH21.setFrequency(listD.get(2).getDgrndTsfTm());
        nodeDVoGH21.setFrequencyPercent(new BigDecimal(listD.get(2).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH21);

        NodeCoverageTableNodeVo nodeDVoGH22 = new NodeCoverageTableNodeVo();
        nodeDVoGH22.setFrequency(listD.get(2).getAtotD());
        nodeDVoGH22.setFrequencyPercent(new BigDecimal(listD.get(2).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH22);


        NodeCoverageTableNodeVo nodeDVoGH23 = new NodeCoverageTableNodeVo();
        nodeDVoGH23.setFrequency(listD.get(2).getCargoWeightA());
        nodeDVoGH23.setFrequencyPercent(new BigDecimal(listD.get(2).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH23);

        NodeCoverageTableNodeVo nodeDVoGH24 = new NodeCoverageTableNodeVo();
        nodeDVoGH24.setFrequency(listD.get(2).getMailWeightA());
        nodeDVoGH24.setFrequencyPercent(new BigDecimal(listD.get(2).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH24);

        NodeCoverageTableNodeVo nodeDVoGH25 = new NodeCoverageTableNodeVo();
        nodeDVoGH25.setFrequency(listD.get(2).getBagWeightA());
        nodeDVoGH25.setFrequencyPercent(new BigDecimal(listD.get(2).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH25);

        NodeCoverageTableNodeVo nodeDVoGH26 = new NodeCoverageTableNodeVo();
        nodeDVoGH26.setFrequency(listD.get(2).getReservationsA());
        nodeDVoGH26.setFrequencyPercent(new BigDecimal(listD.get(2).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH26);

        NodeCoverageTableNodeVo nodeDVoGH27 = new NodeCoverageTableNodeVo();
        nodeDVoGH27.setFrequency(listD.get(2).getCargoWeightD());
        nodeDVoGH27.setFrequencyPercent(new BigDecimal(listD.get(2).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH27);

        NodeCoverageTableNodeVo nodeDVoGH28 = new NodeCoverageTableNodeVo();
        nodeDVoGH28.setFrequency(listD.get(2).getMailWeightD());
        nodeDVoGH28.setFrequencyPercent(new BigDecimal(listD.get(2).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH28);

        NodeCoverageTableNodeVo nodeDVoGH29 = new NodeCoverageTableNodeVo();
        nodeDVoGH29.setFrequency(listD.get(2).getBagWeightD());
        nodeDVoGH29.setFrequencyPercent(new BigDecimal(listD.get(2).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH29);

        NodeCoverageTableNodeVo nodeDVoGH30 = new NodeCoverageTableNodeVo();
        nodeDVoGH30.setFrequency(listD.get(2).getReservationsD());
        nodeDVoGH30.setFrequencyPercent(new BigDecimal(listD.get(2).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDGHList.add(nodeDVoGH30);

        //添加单出国航保障节点
        voDGH.setMechanism(nodeDGHList);
        //添加单出国航
        returnList.add(voDGH);



        //单出地服----------------------------单出地服-------------------------
        NodeCoverageTableVo voDDF = new NodeCoverageTableVo();
        voDDF.setType("");
        voDDF.setName("地服");
        voDDF.setNumber(listD.get(3).getTotal());

        //单出地服保障节点数据数组
        List<NodeCoverageTableNodeVo> nodeDDFList = new ArrayList<NodeCoverageTableNodeVo>();
        NodeCoverageTableNodeVo nodeDVoDF1 = new NodeCoverageTableNodeVo();
        nodeDVoDF1.setFrequency(listD.get(3).getAtotA());
        nodeDVoDF1.setFrequencyPercent(new BigDecimal(listD.get(3).getAtotRateA()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF1);

        NodeCoverageTableNodeVo nodeDVoDF2 = new NodeCoverageTableNodeVo();
        nodeDVoDF2.setFrequency(listD.get(3).getAldt());
        nodeDVoDF2.setFrequencyPercent(new BigDecimal(listD.get(3).getAldtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF2);

        NodeCoverageTableNodeVo nodeDVoDF3 = new NodeCoverageTableNodeVo();
        nodeDVoDF3.setFrequency(listD.get(3).getAgrndTsfTm());
        nodeDVoDF3.setFrequencyPercent(new BigDecimal(listD.get(3).getAgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF3);

        NodeCoverageTableNodeVo nodeDVoDF4 = new NodeCoverageTableNodeVo();
        nodeDVoDF4.setFrequency(listD.get(3).getAibt());
        nodeDVoDF4.setFrequencyPercent(new BigDecimal(listD.get(3).getAibtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF4);

        NodeCoverageTableNodeVo nodeDVoDF5 = new NodeCoverageTableNodeVo();
        nodeDVoDF5.setFrequency(listD.get(3).getArsl());
        nodeDVoDF5.setFrequencyPercent(new BigDecimal(listD.get(3).getArslRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF5);

        NodeCoverageTableNodeVo nodeDVoDF6 = new NodeCoverageTableNodeVo();
        nodeDVoDF6.setFrequency(listD.get(3).getAtdo());
        nodeDVoDF6.setFrequencyPercent(new BigDecimal(listD.get(3).getAtdoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF6);

        NodeCoverageTableNodeVo nodeDVoDF7 = new NodeCoverageTableNodeVo();
        nodeDVoDF7.setFrequency(listD.get(3).getAtfo());
        nodeDVoDF7.setFrequencyPercent(new BigDecimal(listD.get(3).getAtfoRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF7);

        NodeCoverageTableNodeVo nodeDVoDF8 = new NodeCoverageTableNodeVo();
        nodeDVoDF8.setFrequency(listD.get(3).getAsct());
        nodeDVoDF8.setFrequencyPercent(new BigDecimal(listD.get(3).getAsctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF8);

        NodeCoverageTableNodeVo nodeDVoDF9 = new NodeCoverageTableNodeVo();
        nodeDVoDF9.setFrequency(listD.get(3).getAfct());
        nodeDVoDF9.setFrequencyPercent(new BigDecimal(listD.get(3).getAfctRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF9);

        NodeCoverageTableNodeVo nodeDVoDF10 = new NodeCoverageTableNodeVo();
        nodeDVoDF10.setFrequency(listD.get(3).getAsr());
        nodeDVoDF10.setFrequencyPercent(new BigDecimal(listD.get(3).getAsrRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF10);

        NodeCoverageTableNodeVo nodeDVoDF11 = new NodeCoverageTableNodeVo();
        nodeDVoDF11.setFrequency(listD.get(3).getAer());
        nodeDVoDF11.setFrequencyPercent(new BigDecimal(listD.get(3).getAerRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF11);

        NodeCoverageTableNodeVo nodeDVoDF12 = new NodeCoverageTableNodeVo();
        nodeDVoDF12.setFrequency(listD.get(3).getAsc());
        nodeDVoDF12.setFrequencyPercent(new BigDecimal(listD.get(3).getAscRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF12);

        NodeCoverageTableNodeVo nodeDVoDF13 = new NodeCoverageTableNodeVo();
        nodeDVoDF13.setFrequency(listD.get(3).getAec());
        nodeDVoDF13.setFrequencyPercent(new BigDecimal(listD.get(3).getAecRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF13);

        NodeCoverageTableNodeVo nodeDVoDF14 = new NodeCoverageTableNodeVo();
        nodeDVoDF14.setFrequency(listD.get(3).getAsbt());
        nodeDVoDF14.setFrequencyPercent(new BigDecimal(listD.get(3).getAsbtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF14);

        NodeCoverageTableNodeVo nodeDVoDF15 = new NodeCoverageTableNodeVo();
        nodeDVoDF15.setFrequency(listD.get(3).getAebt());
        nodeDVoDF15.setFrequencyPercent(new BigDecimal(listD.get(3).getAebtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF15);

        NodeCoverageTableNodeVo nodeDVoDF16 = new NodeCoverageTableNodeVo();
        nodeDVoDF16.setFrequency(listD.get(3).getAtdc());
        nodeDVoDF16.setFrequencyPercent(new BigDecimal(listD.get(3).getAtdcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF16);

        NodeCoverageTableNodeVo nodeDVoDF17 = new NodeCoverageTableNodeVo();
        nodeDVoDF17.setFrequency(listD.get(3).getAtfc());
        nodeDVoDF17.setFrequencyPercent(new BigDecimal(listD.get(3).getAtfcRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF17);

        NodeCoverageTableNodeVo nodeDVoDF18 = new NodeCoverageTableNodeVo();
        nodeDVoDF18.setFrequency(listD.get(3).getAact());
        nodeDVoDF18.setFrequencyPercent(new BigDecimal(listD.get(3).getAactRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF18);

        NodeCoverageTableNodeVo nodeDVoDF19 = new NodeCoverageTableNodeVo();
        nodeDVoDF19.setFrequency(listD.get(3).getAlsw());
        nodeDVoDF19.setFrequencyPercent(new BigDecimal(listD.get(3).getAlswRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF19);

        NodeCoverageTableNodeVo nodeDVoDF20 = new NodeCoverageTableNodeVo();
        nodeDVoDF20.setFrequency(listD.get(3).getAobt());
        nodeDVoDF20.setFrequencyPercent(new BigDecimal(listD.get(3).getAobtRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF20);

        NodeCoverageTableNodeVo nodeDVoDF21 = new NodeCoverageTableNodeVo();
        nodeDVoDF21.setFrequency(listD.get(3).getDgrndTsfTm());
        nodeDVoDF21.setFrequencyPercent(new BigDecimal(listD.get(3).getDgrndTsfTmRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF21);

        NodeCoverageTableNodeVo nodeDVoDF22 = new NodeCoverageTableNodeVo();
        nodeDVoDF22.setFrequency(listD.get(3).getAtotD());
        nodeDVoDF22.setFrequencyPercent(new BigDecimal(listD.get(3).getAtotRateD()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF22);

        NodeCoverageTableNodeVo nodeDVoDF23 = new NodeCoverageTableNodeVo();
        nodeDVoDF23.setFrequency(listD.get(3).getCargoWeightA());
        nodeDVoDF23.setFrequencyPercent(new BigDecimal(listD.get(3).getCargoWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF23);

        NodeCoverageTableNodeVo nodeDVoDF24 = new NodeCoverageTableNodeVo();
        nodeDVoDF24.setFrequency(listD.get(3).getMailWeightA());
        nodeDVoDF24.setFrequencyPercent(new BigDecimal(listD.get(3).getMailWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF24);

        NodeCoverageTableNodeVo nodeDVoDF25 = new NodeCoverageTableNodeVo();
        nodeDVoDF25.setFrequency(listD.get(3).getBagWeightA());
        nodeDVoDF25.setFrequencyPercent(new BigDecimal(listD.get(3).getBagWeightARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF25);

        NodeCoverageTableNodeVo nodeDVoDF26 = new NodeCoverageTableNodeVo();
        nodeDVoDF26.setFrequency(listD.get(3).getReservationsA());
        nodeDVoDF26.setFrequencyPercent(new BigDecimal(listD.get(3).getReservationsARate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF26);

        NodeCoverageTableNodeVo nodeDVoDF27 = new NodeCoverageTableNodeVo();
        nodeDVoDF27.setFrequency(listD.get(3).getCargoWeightD());
        nodeDVoDF27.setFrequencyPercent(new BigDecimal(listD.get(3).getCargoWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF27);

        NodeCoverageTableNodeVo nodeDVoDF28 = new NodeCoverageTableNodeVo();
        nodeDVoDF28.setFrequency(listD.get(3).getMailWeightD());
        nodeDVoDF28.setFrequencyPercent(new BigDecimal(listD.get(3).getMailWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF28);

        NodeCoverageTableNodeVo nodeDVoDF29 = new NodeCoverageTableNodeVo();
        nodeDVoDF29.setFrequency(listD.get(3).getBagWeightD());
        nodeDVoDF29.setFrequencyPercent(new BigDecimal(listD.get(3).getBagWeightDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF29);

        NodeCoverageTableNodeVo nodeDVoDF30 = new NodeCoverageTableNodeVo();
        nodeDVoDF30.setFrequency(listD.get(3).getReservationsD());
        nodeDVoDF30.setFrequencyPercent(new BigDecimal(listD.get(3).getReservationsDRate()).multiply(new BigDecimal("100")).setScale(2,BigDecimal.ROUND_HALF_UP)+"%");
        nodeDDFList.add(nodeDVoDF30);

        //添加单出地服保障节点
        voDDF.setMechanism(nodeDDFList);
        //添加单出地服
        returnList.add(voDDF);


        return returnList;
    }

    @Override
    public MAILCoveragePieAndBarVo findMAILCoverageD(Map params) {

        MAILCoveragePieAndBarVo vo=new MAILCoveragePieAndBarVo();

        List<MAILCoverageReportVo> listD = nodeCoverageReportMapper.findMAILCoverageD(params);
        if (listD!=null&&listD.size()>0){
            List<MAILCoverageReportVo> listC=new ArrayList<>();
             vo.setStaticDataPieW(listD);
            String []legendDataBarW = new String[listD.size()];
            String []legendDataBarC = new String[listD.size()];
            int []staticDataBarW = new int[listD.size()];
            int []staticDataBarC = new int[listD.size()];
            for (int i = 0; i < listD.size(); i++) {
                MAILCoverageReportVo v=listD.get(i);
                MAILCoverageReportVo vc=new MAILCoverageReportVo();
                vc.setName(v.getName());
                vc.setValue(0);
                listC.add(vc);
                legendDataBarW[i]=v.getName();
                legendDataBarC[i]=v.getName();
                staticDataBarW[i]=v.getValue();
                staticDataBarC[i]=0;
            }
            vo.setStaticDataPieC(listC);
            vo.setLegendDataBarW(legendDataBarW);
            vo.setLegendDataBarC(legendDataBarC);
            vo.setStaticDataBarW(staticDataBarW);
            vo.setStaticDataBarC(staticDataBarC);
        }

        return vo;
    }


}


