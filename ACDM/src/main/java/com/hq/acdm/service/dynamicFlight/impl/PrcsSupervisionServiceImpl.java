package com.hq.acdm.service.dynamicFlight.impl;

import com.hq.acdm.dao.dynamicFlight.FltMonitorMapper;
import com.hq.acdm.dao.dynamicFlight.PrcsSupervisionMapper;
import com.hq.acdm.dao.realtimeSituation.TSchedulingNoticeInfoMapper;
import com.hq.acdm.model.realtimeSituation.TDynTask;
import com.hq.acdm.model.realtimeSituation.TSchedulingNoticeInfo;
import com.hq.acdm.service.dynamicFlight.FltMonitorService;
import com.hq.acdm.service.dynamicFlight.PrcsSupervisionService;
import com.hq.acdm.util.DateTimeUtil;
import com.hq.acdm.util.JexlUtil;
import com.hq.acdm.util.StringUtil;
import com.hq.acdm.util.mqadapter.MqUtil;
import com.hq.acdm.vo.dynamicFlight.*;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/29 10:01
 * @Description
 */
@Service
public class PrcsSupervisionServiceImpl implements PrcsSupervisionService {

    @Resource
    private PrcsSupervisionMapper prcsSupervisionMapper;
    @Resource
    private TSchedulingNoticeInfoMapper tschedulingNoticeInfoMapper;

    @Override
    public List<PrcsJJJGVo> findJJJG(@Param("params") Map params) {
        return prcsSupervisionMapper.getJJJG(params);
    }

    @Override
    public List<PrcsLDHXVo> findLDHX(@Param("params") Map params) {
        return prcsSupervisionMapper.getLDHX(params);
    }

    @Override
    public List<PrcsLGHXVo> findLGHX(@Param("params") Map params) {
        return prcsSupervisionMapper.getLGHX(params);
    }

    @Override
    public List<PrcsQZYWVo> findQZYW(@Param("params") Map params) {
        //return prcsSupervisionMapper.getQZYW();
        //改为前站起飞
        return prcsSupervisionMapper.getQZQF(params);
    }

    @Override
    public List<PrcsQZYWVo> findTQQF(@Param("params") Map params) {
        return prcsSupervisionMapper.getTQQF(params);
    }

    @Override
    public List<TDynTask> findGZBZState(@Param("params") Map params){
        return prcsSupervisionMapper.getGZBZState(params);
    }

    //查询任务节点信息
    @Override
    public List<TaskNodeVo> findTaskNode(){
        return prcsSupervisionMapper.findTaskNode();
    }

    @Override
    public List<Map<String, Object>> selectNoticeTime(@Param("params") Map params) {
        List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
        List<TaskNodeVo> nodeList = this.findTaskNode();
        String startColumn = "";
        String startEstColumn = "";
        String endColumn = "";
        String endEstColumn = "";
        List<Map<String,Object>> listMaps = new ArrayList<Map<String,Object>>();
        StringBuilder sb=new StringBuilder();
        String cname="";
        for (int i = 0; i <nodeList.size() ; i++) {
            if (params.get("ename").equals(nodeList.get(i).getTskcodes())){
                cname=nodeList.get(i).getTaskName();
                startColumn = nodeList.get(i).getStartcolumn();
                startEstColumn = nodeList.get(i).getStartestcolumn();
                endColumn = nodeList.get(i).getEndcolumn();
                endEstColumn = nodeList.get(i).getEndestcolumn();
                if (StringUtil.isNotEmpty(startColumn)){
                    sb.append("IFNULL(T.`"+startColumn+"`,'') as timeB"+",");
                }else {
                    sb.append("''"+" as timeB"+",");
                }
                if (StringUtil.isNotEmpty(startEstColumn)){
                    sb.append("IFNULL(T.`"+startEstColumn+"`,'') as timeBes"+",");
                }else {
                    sb.append("''"+" as timeBes"+",");
                }
                if (StringUtil.isNotEmpty(endColumn)){
                    sb.append("IFNULL(T.`"+endColumn+"`,'') as timeE"+",");
                }else {
                    sb.append("''"+" as timeE"+",");
                }
                if (StringUtil.isNotEmpty(endEstColumn)){
                    sb.append("IFNULL(T.`"+endEstColumn+"`,'') as timeEes"+",");
                }else {
                    sb.append("''"+" as timeEes"+",");
                }
                break;
            }
        }
        String agent=sb.toString();
        if (agent.contains(","))agent=agent.substring(0,agent.lastIndexOf(","));
        params.put("agent",agent);
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("flightId",params.get("flightId"));
        paramMap.put("taskType",params.get("ename").toString());
        List<String> listMsg = prcsSupervisionMapper.findSchedulingNoticeInfo(paramMap);
        listMap=prcsSupervisionMapper.SelectNoticeTime(params);
        for (int i = 0; i <listMap.size() ; i++) {
            Map<String,Object> map = listMap.get(i);
            map.put("cname",cname);
            map.put("ename",params.get("ename"));
            if(i==0){
                map.remove("MSG");
                map.put("MSG",listMsg);
            }
            listMaps.add(map);
        }
        return listMaps;
    }

