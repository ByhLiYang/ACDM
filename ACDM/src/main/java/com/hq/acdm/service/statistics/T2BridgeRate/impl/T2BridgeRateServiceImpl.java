package com.hq.acdm.service.statistics.T2BridgeRate.impl;

import com.hq.acdm.dao.statistics.T2BridgeRateMapper;
import com.hq.acdm.model.statistics.T2BridgeRate.T2BridgeRate;
import com.hq.acdm.service.statistics.T2BridgeRate.T2BridgeRateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuhao
 * @date 2018/11/8 0008 10:31
 */
@Service("T2BridgeRateService")
public class T2BridgeRateServiceImpl implements T2BridgeRateService{
    @Resource
    private T2BridgeRateMapper t2BridgeRateMapper;
    @Override
    public List<T2BridgeRate> queryT2BridgeRate(Map map) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        List<T2BridgeRate> list = t2BridgeRateMapper.queryT2BridgeRate(map);
        for(int i=0;i<list.size();i++){
            if("0".equals(list.get(i).getZHIXINGSHU())||"0".equals(list.get(i).getKAOQIAOSHU())){
                list.get(i).setKAOQIAOLV("0%");
            }else{
                list.get(i).setKAOQIAOLV(df.format(Integer.parseInt(list.get(i).getKAOQIAOSHU())*100.0/Integer.parseInt(list.get(i).getZHIXINGSHU()))+"%");
            }
        }
        return list;
    }
}
