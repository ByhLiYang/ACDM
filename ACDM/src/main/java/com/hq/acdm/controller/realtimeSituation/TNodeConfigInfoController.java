package com.hq.acdm.controller.realtimeSituation;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.realtimeSituation.TNodeConfigInfo;
import com.hq.acdm.model.realtimeSituation.TNodeConfigInfoExample;
import com.hq.acdm.service.RedisPool;
import com.hq.acdm.service.realtimeSituation.TNodeConfigInfoService;
import com.hq.acdm.vo.realtimeSituation.NodeInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.ShardedJedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author LiFaQiang
 * @date 2019/03/25 11:23
 * @Description
 */
@Api(description = "节点信息表维护")
@RestController
@RequestMapping("/realtimeSituation/tNodeConfigInfo")
@Slf4j
public class TNodeConfigInfoController {

    @Resource
    private TNodeConfigInfoService tNodeConfigInfoService;

    @ApiOperation(httpMethod = "POST", value = "查询全部节点", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectAllNodeConfigInfo.json", method = RequestMethod.POST)
    public ServerResponse selectAllNodeConfigInfo(@ApiParam("查询全部节点")
                                                  @RequestParam("nodeCode") String nodeCode,
                                                  @RequestParam("nodeName") String nodeName,
                                                  HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> queryMap = new HashMap<String,Object>();
        queryMap.put("nodeCode",nodeCode);
        queryMap.put("nodeName",nodeName);
        List<TNodeConfigInfo> tNodeConfigInfoList = tNodeConfigInfoService.selectAllNodeConfigInfo(queryMap);
        return ServerResponse.createBySuccess(tNodeConfigInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "节点新增", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public ServerResponse insert(@ApiParam("节点新增")
                                 @RequestParam("nodeCode") String nodeCode,
                                 @RequestParam("nodeSeq") String nodeSeq,
                                 @RequestParam("nodeName") String nodeName,
                                 @RequestParam("nodeColumn") String nodeColumn,
                                 @RequestParam("nodeEstimateColumn") String nodeEstimateColumn,
                                 @RequestParam("nodeSubexp") String nodeSubexp,
                                 @RequestParam("isavailabl") String isavailabl,
                                 @RequestParam("isnecessary") String isnecessary,
                                 @RequestParam("rmk") String rmk,
                                 HttpServletRequest request, HttpServletResponse response) {
        TNodeConfigInfo tNodeConfigInfo = new TNodeConfigInfo();
        tNodeConfigInfo.setId(UUID.randomUUID().toString().replaceAll("-",""));
        tNodeConfigInfo.setNodeCode(nodeCode);
        int nodeSeqInt = 0;
        if(nodeSeq != null && !"".equals(nodeSeq)){
            nodeSeqInt = Integer.parseInt(nodeSeq);
        }
        tNodeConfigInfo.setNodeSeq(nodeSeqInt);
        tNodeConfigInfo.setNodeName(nodeName);
        tNodeConfigInfo.setNodeColumn(nodeColumn);
        tNodeConfigInfo.setNodeEstimateColumn(nodeEstimateColumn);
        tNodeConfigInfo.setNodeSubexp(nodeSubexp);
        int isavailablInt = 1;
        if(isavailabl != null && !"".equals(isavailabl)){
            isavailablInt = Integer.parseInt(isavailabl);
        }
        tNodeConfigInfo.setIsavailabl(isavailablInt);
        int isnecessaryInt = 1;
        if(isnecessary != null && !"".equals(isnecessary)){
            isnecessaryInt = Integer.parseInt(isnecessary);
        }
        tNodeConfigInfo.setIsnecessary(isnecessaryInt);
        tNodeConfigInfo.setRmk(rmk);
        tNodeConfigInfo.setCreateTm(new Date());
        return ServerResponse.createBySuccess(tNodeConfigInfoService.insert(tNodeConfigInfo));
    }

    @ApiOperation(httpMethod = "POST", value = "节点更新", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse updateByPrimaryKey(@ApiParam("节点更新")
                                             @RequestParam("id") String id,
                                             @RequestParam("nodeCode") String nodeCode,
                                             @RequestParam("nodeSeq") String nodeSeq,
                                             @RequestParam("nodeName") String nodeName,
                                             @RequestParam("nodeColumn") String nodeColumn,
                                             @RequestParam("nodeEstimateColumn") String nodeEstimateColumn,
                                             @RequestParam("nodeSubexp") String nodeSubexp,
                                             @RequestParam("isavailabl") String isavailabl,
                                             @RequestParam("isnecessary") String isnecessary,
                                             @RequestParam("rmk") String rmk,
                                 HttpServletRequest request, HttpServletResponse response) {
        TNodeConfigInfo tNodeConfigInfo = new TNodeConfigInfo();
        tNodeConfigInfo.setId(id);
        tNodeConfigInfo.setNodeCode(nodeCode);
        int nodeSeqInt = 0;
        if(nodeSeq != null && !"".equals(nodeSeq)){
            nodeSeqInt = Integer.parseInt(nodeSeq);
        }
        tNodeConfigInfo.setNodeSeq(nodeSeqInt);
        tNodeConfigInfo.setNodeName(nodeName);
        tNodeConfigInfo.setNodeColumn(nodeColumn);
        tNodeConfigInfo.setNodeEstimateColumn(nodeEstimateColumn);
        tNodeConfigInfo.setNodeSubexp(nodeSubexp);
        int isavailablInt = 1;
        if(isavailabl != null && !"".equals(isavailabl)){
            isavailablInt = Integer.parseInt(isavailabl);
        }
        tNodeConfigInfo.setIsavailabl(isavailablInt);
        int isnecessaryInt = 1;
        if(isnecessary != null && !"".equals(isnecessary)){
            isnecessaryInt = Integer.parseInt(isnecessary);
        }
        tNodeConfigInfo.setIsnecessary(isnecessaryInt);
        tNodeConfigInfo.setRmk(rmk);
        tNodeConfigInfo.setUpdateTm(new Date());
        return ServerResponse.createBySuccess(tNodeConfigInfoService.updateByPrimaryKeySelective(tNodeConfigInfo));
    }

    @ApiOperation(httpMethod = "POST", value = "节点删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByPrimaryKey.json", method = RequestMethod.POST)
    public ServerResponse deleteByPrimaryKey(@ApiParam("节点删除")
                                             @RequestParam("id") String id,
                                             HttpServletRequest request, HttpServletResponse response) {

        return ServerResponse.createBySuccess(tNodeConfigInfoService.deleteByPrimaryKey(id));
    }

    @ApiOperation(httpMethod = "POST", value = "节点所有信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectByExample.json", method = RequestMethod.POST)
    public ServerResponse selectByExample(@ApiParam("节点所有信息")
                                              @RequestParam("example")  TNodeConfigInfoExample example,
                                              HttpServletRequest request, HttpServletResponse response) {

        List<TNodeConfigInfo> tNodeConfigInfoList = tNodeConfigInfoService.selectByExample(example);
        return ServerResponse.createBySuccess(tNodeConfigInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "查询节点所有信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectAllNode.json", method = RequestMethod.POST)
    public ServerResponse selectAllNode(@ApiParam("查询节点所有信息")
                                          HttpServletRequest request, HttpServletResponse response) {
        List<NodeInfoVo> tNodeConfigInfoList = tNodeConfigInfoService.selectAllNode();
        return ServerResponse.createBySuccess(tNodeConfigInfoList);
    }

    @ApiOperation(httpMethod = "POST", value = "修改节点是否显示", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateAllNodeIsAvailabl.json", method = RequestMethod.POST)
    public ServerResponse updateAllNodeIsAvailabl(@ApiParam("修改节点是否显示")
                                                      @RequestBody String node,
                                                HttpServletRequest request, HttpServletResponse response) {

        return ServerResponse.createBySuccess(tNodeConfigInfoService.updateAllNodeIsAvailabl(node));
    }
}
