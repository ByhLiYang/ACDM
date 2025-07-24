package com.hq.acdm.controller.statistics.aosssysdic;


import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.statistics.aosssysdic.Aosssysdic;
import com.hq.acdm.service.statistics.aosssysdic.AosssysdicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 参数管理
 */
@Api(description = "参数管理")
@RestController
@RequestMapping("/statisticalReport/aosssysdic")
@Slf4j
public class AosssysdicController {

    @Autowired
    private AosssysdicService aosssysdicService;

    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getParamValue.json", method = RequestMethod.POST)
    public ServerResponse getParamValue(@ApiParam("类型代码")@RequestParam("typecode") String typecode,
                                        @ApiParam("参数代码") @RequestParam("paracode")String paracode,
                                        @ApiParam("参数名称") @RequestParam("parameterName")String parameterName,
                                        @ApiParam("参数描述") @RequestParam("parameterDescription")String parameterDescription) {
        List<Aosssysdic> aosssysdiclist = aosssysdicService.selectDefinedParawvalue(typecode,paracode,parameterName,parameterDescription);

        //将数据转换成前端需要的格式
        List arrayList = new ArrayList<>();
        for (Aosssysdic aosssysdic:aosssysdiclist) {
            Map<String,Object> map = new HashMap<String,Object>();
            // 类型代码
            map.put("TYPECODE",aosssysdic.getPARAMTYPECODE());
            // 类型名称
            map.put("TYPENAME",aosssysdic.getPARAMTYPENAME());
            // 参数代码
            map.put("PARACODE",aosssysdic.getPARAMCODE());
            // 参数名称
            map.put("PARANAME",aosssysdic.getPARAMNAME());
            // 参数描述
            map.put("PARADESC",aosssysdic.getPARAMDESC());
            // 参数值
            map.put("PARAVALUE",aosssysdic.getPARAMVALUE());
            arrayList.add(map);
        }
        return ServerResponse.createBySuccess(arrayList);
    }

    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/paramTypeList.json", method = RequestMethod.GET)
    public ServerResponse getParamTypeList() {
        List<Aosssysdic> aosssysdiclist = aosssysdicService.selectParamtypeList();

        //将数据转换成前端需要的格式
        List arrayList = new ArrayList<>();
        for (Aosssysdic aosssysdic:aosssysdiclist) {
            Map<String,Object> map = new HashMap<String,Object>();
            // 类型代码
            map.put("TYPECODE",aosssysdic.getPARAMTYPECODE());
            // 类型名称
            map.put("TYPENAME",aosssysdic.getPARAMTYPENAME());
            arrayList.add(map);
        }
        return ServerResponse.createBySuccess(arrayList);
    }


    //被以上 getParamValue 替代
    @ApiOperation(httpMethod = "GET", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/allSysDic.json", method = RequestMethod.GET)
    public ServerResponse getAllSysDic() {
        List<Aosssysdic> aosssysdiclist = aosssysdicService.selectAllSysdic();

        //将数据转换成前端需要的格式
        List arrayList = new ArrayList<>();
        for (Aosssysdic aosssysdic:aosssysdiclist) {
            Map<String,Object> map = new HashMap<String,Object>();
            // 类型代码
            map.put("TYPECODE",aosssysdic.getPARAMTYPECODE());
            // 参数类型名称
            map.put("TYPENAME",aosssysdic.getPARAMTYPENAME());
            // 参数代码
            map.put("PARACODE",aosssysdic.getPARAMCODE());
            // 参数名称
            map.put("PARANAME",aosssysdic.getPARAMNAME());
            // 参数描述
            map.put("PARADESC",aosssysdic.getPARAMDESC());
            // 参数值
            map.put("PARAVALUE",aosssysdic.getPARAMVALUE());
            arrayList.add(map);
        }
        return ServerResponse.createBySuccess(arrayList);
    }



    @ApiOperation(httpMethod = "POST", value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateSysDic.json", method = RequestMethod.POST)
    public ServerResponse updateSysDic(
           @ApiParam("更新参数类型名称")@RequestParam("TYPENAME") String typecode,
           @ApiParam("更新参数类型")@RequestParam("TYPECODE") String typename,
           @ApiParam("更新参数代码")@RequestParam("PARACODE") String paracode,
           @ApiParam("更新参数名称")@RequestParam("PARANAME") String paraname,
           @ApiParam("更新参数描述")@RequestParam("PARADESC") String paradesc,
           @ApiParam("更新参数值")@RequestParam("PARAVALUE") String paravalue) {

        try {
            //非空判断
            if(StringUtils.isEmpty(typecode) || StringUtils.isEmpty(paracode)){
                return ServerResponse.createByParamError();
            }

            //传参
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("typecode",typecode);
            map.put("typename",typename);
            map.put("paracode",paracode);
            map.put("paraname",paraname);
            map.put("paradesc",paradesc);
            map.put("paravalue",paravalue);

            boolean result = aosssysdicService.updateSysDic(map);
            if(!result){
                return ServerResponse.createByOtherError("更新失败");
            }
        }catch (Exception e){
            log.error("updateSysDic.json接口异常",e);
            return ServerResponse.createBySystemError();
        }
        return ServerResponse.createBySuccess();
    }
}
