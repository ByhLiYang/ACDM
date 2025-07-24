package com.hq.acdm.controller.indexmobile;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.SysCacheService;
import com.hq.acdm.service.abnormal.DelayLiveService;
import com.hq.acdm.service.index.SceneMoniterService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.abnormal.DelayNumberVO;
import com.hq.acdm.vo.index.FlightFulInfoVo;
import com.hq.acdm.vo.index.SceneMoniterVo;
import com.hq.acdm.vo.index.StandStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2018/11/16 15:10
 * @Description
 */
@Api(description = "手机端航班延误概况")
@RestController
@RequestMapping("/indexmobile/situation")
public class SituationController {

    @Resource
    private DelayLiveService delayLiveService;
    @Resource
    private SysCacheService sysCacheService;
    @Resource
    private com.hq.acdm.service.sys.UsersService UsersService;

    @ApiOperation(httpMethod = "GET", value = "航班延误概况", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delay.json", method = RequestMethod.GET)
    public ServerResponse<DelayNumberVO> getDelayInfoByMobile(HttpServletRequest request) {

        Map<String, Object> queryMap = new HashMap<>();
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
        return ServerResponse.createBySuccess(delayLiveService.getDelayInfoByMobile(queryMap));
    }

}