    @Override
    public List<Map<String,Object>> findGZBZ(@Param("params") Map params) {
        Map<String, Object> queryMap = new HashMap<>();
        List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
        List<TaskNodeVo> nodeList = this.findTaskNode();
        List<String> listParams = new ArrayList<String>();
        for (int i = 0; i <nodeList.size() ; i++) {
            listParams.add(nodeList.get(i).getStartcolumn());
            listParams.add(nodeList.get(i).getStartestcolumn());
            listParams.add(nodeList.get(i).getEndcolumn());
            listParams.add(nodeList.get(i).getEndestcolumn());
        }
        List<Map<String,Object>> listGZBZ= prcsSupervisionMapper.getGZBZlist(listParams,params);

        String startColumn = "";
        String startEstColumn = "";
        String endColumn = "";
        String endEstColumn = "";
        String nowTime = DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm");

        if(listGZBZ != null && listGZBZ.size()>0){
            for(int i=0;i<listGZBZ.size();i++){
                Map<String,Object> map = listGZBZ.get(i);
                List<PrcsGZBZTaskNodeVo> taskNodeList = new ArrayList<PrcsGZBZTaskNodeVo>();
                for(int j=0;j<nodeList.size();j++){
                    TaskNodeVo node = nodeList.get(j);
                    startColumn = "";
                    startEstColumn = "";
                    endColumn = "";
                    endEstColumn = "";
                    PrcsGZBZTaskNodeVo tnVo = new PrcsGZBZTaskNodeVo();
                    tnVo.setEname(node.getTskcodes());
                    tnVo.setCname(node.getTaskName());
                    tnVo.setDroa("D");
                    if (StringUtil.isNotEmpty(node.getStartnode())&&"ARR".equals(node.getStartnode().substring(0,3))){
                        tnVo.setDroa("A");
                    }
                    tnVo.setStatus("0");
                    if(node.getStartcolumn() != null && !"".equals(node.getStartcolumn())){
                        startColumn = JexlUtil.convertToCode(node.getStartcolumn(),map) == null ? "" : JexlUtil.convertToCode(node.getStartcolumn(),map).toString();
                    }
                    if(node.getStartestcolumn() != null && !"".equals(node.getStartestcolumn())){
                        startEstColumn = JexlUtil.convertToCode(node.getStartestcolumn(),map) == null ? "" : JexlUtil.convertToCode(node.getStartestcolumn(),map).toString();
                    }
                    if(node.getEndcolumn() != null && !"".equals(node.getEndcolumn())){
                        endColumn = JexlUtil.convertToCode(node.getEndcolumn(),map) == null ? "" : JexlUtil.convertToCode(node.getEndcolumn(),map).toString();
                    }
                    if(node.getEndestcolumn() != null && !"".equals(node.getEndestcolumn())){
                        endEstColumn = JexlUtil.convertToCode(node.getEndestcolumn(),map) == null ? "" : JexlUtil.convertToCode(node.getEndestcolumn(),map).toString();
                    }

                    //判断状态//原状态：未录入0、应开始实际未开始(开始一半)1、正常2、晚于正常完成3
                    //新状态：未录入：0、应开始实际未开始：1、晚于预计开始：2、开始进行中：3、正常：4、应完成实际未完成：5、晚于正常完成：6
                    if("".equals(startColumn)){
                        if("".equals(startEstColumn) && "".equals(endEstColumn) && "".equals(endColumn)){
                            tnVo.setStatus("0");
                        }
                        if(!"".equals(startEstColumn) && "".equals(endEstColumn) && "".equals(endColumn)){
                            if(startEstColumn.compareTo(nowTime) > 0){
                                    tnVo.setStatus("0");
                            }
                            if(startEstColumn.compareTo(nowTime) <= 0){
                                tnVo.setStatus("1");
                            }
                        }
                        if(!"".equals(startEstColumn) && !"".equals(endEstColumn) && "".equals(endColumn)){
                            if(endEstColumn.compareTo(nowTime) > 0){
                                tnVo.setStatus("0");
                            }
                            if(endEstColumn.compareTo(nowTime) <= 0){
                                tnVo.setStatus("1");
                            }
                        }
                        if(!"".equals(startEstColumn) && !"".equals(endEstColumn) && !"".equals(endColumn)){
                            if(endEstColumn.compareTo(endColumn) >= 0){
                                tnVo.setStatus("4");
                            }
                            if(endEstColumn.compareTo(endColumn) < 0){
                                tnVo.setStatus("6");
                            }
                        }
                        if("".equals(startEstColumn) && !"".equals(endEstColumn) && "".equals(endColumn)){
                            if(endEstColumn.compareTo(nowTime) > 0){
                                tnVo.setStatus("0");
                            }
                            if(endEstColumn.compareTo(nowTime) <= 0){
                                tnVo.setStatus("1");
                            }
                        }
                        if("".equals(startEstColumn) && !"".equals(endEstColumn) && !"".equals(endColumn)){
                            if(endEstColumn.compareTo(endColumn) >= 0){
                                tnVo.setStatus("4");
                            }
                            if(endEstColumn.compareTo(endColumn) < 0){
                                tnVo.setStatus("6");
                            }
                        }
                        if("".equals(startEstColumn) && "".equals(endEstColumn) && !"".equals(endColumn)){
                             tnVo.setStatus("4");
                        }
                        if(!"".equals(startEstColumn) && "".equals(endEstColumn) && !"".equals(endColumn)){
                            tnVo.setStatus("4");
                        }
                    }else{
                        if("".equals(startEstColumn) && "".equals(endEstColumn) && "".equals(endColumn)){
                             tnVo.setStatus("3");
                        }
                        if(!"".equals(startEstColumn) && "".equals(endEstColumn) && "".equals(endColumn)){
                            if(startEstColumn.compareTo(startColumn) >= 0){
                                tnVo.setStatus("3");
                            }
                            if(startEstColumn.compareTo(startColumn) < 0){
                                tnVo.setStatus("2");
                            }
                        }
                        if(!"".equals(startEstColumn) && !"".equals(endEstColumn) && "".equals(endColumn)){
                            if(startEstColumn.compareTo(startColumn) >= 0){
                                tnVo.setStatus("3");
                            }
                            if(startEstColumn.compareTo(startColumn) < 0){
                                tnVo.setStatus("2");
                            }
                            if(endEstColumn.compareTo(nowTime) > 0){
                                tnVo.setStatus("3");
                            }
                            if(endEstColumn.compareTo(nowTime) <= 0){
                                tnVo.setStatus("5");
                            }
                        }
                        if(!"".equals(startEstColumn) && !"".equals(endEstColumn) && !"".equals(endColumn)){
                            if(endEstColumn.compareTo(endColumn) >= 0){
                                tnVo.setStatus("4");
                            }
                            if(endEstColumn.compareTo(endColumn) < 0){
                                tnVo.setStatus("6");
                            }
                        }
                        if("".equals(startEstColumn) && !"".equals(endEstColumn) && !"".equals(endColumn)){
                            if(endEstColumn.compareTo(endColumn) >= 0){
                                tnVo.setStatus("4");
                            }
                            if(endEstColumn.compareTo(endColumn) < 0){
                                tnVo.setStatus("6");
                            }
                        }
                        if("".equals(startEstColumn) && !"".equals(endEstColumn) && "".equals(endColumn)){
                            if(endEstColumn.compareTo(nowTime) > 0){
                                tnVo.setStatus("4");
                            }
                            if(endEstColumn.compareTo(nowTime) <= 0){
                                tnVo.setStatus("5");
                            }
                        }
                        if("".equals(startEstColumn) && "".equals(endEstColumn) && !"".equals(endColumn)){
                            tnVo.setStatus("4");
                        }
                        if(!"".equals(startEstColumn) && "".equals(endEstColumn) && !"".equals(endColumn)){
                            tnVo.setStatus("4");
                        }
                    }

                    taskNodeList.add(tnVo);
                }
                map.put("taskNodeList",taskNodeList);
                listMap.add(map);
            }
        }


        /*
        List<PrcsGZBZVo> listGZBZ = prcsSupervisionMapper.getGZBZ();
        if(listGZBZ != null && listGZBZ.size()>0){
            for(int i=0;i<listGZBZ.size();i++){
                PrcsGZBZVo vo = listGZBZ.get(i);


                if(i==0){
                    queryMap.put("flightA",vo.getFlightId());
                    queryMap.put("flightD",vo.getFlightIdD());
                }else{
                    queryMap.clear();
                    queryMap.put("flightA",vo.getFlightId());
                    queryMap.put("flightD",vo.getFlightIdD());
                }
                List<TDynTask> listTask = this.getGZBZState(queryMap);
                if(listTask != null && listTask.size()>0){
                    for(int j=0;j<listTask.size();j++){
                        TDynTask task = listTask.get(j);
                        if(task.getTaskCode().equals("Clean")){
                            vo.setClean(task.getTaskStatus()+"");//清洁
                        }
                        if(task.getTaskCode().equals("Meal")){
                            vo.setMeal(task.getTaskStatus()+"");//配餐
                        }
                        if(task.getTaskCode().equals("AddFuel")){
                            vo.setAddFuel(task.getTaskStatus()+"");//加油
                        }
                        if(task.getTaskCode().equals("Board")){
                            vo.setBoard(task.getTaskStatus()+"");//登机（上客）
                        }
                        if(task.getTaskCode().equals("Load")){
                            vo.setLuggage(task.getTaskStatus()+"");//装配行李
                        }
                    }
                }
                listVo.add(vo);
            }
        }*/
        return listMap;
    }

