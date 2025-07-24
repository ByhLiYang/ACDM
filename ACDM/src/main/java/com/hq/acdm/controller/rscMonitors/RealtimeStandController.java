package com.hq.acdm.controller.rscMonitors;

import com.hq.acdm.common.ServerResponse;
import com.hq.acdm.model.sys.Users;
import com.hq.acdm.service.realtimeSituation.FlightIndexService;
import com.hq.acdm.service.rscMonitors.RealtimeStandService;
import com.hq.acdm.util.ConstantUtil;
import com.hq.acdm.util.CookieUtil;
import com.hq.acdm.util.JsonMapper;
import com.hq.acdm.vo.realtimeSituation.FlightHandTerminalVo;
import com.hq.acdm.vo.rscMonitors.AltAbilityVo;
import com.hq.acdm.vo.rscMonitors.BaseStand;
import com.hq.acdm.vo.rscMonitors.StandInfoVo;
import com.hq.acdm.vo.rscMonitors.StandStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiFaQiang
 * @date 2019/04/28 16:21
 * @Description
 */
@Api(description = "机位监管")
@RestController
@RequestMapping("/rscMonitors/realtimeStand")
public class RealtimeStandController {
    @Resource
    private RealtimeStandService realtimeStandService;
    @Resource
    private FlightIndexService flightIndexService;
    @ApiOperation(httpMethod = "GET", value = "机位状态详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getStandInfo.json", method = RequestMethod.GET)
    public ServerResponse<List<StandStatusVo>> getStandInfo() {
        return ServerResponse.createBySuccess(realtimeStandService.findStandInfo());
    }
    @ApiOperation(httpMethod = "GET", value = "机位备降能力查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getAltAbility.json", method = RequestMethod.GET)
    public ServerResponse<AltAbilityVo> getAltAbility() {
        //查询出即将进港、占用无出港、即将出港、预计冲突的机位
        List<StandStatusVo> list = realtimeStandService.findStandInfo();
        //查出所以可以使用的机位
        List<BaseStand> baseList = realtimeStandService.findBaseStand();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < baseList.size(); j++) {
                //从所有可用机位中剔除掉即将出港、占用无出港、即将出港、预计冲突的机位
                if (list.get(i).getStand().equals(baseList.get(j).getStand())){
                    baseList.remove(j);
                }
            }
        }
        AltAbilityVo aav = new AltAbilityVo();
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        for (int i = 0; i < baseList.size(); i++) {
            //统计可备降机型B的机位
            if ("B".equals(baseList.get(i).getType())){
                B++;
            }
            //统计可备降机型C的机位
            if ("C".equals(baseList.get(i).getType())){
                C++;
            }
            //统计可备降机型D的机位
            if ("D".equals(baseList.get(i).getType())){
                D++;
            }
            //统计可备降机型E的机位
            if ("E".equals(baseList.get(i).getType())){
                E++;
            }
        }
        aav.setB(B);
        aav.setC(C);
        aav.setD(D);
        aav.setE(E);
        aav.setHJ(B+C+D+E);
        return ServerResponse.createBySuccess(aav);
    }
    @ApiOperation(httpMethod = "GET", value = "提供给数仓的机位统计数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/standInfo.json", method = RequestMethod.GET)
    public ServerResponse<StandInfoVo> standInfo() {
        StandInfoVo siv = new StandInfoVo();
        siv.setJwzs(realtimeStandService.findJWZS());
        siv.setBkys(realtimeStandService.findBKYS());
        siv.setJrtc(realtimeStandService.findJRTC());
        siv.setGyhb(realtimeStandService.findGYHB());
        List<StandStatusVo> list = realtimeStandService.findStandInfo();
        List<BaseStand> baseList = realtimeStandService.findBaseStand();
        int JJWZS = 0;
        int YJWZS = 0;
        int JJWZY = 0;
        int YJWZY = 0;
        int CQZY = 0;
        int BZY = 0;
        int BZS = 0;
        int CZY = 0;
        int CZS = 0;
        int DZY = 0;
        int DZS = 0;
        int EZY = 0;
        int EZS = 0;
        int FZY = 0;
        int FZS = 0;
        int DQZY = 0;
        int DQSY = 0;
        int JJDG = 0;
        int JJCG = 0;
        int XXSZY = 0;
        for (int i = 0; i < list.size(); i++) {
            if ("1".equals(list.get(i).getStatus())){
                CQZY++;
            }
            if ("0".equals(list.get(i).getStatus())){
                JJDG++;
            }
            if ("3".equals(list.get(i).getStatus())){
                JJCG++;
            }
            if ("1".equals(list.get(i).getStatus())||"3".equals(list.get(i).getStatus())){
                for (int j = 0; j < baseList.size(); j++) {
                    if (list.get(i).getStand().equals(baseList.get(j).getStand())){
                        if ("Y".equals(baseList.get(j).getIsremote())){
                            YJWZY++;
                        }else{
                            JJWZY++;
                        }
                        if (null!=baseList.get(j).getType()&&"B".equals(baseList.get(j).getType())){
                            BZY++;
                        }else if (null!=baseList.get(j).getType()&&"C".equals(baseList.get(j).getType())){
                            CZY++;
                        }else if (null!=baseList.get(j).getType()&&"D".equals(baseList.get(j).getType())){
                            DZY++;
                        }else if (null!=baseList.get(j).getType()&&"E".equals(baseList.get(j).getType())){
                            EZY++;
                        }else if (null!=baseList.get(j).getType()&&"F".equals(baseList.get(j).getType())){
                            FZY++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < baseList.size(); i++) {
            if ("Y".equals(baseList.get(i).getIsremote())){
                YJWZS++;
            }else{
                JJWZS++;
            }
            if (null!=baseList.get(i).getType()&&"B".equals(baseList.get(i).getType())){
                BZS++;
            }else if (null!=baseList.get(i).getType()&&"C".equals(baseList.get(i).getType())){
                CZS++;
            }else if (null!=baseList.get(i).getType()&&"D".equals(baseList.get(i).getType())){
                DZS++;
            }else if (null!=baseList.get(i).getType()&&"E".equals(baseList.get(i).getType())){
                EZS++;
            }else if (null!=baseList.get(i).getType()&&"F".equals(baseList.get(i).getType())){
                FZS++;
            }
        }
        DQZY=YJWZY+JJWZY;
        DQSY=YJWZS+JJWZS-DQZY;
        XXSZY=DQZY+(JJDG-JJCG);
        siv.setCqzy(CQZY);
        siv.setJjwzy(JJWZY);
        siv.setJjwzs(JJWZS);
        siv.setYjwzy(YJWZY);
        siv.setYjwzs(YJWZS);
        siv.setBzy(BZY);
        siv.setBsy(BZS-BZY);
        siv.setCzy(CZY);
        siv.setCsy(CZS-CZY);
        siv.setDzy(DZY);
        siv.setDsy(DZS-DZY);
        siv.setEzy(EZY);
        siv.setEsy(EZS-EZY);
        siv.setFzy(FZY);
        siv.setFsy(FZS-FZY);
        siv.setDqzy(DQZY);
        siv.setDqsy(DQSY);
//        siv.setJjdg(JJDG);
//        siv.setJjcg(JJCG);
        siv.setXxszy(XXSZY);
//        siv.setZyb(new BigDecimal(DQZY*100.00/(YJWZS+JJWZS)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
//        siv.setSyjw(DQSY);
        return ServerResponse.createBySuccess(siv);
    }
}