    //查询任务节点对应的调度信息
    public List<String> findSchedulingNoticeInfo(@Param("params") Map params){
        // 先保存操作信息 ：用户，操作时间，发布 XXX 任务 , 再查询出来保存的数据信息以及相关航班ID所对应的调度信息
        Date now = new Date();
        String nowStr = DateTimeUtil.dateToStr(now).substring(0,16);
        String msg = params.get("employeeId")+" 在 "+nowStr+" 发布 "+params.get("cname")+" 任务";
        TSchedulingNoticeInfo sni = new TSchedulingNoticeInfo();
        sni.setId(UUID.randomUUID().toString().replaceAll("-",""));
        int flightId = Integer.parseInt(params.get("flightId").toString());
        sni.setFlightId(flightId);
        sni.setFlno(params.get("flno").toString());
        sni.setTaskType(params.get("ename").toString());
        sni.setMsg(msg);
        sni.setStatus("1");
        sni.setMsgTime(now);
        sni.setCreateEmp(params.get("employeeId").toString());
        sni.setCreateTm(now);
        tschedulingNoticeInfoMapper.insert(sni);//插入数据
        //查询调度信息数据
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("flightId",flightId);
        paramMap.put("taskType",params.get("ename").toString());
        List<String> list = prcsSupervisionMapper.findSchedulingNoticeInfo(paramMap);
        //以下Json消息通过MQ发送到地服
        String isSend="";
        try {
            ServicedefineVo v=new ServicedefineVo();
            v.setSender(params.get("employeeId").toString());
            v.setFlightId(flightId+"");
            Map<String,String> nodeMap = new HashMap<String,String>();
            nodeMap.put("OpenGate","KCM");//开门
            nodeMap.put("Deplane","");//下机
            nodeMap.put("Load","ZJ");//装配行李
            nodeMap.put("Clean","QJ");//保洁
            nodeMap.put("AddFuel","");//加油
            nodeMap.put("Meal","");//配餐
            nodeMap.put("Board","");//登机
            nodeMap.put("CloseGate","GCM");//关门
            nodeMap.put("Handling","QY");//牵引到位
            nodeMap.put("Maintenance","JWFX");//机务放行
            v.setNodeCode(nodeMap.get(params.get("ename").toString()));
            if (StringUtil.isNotEmpty(v.getNodeCode())){
                JSONObject J=  new JSONObject(v);
               boolean flag= MqUtil.splitToListInt(J.toString());
               if (flag){
                   isSend="消息发送成功";
               }else {
                   isSend="消息发送失败";
               }

            }else {
                isSend="没有对应调度信息";
            }

        }catch (Exception e){
            isSend="消息配置信息有误，请联系管理员";
        }
        if (StringUtil.isNotEmpty(isSend)){
            list.add(isSend);
        }
        return list;
    }


}
